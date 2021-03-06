# SQL 옵티마이저

## 비용기반 옵티마이저

비용기반(Cost-Based) 옵티마이저는 사용자 쿼리를 위해 후보군이 될만한 실행계획들을 도출하고, 데이터 딕셔너리(Data Dictionary)에 미리 수집해 둔 통계정보를 이용해 각 실행계획의 예상비용을 신청하고, 그중 가장 낮은 비용의 실행계획 하나를 선택하는 옵티마이저이다.  
CBO가 사용하는 통계정보로는 데이터양, 컬럼 값의 수, 컬럼 값 분포, 인덱스 높이, 클러스터링 팩터 등이 있다.

## 규칙기반 옵티마이저

과거에는 각 액세스 경로에 대한 우선순위 규칙에 따라 실행계획을 만드는 옵티마이저를 사용했었다.  
일명 `규칙기반(Rule-Based) 옵티마이저`이다.

BRO는 데이터 특성을 나타내는 특계정보를 전혀 활용하지 않고 단순한 규칙에만 의존하기 때문에 대량 데이터를 처리하는데 부적합하다.

순위|액세스 경로
:--:|:--:
1|Single Row by Rowid
2|Single Row by Cluster Join
3|Single Row by Hash Cluster Key with Unique or Primary Key
4|Single Row by Unique or Primary Key
5|Clustered Join
6|Hash Cluster Key
7|Indexed Cluster Key
8|Composite Index
9|Single-Column Indexs
10|Bounded Range Search on Indexed Columns
11|Unbounded Range Search on Indexed Columns
12|Sort Merge Join
13|MAX or MIN of Indexed Column
14|ORDER BY on Indexed Column
15|Full Table Scan

어느 정도 보편타당하기 때문에 사용에 큰 무리가 없던 시절이 있었다. 하지만 지금과 같은 대용량 데이터베이스 환경에는 전혀 대안이 될 수 없다.

- 규칙기반이 안좋은 경우

1. Index을 무조건 사용하여 Full Table Scan은 후 순위가 된다. 고객유형코드 조건을 만족하는 고객이 전체에 90%를 차지한다면 좋지 못한 선택이다.
2. 부분범위 처리가 되는 거면 소트 연산을 생략한다면 성능을 높이겠지만, 그렇지 못한경우 전체 레코드를 액세하는 경우 결코 좋은 선택이 아니다.
3. Between 조건이 부등 조건보다 우선순위가 높기 때문에 BETWEEN은 닫힌 범위검색 조건이고, 부등호는 열린 범위 검색조건이므로 BETWEEN이 유리하다고 볼 수 있지만, 60세 이상 연령 검색 보다는 3000 ~ 6000 연봉자가 더 많은데 BRO는 그것을 모른다.


## 옵티마이저 서브 엔진

옵티마이저가 최적화를 수행할 때 세부적으로 아래 3개의 서브 엔진을 사용한다.

- Query Transformer : 사용자로부터 전달받은 SQL을 그대로 최적화하지 않고 우선 최적화에 유리한 형태로 변환을 시도한다.
- Estimator : 쿼리 오퍼레이션 각 단계의 선택도(Selectivity), 카디널리티(Cardinality), 비용(Cost)을 계산하고, 궁극적으로 실행계획 전체에 대한 총 비용을 계산해 낸다.
- Plan Generator: 하나의 쿼리를 수행하는데 있어, 후보군이 될만한 실행계획들을 생성해 낸다.


## 옵티마이저가 힌트를 무시하는 경우

1. 문법적으로 맞지 않게 힌트를 기술
2. 잘못된 참조 사용
3. 논리적으로 불가능한 액세스 경로
4. 의미적으로 맞지 않게 힌트를 기술
5. 옵티마이저에 의해 내부적으로 쿼리가 변환된 경우
6. 버그


## 옵티마이저 기능

- Bind Variable Peeking은 SQL이 첫 번째 수행될 때 함께 딸려 온 바인드 변수 값을 살짝 훔쳐보고(peek), 그 값에 대한 컬럼 분포를 이용해 실행계획을 결정하는 기능이다.

- Adaptive Cursor Sharing은 처음 실행 시 특정 실행계획으로 실행했다가 바인드변수에 다른 값이 입력됐을 떄 예상보다 많은 I/O가 발생하면 다른 실행계획을 추가로 생성하고, 이후로 바인드 변수 값 분포에 따라 다른 실행계획을 선택적으로 사용하는 기능이다.


## 통계정보

옵티마이저가 사용하는 통계정보로는 크게 오브젝트 통계와 시스템 통계가 있다.  

- 오브젝트 통계
1. 테이블 통계(레코드 수, 블록 수, 평균 행 길이 등)
2. 인덱스 통계(인덱스 높이, 리프 블록 개수, 클러스터링 팩터 등)
3. 컬럼 통계(중복을 제거한 컬럼 값의 수, 최소 값, 최대 값, Null 값 개수, 히스토그램 등)

- 시스템 통계
1. CPU 속도
2. Single Block I/O 속도
3. Multiblock I/O 속도
4. 평균적인 Multiblock I/O 개수


## 최초 응답속도 최적화

효과적인 애플리케이션 아키택처는 주로 2-Tier 환경의 클라이언트/서버 구조다.  
이 애플리케이션 구조의 특징은 전체 결과집합이 아무리 많아도 사용자가 스크롤을 통해 일부만 Fetch 하다가 멈출 수 있다는 점이다. 결과 집합을 끝까지 Fetch 하거나 다른 쿼리를 수행하기 전까지 SQL 커서는 오픈된 상태를 유지한다.

OTLP성 애플리케이션이더라도 3-Tier 구조는 클라이언트와 서버 간 연결을 지속하지 않는 환경이므로 오픈 커서를 계속 유지할 수 없어 일반적으로 페이징 처리 기법을 사용한다.  
대량 데이터 중 일부만 Fetch 하다가 멈추는 것이 아니라 집합 자체를 소량으로 정의해서 모두 Fetch한다면, 전체 처리속도 최적화가 더 적절한 설정이다.



## 옵티마이저 행동에 영향을 미치는 요소

- 옵티마이징 팩터 : 인덱스, IOT, 클러스터링, 파티셔닝 등 오브젝트 구성
- DBMS 제약설정 : PK, FK, Check, Not Null 등
- 통계정보
- 옵티마이저 힌트
- 옵티마이저 관련 파라미터


## 옵티마이저의 한계

옵티아마이저가 항상 최적의 실행계획을 생성하지 못하는 데는 아래와 같은 이유가 있다.

- 부족한 옵티아미이징 팩터 : 인덱스, IOT, 클러스터링, 파티셔닝 등 오브젝트 구성
- 부정확한 통계 : 정보 수집 및 보관 비용 측면의 한계(샘플링 비율, 수집 주기 등)
- 결합 선택도 산정의 어려움
- 바인드 변수 사용 시, 히스토그램 사용에 제약 : 균등분포 가정
- 비현실적인 가정과 규칙에 의존
- 최적화 시간에 허용된 시간 제약


## 선택도와 카디널리티

선택도(Selectivity)란, 전체 레코드 중에서 조건절에 의해 선택되는 레코드 비율을 말한다. NDV는 컬럼 값 종류 개수를 의미한다.

선택도 = 1 / NDV

카디널리티(Cardinality)란, 전체 레코드 중에서 조건절에 의해 선택되는 레코드 개수이다.

카디널리티 = 총 로우 수 * 선택도 = 총 로우 수 / NDV

## 컬럼 통계

오라클이 수집하는 컬럼 통계 항목들이다.

- 중복을 제거한 컬럼 값의 수
- 최소값
- 최대값
- 밀도
- 평균 컬럼 길이
- NULL 값을 가진 레코드 수

## 시스템 통계

시스템 통계는 애플레이케이션 및 하드웨어 성능 특성을 측정

- CPU 속도
- 평균적인 Single Block I/O 속도
- 평균적인 Multiblock I/O 속도
- 평균적인 Multiblock I/O 개수
- I/O 서브시스템의 최대 처리량(Throughput)
- 병렬 Slave의 평균적인 처리량(Throughput)


## I/O 비용 모델 vs CPU 비용 모델

I/O 비용 모델의 비용(Cost)은 예상되는 디스크 I/O call 횟수를 의미한다.  
CPU 비용 모델에서는 예상 I/O 시간과 예상 CPU 사용시간을 구한 후 Single Block I/O 시간으로 나눈 값을 비용 값으로 사용한다. 즉, 비용을 Single Block I/O에 소요되는 시간과의 상대적인 시간 비용으로 표현한 것이다.


## 히스토그램 유형

- 도수분포(Frequency) : 값별로 빈도수 저장
- 높이균형(Height-Balanced) : 각 버킷의 높이가 동일하도록 데이터 분포 관리
- 상위도수분포(Top-Frequency) : 많은 레코드를 가진 상위 n개 값의 빈도수 저장
- 하이브리드(Hybrid) : 도수분포와 높이균형 히스토그램의 특성을 결합


## 인덱스를 이용한 테이블 액세스 비용

비용 = 브랜치 레벨 + (리프 블록 수 * 유효 인덱스 선택도) + (클러스터링 팩터 * 유효 테이블 선택도)

`유효 인덱스 선택도`는 인덱스 총 레코드 중에서 조건절을 만족할 것으로 예상되는 레코드비율을 의미한다.  
`유효 테이블 선택도`는 전체 인덱스 레코드 중에서 인덱스 스캔을 완료하고서 테이블을 방문할 것으로 예상되는 레코드 비율을 의미한다.


## SQL 공유와 재사용

`소프트 파싱(Soft Parsing)` : SQL과 실행계획을 캐시에서 찾아 곧바로 실행하는 경우  
`하드 파싱(Hard Parsing)` : SQL과 실행계획을 캐시에서 찾지 못해 최적화 및 로우 소스 생성 과정을 모두 거쳐서 실행하는 경우


### SQL 최적화 과정

옵티마이저가 SQL을 최적화할 때도 데이터베이스 사용자들이 보통 생각하는 것보다 훨씬 많은 일을 수행한다.  
그 과정에 사용하는 정보는 다음과 같다.

- 테이블, 컬럼, 인덱스 구성에 관한 기본 정보
- 오브젝트 통계 : 테이블 통계, 인덱스 통계, 컬럼 통계
- 시스템 통계 : CPU 속도, SingleBlock I/O 속도, Multiblock I/O 속도 등
- 옵티마이저 관련 파라미터

하나의 쿼리를 수행하는 데 있어 후보군이 될만한 무수히 많은 실행경로를 도출하고, 딕셔너리와 통계정보를 읽어 각각에 대한 효율성을 판단해야 하므로 하드파싱과정에 많은 CPU 자원을 사용한다. SQL 최적화 과정이 하드한 이유다.


### 공유 가능 SQL

사용자 정의 함수/프로시저, 트리거, 패키지 등은 생성할 때부터 이름을 갖는다. 컴파일한 상태로 딕셔너리에 저장되며, 사용자가 삭제하지 않는 한 영구적으로 보관된다.  
실행할 때 라이브러리 캐시에 적재함으로 써 여러 사용자가 공유하면서 재사용한다.

반면, SQL은 이름이 따로 없다. 전체 SQL 텍스트가 이름 역활을 한다. 딕셔너리에 저장하지도 않는다.  
처음 실행할 때 최적화 과정을 거쳐 동적으로 생성한 내부 프로시저를 라이브러리를 캐시에 적재함으로써 여러 사용자가 공유하면서 재사용한다.  
캐시 공간이 부족하면 버려졌다가 다음에 다시 실행할 때 똑같은 최적화 공간거쳐 캐시에 적재된다. 의미적으로 100% 같은 SQL이더라도 텍스트 중 일부가 다르면, 각각 최적화를 진행하고 라이브러리 캐시에서 별도 공간을 사용한다.

### 커서

- 명시적 커서는 DECLARE 문으로 SQL 문을 정의하고, 커서의 Open, Fetch, Close를 명시적으로 처리하는 개발 패턴을 말한다.
- 묵시적 커서는 DECLARE 문을 생략하고 커서의 Open, Fetch, Close도 DBMS가 자동으로 처리하는 개발 패턴을 말한다.  

라이브러리에서 SQL을 찾는 작업을 생략하고 반복 수행하는 기능은 `애플리케이션 캐시 캐싱`에 대한 설명이다.


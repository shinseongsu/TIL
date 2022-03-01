# 인덱스 튜닝

## B*Tree 튜닝

- 브랜치 블록의 각 로우는 하위 블록에 대한 주소값을 갖는다.
- 브랜치 블록 각 로우의 키 값은 하위 블록이 갖는 값의 범위를 의미한다.
- 리프 블록의 각 로우는 테이블 로우에 대한 주소값을 갖는다.
- 리프 블록 각 로우의 키 값과 테이블 로우의 키 값은 서로 일치한다.
- 리프 블록의 각 로우와 테이블 로우 간에 1:1 관계이다.
- 리프 블록끼리는 이중연결리스트(double linked list) 구조이다.

## 인덱스 ROWID

오라클 초기 버전에는 `제한 ROWID 포맷`은 `ROWID가 데이터파일 + 블록번호 + 블록 내 로우번호`로 구성된다.  
오라클 8 버전부터 `확장 ROWID 포맷`은 `오브젝트 번호 + 데이터파일 번호 + 블록 번호 + 블록 내 로우번호`

## 인덱스 탐색 

B*Tree 인덱스를 탐색할 때는 우선 루트에서 리프 블록까지 수직적 탐색을 통해 스캔 시작지점을 찾는다.  
수직적 탐색을 통해 조건을 만족하는 첫 번째 레코드를 찾았으면, 인덱스 리프 블록을 스캔하면서 찾고자 하는 데이터가 더 안 나타날 때까지 수평적 탐색을 진행한다.


## 인덱스 사용

```sql
[ 인덱스 구성 ]
고객_PK : 고객번호
고객_X1 : 가입일자 + 성별 + 고객명

SELECT /*+ ___  */ 고객번호, 성별, 가입일자, 연락처
  FROM 고객 C
 WHERE 고객명 = :CUST_NM
   AND 가입일자 BETWEEN :ENT_DT1 AND :ENT_DT2 

사용가능 한 인덱스 사용법

INDEX(C)
INDEX(C 고객_X1)
INDEX(C(가입일자))

INDEX(C(가입일자, 고객명)) -> x 사용할수 없음  
가입일자 + 고객명 선두로 한 인덱스가 없어 무시될수 있다. 인덱스가 사용되어도 Table Full Scan이 될 수 있기 때문에 정답은 아니다.

```

## SQL Server Index 사용법

```sql
고객_PK : 고객번호(클러스터형 인덱스)

DECLARER @CUST_NO INT

1.
SELECT *
  FROM 고객 WITH( FORCESEEK( 고객_PK (고객번호)))
 WHERE 고객번호 = @CUST_NO
 
2.
SELECT *
  FROM 고객
 WHERE 고객번호 = @CUST_NO
 OPTION (INDEX(고객_PK)) 

```

## Index Range Scan

- B*Tree 인덱스의 가장 일반적이고 정상적인 형태의 스캔 방식이다.
- 인덱스 루트에서 리프 블록까지 수직 탐색한 후에 리프 블록을 수평 탐색하는 방식이다.
- 수평 탐색 범위는 인덱스 구성, 조건절 연산자에 따라 달라진다.
- WHERE 절에 선두 컬럼이 있어야한다. 하지만 , 꼭 = 일 필요는 없고 LIKE, 부등호, LIKE 모두 가능하다.

## INDEX FULL SCAN

Index Full Scan은 인덱스 리프 블록을 처음부터 끝까지 모두 스캔하는 방식이며, `인덱스 선두 컬럼이 조건절에 없을 떄` 사용한다.

인덱스 선두 컬럼이 조건절에 없으면 Index Range Scan이 불가능하므로 테이블을 Full Scan해야 하는데, 컬럼이 많은 큰 테이블을 스캔하려면 블록 I/O가 많이 발생하므로 성능이 느리다.  
-> 컬럼이 적은 인덱스를 스캔하면 I/O 발생량을 줄일 수 있다. 단, 인덱스 필터 조건을 만족하는 데이터가 적어야 한다. 필터 조건을 만족하는 데이터가 많으면 테이블 랜덤 액세스도 그만큼 많이 발생하므로 테이블 전체 스캔보다 성능이 훨씬 느려진다.

필터 조건을 만족하는 데이터가 많더라도 결과집합 중 앞쪽 일부만 스캔하고 멈춘다면, 즉 부분범위 처리를 활용할 수 있다면, Index Full Scan이 효과적일 수 있다. 인덱스 앞쪽에서 조건을 만족하는 데이터를 빨리 찾을 수 있기 때문이다.

## INDEX UNIQUE SCAN

```sql
주문상품_PK : 주문일자 + 고객ID + 상품ID

SELECT 상품ID, 주문수량, 주문가격, 할인률
  FROM 주문상품
 WHERE 주문일자 = :ord_dt
   AND 고객ID  = :cust_id  
```

인덱스 구성 컬럼을 모두 '=' 조건으로 검색하면 Index Unique Scan이 선택되지만, 전체가 아닌 일부 컬럼으로 검색할 때는 Range Scan이 선택된다.


## INDEX Fast Full Scan

- Multiblock I/O 방식을 사용한다.
- 병렬 스캔도 가능하다.
- `인덱스에 포함된 컬럼으로만 조회 할 때` 사용할 수 있다.
- 인덱스 리프 블록끼리 논리적 연결 순서를 따르지 않고 Table Full Scan처럼 HWM 아래 익스텐트 전체를 Multiblock I/O 방식으로 Full Scan 하므로 결과 집합의 순서를 보장하지 않는다.


## Index Skip Scan

- 인덱스 선두 컬럼이 조건절에 없을 때 사용할 수 있는 스캔 방식 중 하나다.
- 인덱스 선두 컬럼이 조건절에 있을 때도 사용할 수 있다.
- INDEX_SS 힌트로 유도한다.

### 연습문제

```sql
ALTER TABLE 고객 ADD CONSTRAINT 고객_PK PRIMARY KEY(고객번호);
CREATE INDEX 고객_X01 ON 고객(고객등급, 연령);


SELECT 고객번호, 고객명, 가입일시, 고객등급, 연령, 연락처
  FROM 고객
 WHERE 연령 BETWEEN 20 AND 40
 ORDER BY 고객번호; 
```

-> 선두 컬럼이 WHERE 절에 없어 INDEX RANGE SCAN은 안된다.  
인덱스에 없는 컬럼을 포함하므로 Index Fast Full Scan은 불가능하다.  
고객등급 NDV가 적을수록 Skip Scan이 유리하다.

### 연습문제 2

```sql
ALTER TABLE 고객 ADD CONSTRAINT 고객_PK PRIMARY KEY(고객번호);
CREATE INDEX 고객_X01 ON 고객(연령, 고객명);

SELECT 고객번호, 고객명, 가입일시, 고객등급, 연령, 연락처
  FROM 고객
 WHERE 연령 BETWEEN 20 AND 40
   AND 고객명 = '홍길동'
ORDER BY 고객번호; 

```

-> 고객_PK를 사용하도록 힌트로 유도하면 고객번호가 조건절에 없으므로 INDEX FULL SCAN하게 된다.  
고객_X01를 사용하면 선두컬럼인 연령이 조건절에 있으므로 Index Range Scan이 가능하다. Index Skip Scan도 가능하다.  

동명이인이 거의 없다면 Range Scan 보다 Skip Scan이 유리하다.  
고객_X01 선두컬럼 연령이 조건절에 있으므로 Index Full Scan은 불가능하다.


### Index Skip Scan 문제 

Index Skip Scan은 NDV가 적은 인덱스 선두 컬럼이 조건절에 없을 때 유용한 스캔 방식인데, NDV가 적은 두 개의 선두컬럼이 모두 조건절에 없을 때도 사용할 수 있다.  

선두 컬럼이 부등호, BETWEEN, LIKE 같은 범위검색 조건일 때도 Index Skip Scan을 사용 할 수 있다.
IN일 경우에는 사용할 수 없다.

## B*Tree 인덱스에서 생길 수 있는 현상 

- Index Skew : 인덱스 엔트리가 왼쪽 또는 오른쪽으로 치우치는 현상을 말한다.
- Index Sparse : 인덱스 블록 전반에 걸쳐 밀도(density)가 떨어지는 현상을 말한다.
- Index Fragmentation : 디스크 상에 Page들이 연속적으로 위치해 있지 않고(서로 연관된 데이터들이 한 Extent로 묶이지 않는), 공간을 두고 떨어져 있는 현상

## 비트맵(Bitmap) 인덱스

비트맵 인덱스는 성별처럼 Distinct Value 개수가 적을 때 저장효율이 매우 좋다. 그런 컬럼이면 B*Tree 인덱스보타 훨씬 적은 용량을 차지하므로 인덱스가 여러 개 필요한 대용량 테이블에 유용하다.

비트맵 인덱스는 여러 인덱스를 동시에 사용할 수 있다.  
여러 개 비트맵 인덱스로 Bitwise연산을 수행함으로써 테이블 엑세스랑 크게 줄일 수 있다면 극적인 성능 향상을 가져다 준다.  
따라서, 다양한 조건절이 사용되는 특히 정형화되지 않은 임의 질의가 많은 대용량 DW/OLAP 환경에 적합하다.  

다만, 비트맵 인덱스는 Lock에 의한 DML 부하가 심한 것이 단점이다. 레코드 하나만 변경되더라도 해당 비트맵 범위에 속한 모든 레코드에 lock이 걸린다.  
OTLP성 환경에 비트맵 인덱스를 쓸 수 없는 이유가 바로 여기에 있다.


## 함수기반 인덱스

조건절에서 인덱스 컬럼에 함수를 적용하면 정상적인 Index Range Scan이 불가능하다.  
인덱스에는 가공하지 않은 값을 기준으로 정렬해서 저장했는데, 가공한 값으로 검색하면 수직적탐색을 통해 스캔 시작점과 끝 지점을 찾을 수 없기 때문이다.  
인덱스에도 함수를 적용한 상태로 저장하면 정상적인 Index Range Scan이 가능한데, 이것을 함수기반 인덱스라고 한다.

```sql
SELECT * FROM 고객 WHERE REPLACE(전화번호, '-', '') = :PHONE_NO
```

## 리버스 키(Reverse Key) 인덱스

일련번호, 입력일시, 변경일시 등 오름차순 한 방향으로만 값이 증가하는 컬럼에 인덱스를 생성하면, 동시에 INSERT 하려는 다중 트랜잭션에 의해 우측(마지막)에 경합이 발생할 수 있다. 그럴 때 인덱스 키 값을 역으로(reverse) 변환해서 지정하면 신규 INSERT하는 값들이 여러 리프 블록에 흩어지므로 경합도 자연스럽게 줄어든다.  

리버스 키 인덱스를 생성하는 방법
```sql
CREATE INDEX HOT_TABLE_R1 ON HOT_TABLE( RIGHT_GROWING_COL ) REVERSE; 

CREATE INDEX HOT_TABLE_R1 ON HOT_TABLE( REVERSE(RIGHT_GROWING_COL));


SELECT * FROM HOT_TABLE A
WHERE REVERSE(RIGHT_GROWING_COL) = REVERSE(:KEYWORD)
```

### 여러 인덱스 특징 ( 랜덤 액세스를 줄일 수 있다.)

- IOT는 테이블을 인덱스 구조로 관리한다. 일반 힙(Heap) 구조 테이블은 값을 무작위로 입력하지만, IOT는 지정한 키 값 순으로 정렬 상태를 유지한다. 키 값 이외의 컬럼도 모두 인덱스 리프 블록에 저장하므로 테이블 랜덤 액세스가 전혀 발생하지 않는다.

- 클러스터는 값이 같은 레코드를 한 블록(데이터 많을 경우 연결된 여러 블록)에 모아서 저장하므로 인덱스를 이용한 테이블 랜덤 액세스를 줄이는데 도움을 준다.

- 테이블 파티션은 사용자가 지정한 기준에 따라 데이터를 세그먼트 단위로 모아서 저장한다. 따라서 특정 조건을 만족ㄱ하는 데이터를 인덱스를 이용한 랜덤 액세스가 아닌 full Scan 방식으로 빠르게 찾을 수 있다.


## IOT(Index-Organized Table)

- IOT는 PK순으로 정렬 상태를 유지하는 테이블이다.  
일반 속성이 없꼬 PK가 테이블 IOT로 구성하면, 별도 PK 인덱스를 생성하지 않아도 되므로 공간을 절약할 수 있고 Insert 성능도 높일 수 있다.

- 일자순으로저장하고 PK끼리 모아서 저장하므로 조회하는 성능쿼리를 높일 수 있다.

- 일자 순으로 정렬되도록 IOT를 구성하면, 한 달 이상 넓은 범위로 조회하더라도 테이블 랜덤 액세스가 전혀 발생하지 않아 빠른 조회가 가능하다.

- 일반적인 속성을 IOT 리프 블록에 저장할 경우, 인덱스 Dept가 증가하고 블록 I/O를 증가시킴으로써 랜덤 엑세스 감소 효과를 상쇄한다.

- SQL server 클러스트형 인덱스는 PK가 아닌 컬럼으로도 생성할 수 있다.

- 클러스터형 인덱스는 데이터를 정렬하는 기준을 정의하는 기능이므로 테이블에 한 개만 생성할 수 있다. (Oracle, SQL serverr 둘다)


### Index Range Scan 불가 조건

인덱스를 정상적으로 Range Scan 할 수 없는 이유는 인덱스 스캔 시작점을 찾을 수 없기 때문이다.  
일정 범위를 스캔하려면 '시작지점' 과 '끝지점'이 있어야한다.

- 중간 값 검색(양쪽 % LIKE 조건) 하는 경우
- 부정형 비교 조건인 경우
- 인덱스 컬럼을 변경하는 경우
- NVL() 같은 경우는 값에 따라 인덱스 Range Scan 가능 여부가 결정된다.


### IS NULL 조건에 대한 Index Range Scan

오라클 구성 컬럼이 모두 NULL인 레코드는 인덱스에 저장하지 않습니다. 따라서 단일 컬럼에 생성한 인덱스에 대한 IS NULL 조건으로 Index Range Scan이 불가능하다.  
2개 이상 컬럼으로 구성된 결합 인덱스에 대해서는 IS NULL 조건에 대한 Index Range Scan이 가능하다. 구성 컬럼 중 하나라도 NULL이 아닌 레코드는 인덱스에 저장하기 때문이다.


### Index Range Scan 가능 조건

인덱스를 Range Scan 하려면 인덱스 선두 컬럼이 가공되지 않은 상태로 조건절에 있어야 한다.

조건절이 NOT BETWEEN 조건인경우 CONCATENATION(옵티마이저에 의한 UNION ALL 분기)가 일어나면 RangeScan이 가능하다.  
참고로, CONCATENATION을 유도하려면 USE_CONCAT 힌트를 쓰면 된다.

OR 조건은 기본적으로 Index Range Scan을 위한 엑세스 조건으로 사용할 수 없다.

-> 인덱스에 없는 컬럼을 쓸경우 Table Full Scan을 하게 된다.




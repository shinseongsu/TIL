# 1회 실전모의고사

## 오라클 메모리 구성 요소 항목

1. PGA  
각 오라클 서버 프로세스는 자신만의 PGA(Process/Program/Private Global Area) 메모리 영역을 할당받고, 이를 프로세스에 종속적인 고유 데이터를 저장하는 용도로 사용한다.

2. UGA  
전용 서버(Dedicated Server) 방식으로 연결할 때는 프로세스와 세션이 1:1 관계를 갖지만, 공유 서버(Shared Server 또는 MTS) 방식으로 연결할 떄는 1:M 관계를 갖는다. 즉, 하나의 프로세스가 여러 개 세션을 위해 일한다. 따라서 각 세션을 위한 독립적인 메모리 공간이 필요해지는데, 이를 'UGA(User Global Area)'라고 한다.

3. CGA  
오라클은 하나의 데이터베이스 Call을 넘어서 다음 Call까지 계속 참조되어야 하는 정보는 UGA에 담고, Call이 진행되는 동안에만 필요한 데이터는 CGA에 담는다. CGA는 Parse Call, Execute Call, Fetch Call마다 매번 할당받는다. CGA에 할당된 공간은 하나의 Call이 끝나자마자 해제된다.


## 오라클 데이터베이스 저장구조에 대한 설명

한 세그먼트는 정확히 한 테이블스페이스만 속하지만 여러 데이터 파일에 걸쳐 저당된다. 한 테이블스페이스가 여러 데이터 파일로 구성되기 떄문이다. 한 테이블 스페이스에는 당연히 여러 세그먼트가 존재한다.  

세그먼트는 익스텐트의 집합이며, 익스텐트는 연속된 블록의 집합이다. 한 익스텐트에 담긴 블록은 모두 같은 테이블(또는 인덱스) 블록이다.


## 오라클 용어

버퍼캐시에 있는 블록 버퍼를 깽신하기 전에 먼저 Redo 엔트리를 록그 버퍼에 기록해야 하여, DBWR가 버퍼캐시로부터 Dirty 블록들을 디스크에 기록하기 전에 먼저 LGWR가 해당 Redo 엔트리를 모두 Redo 로그 파일에 기록했음이 보장되어야 한다. 이를 `Write Ahead Logging`이라고 한다.

사용자가 요구한 갱신 사항을 휘발성인 버퍼캐시에만 기록한 채 아직 디스크에 영구 기록하지 않았더라면 Redo 로그를 믿고 빠르게 커밋을 오나료하는 매커니즘 `Fast Commit`이라고 한다.  

변경된 블록을 커밋 시점에 바로 Cleanout 하지 않고 끄대로 두었닥가 나중에 해당 블록을 처음 읽는 세션에 의해 정리되도록 하는 것을 `Delayed Block Cleanout`이라고 한다.

DML을 수행하는 사용자 프로세스가 로그 버퍼에 로그를 기록하고 데이터 블록을 변경한다.  
이후 Log Writer(LGWR)가 주기적으로 로그 버퍼 엔트리를 Redo 로그 파일에 기록하는데, 메모리상의 로그 버퍼는 언제든 유실될 가능성이 있다. 따라서 트랜잭션의 영속성을 보장하려면 최소한 커밋 시점에는 로그를 메모리가 아닌 디스크 파일에 안전하게 끼록해야 한다. 이를 `Log Force at commit`이라고 한다.


## 오라클 버퍼 블록이 놓일 수 있는 3가지 상태

`Free 버퍼`: 인스턴스 기동 후 아직 데이터가 읽히지 않아 비어 있는 상태(Clean 버퍼)이거나, 데이터가 담겼지만 데이터파일과 서로 동기화돼 있는 상태에서 언제든지 덮어 써도 무방한 버퍼 블록을 말한다. 오라클이 데이터파일로부터 새로운 데이터 블록을 로딩하려면 먼저 Free 버퍼를 확보해야 한다. Free 상태인 버퍼에 변경이 발생하면 그 순간 Dirty 버퍼로 상태가 바뀐다.

`Dirty 버퍼`: 버퍼캐시에 적재된 이후 변경이 발생했지만, 아직 데이터파일에 기록하지 않아 동기화가 필요한 버퍼 블록을 말한다. 이 버퍼 블록들을 다른 데이터 블록을 위해 재사용하려면 데이터파일에 먼저 기록해야 하며, 그 순간 Free 버퍼로 상택가 바뀐다.

`Pinned 버퍼`: 읽기 또는 쓰기 작업을 위해 현재 액세스되고 있는 버퍼 블록을 말한다.


## 데이터베이스 I/O 설명

1. 전통적인 I/O 비용 모델에서는 예상 I/O Call 횟수가 곧 비용(Cost)이었다. 최신 CPU 비용 모델에서는 CPU 사용량을 감안해서 비용을 산정하지만, 여전히 예상 I/O Call 횟수가 절대적인 비중을 차지한다.

2. SQL 성능이 느린 대부분의 원인은 디스크 I/O 때문이다. 하지만, 디스크 I/O 발생량을 직접 줄일 수 없다. 논리적인 I/O 발생량을 최소화함으로써 물리적인 디스크 I/O 발생량을 줄이는 것이 I/O 튜닝이다.

3. 데이터베이스는 블록 단위로 I/O를 처리한다. 특정 로우만 액세스하고 싶어도 해당 로우가 속한 블록을 통째로 I/O 한다는 뜻이다. 따라서 전형적인 온라인 트랜잭션을 주로 처리하는 시스템이라면 블록 사이즈를 작게(2kb 또는 8kb) 설정하는 것이 유리하다. 버퍼캐시에 불필요한 데이터가 많이 적재되는 부작용을 최소화할 수 있기 떄문이다.  
하지만, 요즘 대부분의 시스템은 온라인 트랜잭션 처리와 대량 데이터 분석 처리를 병행하는 하이브리드 형태이기 때문에 대개 기본 사이즈(8K)를 그대로 사용하며, 필요할 때 Multiblock I/O 단위를 늘려서 대용량 처리 성능을 극대화한다.


## 대기 이벤트

1. latch: cache buffers chains 대기 이벤트는 특정 캐시버퍼 체인을 동시다발적으로 탐색하거나 변경하려고 할 때 나타난다.

2. buffer busy waits 대기 이벤트는 특정 블록에 대한 동시다발적인 읽기 또는 쓰기 요청으로 인해 버퍼 Lock 경합이 발생할 때 나타난다.

3. log buffer space 대기 이벤트는 서버 프로세스에 의한 Redo 생성량이 너무 많아 LGWR가 로그 버퍼 내용을 파일에 다 기록하기도 전에 로그 버퍼가 다 찰 때 나타난다.


## SingleBlock / MultiBlock

- SingleBlock - Index Unique Scan, Index Range Scan, Index Full Scan, Index Skip Scan

- MultiBlock - Table Full Scan, Index Fast Full Scan


## Index Range Scan이 가능한 경우

```sql

[ 인덱스 구성 ]
주문_PK : 주문번호
주문_X1 : 주문유형코드 + 계좌번호
주문_X2 : 주문일자 + 고객번호

예 ) SELECT * FROM 주문 WHERE 주문일자 LIKE '2021%' AND 고객번호 LIKE '%' || :CUST_NO || '%'

- 인덱스를 Range Scan 하려면 선두 컬럼이 가공되지 않은 상태로 조건절에 있어야 한다. 반대로 말해, 인덱스 선두 컬럼이 가공되지 않은 상태로 조건절에 있으면 인덱스 Range Scan은 무조건 가능하다.

```

## 옵티마이저에 의해 선택될 인덱스 스캔방식은?

```sql
[ 인덱스 구성 ]
주문_PK : 주문번호
주문_X1 : 전화번호 + 주문일자

SELECT /* index(o) */
  FROM 주문 o
 WHERE 전화번호 = '01012345678' OR 고객번호 = 'C8378036'

- OR 조건을 분기해 인덱스를 Range Scan 할 수 있는 경우가 있으나, 분기된 각각에 대해 사용할 인덱스가 없으면 옵티마이저는 기본적으로 Table Full Scan을 선택한다. 문제의 SQL처럼 INDEX 힌트를 사용할 경우 Index Full Scan을 선택한다.  
문제의 SQL은 인덱스에 없는 컬럼도 읽어야 하므로 Index Fast Full Scan이 불가능하다.

```

## 인덱스가 주어졌을때, SQL별 어떤 스캔을 타는지 말하여라.

```sql
[ 인덱스 구성 ]
거래_X01 : 고객번호 + 거래일자 + 거래유형코드

1. WHERE 거래일자 = :TRD_DT  
     AND 거래유형코드 = :TRD_CLS_CD

- 고객번호 조건절이 없으므로 인덱스를 Full Scan한다.

2. WHERE 고객번호 = :CUST_NO
     AND 거래일자 LIKE :TRD_DT || '%'
     AND 거래유형코드 = :TRD_CLS_CD

- 고객번호 =, 거래일자 LIKE  조건절이 가리키는 범위를 스캔하면서 거래유형코드를 필터링 하므로 스캔 과정에 비효율이 나타날 수 있다.     

3. WHERE 고객번호 := CUST_NO
     AND 거래일자 := TRD_DT
     AND 거래유형코드 LIKE 'Z' || '%'

- 고겍 반허 =, 거래일자 =, 거래유형코드 LIKE 조건절이 가리키는 범위만 정확히 스캔한다.

4. WHERE 고객번호 := CUST_NO
     AND 거래유형코드 = :TRD_CLS_CD
     AND 거래금액 = :TRD_AMT               

- 고객번호 조건절이 가리키는 범위를 모두 스캔하면서 거래유형코드를 필터링하므로 스캔 과정에 비효율이 나타날 수 있다. 더구나, 거래금액 조건절은 테이블 액세스 후에 필터링한다.

```

## 거래 데이터를 조회하는 화면에서 거래일자는 반드시 입력해야 하지만, 고객번호는 입력하지 않을 수 있다. 거래 테이블에 인덱스가 아래와 같이 구성된 상황에서 최적SQL을 작성하는 방안으로 가장 부적절한 것을 고르시오.

```sql
[ 인덱스 구성 ]
거래_PK : 거래번호
거래_X1 : 고객번호 + 거래일자
거래_X2 : 거래일자

1. 아래와 같이 두 개 SQL을 작성하고, 고객번호 입력 여부에 따라 하나를 선택해서 실행한다.

SELECT * FROM 거래 WHERE 거래일자 BETWEEN :TRD_DT1 AND :TD_DT2

SELECT * FROM 거래 WHERE 고객번호 = :CUST_NO AND 거래일자 BETWEEN :TRX_DT1 AND :TRD_DT2


2. SELECT * FROM 거래
    WHERE :CUST_NO IS NULL
      AND 거래일자 BETWEEN :TRD_DT1 AND :TRD_DT2
    UNION ALL
   SELECT * FROM 거래
    WHERE :CUST_NO IS NOT NULL
      AND 고객번호 := CUST_NO
      AND 거래일자 BETWEEN :TRD_DT1 AND :TRD_DT2 


3. SELECT * FROM 거래
    WHERE 고객번호 = NVL(:CUST_NO, 고객번호)
      AND 거래일자 BETWEEN :TRD_DT1 AND :TRD_DT2


4. SELECT * FROM 거래
    WHERE 고객번호 LIKE :CUST_NO || '%'
      AND 거래일자 BETWEEN :TRD_DT1 AND :TRD_DT2

- 고객번호가 숫자형 컬럼이면 자동형변환이 일어나므로 고객번호사 선두컬럼인 거래_X1 인덱스를 Range Scan 할 수 없다.

```

## 인덱스 구성이 아래와 같을 때 튜닝 방안으로 가장 부적절한것을 고르시오.

- 하루 주문 데이터는 10만건이며, 주문 데이터 보관 기간은 5년
- 주문유형코드로는 5개 값이 존재하며, 주문 시 반드시 입력

```sql
[ 인덱스 구성 ]
주문_PK : 주문번호
주문_X1 : 주문유형코드 + 고객번호 + 주문일시
주문_X2 : 주문일시 + 고객번호

SELECT *
  FROM 주문
 WHERE 고객번호 = :CUST_NO
   AND 주문일시 >= TRUNC(SYSDATE-2)

------------------
Execution Plan

SELECT STATEMENT Optimizer=ALL_ROWS
    TABLE ACCESS (FULL) OF 주문


- Index Range Scan으로 유도하기 위해 INDEX(주문 주문_X1) 힌트를 추가한다.

- SQL을 아래와 같이 수정한다.  

SELECT * FROM 주문
WHERE 고객번호 :CUST_NO
AND 주문일시 >= TRUNC(SYSDATE-2)
AND 주문유형코드 IN (SELECT 주문유형코드 FROM 주문유형)

- Index Skip Scan을 유도하기 위해 INDEX_SS(주문  주문_X1) 힌트를 추가한다.




```


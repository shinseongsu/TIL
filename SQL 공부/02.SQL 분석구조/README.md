# SQL 분석 도구

## 1. 예상 실행계획

- 오라클에서 실행 계획 확인법

```sql
explain for
select * from emp where ename = :ename and deptno = :deptno;

select * from table(dbms_xplain.display(null, null, 'typical'));
```

- SQL server에서 실행계획 확인법

```sql
use pubs
go
set showplan_text
go
select * from dbo.employee
go
```

- 오라클 예상 실행계획에서 확인할 수 있는 정보

1. Plan Hash Value
2. 오브젝트 액세스 방식(Operation)
3. 오브젝트 명
4. 예상 Cadinality(=Rows)
5. 예상 데이터 크기(Bytes)
6. 예상 cost
7. 예상 CPU TIME
8. 조건절 정보 (Predicate Information)


오라클 AutoTrace 확인 법

```sql
set autotrace traceonly;

select empno, ename, deptno from emp where ename = 'SCOTT';
```

알수 있는점

1. 예상 실행계획
2. 실제 디스크에 읽은 블록 수
3. 실제 기록한 Redo 크기


Autotrace 옵션

1. set autotrace on  
SQL을 실행하고 결과집합과 함께 예상 실행계획 및 실행통계를 출력한다.
2. set autotrace on explain  
SQL을 실행하고 결과집합과 함께 예상 실행계획을 출력한다.
3. set autotrace on statistics  
SQL을 실행하고 결과집합과 함께 실행통계를 출력한다.
4. set autotrace traceonly  
SQL을 실행하지만 결과는 출력하지 않고, 예상 실행계획과 실행통계만 출력한다.
5. set autotrace explain  
SQL을 실제로 실행하지 않고, 예상 실행계획만 출력한다.
6. set autotrace traceonly statistics  
SQL을 실행하지만 결과는 출력하지 않고, 출력 통계만 출력한다.


## 2.SQL 트레이서

- 오라클에서 SQL 트레이서를 확인할떄,

```sql
alter session set sql_trace=true;

select * from emp where ename = 'SCOTT';
```

- SQL server 에서 SQL 트레이서를 확인할때,

```sql
use pubs
go
set statistics profile
set statistics io on
set statistics time on
go
select * from dbo.employee
go
```


* tkprof : 오라클 트레이스 파일을 분석해서 리포트 파일을 생성해 주는 명령어

SQL 트레이서에서 확인할 수 있는 정보

1. 하드파싱 횟수
2. 실제 사용한 CPU Time
3. 실제 디스크에서 읽은 블록 수


- 오라클 SGA 메모리에 기록한 SQL 트레이스 정보를 출력하고자 할 때, 힌트와 함수명을 적으세요.

```sql
select /*+ gather_plan_statistics */ count(*) from big_table;

select * from table(dbms_xplan.display_cursor(null, null, 'allstats last'));
```

## 3. 응답시간 분석

`Shared Pool`: 특정 오브젝트 정보 또는 SQL 커서를 위한 Free Chunk를 할당받으려 할 떄 shared pool 래치를 할당받아야한다.  
하드 파싱을 동시에 심하게 일으킬 때 주로 나타난다.

`library cache lock` 과 `lobrary cache pin` 대기이벤트 : 주로 SQL 수행 도중 DDL을 수행 할 떄 나타난다.

`free buffer waits` 대기이벤트 : 서버 프로세스가 버퍼 캐시에서 Free Buffer를 찾지 못해 DBW에게 공간을 확보해 달라고 신호를 보낸 후 대기할 떄 나타낸다.

`log file sync` 대기이벤트: 커밋 명령을 전송받은 서버 프로세스가 LGWR에게 로그 버퍼를 로그 파일에 기록해 달라고 신호를 보낸 후 대기할 때 나타난다.

<br>
<br>

- 대기 이벤트 기반

대기 이벤트를 기반으로 세션 또는 시스템 전체에 발생하는 병목 현상과 그 원인을 찾아 문제를 해결하는 방법, 과정을 `대기 이벤트(Wait Event) 기반` 또는 `응답 시간 분석(Response Time Analysis)` 성능관리 방법론이라고 한다.

```
Response Time = Service Time + Wait Time
              = CPU Time     + Queue Time
```

서비스 시간(Service Time, CPU Time)은 프로세스가 정상적으로 동작하며 일을 수행한 시간  
대기 시간(Wait Time, Queue Time) CPU을 OS에 반환하고 수면(Sleep) 상태에서 대기한 시간을 의미한다.


- AWR

오라클은 전총적으로 사용하던 Ratio 기반 성능 분석 방법론에 응답 시간 분석 방법론을 더해 Statspack을 개발하였고, 이를 확장 및 업그레이드해서 만든 것이 AWR이다.  

성능 이슈를 해결하려면 peek 시간대 또는 장애 발생 시점을 전후에 가능한 한 짧은 스냅샷 구간을 선택해야 한다.  

특정 시점에 시스템에 큰 부하가 발생했어도 하루 또는 일주일 보고서로 출력해서 보면 초당 부하 발생량과 대기 시간에 전혀 문제가 없는 것처럼 평군 수치가 나타나기 때문이다.  

사용자 인터뷰를 통해 성능 저하 현상을 경험했던 시간대를 파악하거나 sar, topas, vmstat, osstat 등 OS 모니터링 도구를 이용해 CPU 메모리, I/O 사용량 정보를 수집하고 이를 통해 peak 시간대를 파악할 수 있다.

AMR은 뷰를 조회하지 않고 DMA(Direct Memory Access) 방식으로 SGA 공유 메모리를 직접 액세스해서 성능 정보를 수집하기 때문에 좀 더 빠르게 정보를 수집할 수 있다. 부하가 적기 때문에 Statspack 보다 더 자주 더 많은 정보를 수집할 수 있게 되었다.


- AWR 보고서 보고서 요약(Report Summary) 내용 

- 캐시 크기 (Cache Sizes)
- 부하 프로파일 (Load Profile)
- 인스턴스 효율성(Instance Efficiency)
- 최상위 대기 이벤트 (Top N Events)
- Shared Pool 통계 (Shared Pool Statistics)
- IO 프로파일 (IO Profile)
- 메모리 통계 (Memory Statistics)


<br><br>

- SQL 파싱 항목

`Soft Parse` : 실행계획이 라이브러리 캐시에서 찾아져 하드파싱을 일으키지 않고 SQL을 수행한 비율이다.

(전체 Parse Call 횟수 - 하드파싱 횟수 ) / (전체 Parse Call 횟수 ) * 100

`Execute to Parse` : Parse Call 없이 곧바로 SQL을 수행한 비율, 즉 커서를 애플리케이션에서 캐싱한 채 반복 수행한 비율이다.

`Parse CPU to Parse Elapsd` : 파싱 총 소요 시간 중 CPU time이 차지한 비율이다. 파싱에 소요된 시간 중 실제 일을 수행한 시간 비율을 말하며, 이 값이 낮가면 파싱 도중 대기가 많이 발생했음을 의미한다.

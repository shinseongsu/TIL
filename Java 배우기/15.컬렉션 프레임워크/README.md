# 컬렉션 프레임워크 (Collection Framework)

- 여러 데이터를 편리하게 관리할 수 있게 만들어 놓은 것
  - 자료 구조 및 알고리즘을 구조화

- 대표 인터페이스
  - List 인터페이스, Set 인터페이스, Map 인터페이스


## List 인터페이스

- 순서가 있는 데이터의 집합
- 데이터 중복 허용
- 대표 구현 클래스
  - ArrayList
  - LinkedList
  - Verctor

```java
ArrayList list1 = new ArrayList();
LinkedList list2 = new LinkedList();
Vector v = new Vector();
```

## Set 인터페이스

- 순서가 없는 데이터의 집합
- 데이터의 중복 허용 하지 않음
- 대표 구현 클래스
  - HashSet
  - TreeSet

```java
HashSet set1 = new HashSet();
TreeSet set2 = new TreeSet();
```

## Map 인터페이스

- 키와 값의 쌍으로 이루어진 데이터 집합
- 순서를 유지 하지 않음
- 대표 구현 클래스
  - HashMap
  - TreeMap

```java
HashMap map1 = new HashMap();
TreeMap map2 = new TreeMap();
```

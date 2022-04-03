# 스트림 ( Stream )

- 배열, 컬렉션 등의 데이터를 하나씩 참조하여 처리 가능한 기능
- for문의 사용을 줄여 크기를 간결하게 함
- 스트림은 크게 3가지로 구성
  - Stream 생성
  - 중개 연산
  - 최종 연산

> 데이터소스 객체, Stream 생성().중개연산().최종연산();

## 스트림 생성 

- 배열 스트림

```java
String[] arr = new String[]{ "a", "b", "c" };
Stream stream = Arrays.stream(arr);
```

- 컬렉션 스트림

```java
ArrayList list = new ArrayList(Arrays.asList(1, 2, 3));
Stream stream = list.stream();
```

## 스트림 중개연산

- Filtering
  - filter 내부 조건에 참인 요소들을 추출

```java
IntStream intStream = IntStream.range(1, 10).filter(n -> n % 2 ==0);
```

- Mapping
  - map 안의 연산을 요소별로 수행

```java
IntStream intStream = IntStream.range(1, 10).amp(n -> n + 1);
```


## 스트림 최종연산

- Sum, Average

```java
IntStream.range(1, 5).sum()
IntStream.range(1, 5).average().getAsDouble()
```

- min, max

```java
IntStream.range(1, 5).min().getAsInt();
IntStream.range(1, 5).max().getAsInt();
```
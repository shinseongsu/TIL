# 재고 시스템으로 알아보는 동시성

1. Synchoronized

```java
public synchronized void decrease(Long id, Long quantity) {
```

- 문제점 : 한 프로세스안에서만 동시성이 보장이 된다. 두개의 서버가 사용이 될때는 보장되지 않는 점이 있다.


2. PERSSIMISTIC_WRITE LOCK 사용

```java
@Lock(value = LockModeType.PESSIMISTIC_WRITE)
```

- 장점 : 충돌이 자주 일어나면 옵티머스 보다 더 좋을 수 있다.
        락을 통해 update를 작업해 일관성이 유지됩니다.
- 단점 : 성능이 느려진다.

3. Perssimistic Lock 사용

```java
@Lock(value = LockModeType.OPTIMISTIC)
```

- 장점 : Perssimistic lock 보다는 빠르다
- 단점 : 실패할 경우 재시도 하는 로직을 만들어야 한다.


4. named Lock 사용

```java
@Query(value = "select get_lock(:key, 1000)", nativeQuery = true)

@Query(value = "select release_lock(:key)", nativeQuery = true)
```

- 장점 : 코드가 간단하다
- 단점 : lock 사용하면 Connection Pool이 부족할 수 있어 실무에서는 DataSource를 분리하여 사용한다.


5. redis Lettuce Lock 방식

```java
redisTemplate
            .opsForValue()
            .setIfAbsent(generateKey(key), "lock", Duration.ofMillis(3_000));
```

- 장점 : 구현이 간단하다.
        재시도가 필요한 경우 lettuce 활용
- 단점 : spin lock 방식이여서 redis 부하가 발생합니다.


6. redis Redission

```java
RLock lock = redissonClient.getLock(key.toString());
```

- 장점 : 락 획득 재시도 기본으로 제공한다.
  - pub-sub 방식으로 구현되어 lettuce방식보다 부하가 덜 간다.
- 단점 : lock을 라이브러리가 지원하긱 때문에 docs을 읽어야한다.

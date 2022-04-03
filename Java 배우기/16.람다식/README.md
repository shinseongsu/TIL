# 람다식

## 람다 표현식 (Lambda Expression)

- 메소드 대신 하나의 식으로 표현하는 것
- 익명 함수 (Anonymous function)

```java
반환타입 메소드이름 (매개변수, ...) {
    실행문    
}

public int sum(int x, int y) {
    return x + y;    
}
```

```java
(매개변수, ...) -> { 실행문 ... }
(int x, int y) -> { return x = y; }
```

## 람다식 장점

- 일반적으로 코드가 간결해짐
- 코드 가족성이 높아짐
- 생산성이 높아짐


## 람다식 단점

- 재사용이 불가능(익명)
- 디버깅 어려움
- 재귀함수로는 맞지 않음


# 인터페이스

- 다중 상속처럼 사용할 수 있는 기능
- 추상 메소드와 상수만으로 이루어짐

```java
접근제어자 interface 인터페이스이름 {
    public static final 타입 상수이름 = 값;
    public abstract 반환타입 메소드이름(배개변수);
    ...
}

class 클래스 implements 인터페이스 {
    ...
}
```

- 동시 사용으로 다중 상속과 같은 효과

```java
접근제어자 interface 인터페이스 {
    ...
}

접근제어자 class 클래스 {
    ...
}

class 클래스 extends 클래스 implements 인터페이스 {
    ...
}
```
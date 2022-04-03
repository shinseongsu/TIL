# 내부 클래스 (Inner Calss)

- 클래스 In 클래스 (클래스 안에 선언한 클래스)

```java
class Outer {
    ...
    
    class Inner {
        ...
    }
}
```

## 내부 클래스 특징

- 내부 클래스에서 외부 클래스 멤버에 접근 가능
- 외부에서는 내부 클래스에 접근 불가

## 내부 클래스 종류

- 인스턴스 클래스 (instance class)
- 정적 클래스 (static class)
- 지역 클래스 (local class)
- 익명 클래스 (anonymous class)


## 익명 클래스 (Anonymous Class)

- 이름을 가지지 않는 클래스
- 선언과 동시에 객체 생성
- 일회용 클래스

```java
클래스이름 참조변수 이름 = new 클래스 이름() { 
    ...
};
```


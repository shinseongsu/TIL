# 다형성 ( Polymorphism )

- 한 객체가 여러 가지 타입을 가질 수 있는 것
- 부모클래스 타입의 참조 변수로 자식 클래스 인스턴스 참조

```java
class Person { }
class Student externds Person { }

Person p1 = new Student();
```


## instanceof

- 실제 참조하고 있는 인스턴스의 타입 확인

```java
class Person { }
class Student externds Person { }

Person p1 = new Student();
System.out.println(p1 instanceof Person);
```


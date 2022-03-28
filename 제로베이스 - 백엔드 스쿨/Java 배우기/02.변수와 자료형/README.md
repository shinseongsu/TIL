# 변수 (Vriable)

- 데이터를 저장하는 메모리 공간에 붙여준 이름

```java
int age = 20;
String country = "Korea";
```

int 는 자료형 ,  age 는 변수명이라고 부른다.  


## 변수 이름 규칙

| 변수 규칙 | 예시  
|---|---|
문자와 숫자, _(underscore), $ 사용가능 | int apple = 2000;<br>intapple3 = 6000;<br>int _apple = 2000;
숫자로 시작 x | int 3apple = 6000;
대문자와 소문자 구분 | int apple = 2000; <br> int Apple = 3000; <br> int APPLE = 3500;
공백 사용 x | int one apple = 2000;
미리 예약된 이름 사용 x | int true = 1; <br> int if = 2; int continue = 10;


## 표기법

- 카멜 표기법 (camelCase)
    - 가장 앞의 문자는 소문자로, 나머지 단어의 첫 문자는 대문자로 표기  
  ex) myName, zeroBase, iPhone, powerPoint  

- 파스칼 표기법 (PascalCase)
    - 각 문자의 첫 문자를 대문자로 표기
  ex) MyName, ZeroBase, IPhone, PowerPoint



## 자료형 (Data Type)

- 변수의 종류, 단위 
  - 숫자 (Nubmer)
  - 부울 (Boolean)
  - 문자 (Character)
  - 문자열 (String)
  - ...

- 변수의 종류에 따라 담을 수 있는 데이터의 타입과 크기가 다름


## 자료형 - 숫자(Number)

- 숫자 형태의 자료형
  - 정수 / 실수 / 2진수, 8진수, 16진수

종류 | 예시
|---|---|
정수 | int intNum = 10; <br> long longNum = 2147483648L;
실수 | float floatNum = 0.1f;  <br> double doubleNum = 3.4028236E38;
2진수, 8진수, 16진수 | // 10진수 12 를 다른 진수로 표현 시,  <br> int numBase2 = 0b1100;  <br> int numBase8 = 014;  <br> int numBase16 = 0xC;


## 자료형 - 부울 (Boolean)

- 참과 거짓을 나타내는 자료형

```java
boolean isPass = true;
boolean isOk = false;
```

## 자료형 - 문자 (Charactrer)

- 한 개의 문자 표현에 사용하는 자료형

```java
char keyFirst = 'a';
char keyLast = 'z';
```

## 자료형 - 문자형 (String)

- 문자로 이루어진 집합

```java
String s1 = "Hello World!";
String s2 ="01234";
```

- 문자열 메소드
  - equals indexOf, replace, substring, toUpperCase


## 자료형 - StringBuffer

- 문자열을 자주 추가하거나 변경할 때 사용하는 자료형

```java
StringBuffer sb1 = new StringBuffer("Hello World!");
```

- StringBuffer 메소드
  - append, insertm substring


## 자료형 - 배열 (Array)

- 많은 수의 데이터를 담을 수 있는 자료형

```java
int[] myArray1 = {1, 2, 3, 4, 5};
char[] myArray2 = {'a', 'b', 'c', 'd', 'e'};
```


## 자료형 - 리스트(List)

- 배열과 같이 여러 데이터를 담을 수 있는 자료형
- 추가로 여러가지 메소드를 제공

```java
ArrayList l1 = new ArrayLiist();
l1.add(1);
```

- 리스트 메소드
  - add, get, size, remove, clear, sort, contains


## 자료형 - 맵 (Map)

- Key, value 형태로 데이터를 저장하는 자료형

```java
HashMap<String, String> map = new HashMap<String, String>();
map.put("product", "kiwi");
map.put("price", "9000");
```

- 맵 메소드
  - put, get, size, remove, containsKey


## 자료형 - 제네릭스 (Generics)

- 자료형을 명시적으로 지정
- 제한적일 수 있지만 안정성을 높여주고 형변환을 줄여줌

```java
ArrayList<String> l1 = new ArrayList<String>();
HashMap<String, Integer> map1 = new HashMap<String, Integer>();
```
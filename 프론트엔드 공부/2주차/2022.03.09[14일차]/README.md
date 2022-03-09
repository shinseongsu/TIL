# 2022.03.09[14일차]

기존에 알던 내용이진만 기초일수록 순간적으로 기억이 나지 않는 경우가 많이 있어 차근차근 공부 해 기초를 확실히 다질 생각이다.

## 코딩 테스트랑?

sw기본역량을 정량 평가하기 위해 문제 해결 능력과 구현능력을 코딩으로 시험보는 것을 말한다.  
대표적인 문제 유형으로는 문제의 요구사항을 코드로 만드는 구현, 깊이우선탐색(DFS)와 너비우선탐색(BFS)를 사용한 완전탐색, 그리고 가장 이득이 되는 선택을 반복하는 탐욕알고리즘이 있다.  
javascript로 코딩문제를 풀기 위해서 Node.js를 사용한다.

## JavaScript

JavaScript는 객체 기반의 스크립트 프로그래밍 언어이다.  
JavaScript를 표준화 하기 위해 만든 ECMAScript 사양을 준수하는 범용 스크립트 언어이다.  
네이밍이 JavaScript라고 해서 Java와 연관이 있지는 않다.  
Mocha를 시작으로 LiveScript라는 이름으로 바뀌었다가 현재의 Javascript가 되었다.  
웹의 동작을 구현하기 위해 개발되었다.

## Node.js

Node.js는 V8로 빌드된 이벤트 기반 자바스크립트의 런타임 환경이다.  
확장성 있는 네트워크 애플리케이션, 서버사이드 개발에 주로 사용된는 SW 플랫폼이다.

## 기본 입출력

사용자가 프로그램과 상호작용 하기위한 방법이다. 기본 입출력이 종류로는 표준 입력, 표준 출력, 표준 오류 출력이 있다.

### 표준입력 (stdin)

사용자가 프로그램과 상호작용 하기위한 방법이다. 기본 입출력의 종류로는 표준 입력, 표준 출력, 표준 오류 출력이 있다.

### 표준출력 (stdout)

일반적으로 컴퓨터 모니터에 문자열로 출력한다.  
프로그램의 실행 상태 혹은 결과를 보고 판단하며 알고리즘에서 문제의 정답 확인, 디버깅용으로 사용한다.

## 자바스크립트의 코드 구성

JS의 문법은 대부분 C, C++, JAVA로 부터 차용하여 제작된 스크립트기반언어이다. 자바스크립트 응용 프로그램은 명령문으로 이루어져 있으며, 이 명령문은 표현식의 조합으로 되어있다. (표현식 -> 명령문 -> 응용프로그램)  
하나의 명령문은 끝에 개행을 하거나 `;`을 붙인다.

## 식별자

변수나 함수에 이름을 붙일때 사용하는 단어이다.  
대소문자를 구별하며 유니코드 문자셋을 사용한다.  
식별자는 다음과 같은 규칙을 가진다.

- 예약어를 사용할 수 없다.
- 숫자로 시작할 수 없다.
- 특수문자는 `_`와 `$`만 허용한다.
- 공백을 사용할 수 없다.

## 주석

단일행 주석 `//`로 표현하고, 다중행 주석은 `/* */`로 표현한다.

```js
// 이것은 주석입니다.
/*
    이것은
    다중행 주석입니다.
*/
```

## 변수

변경 가능한 값을 지정하기 위한 기억공간(memory)이다.  
사용하기 전 선언을 필요로 하며 중복 선언을 할 수 없다.  
선언시 예약어 `let`을 사용한다.

```js
let name = "EastFlow";
```

## 상수

변경이 불가능한 값을 저장하기 위한 기억공간이다.  
보통 대문자로 표기하며 사용하기 전 선언을 필요로 한다.  
중복선언은 불가능하다. 예약어 `const`를 사용한다.

```js
const birth = "1995.08.15";
```

## 호이스팅(Hoisting)

코드에 선언된 변수 및 함수를 유효한 범위의 코드 상단으로 끌어올리는 작업이다.  
var의 변수/함수 선언만 위로 올리고 할당은 올려지지 않는다.  
예약어 var로만 사용가능하다. `let`, `const`의 변수 선언과 함수 표현식에서는 호이스팅이 발생하지 않는다.

```js
console.log(name); // undefined | 아래 선언부에서 var가 아닌 let, const 사용시 에러가 발생하지만 var는 Hosting이 발생하여 에러 대신 undefined를 출력한다.
var name = "EastFlow";
console.log(name); // EastFlow
```

## 자료형

자료형이란 목적에 따라 특별한 성질이나 정해진 범주를 가지고 있는 데이터의 종류를 의미한다. 자료형은 원시타입과 객체타입이 있다.

|             원시타입(primitive type)             | 객체타입(object type) |
| :----------------------------------------------: | :-------------------: |
| Boolean, null, undefined, number, string, symbol |        object         |

### Boolean

true, false를 통해 논리적인 값을 표현하는 자료형이다.

### null & undefined

null: 값이 비어 있다는 의미로 표현되는 자료형이다.  
존재하지않는 (nothing), 비어있는 (empty), 알수없는 (unknown) 값을 나타낼때 사용한다.

undefined: 값이할당되어있지 않는 상태를 의미하는 자료형이다.  
변수의 선언후 초기화 하지 않으면 undefined가 된다.

### number

number는 정수, 부동소수점숫자를 표현하는 자료형이다.  
일반적 숫자외에 Infinity, -Infinity, NaN를 가진다.  
사칙연산을 할 수 있으며 2^53-1 보다 큰 값을 사용할 수 없고 더 큰 값을 사용하기 위해서는 bigint 자료형을 사용해야 한다.

### string

문자, 문자열을 표현하는 자료형이다.  
큰따옴표: ""  
작은따옴표: ''  
역따옴표(백틱,backtick): ``  
를 사용하여 표현한다.

백틱안에 `${}`를 사용하여 변수를 표현할 수 있다.

```js
let name = "EastFlow";
console.log(`My name is ${name}`);
```

## 객체타입 (Object)

다수의 원시자료형을 포함하거나 복잡한 개체(entity)를 표현 할 수 있는 자료형이다.  
object는 Object()혹은 {}를 통해 생성할 수 있다. object객체는 'key:value'형태로 표현하며 접근은 object.key 형태로 표현한다.

```js
let man = {
    name : 'kim',
    age : 27
};

console.log(man.name); // kim
console.log(man.age)l  // 27
```

## 객체의 복사

object의 값을 복사할떄는 대상전체가 아닌 object내의 주소값을 복사하게 된다.  
가리키는 대상 전체를 복사하는 방법은 얕은 복사(shallow copy), 깊은 복사(deep copy)를 통해 가능하다.

### 얕은 복사

```js
let user = {
  name: "eastflow",
  age: 27,
};

// 전개 연산자를 이용한 복사
let admin = { ...user };

// Object.assign을 통한 복사
let amdmin = Object.assign({}, user);

// for문을 위함 복사
let admin = {};
for (let key in user) {
  admin[key] = user[key];
}
```

### 깊은 복사

```js
let user = {
  name: "eastflow",
  age: 27,
  sizes: {
    height: 170,
    width: 50,
  },
};

// 얕은 복사는 객체내의 주소값을 공유한다.
// 객체 깊은 복사
// 객체의 얕은 복사가 객체내의 객체는 복사될때 값이 아닌 주소값이 복사한다.
// 따라서 얕은 복사로 객체를 복사시 객체내의 객체값을 변경시키면 다른 객체의 값도 같이 변경되게 한다.

// Deepcopy
// 재귀함수를 이용한 깊은 객체복사

// .JSON객체를 이용한 깊은 복사, stringify는 객체를 문자열로 변환하는데 이때 원본객체와의 참조가 끊긴다.
let admin = JSON.parse(JSON.stringify(user));
```

## 형변환

자바스크립트는 느슨한 타입언어 혹은 동적타입 언어로 변수의 자료형을 명시적으로 선언할 필요가 없다.  
연산자로 인한 계산이나 변수에 전달되는 값은 자동으로 암묵적 형변환을 수행한다.  
강제적으로 형변환을 수행하기 위해서는 자료형 함수를 이용해 명시적 형변환을 수행한다.  
형변환의 종류는 `String()`, `Number()`, `parseInt`, `parseFloat`, `Boolean()`이 있다.

```js
// String() 형변환
console.log("------- String() ------");
console.log(123);
console.log(String(123));
console.log(String(-1/0));
console.log(String(NaN));
console.log(String(true));
console.log(String(null));
console.log(String(undefined));

// Number() 형변환
console.log("------- Number() ------");
console.log(Number(""));
console.log(Number('123));
console.log(Number('aaaa'));
console.log(Number(true));
console.log(Number(false));
console.log(Number(null));
console.log(Number(undefined));

// 정수변환 parseInt, 실수변환 parseFloat
console.log(parseInt('123.123'));
console.log(parseFloat('123.123'));

// Boolean() 형변환
// 문자열의 경우 값이 있으면 true 비었다면 false
console.log("------- Boolean() ------");
console.log(Boolean(''));
console.log(Boolean(123));
console.log(Boolean('string'));
console.log(Boolean('0'));
console.log(Boolean(0));
console.log(Boolean('1'));
console.log(Boolean(NaN));
console.log(Boolean(null));
console.log(Boolean(undefined));
```

### 연산자

연산자는 프로그램에서 데이터를 처리하여 결과를 산출할 목적으로 사용되는 문자이다.  
연산의 대상 값은 피연산자라고 하고, 피연산자의 개수에 따라 단항/이항/삼항 연산자의 종류가 존재한다.

|                   단항연산자                   |                   이항연산자                   |     삼항연자     |
| :--------------------------------------------: | :--------------------------------------------: | :--------------: |
| 부호연산자, 증감연산자, 논리연산자, 비트연산자 | 산술연산자, 대입연산자, 비교연산자, 논리연산자 | (조건식)?참:거짓 |

### 산술연산자

덧셈 연산자 : `+`  
뺄셈 연산자 : `-`  
곱셈 연산자 : `*`  
나눗셈 연산자 : `/`  
나머지 연산자 : `%`  
제곱 연산자 : `**`

### 대입연산자 =

계산한 결과를 하나의 변수에 저장하기 위한 연산자이다.

```js
let sum = 10 + 21;
```

### 복합 대입연산자

변수가 자기 자신을 포함한 연산을 대입할때 사용하는 연산자이다.  
종류는 `+=`. `-=`, `*=`, `/=`, `%=`이 있다.

```js
let sum = 10;
sum += 10; // sum = sum + 10;

let sum = 10;
sum -= 10; // sum = sum - 10;
```

### 증감 연산자

값을 1씩 늘어가나 줄일때 사용하는 연산자이다.  
종류는 `++`, `--`가 있으며 사용하는 위치에 따라 계산을 달리한다.

```js
let num = 10;
// 중감연산자를 변수의 뒤에 사용하면 해당 작업을 완료한뒤 증감한다.
console.log(num++); // output: 10 , num = 10+1
console.log(--num); // output: 11-1, output= 10
```

### 비교 논리연산자

| 비교연산자 |                        설명                         |
| :--------: | :-------------------------------------------------: |
|   a > b    |          a가 b보다 크면 true 아니면 false           |
|   a < b    |         a가 b보다 작으면 true 아니면 false          |
|   a >= b   |      a가 b보다 크거나 같으면 true 아니면 false      |
|   a <= b   |      a가 b보다 작거나 같으면 true 아니면 false      |
|   a == b   |          a와 b가 같으면 true 아니면 false           |
|   a != b   |        a와 b가 같지 않으면 true 아니면 false        |
|  a === b   |   a와 b가 자료형과 값이 같으면 true 아니면 false    |
|  a !== b   | a와 b가 자료형과 값이 같지 않으면 true 아니면 false |

`==`는 단순값을 비교하는 동등비교이다.  
`===`는 자료형까지 같음을 판단하는 일치 비교 연산자이다.  
결과값은 boolean으로 나온다.

```js
let num = 10;
let str = "10";
console.log(num == str); // true
console.log(num === str); // false
```

논리연산자의 종류 : &&(AND), ||(OR), !(NOT)

|   x   |   y   | x \|\| y | x&&y  |
| :---: | :---: | :------: | :---: |
| true  | true  |   true   | true  |
| true  | true  |   true   | false |
| false | true  |   true   | false |
| false | false |  false   | false |

숫자의 경우

| 논리연산자 |                   설명                    |
| :--------: | :---------------------------------------: |
| a \| \| b  |     a가 b보다 크면 true 아니면 false      |
|   a && b   |    a가 b보다 작으면 true 아니면 false     |
|     !a     | a가 b보다 크거나 같으면 true 아니면 false |

## SCOPE

변수 혹은 상수에 접근할 수 있는 범위를 의미한다.  
모듈/함수 내 코드에서 동일한 변수 사용시 간섭을 줄이는 용도로 사용한다.  
Scope는 Global Scope와 Local Scope의 타입으로 구분하며 Local Scope는 {}안에 담아 사용한다. Global Scope 전역에 선언되어 어디에서도 접근 가능하고, Local Scope특정 지역에 선언되어 해당지역 내에서만 접근 가능하다.

```js
// global scope
let x = 1;
let y = 2;
{
  // local scope
  let x = 3;
  let y = 4;
  console.log(x); // 3
  console.log(y); // 4
}
console.lgo(x); // 1
console.log(y); // 2
```

## 조건문

### if-else

알고리즘에서 논리적 비교를 할 때 사용되는 조건식이다.  
`if`, `if else`, `else` 키워드를 통해 구성되며, 조건식에 맞을경우 `{}`내의 명령문을 실행한다.  
단, 실행문장이 단일문장이면 `{}`을 생략할 수 있다.

```js
let apple_price = 4;

if (apple_price >= 10) console.log("very expensive");
else if (apple_price <= 5) console.log("very cheap");
else console.log("nice");

console.log("done");

let age = 10;
if (age < 10) console.log("young");
else console.log("old");

// 삼항연산자
let result;
result = age < 10 ? "young" : "old";
console.log(result);
```

### switch

`switch`는 표현문을 평가하여 그 값이 일치하는 case문을 실행하는 조건문이다.  
`switch`, `case`, `break`, `default` 키워드를 통해 구성되며, switch의 조건에 맞는 case 구문을 실행한다.  
일반적으로 하나의 case만 수행되도록 case 끝을 break를 사용하여 탈출한다.  
`break`는 현재 블록을 강제로 탈출하는 예약어이다.  
`break`가 없다면 코드를 계속 진행하여 다음 case로 넘어간다.

```js
let dayNum = 1;
let day = "";

switch (dayNum) {
  case 0:
    day = "sunday";
    break;
  case 1:
    day = "monday";
    break;
  case 2:
    day = "tuesday";
    break;
  case 3:
    day = "wednesday";
    break;
  case 4:
    day = "thurday";
    break;
  case 5:
    day = "friday";
    break;
  case 6:
    day = "saturday";
    break;
  default:
    day = "error";
    break;
}
console.log(day);

let browser = "chrome";
switch (browser) {
  case "explorer":
    msg = "active x required";
    break;
  case "chrome":
  case "firefox":
  case "opera":
    msg = "supported browser";
    break;
  default:
    msg = "not supported";
    break;
}

console.log(msg);
```

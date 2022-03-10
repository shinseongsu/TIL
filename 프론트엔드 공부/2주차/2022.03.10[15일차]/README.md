# 2022.03.10[15일차]

오늘도 JavaScript 기본문법을 공부했다.

## 반복문

### for

선언문, 조건문, 증감문의 형태로 이루어져있다.  
조건무이 fail되기 전까지 코드블록을 반복적으로 수행한다.  
선언문, 조건문, 증감문 자리에 공백을 입력할 수 있다.

```js
// output : 0, 1, 2
for (let i = 0; i < 3; i++) {
  console.log(i);
}
// output: none
for (let i = 10; i < 3; i++) {
  console.log(i);
}

let num = 0;
// output : 0, 1
for (; num < 2; ) {
  console.log(num++);
}

// 이중 for문
for (let i = 0; i < 3; i++) {
  for (let j = 0; j < 3; j++) {
    console.log(i, j, i + j);
  }
}

// for .. of
let lang = "javascript";
let text = "";
for (let x of lang) {
  text += x;
  console.log(x);
}
console.log(text);
```

### for문의 확장

- for..in 반복문  
  객체의 key,value 형태를 반복하여 수행하는데 최적화 된 유형이다.  
  처음부터 마지막 객체까지 객체의 키 개수만큼 반복한다.

```js
for (key in object) {
}
```

- for..of 반복문  
  Collection 객체 자체가 Symbol.iterator 속성을 가지고 있어야 동작 가능한 유형이다.  
  ES6에 새로 추가된 Collection 기반의 반복문이다.

```js
for (variable of iterable) {
}
```

### while

조건문이 참일때 코드불록을 계속해서 반복 수행하는 반복문이다.  
for문에 비해 선언문과 증감문 없이 loop를 수행한다. 무한 loop 등의 수행에 많이 사용한다.

최소 한번의 수행을 보장하는 do..while 반복문도 존재한다.

```js
let i = 0;
while (i < 3) {
  console.log(i++);
}

do {
  console.log("do..while loop");
  i = 0;
} while (i > 1000);
```

### 반복문 제어

```js
let text = "";
for (let i = 0; i < 10; i++) {
  if (i === 3) break;
  text += i;
}
console.log(text);

text = "";
for (let i = 0; i < 10; i++) {
  if (i % 2 == 0) continue;
  text += i;
}
console.log(text);

// Label
end: for (let i = 0; i < 3; i++) {
  for (let j = 0; j < 3; j++) {
    console.log(i, j, i * j);
    break end;
  }
}
```

### break

반복문 수행시 코드블록을 탈출할때 사용되는 식별자이다.  
다중 반복문일 경우 가장 안쪽의 반복문을 종료시킨다.  
Label을 통하여 다중 반복문을 한번에 종료할 수 있다.

### continue

반복문 수행시 코드블록의 실행을 해당 라인에서 중지하고 블록코드를 종료시킨후 반복문 내 명시된 조건 판단으로 돌아간다.

### Label

프로그램 내 특정 영역을 지정하여 별도 이름을 붙이는 식별자이다.  
break, continue를 사용하여 반복문안에서만 사용가능하며 break, continue 지시자 위에 있어야 한다.  
프로그램의 가독성과 logic을 망치므로 사용하지 않는것을 권장한다.

## 함수

함수는 다수의 명령문을 코드블록으로 감싸고, 하나의 실행단위로 만든 코드의 집합이다.  
유사한 동작을 하는 코드를 하나로 묶어 범용성을 확대시킨 블록코드이다.  
함수는 정의 부분과 호출부분으로 구성되어 있다.  
함수는 가급적 한가지 일만 하며, 매개변수는 최대 3개 이내로 작성을 권장한다.

```js
// 함수 선언식
function add(x, y) {
  return x + y;
}

// 함수 표현식
const mul = function (x, y) {
  return x + y;
};

// 화살표 함수
const div = (x, y) => {
  x / y;
};

// 함수의 호출
let result = add(10, 20);
console.log(`add = ${result}`);

// 함수호출의 default value 설정하기
function printXY(x, y = 10) {
  console.log(`x = ${x} , y = ${y}`);
}

printXY(10, 20);
printXY(5);

// 함수 호출의 dynamic parameters
function dymaicPrint() {
  console.log(arguments[0], arguments[1]);
}

dymaicPrint(1, 2, 3, 4, 5);
dymaicPrint(1);
dymaicPrint();

// 함수의 반환
// return을 사용해 함수의 결과를 반환한다.
function checkAge(age) {
  if (age > 10) return true;
  else return false;
}

console.log(checkAge(14));
console.log(checkAge(24));
```

### 함수의 정의

```js
function 함수이름(매개변수) {
  코드블록;
  return 반환결과;
}
```

### 함수의 호출

```js
함수이름(매개변수);
```

### default value

자바스크립트 함수는 매개변수와 인수의 갯수가 일치하는지 확인하지 않는다.  
ES6에 도입된 기본값을 통해 undefined 변수가 들어올 경우 사용할 값을 초기화 지정 가능하다.

```js
function printXY(x, y = 10) {
  console.log(`x = ${x}, y = ${y}`);
}
printXY(5); // x = 5, y = 10
```

### dynamic parameters

지정된 매개변수가 없으나 실제 들어오는 매개변수를 제어할 수 있다.

```js
function dynamicPrint() {
  console.log(arguments[0], arguments[1]);
}
dynamicPrint(1, 2, 3, 4); // 1 2
```

### 함수의 반환

함수는 return을 통해 값을 반환하며 return할 경우 이후의 코드는 실행되지 않는다.

```js
function func(num) {
  return num + 1;
  console.log(num); // 작동하지 않음
}
```

## 재귀함수

함수 스스로 자신을 참조해 호출하면서 동일한 코드가 계속적으로 수행되는 함수 호출방법이다.  
재귀함수는 특정 조건이 됐을 때, 자신을 그만 호출되도록 제한하는ㄴ exit code가 필요하다.  
탈출코드가 없으면 무한로프에 빠질 수 있기 떄문이다.

```js
function recursion(num) {
  if (num == 0) return;
  recursion(num - 1);
  console.log(`recursion level ${num}`);
}
recursion(5);

// 더하기 재귀함수
function recursion2(num) {
  if (num == 0) return 0;
  return (num += recursion2(num - 1));
}
console.log(recursion2(5));

// 팩토리얼 재귀함수
function recursion3(num) {
  if (num == 0) return 1;
  return (num += recursion3(num - 1));
}
console.log(recursion3(5));
```

### 콜백함수와 고차함수

콜백함수란 다른함수의 매개변수로 전달되어 수행되어지는 함수이다.  
고차함수란 매개변수를 통해 함수를 받아 호출하는 함수이다. (콜백함수를 실행하는 함수)

```js
// 콜백함수
function callback() {
  console.log("--- callback function---");
}

// 고차함수 -> 콜백함수를 실행하는 함수
function higher_order_function(callback) {
  console.log("---higher order function---");
  callback();
}

higher_order_function(callback);

// 콜백함수 예제
function add(x, y) {
  return x + y;
}

function mul(x, y) {
  return x - y;
}

function sub(x, y) {
  return x - y;
}

function div(x, y) {
  return x / y;
}

function calculator(callback, x, y) {
  return callback(x, y);
}

console.log(calculator(add, 10, 20));
console.log(calculator(mul, 10, 20));
console.log(calculator(sub, 10, 20));
console.log(calculator(div, 10, 20));
```

### call by value

값에 의한 복사로 함수 내에서 매개변수 값을 변경시켜도 영향이 미치지 않는다. 원시타입을 매개변수로 넘겼을때 발생한다.

```js
let a = 1;
let add = (b) => {
  b + b + 1;
};

add(a);
console.log(a); // 1
```

### call by reference

주소에 대한 복사로 함수내에서 매개변수 내 값을 변경시키면 원본데이터에도 영향을 받는다. 객체타입을 매개변수로 넘겼을 때 발생한다.

```js
var a = { v: 1 };
var add = (b) => {
  b.v = b.v + 1;
};
add(a);
consol.log(a.v); // 2
```

### 함수의 표현

다양한 방법으로 함수의 정의가 가능하며 함수표현식처럼 함수를 정의하여 변수에 저장가능하다.

```js
// 함수 선언식
function add1(x, y) {
  return x + y;
}

// 함수 표현식
const add2 = function (x, y) {
  return x + y;
};

// 화살표 함수
const add3 = (x, y) => x + y;
```

### 함수 저장

배열의 요소 혹은 객체의 속성에 함수를 정의하여 저장가능하다.

```js
// 배열요소에 함수 저장
let list = [
  "john",
  27,
  function hellofunc() {
    console.log("hello");
  },
];
// 객체요소에 함수 저장
let object = {
  name: "john",
  age: 27,
  hellofunc() {
    console.log("hello");
  },
};
```

### method

객체에 저장된 값이 함수인 경우, 이를 메소드(method)라고 부른다.  
변수가 객체의 주소값을 가지고 있고 객체 또한 함수의 주소값을 가지고 있는것이다.

### this

메서드에서 객체 내부의 속성값을 접근할 수 있는 지시자이다.  
thi를 사용하는 method는 추가 가능하며, 이 떄 this는 runtime에 결정되어 호출한 객체에 따라 다르다.

```js
let obj = {
  name: "kim",
  age: 27,
  hello() {
    console.log("hello" + this.name); // this.name -> 'kim'
  },
};
```

## Number

자바스크립트에서 일반적인 숫자는 64비트 형식의 IEEE-754표준기반 형태로 저장되는 자료형이다.  
10진수 외에도 16진수, 2진수, 8진수의 다양한 진수 사용한다.  
16진수(HExadecimal) 표기 : 0xFF  
8진수(Octal) 표기 : 0o71  
2진수(Binary) 표기 : 0b1101

```js
// 형변환
let us = 1e-6;
console.log(us.toString());
console.log(typeof us.toString());
console.log(typeof String(us));
console.log(typeof (us + ""));

let num1 = 125.0;
let num2 = 123.456;

console.log(num1 - num2);
console.log((num1 - num2).toFixed(3));
console.log((num1 - num2).toPrecision(3));

console.log(Number.isNaN(0.123));
console.log(Number.isNaN(111 / "aaa"));

console.log(Number.isFinite(-123));
console.log(Number.isFinite(Infinity));
console.log(Number.isFinite("hello"));

console.log(Number.parseInt("123abc"));
console.log(Number.parseFloat("1.24em"));
```

### 대표 상수값

[MAX|MIN]\_VALUE, [MAX|MIN]\_SAFE_INTEGER, {POSITIVE|NEGATIVE}\_INFINITY, NaN

### 대표메서드

문자열로 변환 : Number.toString()  
특정 자리수까지 제한하여 숫자 표현 : Number.toFixed(), Number.toPercision()  
타입확인 NUmber.isNaN(), Number.isFinite()

### 지수/진법

- 지수 표기법 아주 큰 숫자나 아주 작은 숫자를 표기하기위해 지수표기법(e)으로 0의개수를 대체 표기가능하다.

```js
let billion_1 = 1000000000; // 10억
let billion_2 = 1e9; // 10억
```

- 진법표기  
  진법 표기를 지원하기 위해 0x(16진수), 0o(8진수), 0b(2진수)로 N진수 표기가능하다.

```js
console.log(0x0f);
```

### 상수값

지수로 표기되는 양수 최대값: NUmber.MAX_VALUE, Number.MIN_VALUE  
안전하게 표기되는 최대/최소값 : Number.MAX_SAFE_INTEGER, Number.MIN_SAFE_INTEGER  
무한대 양수/음수값 : Number.POSITIVE_INFINITY, Number.NEGERTIVE_INFINITY  
부동소수점 산술에서 정의되지 않거나 표현할 수 없는 값으로 해석될 수 있는 데이터 유형: Number.NaN

### Number 형변환

Number -> String

Number.toString()

String(Number)

Number + ""

### 자리수 표현

소수의 자리수 길이를 제한 : `Number.toFixed(pos)`

```js
let num = 123.456;
console.log(num.toFixed(1)); // 123.4
```

정수와 소수의 자리수를 합한 길이로 제한 : `Number.toPrecision(pos)`

```js
let num = 123.456;
console.log(num.toPrecision(4)); // 123.4
```

### Number 자료형 확인

부동 소수점 산술에서 정의되지 않거나 표현할수 없는 값(NaN)인지 확인: `Number.isNaN()`

```js
// 들어오는 값이 isNaN에 포함되는지 아닌지를 판별
console.log(Number.isNaN(0.123));
console.log(Number.isNaN(111 / "aaa"));
```

정상적인 유한수인지 확인: `Number.isFinite()`

```js
// 유한수인지 판별
console.log(Number.isFinite(-123)); // true
console.log(Number.isFinite(Infinity)); // false
console.log(NUmber.isFinite("hello")); // false
```

### 정수와 실수 형변환

정수로 변환하는 방법(N진수로 명시적변환도 가능): `Number.parseInt()`  
실수로 변환하는 방법: `Number.parseFloat()`

```js
console.log(Number.parseInt("123ab")); // 123만 출력
console.log(Number.parseFloat("1.24em")); // 1.24 숫자만 출력
```

## string

텍스트길이에 상관없이 문자열 형태로 저장되는 자료형이다.  
자바스크립트에서는 글자 하나만 저장할수 있는 `char`자료형이 없다.  
자바스크립트에서 문자열은 페이지 인코딩 방식과 상관없이 항상 UTF-16 형식을 따른다.

### 대표속성과 메소드

| 대표속성과 메소드 |                                       표현                                        |
| :---------------: | :-------------------------------------------------------------------------------: |
|    문자열 길이    |                                   String.length                                   |
|    문자열 접근    |                  String.charAt(index), String.charCodeAt(index)                   |
|    문자열 검색    | String.indexOf(), String.lastIndexOf(), String.includes(), String.startsWith() 등 |
|    문자열 변환    |                    String.toUpperCase(), String.toLowerCase()                     |
|    문자열 치환    |                                 String.replace()                                  |
|    문자열 추출    |               String.splice(), String.substring(), String.substr()                |
|    문자열 분할    |                                  String.split()                                   |

### 문자 정의 / 표기

- 정의방법
  string 정의방법은 `""`, `''`, `String()` 이 있고, 문자열과 변수 혼합 방법 표현 `''`이 있다.

- 문자표기 다양한 문자표기방법으로  
  Linefeed: `(\n)`  
  Carriage return: `(\r)`  
  Backslash: `(\\)`  
  Tab: `(\t)`  
  Unicode: `(\u{})` 이 있다.

```js
// 개행
// /n, /r은 다르나 윈도우에선 혼합하여 하나의 new line을 처리하고 있다.
console.log("line\nfeed");
console.log("line\rfeed");

// \표현
console.log("\\n");

// Tab
console.log('String\ttab');

// unicode
console.log('unicode\u(1F60D)');
```

### 문자열 길이/접근

- 문자열 길이 문자열 길이 확인 방법 `String.length`
- 문자접근  
  문자열 내 개별 문자 접근방법 : `String.charAt(index)`, `String.charCodeAt(index)`, `String[index]`

## 문자열 변환

### 문자열 검색 / 변환

- 문자열 검색

|                     문자열검색(index)                      |                                     문자열검색(bool)                                     |
| :--------------------------------------------------------: | :--------------------------------------------------------------------------------------: |
| String.indexOf(substr,pos), String.lastIndexOf(substr,pos) | String.includes(substr,pot), String.startsWith(substr,pos), String.endsWith(substr, pos) |

### 문자열 대소문자 변환

대소문자 변환: `String.toUpperCase()`, `String.toLowerCase()`

```js
let txt2 = "HeLLo woRld";
console.log(txt2.toUpperCase());
console.log(txt2.toLowerCase());
```

### 문자열 치환

처음 만나는 요소 문자열 치환 (최환된 문자열 반환): `String.replace (origin_str, change_str)` 정규표현식 활용 문자열 치환 : 치환 문자열에 정규표현식 기입

### 문자열 추출

위치기반 문자열 추출: `String.slice(start, end), String.substring(start, end)` 길이기반 문자열 추출 : String.substr(start, length)

### 문자열 분할

배열로 문자열 분할: `string.split(Separator, limit)`

## 배열

여러 개체값을 순차적으로 나열한 자료구조이며 알고리즘 내 사용빈도가 높다.  
배열내 값을 요소라고 하며, 배열요소는 index로 접근한다.

### 대표속성과 메소드

배열크기 및 배열여부 확인: `Array.length()`, `Array.isArray()`  
배열추가/삭제: `Array.push()`, `Arrays.pop()`, `Array.shift()`, `Array.unshift()`, `Array.splice()`, `Array.slice()` 등  
배열탐색: `Array.indexOf()`, `Array.lastindexOfr()`, `Array.inclue()`  
배열변형(callback 미사용): `Array.sort()`, `Array.reverse()`, `Array.join()`

### 배열선언 / 접근 / 속성

배열선언: `new Array()` 혹은 `[]`를 통해 선언하며, 사이즈 혹은 값을 입력하여 초기화도 가능하다.  
접근방법: `Array[index]`의 index를 통해 접근한다. 배열속성: `Array.length`를 통해 배열요소의 개수 확인 가능하다.

```js
let arr1 = new Array(10);
let arr2 = [];
```

### 배열의 실체

자바스크립트에서 배열은 다른언어에서 말하는 일반적 배열이 아닌 Hash기반의 객체이다.  
메모리가 연속적인 밀집배열이 아닌 비 연속적인 희소배열이다.

### 배열타입확인 및 요소삭제

배열타입확인방법: `Array.isArray(value)`  
배열 일부 요소 삭제: `delete array[index]` (삭제해도 배열사이즈가 그대로인 문제점이 있다.)

```js
// 배열 타입확인과 삭제
let num = 123.456;
let str = "str";
let fruits = ["apple", "banana", "cherry"];

console.log(Array.isArray(num));
console.log(Array.isArray(str));
console.log(Array.isArray(fruits));
console.log(fruits);
console.log(fruits.length);

delete fruits[1];
console.log(fruits); // ['apple', <1 empty item>, 'cherry']
console.log(fruits.length); // 3
```

# 2022.03.11[16일차]

어제에 이어 자바스크립트 문법을 공부해보겠습니다.

## 배열 조작

### 배열 추가/삭제 (LIFO - BACK)

배열추가: Array.push(element)  
배열삭제: Array.pop()

### 배열 추가/삭제 (LIFO - Front)

배열추가: Array.unshift(element) 배열삭제: Array.shift()

```js
let alpha = ["a", "b", "c"];

alpha.push("d");
console.log(alpha); // a b c d
alpha.pop();
console.log(alpha); // a b c

alpha.shift();
console.log(alpha); // b c
alpha.unshift("A");
console.log(alpha); // A b c
```

### 배열 삭제/변경 (index)

배열요소 삭제/변경 : Array.splice(index, [, deleteCount, el_1, ..., e1_N])  
배열요소 삭제: Array.slice([start], [end])  
Array.slice는 Array.splice와 달리 원본객체에 영향을 끼치지 않는다.  
다중 배열 병합: Array.concat(arg1, arg2)

```js
// splice
let alpha = ["a", "b", "c"];
// 매개변수로 받은 index부터 이후의 값들을 return
let spl = alpha.splice(1); // spl은 alpha의 index 1 이후값을 가짐
console.log(spl); // b c
// 잘리고 남은 나머지가 원래 배열에 남아있다. (원본이 손상)
console.log(alpha); // a

// slice
alpha = ["a", "b", "c"];
console.log(alpha.slice(1)); // b c
console.log(alpha.slice(1, 2)); // b
console.log(alpha.slice(-2)); // a b c

// 원본이 유지됨
console.log(alpha); // a b c
```

### 배열 반복문

다양한 반복문 문법을 통해 배열 요소에 접근가능하다.  
반복문 문법: for...length(index 접근), for...of(element 접근), for...in(key 접근)

```js
let alpha = ["a", "b", "c"];

for (let i = 0; i < alpha.length; i++) {
  console.log(alpha[i]);
}

for (let element of alpha) {
  console.log(element);
}

for (let key in alpha) {
  console.log(alpha[key]);
}
```

## 배열탐색 / 변형

- 배열 탐색  
  index 탐색(앞에서부터) : Array.indexOf(item, from)  
  index 탐색(뒤에서부터) : Array.lastIndexOf(item, from)  
  값 포함 여부 확인: Array.includes(item, from)

- 배열 정렬  
  내림차순 정렬: Array.reverse()  
  오름차순 정렬: Array.sort()

- 배열 변환  
  배열값을 문자로 변환 : Array.join(separator)

```js
let alpha = ["a", "b", "c", "d", "e"];
console.log(alpha.indexOf("c", 3)); // return -1 index:3 is 'd'
console.log(alpha.lastIndexOf("d", -3)); // return -1
console.log(alpha.includes("a")); // return true

let nums = [1, -2, 4, 5, 2, 0];
console.log(nums.sort()); // -2 0 1 2 4 5
console.log(nums.reverse()); // 5 4 2 1 0 -2
console.log(alpha.join("-")); // a-b-c-d-e
```

## 고차함수

고차함수란 하나란 하나 이상의 함수를 매개변수로 취하거나 함수를 결과로 반환하는 함수이다.  
매개변수로 전달되는 함수는 콜백함수(callback function)라고 한다.

- 대표 배열 조작 매소드  
  임의 정렬 : Array.sort() (callback function)  
  반복작업 : Array.forEach()  
  콜백함수 결과 배열 반환: Array.map()  
  조건 만족하는 하나의 값 반환: Array.find()  
  조건 만족하는 값 배열로 반환: Array.filter()  
  누적 결과 값 반환: Array.reduce()

### 고차함수 sort()

sort()의 문제와 한계점  
문제점: 숫자 4와 10을 sort()하면 4가 10보다 뒤로 정렬된다.  
sort메서드로 정렬될떄 배열요소가 일시적으로 문자열로 변경되어 발생하는 문제이다.

```js
let nums = [1, -2, 4, 0, 10, 20, 12];
console.log(nums.sort()); // -2 0 1 10 12 28 4
```

한계점: 대소문자를 반드시 구분하기 때문에 구분 없는 정렬을 할 수 없다.

```js
let words = ["apple", "orange", "melon", "Orange"];
console.log(words.sort()); // [ 'Orange', 'apple', 'melon', 'orange']
```

이와같은 문제는 콜백함수를 이용하여 해결 할 수 있다.

```js
let nums = [1, -2, 4, 0, 10, 20, 12];
let asceding_order = function (x, y) {
  // x가 y보다 크면 두 값이 위치를 바꿈
  return x > y ? 1 : -1;
};
console.log(nums.sort(ascending_order)); // -2, 0, 1, 4, 10, 12, 20
```

## 그 외의 고차함수

### forEahc()

배열 요소별 콜백함수 각각 실행하는 고차함수이다.  
Array..forEach(function(item, index, array){})  
item: 배열요소, index: 배열위치, array: 배열

```js
// foreach
let nums = [1, 2, 3];
for (let i = 0; i < nums.length; i++) {
  console.log(nums[i]);
}
// use foreach
nums.foreach((el) => {
  console.log(el);
});
```

### map()

배열요소별 함수 호출 및 결과를 배열로 반환하는 고차함수이다.  
Array.map(function(item, index, array){})  
item: 배열요소, index: 배열위치, array: 배열

```js
nums = [1, 2, 3, 4, 5, 6];
let use_for_loop = [];
for (let i = 0; i < nums.length; i++) {
  use_for_loop.push(nums[i] * 2);
}
console.log(use_for_loop);

// use map()
let use_map = nums.map((el) => {
  return el * 2;
});
console.log(use_map);
```

### find()

콜백함수의 조건을 만족하는 단 하나의 값만 반환하는 고차함수이다.  
Array.find(function(item, index, array){})  
item: 배열요소, index: 배열위치, array:배열

```js
let users = [
  { name: "kim", age: 22, job: false },
  { name: "lee", age: 25, job: false },
  { name: "park", age: 27, job: true },
];

let find_job = users.find((user) => {
  return user.job == false;
});

console.log(find_job);

let find_age = users.find((user) => {
  return user.age > 23;
});
console.log(find_job);
```

### reduce()

요소별 함수 수행 누적 결과 값을 반환하는 고차함수이다.  
Array.reduce(function(accumulator, item, index, array){})  
accumulator: 이전 함수결과 (initial로 초기화 가능), item: 배열요소, index: 배열위치, array: 배열

```js
// reduce()
let call_count = 0;
console.log("result\tvalue\tindex");
// acumulator의 첫값으로 최초 0번인덱스를 넣음
let sum = nums.reduce((accumulator, item, index, array) => {
  console.log(accumulator, "\t\t", item, "\t\t", index);
  call_count++;
  return accumulator + item;
}, 0); // 콜백뒤에 initial value를 넣어 0번 인덱스 부터 시작 할 수 있다.

console.log(call_count); // 5
console.log(sum); // 15
```

## 생성자

### 생성자 함수

유사한 객체를 다중으로 만들때 사용되는 함수이다. (타 언어의 class개념과 유사)  
일반적으로 생성자 함수의 첫글자는 대문자로 시작한다.  
생성자 함수로 객체 생성 시 new 연산자를 통해 객체를 생성한다.  
생성자 함수와 new 연산자를 통해 빠른 객체 생성이 가능하다.

```js
function Man(name, sex) {
  this.name = name;
  this.sex = sex;
}

let man1 = new Man("kim", "man");
let man2 = new Man("lee", "woman");

console.log(man1); // { name : 'kim', sex: 'man' }
console.log(man2); // { name : 'lee', sex: 'woman' }
```

### new.target

new.target 속성을 사용하여 new와 함께 호출했는지 확인할 수 있다.

```js
function User(name) {
  console.log(new.target);
  this.name = name;
}

let user_1 = new User("man"); // [Function: User]
let user_2 = User("man2"); // undefined
```

## Collection

구조 혹은 비구조화 형태로 프로그래밍 언어가 제공하는 값을 담을 수 있는 공간이다.  
자바스크립트에서 제공하는 Collection은 다음과 같다.

| Indexed Collection |           Keyed Collection           |
| :----------------: | :----------------------------------: |
| Array, Typed Array | Object, Map, Set, Weak Map, Weak Set |

### Map

Map은 다양한 자료형의 Key를 허용하고, key-value형태의 자료형을 저장할 수 있는 Collection이다.  
Map은 Object와 비교했을때 보다 다양한 key의 사용을 허가하고, 값의 추가/삭제시 메서드를 통해 수행이 필요하다.

- 대표속성 및 메소드  
  생성자 : new Map()  
  개수확인 : Map.size()  
  요소추가: Map.set(key, value)  
  요소접근: Map.get(key)  
  요소삭제: Map.delete(key)  
  전체삭제: Map.clear()  
  요소 존재여부 확인: Map.has(key)  
  그 밖의 메서드: Map.keys(), Map.values(), Map.entires()

### Map 반복

Collection 객체인 Map이 가지고 있는 iterator속성을 이용하여 for...of 구문을 통해 반복문을 수행할 수 있다.

```js
let juice = new Map([
  // [key, value]
  ["strawberry", 5000],
  ["banana", 4000],
  ["coffee", 3500],
]);
console.log(juice);

for (let item of juice.keys()) {
  console.log(item); // strawberry banana coffee
}
```

### Map <-> Object 변환

Object.entries(Object), Object.fromEntries(Map)를 통해 Map과 Object간 변환이 가능하다.

```js
let juice = new Map([
  // [key, value]
  ["strawberry", 5000],
  ["banana", 4000],
  ["coffee", 3500],
]);
console.log(juice); // Map(3) { 'strawberry' => 5000, 'banana' => 4000, 'coffee' => 3500 }

let juice_obj = Object.fromEntries(juice);
console.log(juice_obj); // { strawberry: 5000, banana: 4000, coffee: 3500 }
let juice_kv = Object.entries(juice_obj);
console.log(juice_kv); // [ ['strawberry', 5000], ['banana' , 4000], ['coffee', 3500]]
let juice_map = new Map(juice_kv);
console.log(juice_map); // Map(3) { 'strawberry' => 5000, 'banana' => 4000, 'coffee' => 3500 }
```

## Set

Set은 value만을 저장하며 중복을 허용하지 않는 Collectiondlek.

- 대표속성 메소드  
  생성자 : new Set()  
  개수확인: Set.size()  
  요소추가: Set.add(value)  
  요소삭제: Set.delete(value)  
  전체삭제: Set.clear()  
  요소존재 여부 확인: Set.has(key)  
  그 박의 메서드 Set.keys(), Set.values(), Set.entires()

```js
let set1 = new Set([1, 2, 3, 4, 5, 6, 7, 8, 8, 8]);
let set2 = new Set("hello");

console.log(set1); // 1, 2, 3, 4, 5, 6, 7, 8
console.log(set2); // h, e, l, o
```

### 요소 추가 삭제

요소추가: Set.add(value)  
요소삭제: Set.delete(value)  
요소존재 여부 확인: Set.has(key)  
다양한 자료형을 value로 사용가능하며, set.add 호출시 Set이 반환되므로 체이닝 가능하다.

```js
let set = new Set();
set.add(10).add(20).add(10).add(30); // 메소드 체이닝
console.log(set); // 10 20 30

console.log(set.has(10)); // true

set.delete(10);
set.delete(-1); // return false
console.log(set);
```

### Set 반복문

Collection 객체인 Set이 가지고 있는 iterator속성을 이용하여 for...of 반복문을 수행할 수 있다.

```js
let set = new Set("hello");
for (item of set) {
  console.log(item); // h e l o
}
```

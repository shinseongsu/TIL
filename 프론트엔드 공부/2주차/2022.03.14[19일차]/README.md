# 2022.03.14 [19일차]

## 실전 17번

```js
function solution(a, b) {
  let result = 0;

  if (a > b) [a, b] = [b, a];

  for (let i = 0; i <= b; i++) {
    result += i;
  }
  return result;
}
```

## 실전 18번

```js
function solution(price, money, count) {
  let total = 0;
  for (let i = 1; i <= count; i++) {
    total += price * i;
  }

  if (money - total >= 0) return 0;
  else return Math.abs(money - total);
}
```

## 실전 19번

```js
function solution(array, commands) {
  let answer = [];

  for (let i = 0; i < commands.length; i++) {
    let newArr = array.slice(commands[i][0] - 1, commands[i][1]);
    newArr.sort((x, y) => x - y);
    answer.push(newArr[commands[i][2] - 1]);

    // map을 이용하여 만들기
    // return commands.map((commands) => {
    //    const [s, e, p] = commands;
    //    return array.slice(s-1, e).sort((x,y) => x-y)[p-1];
    // })
  }

  return answer;
}
```

## 실전 20번

```js
function solution(arr, divisor) {
  let answer = [];

  // answer = arr.filter(el => el%divisor == 0);
  arr.forEach((el) => {
    if (el % divisor == 0) answer.push(el);
  });
  if (answer.length != 0) answer.sort((x, y) => x - y);
  else answer.push(-1);

  return answer;
  // return answer.length ? answer.sort((x,y) => s-y) : [-1];
}
```

## 실전 21번

```js
function solution(arr) {
  let answer = [];
  let last = -1;
  arr.forEach((el) => {
    if (last != el) {
      last = el;
      answer.push(el);
    }
  });
  return answer;
  // return arr.filter((v,i) => v != arr[i+1]);
}
```

## 선형 자료구조

### 자료구조

선형 자료구조: 배열, 큐, 연결리스트, 해시테이블, 스택, 데크  
비선형 자료구조: 그래프, 힙, 트리, 트라이

### 배열

여러 개체값을 순차적으로 나열한 선형 자료구조이다.

### 대표속성과 메소드

배열 크기 및 배열 여부 확인: Array.length, Array.isArray()  
배열 추가/삭제: Array.push(), Array.pop(), Array.shift(), Array.unshift(), Array.splice(), Array.slice() 등  
배열 탐색: Array.indexOf(), Array.lastIndexOf(), Array.includes()  
배열 변형: Array().sort(), Arrays.reverse(), Array.join()
배열 반복: Array.forEach(), Array.map(), Array.find(), Array.filter(), Array.reduce()  
배열 논리연산: Array.some(), Array.every()

### 배열 기본 메소드

배열 선언/접근/속성

선언 : new Array() 혹은 []를 통해 선언하며, 사이즈 혹은 값을 입력하여 초기화도 가능하다.  
접근 방법: Array[index] 를 통해 index를 통하여 O(1) 복잡도로 접근한다.  
배열 속성 Array.length를 통해 배열 요소의 개수를 확인가능하다.

### 배열의 실체

자바스크립트의 배열은 다른 언어의 일반적 배열이 아닌 Hash기반의 객체이다.  
메모리가 연속적인 밀집배열(dense array)가 아닌 비연속적인 희소배열(sparse array) 이다.

### 배열의 타입확인 및 요소 삭제

배열 타입 확인: Array.isArray(value)  
배열 요소 삭제: delete array[index]  
(delete 가 잘 사용되지 않는 이유: 지워도 배열의 크기가 줄어들지 않고 빈 공간이 남는다.)

### 배열 조작

LIFO(Back) 배열 추가 Array.push(element), 배열 삭제 Array.pop()  
LIFO(Front) 배열 추가 Array.unshift(element), 배열 삭제 Array.shift()

배열 요소 삭제/변경: Array.splice(index, deleCount, element1, elementN)  
배열요소 삭제: Array.slice([start], [end])  
배열 병합: Array.concat(arg1, arg2)

### 배열 탐색

Index 탐색 (앞에서부터) : Array.indexOf(item, from) index 탐색(뒤에서부터) : Array.lastIndexOf(item, from) 값 포함 여부 확인: Array.includes(item, from)

### 배열 변형

내림차순 정렬 Array.reverse(), 오름차순 정렬 Array.sort() 배열값을 문자로 변화나 Array.join(separator)

### sort()

sort() 함수 매개변수로 함수를 넣어 고차함수를 이용한 정렬수행 가능

```js
Array.sort((x, y) => x - y); // 정렬시 Number가 String으로 자동 형변환 되어 비교하기에 이렇게 해여 수를 정렬 할 수 있다.
```

## 배열 반복문

반복문 문법: for..length(index 접근), for...of(element접근), for...in(key접근)  
acumulator 이전함수 결과(initial로 초기화 가능), item 배열 요소, index 배열위치, array배열

### forEach()

배열요소별 콜백함수에 각각 실행 Array.forEach(function(item, index, array){})

### map()

배열요소별 함수 호출 및 결과를 배열로 반환 Array.map(function(item, index, array){})

### find()

콜백함수의 조건을 만족하는, 단 하나의 값만 반환 Array.find(function(item,, index, array){})

### filter()

콜백함수의 조건을 만족하는 값을 배열로 반환 Array.filter(function(item, index, array){})

### reduce()

요소별 함수 수행 누적 결과값 반환: Array.reduce(function(accumulator, item, index, array))

## 배열 논리연산

### some()

배열 내 단 하나의 요소라도 콜백함수의 조건을 만족하는 요소가 있다면 true, 아니면 false반환(빈 배열일 경우 false반환) Array.some(function(item, index, array){})

### every()

배열내 모든 요소가 콜백함수의 조건을 만족한다면 true, 아니면 false반환(빈배열인 경우 true반환), Array.every(function(item, index, array){})

## N차원 배열

배열안에 N개 만큼의 배열이 존재하는 객체

### 2차원 배열

array[N][m]으로 접근하며 전체를 push() pop() 가능

## 배열 문제 풀이

### 03.수열 최솟값 위치

```js
function answer(nums) {
  let result = [];

  let min = Math.min(...nums);
  nums.forEach((el, idx) => {
    if (el == min) result.push(idx);
  });

  return result;
}

let input = [
  [5, 2, 10, 2],
  [4, , 5, 7, 4, 8],
  [12, 11, 11, 16, 11, 12],
];

for (let i = 0; i < input.length; i++) {
  process.stdout.write(`#${i + 1}`);
  console.log(answer(input[i]));
}
```

### 04. 체스게임

```js
function answer(chess) {
  let result = [];
  const origin = [1, 1, 2, 2, 2, 8];

  for (let i = 0; i < chess.length; i++) {
    result.push(origin[i] - chess[i]);
  }

  return result;
}

let input = [
  [0, 1, 2, 2, 2, 7],
  [2, 1, 2, 1, 2, 1],
  [0, 1, 1, 5, 3, 6],
];

for (let i = 0; i < input.length; i++) {
  process.stdout.write(`#${i + 1}`);
  console.log(answer(input[i]));
}
```

### 05. 두수 최대 합

```js
function answer(nums) {
  let result = [];

  nums.sort((x, y) => x - y);
  for (let i = nums.length - 1; i > nums.length - 3; i--) {
    result.push(nums[i]);
  }

  return result;
}

let input = [
  [-11, 5, 18, -2, -3, 6, 4, 17, 10, 9],
  [3, 7, -14, 2, -6, 13, -20, -2, -7, 6, -17, -5, 14, -9, 19],
  [
    -15, -4, -8, 12, 12, -8, -8, 9, 10, 15, -2, 10, -14, 2, 13, 19, -9, 3, -18,
    14,
  ],
];

for (let i = 0; i < input.length; i++) {
  process.stdout.write(`#${i + 1}`);
  console.log(answer(input[i]));
}
```

### 06. 일곱 난쟁이

```js
function answer(nums) {
  let result = [];
  let total = 0;

  nums.forEach((element) => {
    total += element;
  });

  total -= 100;
  console.log(total);

  for (let i = 0; i < nums.length; i++) {
    for (let j = i + 1; j < nums.length; j++) {
      if (nums[i] + nums[j] == total) {
        result = nums
          .map((el) => {
            if (el != nums[i] && el != nums[j]) return el;
          })
          .filter((el) => el != undefined);
      }
    }
  }

  return result;
}

let input = [
  [1, 5, 6, , 7, 10, 12, 19, 29, 33],
  [25, 23, 11, 2, 18, 3, 28, 6, 37],
  [3, 37, 5, 36, 6, 22, 19, 2, 28],
];

for (let i = 0; i < input.length; i++) {
  process.stdout.write(`#${i + 1}`);
  console.log(answer(input[i]));
}
```

### 07. 나무그리기

```js
function answer(num) {
  let result = "";

  for (let i = 0; i < num; i++) {
    let star = " ".repeat(num - i - 1) + "*".repeat(i * 2 + 1) + "\n";
    result += star;
  }

  return result;
}

let input = [3, 5, 7];

for (let i = 0; i < input.length; i++) {
  process.stdout.write(`#${i + 1}\n`);
  console.log(answer(input[i]));
}
```

# 2022.03.18[23일차]

## 스택

나중에 넣은 데이터가 먼저 나오는 LIFO(Last In First Out)기반의 선형 자료구조이다.

- 구현 메소드 데이터 전체 획득 Stack.getBUffer()  
  비어있는지 확인 Stack.isEmpty()  
  추가 Stack.push()  
  삭제 Stack.pop()  
  마지막 데이터 조회 Stack.peek()  
  크기확인 Stack.size()  
  데이터 위치 Stack.indexOf()  
  존재여부 확인 Stack.includes()

Ctrl + Z, 웹사이트의 뒤로가기 등이 Stack 구조를 사용한다.

### 스택의 선언

```js
function Stack(array) {
  this.array = array ? array : [];
}
```

### 스택의 데이터 셋 반환

```js
Stack.prototype.getBuffer = function () {
  // array.slice()는 매개변수가 없을 떄 배열 전체를 복사하여 반환한다.
  return this.slice();
};
```

### 객체 내 데이터 존재 여부

```js
// isEmpty(): 객체 내 데이터 존재여부
Stack.prototype.isEmpty = function () {
  return this.array.length === 0; // 스택이 비었으면 true를 반환
};
```

### 스택에 값 추가

```js
// 스택이 배열의 형태를 띄고 있으므로 배열의 메소드 사용
Stack.prototype.push = function (element) {
  return this.array.push(element); // 매개변수를 push() 한다.
};
```

### 스택에 값 삭제

```js
Stack.prototype.pop = function () {
  return this.array.pop(); // pop()를 통해 가장 뒤의 값을 삭제하고 반환한다.
};
```

### 스택의 맨 끝 값 확인

```js
Stack.prototype.peek = function () {
  return this.array[this.array.length - 1]; // pop()과는 다르게 배열에서 값을 삭제하지 않는다.
};
```

### 스택의 크기 확인

```js
Stack.prototype.size = function () {
  return this.array.length; // 스택의 크기 = 배열의 길이
};
```

### 스택에서 지정값의 위치찾기

```js
Stack.prototype.indexOf = function (element, position = 0) {
  for (let i = -position; i < this.array.length; i++) {
    // 전체 탐색
    if (this.array[i] == element) {
      // 지정한 요소가 있다면
      return true;
    }
  }
  return false;
};
```

### 스택에 해당 요소가 있는지 알아보기

```js
Stack.prototype.includes = function (element) {
  for (let i = 0; i < this.array.length; i++) {
    if (this.array[i] == element) {
      return true;
    }
  }
  return false;
};
```

## 스택 문제풀이

### 기차운행

기차가 지정된 순서로 나갈 수 있다면 true, 그렇지 않다면 false를 반환하는 문제이다.

```js
function answer(train) {
  let stack = [];
  let num = 0;

  for (let i = 0; i < train.length; i++) {
    while (stack.isEmpty() || stack.peek() < train[i]) {
      stack.push(++num);
    }

    if (stack[stasck.length - 1] === train[i]) {
      stack.pop();
    } else {
      return false;
    }
  }
  return true;
}
```

### 괄호법

괄호가 제대로 되어있는지 확인하는 것이야 말로 스택이 사용되는 대표적인 예이다.  
괄호가 제대로 되어 있지 않은 경우 빈 배열을 제대로 되어있다면 짝지어진 괄호의 인덱스를 묶어서 출력

```js
function answer(str) {
  let result = [];
  let stack = [];

  for (let i = 0; i < str.length; i++) {
    if (str[i] == "(") {
      stack.push(i);
    } else if (str[i] == ")") {
      if (stack.isEmpty()) return [];
      result.push([stack.pop(), i]);
    }
  }

  if (!stack.isEmpty()) return [];
  return result;
}
```

### 접시 꺼내기

순서대로 들어가는 접시를 주어진 순서대로 꺼낼수 있다면 push를 0으로 pop을 1로 변환하여 배열로 출력, 불가능하다면 빈 배열을 반환해야한다.

```js
function answer(str) {
  let result = [];
  let stack = [];
  let dish = str.split("").sort().join("");
  let dish_index = 0;

  for (let i = 0; i < str.length; i++) {
    while (stack.isEmpty() || stack.peak() < str[i]) {
      stack.push(dish[dish_index++]);
      result.push(0);
    }

    if (stack.isEmpty() || stack.peak() > str[i]) {
      return [];
    } else {
      stack.pop();
      result.push(1);
    }
  }

  return result;
}
```

### 기린의 시야

모든 기린이 볼 수 있는 다른 기린의 수를 출력한다.

```js
function answer(giraffe) {
  let result = 0;
  let stack = [];

  giraffe.push(Number.MAX_SAFE_INTEGER);

  for (let i = 0; i < giraffe.length; i++) {
    while (!stack.isEmpty() && stack.peakk()["h"] < giraffe[i]) {
      result += i - stack.pop()["i"] - 1;
    }
    stadck.push({ h: giraffe[i], i: i });
  }
  return result;
}
```

### 괄호 짝짓기

주어진 괄호에 따라 수식을 계산한다. 괄호 셋이 올바르지 않다면 0를 반환

```js
function answer(str) {
  let result = 0;
  let stack = [];
  let temp = 1;

  for (let i = 0; i < str.length; i++) {
    let mark = str[i];

    switch (mark) {
      case "(":
        temp *= 2;
        stack.push(mark);
        break;
      case "[":
        temp *= 3;
        stack.push(mark);
        break;
      case ")":
        if (stack.isEmpty() || stack.peak() != "(") {
          return 0;
        }

        if (str[i - 1] == "(") {
          result += temp;
        }
        stack.pop();
        temp /= 2;
        break;

      case "]":
        if (stack.isEmpty() || stack.peak() != "[") {
          return 0;
        }

        if (str[i - 1] == "[") {
          result += temp;
        }
        stack.pop();
        temp /= 3;
        break;
    }
  }

  if (!stack.isEmpty()) return 0;

  return result;
}
```

## 큐

먼저 넣은 데이터가 먼저 나오는 FIFO(First In First Out)기반의 선형 자료구조이다.

- 구현 메소드 데이터 전체 획득 Queue.getSBuffer()  
  비어있는지 확인 Queue.isEmpty()  
  데이터 추가 Queue.enqueue()  
  데이터 삭제 Queue.dequeue()  
  첫번째 데이터 Queue.front()  
  데이터 사이즈 Queue.size()  
  데이터 전체 삭제 Queue.clear()

### 큐 선언

```js
function Queue(array) {
  this.array = array ? array : [];
}
```

### 큐의 데이터 셋 반환

```js
Queue.prototype.getBuffer = function () {
  return this.array.slice();
};
```

### 큐가 비어있는지 확인

```js
Queue.prototype.isEmpty = function () {
  return this.array.length === 0;
};
```

### 큐 삽입

```js
Queue.prototype.enqueue = function (element) {
  return this.array.push(element);
};
```

### 큐 삭제

```js
Queue.prototype.dequeue = function () {
  return this.array.shift();
};
```

### 큐의 맨 앞 요소 확인

```js
Queue.prototype.front = function () {
  return this.array.length === 0 ? undefined : this.array[0];
};
```

### 큐의 크기 확인

```js
Queue.prototype.size = function () {
  return this.array.length;
};
```

### 큐 초기화

```js
Queue.prototype.clear = function () {
  this.array = [];
};
```

## 큐 최적화

방식 개선: enqueue / dequeue 방식을 push / shift 에서 index로 변경 (Shift는 O(n) index O(1))  
Shift는 내부적으로 전체 배열을 탐색하기 때문에 시간이 오래걸린다. 10만개의 큐를 삽입/삭제 했을때 시간차이 크게 발생한다.

### 큐 선언 최적화

```js
function Queue(array) {
  this.array = array ? array : [];
  this.tail = array ? array.length : 0;
  this.head = 0;
}
```

### 큐 삽입 최적화

```js
Queue.prototype.enqueue = function (element) {
  return (this.array[this.tail++] = element);
};
```

### 큐 삭제 최적화

```js
Queue.prototype.dequeue = function () {
  if (this.tail === this.head) return undefined;
  let element = this.array[this.head];
  delete this.array[this.head++];
  return element;
};
```

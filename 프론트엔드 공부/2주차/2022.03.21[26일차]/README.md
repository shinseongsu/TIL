# 2022.03.21[26일차]

오늘은 비선형 자료구조 공부를 시작헀다.  
우선 순위 큐는 큐의 값이 객체행태로 되어 있고 이 객체 안에 우선순위를 뜻하는 값이 있어 이 값에 따라 내용을 배치하는 형태의 큐이다.

## 우선순위 큐 (Priority Queue)

우선순위를 고려하여 먼저 나온 데이터가 먼저 나오는 FIFO(FFirst in First Out) 기반의 선형 자료구조이다.  
우선순위 정렬방식은 배열 기반, 연결리스트 기반, 힙(Heap) 기반 등의 정렬 방식이 존재한다.

- 구현 메소드  
  데이터 전체 획득: PriorityQueue.getBuffer()  
  데이터가 비어있는지 확인: PriorityQueue.isEmpty()  
  데이터 추가: PriorityQueue.enqueue()  
  데이터 삭제: PriorityQueue.dequeue()  
  첫번째 데이터 확인: PriorityQueue.front()  
  데이터 사이즈 확인: PriorityQueue.size()  
  데이터 전체삭제: PriorityQueue.clear()

## 우선순위 큐의 구현

### 우선순위 큐의 노드

```js
function Element(data, priority) {
  this.data = data;
  this.priority = priority;
}
```

### 우선순위 큐 선언

```js
function PriortyQueue() {
  this.array = [];
}
```

### 객체내의 데이터 셋 반환

```js
PriorityQueue.prototype.getBuffer = function () {
  return this.array.map((el) => el.data);
};
```

### 데이터 추가

```js
PriortyQueue.prototype.enqueue = function (data, priority) {
  let element = new Element(data, priority);
  let added = false;

  for (let i = 0; i < this.array.length; i++) {
    if (element.priority < this.array[i].priority) {
      this.array.splice(i, 0, element);
      added = true;
      break;
    }
  }

  if (!added) this.array.push(element);

  return this.array.length;
};
```

### 데이터 삭제

```js
PriorityQueue.prototype.dequeue = function () {
  return this.array.shift();
};
```

### 첫데이터 반환

```js
PriorityQueue.prototype.front = function () {
  return this.array.length == 0 ? undefined : this.array[0].data;
};
```

### 데이터 갯수 반환

```js
PriorityQueue.prototype.size = function () {
  return this.array.length;
};
```

### 큐 초기화

```js
PriorityQueue.prototype.sizes = function () {
  this.array = [];
};
```

## 원형 큐 (Circular Queue)

원형 형태를 가지며, 먼저 넣은 데이터가 먼저 나오는 FIFO 기반의 선형 자료구조이다. head와 tail를 이용하여 현재 머릿값과 꼬리값을 알아내 두 값이 빙빙 돌며 자료를 추가한다.

- 구현 메소드  
  데이터가 꽉 차 찼는지 확인: Circular.isFull()  
  데이터가 비어있는지 확인: Circular.isEmpty()  
  데이터 추가: CircularQueue.enqueue()  
  데이터 삭제: CircularQueue.dequeue()  
  데이터 반환: CircularQueue.getBuffer()  
  첫 번째 데이터 반환: CircularQueue.front()  
  큐의 사이즈 반환: CircularQueue.size()  
  큐 전체 삭제: CircularQueue.clear()

## 원형 큐의 구현

### 원형 큐 노드

```js
function CircularQueue(array = [], size = DEFAULT_SIZE) {
  this.array = array;
  this.size = array.length > size ? array.length : size;
  this.length = array.length;
  this.head = 0;
  this.tail = array.length;
}
```

### 객체 내 데이터 셋 반환

```js
CircularQueue.prototype.getBuffer = function () {
  return this.array.slice();
};
```

### 데이터가 가득 찼는지 확인

```js
CircularQueue.prototype.isFull = function () {
  return this.length == this.size;
};
```

### 데이터 추가

```js
CircularQueue.prototype.enqueue = function (element) {
  if (this.isFull()) return false;

  this.array[this.tail % this.size] = element;
  this.tail = (this.tail + 1) % this.size;
  this.length++;
  return true;
};
```

### 데이터 삭제

```js
CircularQueue.prototype.dequeue = function () {
  if (this.isEmpty()) return undefined;

  let element = this.array[this.head % this.size];
  delete this.array[this.head % this.size];
  this.head = (this.head + 1) % this.size;
  this.length--;

  return element;
};
```

### 첫 데이터 보기

```js
CircularQueue.prototype.front = function () {
  return this.length == 0 ? undefined : this.array[this.head];
};
```

### 큐 초기화

```js
CircularQueue.prototype.clear = function (size = DEFAULT_SIZE) {
  this.array = [];
  this.size = size;
  this.length = 0;
  this.head = 0;
  this.tail = 0;
};
```

## 데크(Dequeue)

Double-Ended Queue의 약자로, 삽입과 삭제가 양쪽 끝에서 모두 발생할 수 있는 선형 자료구조이다.  
자바스크립트가 가진 배열이 큐의 형태를 가지고 있는것 같다.

- 구현 메소드  
  데이터 전체 획득: Deque.getBuffer()  
  데이터가 비어있는지 확인: Deque.isEmpty()  
  데이터 추가: Deque.pushFront(), Deque.pushBack()  
  데이터 삭제: Deque.popFront(), Deque.popBack()  
  첫번째 데이터 반환: Deque.front()  
  끝 데이터 반환: Deque.back()  
  데크의 사이즈: Deque.size()  
  데크 전체삭제: Deque.clear()

## 데크의 구현

### 데크 선언

```js
function Deque(array = []) {
  this.array = array;
}
```

### 데크의 데이터 반환

```js
Deque.prototype.getBuffer = function () {
  return this.array.slice();
};
```

### 데크의 데이터 추가

```js
Deque.prototype.pushFront = function (element) {
  return this.array.unshift(element);
};

Deque.prototype.pushBack = function (element) {
  return this.array.push(element);
};
```

### 데크의 데이터 삭제

```js
Deque.prototype.popFront = function () {
  return this.array.shift();
};

Deque.prototype.popBack = function () {
  return this.array.pop();
};
```

### 데크의 데이터 확인

```js
Deque.prototype.front = function () {
  return this.array.length === 0 ? false : this.array[0];
};

Deque.prototype.back = function () {
  return this.array.length === 0 ? false : this.array[this.array.length - 1];
};
```

## 큐 문제풀이

### 큐 만들기

```js
function answer(cmds) {
  let queue = [];
  let answer = [];

  for (let i = 0; i < cmds.length; i++) {
    let order = cmds[i].split(" ");
    switch (order[0]) {
      case "enqueue":
        queue.push(Number(order[1]));
        break;
      case "dequeue":
        queue.length == 0 ? answer.push(-1) : answer.push(queue.shift());
        break;
      case "empty":
        queue.length == 0 ? answer.push(1) : answer.push(0);
        break;
      case "front":
        queue.length == 0 ? answer.push(-1) : answer.push(queue[0]);
        break;
      case "back":
        queue.length == 0
          ? answer.push(-1)
          : answer.push(queue[queue.length - 1]);
        break;
      case "size":
        answer.push(queue.length);
        break;
    }
  }
  return answer;
}
```

### 카드뽑기

문제가 이해가 안됬었는데 막상 이해하고 보니 별로 어려운 문제가 아니었다.

```js
function answer(num) {
  let answer = [];
  let cards = new Queue();

  for (let i = 0; i < num; i++) {
    cards.enqueue(i + 1);
  }

  while (true) {
    answer.push(cards.dequeue());
    if (cards.array.length != 0) {
      cards.enqueue(cards.dequeue());
    } else break;
  }

  return answer;
}
```

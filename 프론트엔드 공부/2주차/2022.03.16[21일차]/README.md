# 2022.03.16 [21일차]

오늘은 자료구조중 연결리스트에 공부할 것이다.  
연결리스트랑 각각의 노드 객체가 다음 노드 정보를 담도있어 순차적으로 연결된 자료구조이다.  
연결리스트의 종류는 알번, 이중, 원형 연결리스트가 있는데 그중 오늘은 일반 연결리스트와 이중 연결리스트의 공부를 진행하였다.

## 프로토 타입(prototype)

어떠한 객체가 만들어지기 위해 객체의 모태가 되는 원형이다.  
자바스크립트는 일반적인 객체지향 언어와는 다르게, 프로토타입을 이용한 복사(cloning)를 통해 새로운 객체를 생성한다.  
일반적인 객체 방식은 속성은 생성자에게 메서드는 프로토타입에서 정의한다.

## 연결리스트

각 노드가 데이터와 포인터를 가지며, 한 줄로 연결되어있는 방식으로 데이터를 저장하는 자료구조이다.

- 구현 메소드  
  노드 개수: LinkedList.size()  
  비어있는지 확인: LinkedList.isEmpty()  
  노드출력: LinkedList.printNode()  
  노드 추가: LinkedList.appned(), LinkedList.intert()  
  노드 삭제: LinkedList.remove(), LinkedList.removeAt()  
  데이터 위치 확인: LinkedList.indexOf()

## 연결리스트 구현

### 노드 구현

```js
function Node(data) {
  this.data = data;
  this.next = null;
}
```

### 연결리스트 구현

```js
function LinkedList() {
  this.head = null;
  this.length = 0;
}
```

### 연결리스트 내 노드 개수 확인

```js
LinkedList.property.size = function () {
  return this.length;
};
```

### 연결리스트 안의 노드 존재여부 확인

```js
LinkedList.property.isEmpty = function () {
  return this.length === 0;
};
```

### 연결리스트의 노드 출력

```js
LinkedList.prototype.printNode = function () {
  for (let node = this.head; node != null; node = node = node.next) {
    process.stdout.write(`${node.data} -> `);
  }
  console.log("null");
};
```

### 노드 추가

```js
LinkedList.prototype.append = function (value) {
  let node = new Node(value);
  let current = this.head;
  if (this.head == null) {
    this.head = node;
  } else {
    while (current.next != null) {
      current = current.next;
    }
    current.next = node;
  }
  this.length++;
};
```

### 노드 추가(중간삽입 가능)

```js
LinkedList.prototype.insert = function (value, position = 0) {
  if (position < 0 || position > this.length) {
    return false;
  }

  let node = new Node(value),
    current = this.head,
    index = 0,
    prev;

  if (position == 0) {
    node.next = current;
    this.head = node;
  } else {
    while (index++ < position) {
      prev = current;
      current = cureent.next;
    }
    node.next = current;
    prev.next = node;
  }

  this.length++;
  return true;
};
```

### 노드 삭제(값으로 삭제)

```js
LinkedList.prototype.remove = function (value) {
  let current = this.head;
  prev = current;
  while (current.data != value && current.next != null) {
    prev = current;
    current = current.next;
  }
  if (current.data != value) {
    return null;
  }
  if (current === this.head) {
    this.head = current.next;
  } else {
    prev.next = current.next;
  }
  this.length--;
  return current.data;
};
```

### 노드 삭제(인덱스 삭제)

```js
LinkedList.prototype.removeAt = function (position = 0) {
  if (position < 0 || position >= this.length) {
    return null;
  }

  let current = this.head,
    index = 0,
    prev;

  if (positon == 0) this.head = current.next;
  else {
    while (index++ < position) {
      prev = current;
      current = current.next;
    }
    prev.next = current.next;
  }
  this.length--;
  return current.data;
};
```

## 이중 연결리스트

각 노드가 데이터와 포인터를 가지며, 두 줄로 연결되어 있는 방식으로 데이터를 저장하는 자료구조이다.

- 구현 메서드 노드 개수: DoubleLinkedList.size()  
  바오았눈자 확인: DoubleLinkedList.isEmpty()  
  순차출력: DoubleLinkedList.printNode()  
  역출력: DoubleLinkedList.printNodeInverse()  
  노드추가: DoubleLinkedList.append(), DoubleLinkedList.insert()  
  노드삭제: DoubleLinkedList.remove(), DoubleLinkedList.removeAt()  
  데이터 위치 확인: DoubleLinkedList.indexOf()

### 이중 연결리스트의 노드 구현

```js
function Node(data) {
  this.data = data;
  this.next = null;
  this.prev = null;
}
```

### 이중 연결리스트의 구현

```js
function DoubleLinkedList() {
  this.head = null;
  this.tail = null;
  this.length = 0;
}
```

### 이중 연결리스트의 크기 확인

```js
DoubleLinkedList.prototype.size = function () {
  return this.length;
};
```

### 이중 연결리스트의 노드 존재여부 확인

```js
DoubleLinkedList.prototype.isEmpty = function () {
  return this.length === 0;
};
```

### 이중 연결리스트의 출력

```js
DoubleLinkedList.prototype.printNode = function () {
  process.stdout.write(`head -> `);
  for (let node = this.head; node != null; node = node.next) {
    process.stdout.write(`${node.data} -> `);
  }
  console.log("null");
};
```

### 이중 연결리스트의 역출력

이중 연결리스트는 역출력할 수 있다.

```js
DoubleLinkedList.prototype.printNodeInverse = function () {
  let temp = [];

  for (let node = this.tail; node != null; node = node.prev) {
    temp.push(node.data);
  }

  for (let i = temp.length - 1; i >= 0; i--) {
    process.stdout.write(`${temp[i]} <- `);
  }
  console.log("tail");
};
```

### 이중 연결리스트의 노드 추가

```js
DoubleLinkedList.prototype.append = function (value) {
  let node = new Node(value);

  if (this.head === null) {
    this.head = node;
    this.tail = node;
  } else {
    this.tail.next = node;
    node.prev = this.tail;
    this.tail = node;
  }
  this.length++;
};
```

이 이후의 이중 연결리스트의 insert()에서 현재 position의 값에 따른 중간 삽입에 어려움을 겪고있다.

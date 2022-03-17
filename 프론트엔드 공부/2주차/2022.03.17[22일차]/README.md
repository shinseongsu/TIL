# 2022.03.17 [22일차]

## 아중 연결리스트

각 노드가 데이터와 포인터를 가지며, 두 줄로 연결되어 있는 방식으로 데이터를 저장하는 자료구조이다.

- 구현 메서드 노드 개수: DoubleLinkedList.size()  
  바오았눈자 확인: DoubleLinkedList.isEmpty()  
  순차출력: DoubleLinkedList.printNode()  
  역출력: DoubleLinkedList.printNodeInverse()  
  노드추가: DoubleLinkedList.append(), DoubleLinkedList.insert()  
  노드삭제: DoubleLinkedList.remove(), DoubleLinkedList.removeAt()  
  데이터 위치 확인: DoubleLinkedList.indexOf()

### 노드추가 insert

```js
DoubleLinkedList.prototype.insert = function (value, position = 0) {
  if (position < 0 || position > this.length) {
    return false;
  }

  let node = new Node(value),
    current = this.head,
    index = 0,
    prev;

  if (position == 0) {
    if (this.head === null) {
      this.head = node;
      this.tail = node;
    } else {
      node.next = current;
      current.prev = node;
      this.head = node;
    }
  } else if (position === this.length) {
    current = this.tail;
    current.next = node;
    node.prev = current;
    this.tail = node;
  } else {
    while (index++ < position) {
      prev = current;
      current = current.next;
    }
    node.next = current;
    prev.next = node;

    current.prev = node;
    node.prev = prev;
  }
  this.length++;
  return true;
};
```

### 노드 삭제 remove (value)

```js
DoubleLinkedList.prototype.remove = function (value) {
  let current = this.head,
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
    if (this.length === 1) this.tail = null;
    else this.head.prev = null;
  } else if (current === this.tail) {
    this.tail = current.prev;
    this.tail.next = null;
  } else {
    prev.next = current.next;
    current.next.prev = prev;
  }

  this.length--;
  return current.data;
};
```

### 노드 삭제 removeAt (index)

```js
DoubleLinkedList.prototype.removeAt = function (position = 0) {
  if (position < 0 || position >= this.length) {
    return false;
  }
  let current = this.head,
    index = 0,
    prev;

  if (position === 0) {
    this.head = current.next;
    if (this.length === 1) this.tail = null;
    else this.head.prev = null;
  } else if (position === this.length - 1) {
    current = this.tail;
    this.tail = current.prev;
    this.tail.next = null;
  } else {
    while (index++ < position) {
      prev = current;
      current = current.next;
    }
    prev.next = current.next;
    current.next.prev = prev;
  }
  this.length--;
  return current.data;
};
```

### 데이터 위치 확인

```js
DoubleLinkedList.prototype.indexOf = function (value) {
  let current = this.head,
    index = 0;

  while (current != null) {
    if (current.data === value) {
      return index;
    }
    index++;
    current = current.next;
  }
  return -1;
};
```

## 원형 연결리스트

각 노드가 데이터와 포인터를 가지며, 원형 형태로 연결되어있는 방식으로 데이터를 저장하는 자료구조이다.

- 구현 메소드  
  노드 개수: CirculatLinkedList.size()  
  비어있는지 확인: CircularLinkedList.isEmpty()  
  노드 추가: CircularLinkedList.appned(), CircularLInkedList.insert()  
  노드 삭제: CircularLinkedList.remove(), CircularLinkedList.removeAt()  
  데이터 위치 확인: CircularLinkedList.indexOf()  
  노드 출력: CircularLinkedList.printNode()

### 노드 추가

```js
CircularLinkedLIst.prototype.append = function (value) {
  let node = new Node(value),
    current = this.head;

  if (this.head == null) {
    this.head = node;
  } else {
    while (current.next != this.head) {
      current = current.next;
    }
    current.next = node;
  }
  node.next = this.head;
  this.length++;
};
```

### 노드 추가 insert

```js
CircularLinkedList.prototype.insert = function (value, position = 0) {
  if (position < 0 || position > this.length) {
    return false;
  }

  let node = new Node(value),
    current = this.head,
    index = 0,
    prev;

  if (position === 0) {
    node.next = current;

    if (this.isEmpty()) {
      current = node;
    } else {
      while (current.next != this.head) {
        current = current.next;
      }
    }
    this.head = node;
    current.next = this.head;
  } else {
    while (index++ < position) {
      prev = current;
      current = current.nexzt;
    }
    prev.next = node;
    node.next = current;
    if (node.next === null) {
      node.next = this.head;
    }
  }

  this.length++;
  return true;
};
```

### 연결리스트 삭제

```js
CircularLinkedList.prototype.remove = function (value) {
  let current = this.head,
    prev = current,
    data;

  while (current.data != value && current.next != this.head) {
    prev = current;
    current = current.next;
  }

  if (current.data != value) {
    return null;
  }

  data = current.data;
  if (currnet === this.head) {
    while (currnet.next != this.head) {
      current = current.next;
    }
    this.head = this.head.next;
    current.next = this.head;
  } else {
    prev.next = current.next;
  }

  this.length--;
  return data;
};
```

### 연결리스트의 노드 삭제 (인덱스 기반)

```js
CircularLinkedList.prototype.removeAt = function (position = 0) {
  if (position < 0 || position >= this.length) {
    return null;
  }

  let current = this.head,
    index = 0,
    prev,
    data;

  if (position === 0) {
    data = current.data;
    while (current.next != this.head) {
      current = current.next;
    }
    this.head = this.head.next;
    current.next = this.next;
  } else {
    while (index++ < position) {
      prev = currnet;
      current = current.next;
    }
    data = current.data;

    prev.next = current.next;
  }

  this.length--;
  return data;
};
```

### 데이터 위치 확인

```js
CircularLinkedList.prototype.indexOf = function (value) {
  let current = this.head,
    index = 0;

  do {
    if (currnet.data === value) {
      return index;
    }
    index++;
    current = current.next;
  } while (current != this.head);

  return -1;
};
```

## 연결리스트 문제

### 열차연결

연결리스트의 append를 할 수 있는지 물어보는 문제이다.

```js
let current, prev;

for (let i = 0; i < arr.length; i++) {
  current = new Train(arr[i]);

  if (i === 0) {
    ll.head = current;
  } else {
    prev.next = current;
  }
  prev = current;
}

return ll;
```

### 서류정리

연결리스트의 연결상태를 바꾸는 문제

```js
function answer(ll) {
  let current = ll.head;
  let prev = null;
  let next;

  while (current != null) {
    next = current.next;
    current.next = prev;
    prev = current;
    current = next;
  }
  ll.head = prev;

  return ll;
}
```

### 대표 선출

연결리스트를 만든 뒤, 일정한 조건에 따라 노드를 하나씩 제거하는 문제

```js
function answer(n, m, k) {
  let result = [];

  let ll = new LinkedList();
  let current, prev;
  for (let i = 1; i <= n; i++) {
    current = new Node(i);

    if (i === i) ll.head = current;
    else prev.next = current;

    prev = current;
  }
  current.next = ll.head;
  current = ll.head;

  while (--m) {
    prev = current;
    current = current.next;
  }

  let count;
  while (current.next != current) {
    result.push(current.data);
    prev.next = current.next;
    count = k;

    while (count--) {
      prev = currnet;
      current = current.next;
    }
  }

  result.push(current.data);
  return result;
}
```

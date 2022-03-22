# 2022.03.22[27일차]

## 큐, 데크 문제풀기

지정된 우선순위에 따라 출력하는 프린터에서 목표로 정한 인덱스의 출력물이 나오는 순서를 도출하는 문제

```js
function answer(priorities, select) {
  let result = -1;
  let count = 0;
  let vq = new Queue();
  let pq = new Queue();
  for (let i = 0; i < priorities.length; i++) {
    vq.enqueue(i);
    pq.enqueue(priorities[i]);
  }

  while (true) {
    if (pq.front() == pq.max()) {
      count++;

      if (vq.front() == select) {
        result = count;
        break;
      } else {
        vq.dequeue();
        pq.dequeue();
      }
    } else {
      vq.enqueue(vq.dequeue());
      pq.enqueue(pq.dequeue());
    }
  }

  return result;
}
```

## 4번 대표선출

```js
function answer(n, m, k) {
  let result = [];
  let cq = new CircularQueue(n);

  for (let i = 1; i <= n; i++) {
    cq.enqueue(i);
  }

  cq.tail = eq.head = (n + m - 1) % n;

  let count;
  result.push(cq.dequeue());

  while (cp.length != 0) {
    count = k - 1;
    while (count--) {
      cq.enqueue(cq.dequeue());
    }
    result.push(cq.dequeu());
  }

  return result;
}
```

## 5번 데크 만들기

```js
function Dequeue() {
  this.array = [];
}

Dequeue.prototype.pushFront = function (element) {
  this.array.unshift(element);
};

Dequeue.prototype.pushBack = function (element) {
  this.array.push(element);
};

Dequeue.prototype.popFront = function () {
  return this.isEmpty() ? -1 : this.array.shift();
};

Dequeue.prototype.popBack = function () {
  return this.isEmpty() ? -1 : this.array.pop();
};

Dequeue.prototype.isEmpty = function () {
  return this.size() === 0 ? 1 : 0;
};

Dequeue.prototype.size = function () {
  return this.array.length;
};

Dequeue.prototype.front = function () {
  return this.isEmpty() ? -1 : this.array[0];
};

Dequeue.prototype.back = function () {
  return this.isEmpty() ? -1 : this.array[this.array.length - 1];
};

function answer(cmds) {
  let result = [];
  let dequeue = new Dequeue();
  for (let i = 0; i < cmds.length; i++) {
    let mark = cmds[i].split(" ");
    switch (mark[0]) {
      case "push_front":
        dequeue.pushFront(Number(mark[1]));
        break;
      case "push_back":
        dequeue.pushBack(Number(mark[1]));
        break;
      case "pop_front":
        result.push(dequeue.popFront());
        break;
      case "pop_back":
        result.push(dequeue.popBack());
        break;
      case "front":
        result.push(dequeue.front());
        break;
      case "back":
        result.push(dequeue.back());
        break;
      case "empty":
        result.push(dequeue.isEmpty());
        break;
      case "size":
        result.push(dequeue.size());
        break;
    }
  }
}
```

## 딕셔너리

key-value 형태로 다영한 자료형 객체를 저장한 구조이다.

- 구현 메소드  
  전체개체획득 Dictionary.getBuffer()  
  초기화: Dictionary.clear()  
  크기: Dictionary.size()  
  개체추가: Dictionary.set()  
  삭제: Dictionary.set()  
  반환: Dictionary.get()  
  여부: Dictionary.has()  
  key,value 배열반환: Dictionary.keys(), Dictionary.values()  
  고차함수 Dictionary.each()

## 딕셔너리 구현

### 딕셔너리 생성자

```js
function Dictionary(items = {}) {
  this.items = items;
}
```

### 딕셔너리 객체 반환

```js
Dicctionary.prototype.getBuffer = function () {
  return { ...this.items };
};
```

### 딕셔너리 초기화

```js
Dictionary.prototype.clear = function () {
  this.items = {};
};
```

### 딕셔너리 크기 반환

```js
Dictionary.prototype.size = function () {
  return Object.keys(this.items).length;
};
```

### 딕셔너리의 개체 존재 여부 확인

```js
Dictionary.prototype.has = function (key) {
  return this.items.hasOwnProperty(key);
};
```

### 딕셔너리 개체 추가

```js
Dictionary.prototype.set = function (key, value) {
  this.items[key] = values;
};
```

### 딕셔너리 개체 반환

```js
Dictionary.prototype.get = function (key) {
  return this.has(key) ? this.items[key] : undefined;
};
```

### 딕셔너리 개체 삭제

```js
Dictionary.prototype.remove = function (key) {
  if (this.has(key)) {
    delete this.items[key];
    return true;
  }
  return false;
};
```

### 딕셔너리 key 반환

```js
Dcitionary.prototype.keys = function () {
  return Object.keys(this.items);
};
```

### 딕셔너리 value 값들을 반환

```js
Dictionary.prototype.values = function () {
  let values = [];
  for (let k in this.items) {
    if (this.has[k]) values.push(this.items[k]);
  }
  return values;
};
```

### 고차함수를 이용하여 개체 이용하기

```js
Dictionary.prototype.each = function (fn) {
  for (let k in this.items) {
    fn(k, this.items[k]);
  }
};
```

## 해시

### 해시 함수(Hash Function)

임의의 길이의 데이터를 고정된 길이의 데이터로 매핑하는 함수이다.

- 해시 함수 특징
  - 압축성: 다양한 가변 길이의 입력에 대해 고정된 크기의 결과값을 반환하는 성질
  - 효율성: 어떤 입력 값에 대해서도 많은 자원과 시간이 소요되지 않고 처리되는 성질
  - 저항성: 결과값을 바탕으로 입력 값을 찾는것이 불가능한 성질

### 해시 테이블

Hash 함수를 사용하여 평균 O(1) 시간복잡도로 특정 값을 신속하게 찾는 자료구조이다.

- 충돌(Collision) 해결방법

  - 해시함수 변경: 더 큰 숫자의 공간과 Modular 산술값을 이용해 충돌 최소화
  - 자료구조 확장: Open Addressing Method(선형 조사법, 이중해시) , Close Addressing Method(체이닝)

- 구현 메서드  
  객체 초기화: HashTable.clear()  
  전체 데이터 반환: HashTable.getBuffer()  
  전체 데이터 출력: HashTable.print()  
  데이터 추가: hashTable.put()  
  데이터 삭제: HashTable.remove()  
  데이터 반환: HashTable.get()

## 해시 테이블 구현

### 해시 테이블 생성

```js
cosnt HASH_SIZE = 37;

function Element(key, value) {
    this.key = key;
    this.value = value;
}

function HashTable() {
    this.table = new Array(HASH_SIZE);
    this.length = 0;
}

HashTable.prototype.hashCode = function(key) {
    let hash = 0;
    for(let i = 0; i < key.lenght ; i++) {
        hash += key.charCodeAt(i);
    }
    return hash % HASH_SIZE;
}
```

### 해시 테이블의 값 추가 / 삭제 / 조회

```js
HashTable.prototype.put = function (key, value) {
  let index = this.hashCode(key);
  console.log(`key: ${key} -> index: ${index}`);

  if (this.table[index] !== undefined) return false;

  this.table[index] = new Element(key, value);
  this.length++;
  return true;
};

HashTable.prototype.get = function (key) {
  return this.table[this.hashCode(key)];
};

HashTable.prototype.remove = function (key) {
  let element = this.table[this.hashCode(key)];
  if (element !== undefined) {
    delete this.table[this.hashCode(key)];
    this.length--;
  }
  return element;
};
```

### 해시 테이블의 초기화, 크기반환, 데이터 반환, 데이터 출력

```js
HashTable.prototype.clear = function () {
  this.table = new Array(HASH_SIZE);
  this.length = 0;
};

HashTable.prototype.size = function () {
  return this.length;
};

HastTable.prototype.getBuffer = function () {
  let array = [];
  for (let i = 0; i < this.table.length; i++) {
    if (this.table[i]) {
      array.push([this.table[i]]);
    }
  }
  return array;
};

HashTable.prototype.print = function () {
  for (let i = 0; i < this.table.length; i++) {
    if (this.table[i])
      console.log(i + " -> " + this.table[i].key + ": " + this.table[i].value);
  }
};
```

## 해시 테이블의 충돌과 해결

해시함수를 이용해 얻은 인덱스 값은 중복 될 수 있다.  
충돌을 줄이기 위해 다양한 방법을 사용할 수 있다.

### 해시 테이블의 충돌을 해결하기 위한 djb2 해시함수

```js
HashTable.prototype.djb2 = function (key) {
  let hash = 5381;
  for (let i = 0; i < key.length; i++) {
    hash = hash * 33 + key.charCodeAt(i);
  }
  return hash % HASH_SIZE;
};
```

## 선형 조사법 해시테이블(linear probing Hash Table)

Hash 충돌이 발생했을때, 그 다음 주소를 확인하고 비어있다면 그 자리에 저장하는 해시테이블 기반 자료구조이다.

- 구현 메소드  
  객체 초기화: LinearHashTable.clear()  
  크기변환: LinearHashTable.size()  
  전체 데이터 반환: linearHashTable.getBuffer()  
  전체 데이터 출력: LinearHashTable.print()  
  데이터 추가: LinearHashTable.put()  
  데이터 삭제: LinearHashTable.remove()  
  데이터 반환: LinearHashTable.get()

### 선형 조삽법 해시테이블 구현

일반 해시테이블과 다른 코드만을 작성

```js
cosnt HASH_SIZE = 5;

LinearHastTable.prototype.put = function(key, value) {
    let index = this.hashCode(key);
    let startIndex = index;

    console.log(`key: ${key}, index: ${index}`);
    do {
        if(this.table[index] === undefined) {
            this.table[index] = new Element(key,value);
            this.length++;
            return true;
        }
        index = (index+1) % HASH_SIZE;
    } while(index !== startIndex);

    return false;
}

LinearHashTable.prototype.get = function(key) {
    let index = this.hashCode(key);
    let startIndex = index;

    do {
        if(this.table[index] !== undefined && this.table[index].key === key) {
            return this.table[index].value;
        }
    } while(index !== startIndex);
    return undefined;
}


LinearHashTable.prototype.remove = function(key) {
    let index = this.hashCode(key);
    let startIndex = index;

    do {
        if(this.table[index] !== undefined && this.table[index].key) {
            let element = this.table[index];
            delete this.table[index];
            this.length--;
            return element;
        }
        index = (index+1) % HASH_SIZE;
    } while( index !== startIndex);

    return undefined;
}
```

## 체이닝 해시 테이블(Chaining Hash Table)

별도의 자료구조인 연결리스트의 병합 사용하여 Hash충돌을 해결한 해시 테이블 기반 자료구조이다.

- 구현 메소드  
  객체 초기화: ChainingHashTable.clear()  
  크기 반환: ChainingHashTable.size()  
  전체 데이터 반환: ChainingHashTable.getBuffer()  
  전체 데이터 출력: ChainingHashTable.print()  
  데이터 추가: ChainingHashTable.put()  
  데이터 삭제: ChainingHashTable.remove()  
  데이터 반환: ChainingHashTable.get()

### 체이닝 해시 테이블 구현

체이닝 해시테이블은 링크드 리스트를 가져와 import하여 사용한다.  
import하는 파일과 export 하는 파일 모두 확장자는 .mjs로 변경되어야 한다.
기존 해시테이블과 다른 부분만 기재한다.

```js
export { LinkedList };

import { LinkedList } from "./linked_list.mjs";
```

### 체이닝 해시테이블 구현

```js
ChainingTable.prototype.getBuffer = function () {
  let array = [];
  for (let i = 0; i < this, table.length; i++) {
    if (this.table[i]) {
      let currnet = this.table[i].head;

      do {
        array.push(current.data);
        current = current.next;
      } while (current);
    }
  }
  return array;
};

ChainingTable.prototype.print = function () {
  for (let i = 0; i < this.table.length; i++) {
    if (this.table[i]) {
      let current = this.table[i].head;
      process.stdout.write(`#${i}`);
      do {
        process.stdout.write(` -> ${current.data.key}: ${current.data.value}`);
        current = current.next;
      } while (currnet);
      console.log();
    }
  }
};

ChainingTable.prototype.put = function (key, value) {
  let index = this.hashCode(key);
  console.log(`key: ${key} -> index: ${index}`);

  if (this.table[index] === undefined) {
    this.table[index] = new LinkedList();
  }

  this.table[index].append(new Elemnet(key, value));
  this.length++;

  return true;
};

ChainingTable.prototype.get = function (key) {
  let index = this.hashcode(key);
  if (this.table[index] !== undefined && !this.table[index].isEmpty()) {
    let current = this.talbe[index].head;

    do {
      if (current.data.key === key) return current.data.value;
      current = current.next;
    } while (current);
  }
  return undefined;
};

ChainingHashTable.prototype.remove = function (key) {
  let index = this.hashCode(key);
  let element = undefined;

  if (this.table[index] !== undefined) {
    let current = this.table[index].head;

    do {
      if (current.data.key === key) {
        element = current.data;
        this.table[index].remove(current.data);
        this.length--;
        if (this.table[index].isEmpty()) {
          delete this.table[index];
        }
      }
      current = current.next;
    } while (current);
  }
  return element;
};
```

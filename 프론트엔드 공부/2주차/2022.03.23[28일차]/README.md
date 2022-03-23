# 2022.03.23[28일차]

## 딕너셔너리, 해시테이블 문제풀이

### 출석체크

두 개의 배열을 받아 공통되는 데이터를 첫번째 배열의 순서에 맞춰 출력한다.

```js
function answer(class_1, class_2) {
  let result = [];

  let temp = new Dictionary();
  for (let i = 0; i < class_2.length; i++) {
    temp.set(class_2[i]);
  }

  for (let i = 0; i < class_1.length; i++) {
    if (temp.has(class_1[i])) result.push(class_1[i]);
  }
  return result;
}
```

### 숫자 카드

첫번째 배열에 숫자 카드의 배열을, 두번째 배열은 목표값을 가진 배열을 준다.  
첫 배열에 목표값이 있는 경우 두번째 배열과 인덱스를 맞춰 몇개의 카드가 있는지 출력한다.

```js
HashTable.prototype.get = function (type) {
  let index = this.hashCode(key);
  return this.table[index] === undefined ? 0 : this.table[index];
};

function answer(card, select) {
  let result = [];
  let ht = new HashTable();

  for (let i = 0; i < card.length; i++) {
    ht.push(card[i]);
  }

  for (let i = 0; i < select.length; i++) {
    result.push(ht.get(select[i]));
  }

  return result;
}
```

## 백신접종

선형 조사법 해시테이블을 사용하는 문제, 선형 조사법 해시테이블로 데이터를 삽입 후 각자 어디에 위치해있는지 위치를 꺼낸다.

```js
HashTable.prototype.put = function (key) {
  let index = this.hashCode(key);
  let startIdx = index;

  do {
    if (this.table[index] === undefined) {
      this.table[index] = new Element(key, index + 1);
      this.length++;
      return true;
    }
    index = (index + 1) % this.size;
  } while (index !== startIdx);
};

HashTable.protoype.get = function (key) {
  let index = this.hashCode(key);
  let startIdx = index;

  do {
    if (this.table[index] !== undefined && this.table[index].key === key) {
      return this.table[index].value;
    }
    index = (index + 1) % this.size;
  } while (index !== startIdx);
  return undefined;
};

function answer(name) {
  let result = [];
  ht = new HashTable(name.length);

  for (let i = 0; i < name.length; i++) {
    ht.put(name[i]);
  }

  for (let i = 0; i < name.length; i++) {
    result.push(ht.get(name[i]));
  }

  return result;
}
```

## 트리

그래프의 일종으로 두 노드 사이의 하나의 간선만 연결되어 있는 최소 연결과 계층형태의 비선형 자료구조이다.

- 트리의 구조 및 용어  
  노드(node): 하나 이상의 값을 갖는 객체 단위  
  간선(edge): 두 노드를 연결하는 선  
  루트 노드(Root node): 부모가 없는 최상위 노드  
  단말 노드(Leaf node): 자식이 없는 노드  
  부모 노드(Parent node): 특정 sub-tree 내에서의 상위 노드  
  자식 노드(Child node): 특정 sub-tree 내에서의 하위 노드  
  형제(Sibling): 같은 부모를 가지는 노드

### 트리의 특징

주요 특징: '최소 연결 트리'로 불린다. 계층모델, 방향 비순환 그래프(DAG: Directed Acyclic Graph)의 한 종류이다.  
트리 종류: 이진트리, 이진 탐색 트리, AVL 트리, 힙(Heap)

- 노드 크기(size): 자신을 포함한 모든 자손 노드의 개수
- 노드 깊이(depth): 루트에서 특정 노드에 도달하기 위한 간선의 개수
- 노드 레벨(level): 트리의 특정 깊이를 가지는 노드의 집합
- 노드 차수(degree): 노드가 지닌 가지의 수
- 트리 차수(tree degree): 트리의 최대 차수
- 트리 높이(height): 루트 노드에서 가장 깊숙이 있는 노드의 길이

## 트리 순회

트리 구조에서 각각의 노드를 정확히 한번씩 체계적으로 방법으로 방문하는 과정이다.

- 필요용어  
  N (Node): 해당 노드를 방문한다.  
  L (Left): 왼쪽 서브 트리로 이동한다.  
  R (Right): 오른쪽 서브 트리로 이동한다.

- 순회방식  
  전위 순회(Pre-order): N-L-R  
  중위 순회(In-order): L-N-R  
  후위 순회(Post-order): L-R-N  
  층별 순회(Level-order): 낮은 Level부터 순차적으로 순회

### 전위 순회

전위 순회 방법

1. 노드로 방문한다.
2. 왼쪽 서브트리를 정위 순회한다.
3. 오른쪽 서브트리를 전위 순회한다.

의사코드

```
preorder(node)
    print node.value
    if node, left =/= null then preorder(node.left)
    if node, right =/= null then preorder(node.right)
```

### 중위 순회

중위 순회 방법

1. 왼쪽 서브트리를 중위 순회한다.
2. 노드를 방문한다.
3. 오른쪽 서브 트리를 중위 순회한다.

의사코드

```
preorder(node)
    if node, left =/= node then inorder(node.left)
    print node.value
    if node, right =/= null then inorder(node.rught)
```

### 후위 순회

후위 순회 방법

1. 왼쪽 서브트리를 후위 순회한다.
2. 오른쪽 서브트리를 후위 순회한다.
3. 노드를 방문한다.

의사코드

```
preorder(node)
    if node, left =/= null then inorder(node.left)
    if node, right =/= null then inorder(node.right)
    print node.value
```

### 층별 순회

층별 순회 방법: 낮은 level부터 순차적으로 조회한다.

1. root 노드를 방문한다.
2. level이 증가
3. 왼쪽에서 오른쪽 순으로 방문한다.

의사코드

```
levelorder(root)
    q.enqueue(root)
    while not q.empty do
    node := q.dequeue()
    print node.value
    if node.left =/= null q.enqueue(node.left)
    if node.right =/= null q.enqueue(node.right)
```

## 이진 트리

각각의 노드가 최대 두개의 자식노드를 가지는 트리 자료구조이다.

- 활용방식  
  검색과 정렬: 이진 탐색트리와 이직 힙(Heap)구현에 사용한다.  
  허프만 코딩: 연관분기 구조 위한 데이터 표현에 활용한다.

- 이진트리의 종류  
  포화 이진 트리(Perfect binaray tree)  
  완전 이진 트리(Complete binaray tree)  
  정 이진 트리(Full binaray tree)  
  편향 이진트리(Skewed binaray tree)  
  균형 이진트리(Balanced binaray tree)

### 포화 이진 트리

모든 레벨의 노드가 가득 채워져 있는 트리이다.  
특징: Leaf 노드를 제외한 모든 자식은 2개의 노드를 보유한다.  
노드의 개수: n = 2^h - 1

### 완전 이진 트리

마지막 레벨 전까지 노드가 가득 채워져 있고, 마지막 레벨은 왼쪽부터 순차적으로 채워져 있는 트리이다.  
특징: 배열을 사용해 효율적인 표현이 가능하다.  
노드의 개수: n < 2^h-1

### 정 이진 트리

모든 노드가 0개 또는 2개의 자식 노드만 갖는 트리이다.  
특징: proper 또는 plane트리 라고도 불린다.  
노드의 개수: n <= 2^h-1

### 편향 이진 트리

왼쪽 혹은 오른쪽으로 편향되게 치우쳐있는 트리이다.  
특징: 각각의 높이에 하나의 노드만 존재한다.  
노드의 개수: h

### 균형 이진 트리

삽입/삭제가 이루어 질 때, 왼쪽 서브 트리와 오른쪽 서브 트리의 높이 차를 1이하로 맞추는 이진 탐색트리이다.  
특징: 서브트리 높이 차이가 항상 1 이하로 유지한다.  
균형 트리의 종류: AVL트리, Red-Black 트리, B트리, B+트리, B\*트리

## 이진 트리 순회

각각의 노드가 최대 두개의 자식 노드를 가지는 트리자료구조를 순회하는 방법이다.

- 구현 메소드  
  노드 추가: BinaryTree.\_insertNode(), BinaryTree.insert()  
  전위 순회: BinaryTree.\_preOrderTraberseNode(), BinaryTree.preOrderTravere()  
  중위 순회: BinaryTree.\_inOrdertraverseNode(), BinaryTree.inOrderTravere()  
  후위 순회: BinaryTree.\_postOrderTraverseNode(), BinaryTree.postOrderTravere()  
  층별 순회: BinaryTree.levelOrderTraverse()

### 이진트리의 구현

```js
function Node(value) {
  this.value = value;
  this.left = null;
  this.right = null;
}

function BinaryTree() {
  this.root = null;
}

BinaryTree.prototype._insertNode = function (node, value) {
  if (node === null) {
    node = new Node(value);
  }

  if (value < node.value) {
    node.left = this._insertNode(node.left, value);
  }

  if (value > node.value) {
    node.right = this._insertNode(node.right, value);
  }
  return node;
};

BinaryTree.prototype.insert = function (value) {
  this.root = this._insertNode(this.root, value);
};
```

### 전위 순회 구현

```js
BinaryTree.prototype._preOrderTraverseNode = function (node, callback) {
  if (node === null) {
    return;
  }
  callback(node);
  node.left = this._preOrderTraverseNode(node.left, callback);
  node.right = this._preOrderTraverseNode(node.right, callback);
};

BinaryTree.prototype.preOrderTraverse = function (callback) {
  this._preOrderTraverseNode(this.root, callback);
};
```

### 중위 순회 구현

전위 순회와 순서만 바꾸면 된다.

```js
BinaryTree.prototype._inOrderTraverseNode = function (node, callback) {
  if (node === null) {
    return;
  }
  this._inOrderTraverseNode(node.left, callback);
  callback(node);
  this_inOrderTraverseNode(node.right, callback);
};
```

### 후위 순회 구현

전위 순위와 순서만 바꾸면 된다.

```js
BinaryTree.prototype._postOrderTraverseNode = function (node, callback) {
  if (node === null) {
    return;
  }
  this._postOrderTraverseNode(node.left, callback);
  this._postOrderTraverseNode(node.right, callback);
  callback(node);
};
```

### 층별 순회 구현

층별 순회는 큐를 사용한다.  
각 층의 노드를 큐에 넣고 큐의 노드를 삭제하면 하위 노드를 불러와 큐에 추가하는 방식을 사용한다.

```js
function Queue(array) {
  this.array = array ? array : [];
}

Queue.prototype.isEmpty = function () {
  return this.array.length === 0;
};

Queue.prototype.enqueue = function (element) {
  return this.array.push(element);
};

Queue.prototype.dequeue = function () {
  return this.array.shift();
};

BinaryTree.prototype.levelOrderTraverse = function (callback) {
  let q = new Queue();
  let node;
  q.enqueue(this.root);
  while (!q.isEmptry()) {
    node = q.dequeue(0);
    callback(node);
    if (node.left !== null) q.enqueue(node.left);
    if (node.right !== null) q.enqueue(node.right);
  }
};
```

## 이진 탐색 트리(Binary Search Tree)

현재 노드를 기준으로 왼쪽에는 작은 값, 오른쪽 큰 값으로 정렬해 놓는 이진 트리 기반 자료구조이다.

- 구현 메소드  
  노드 추가: BinarySearchTree.\_insertNode(), BinarySearchTree.insert()  
  노드 탐색(최대값): BinarySearchTree.\_maxNode(), BinarySearchTree.max()  
  노드 탐색(최소값): BinarySearchTree.\_minNode(), BinarYSearchTree.min()  
  노드 탐색(특정값): BinarySearchTree.\_searchNode(), BinarySearchTree.search()  
  노드 삭제: BinarySearchTree.findMinNode(), BinarySearchTree.removeNode(), BinarySearchTree.remove()

### 이진 탐색 트리 구현

앞서 본 이진트리의 구현 자체가 이진 탐색트리의 구현이다. 코드는 다음과 같다.

```js
BinaryTree.prototype._insertNode = function (node, value) {
  if (node === null) {
    node = new Node(value);
  }

  if (value < node.value) {
    node.left = this._insertNode(node.left, value);
  }

  if (value > node.value) {
    node.right = this._insertNode(node.right, value);
  }
  return node;
};

BinaryTree.prototype.insert = function (value) {
  this.root = this._insertNode(this.root, value);
};
```

### 이진 탐색 트리의 최솟값, 최댓값 구하기

최댓값과 최솟값을 구하는 방법은 노드의 진행 방향만 다를 뿐 원리는 같다.  
최댓값을 구하는 코드는 주석으로 첨부

```js
BinarySearchTree.prototype._minNode = function (node) {
  if (node === null) {
    return null;
  }

  while (node && node.left !== null) {
    node = node.left;
  }

  return node.value;
};

BinarySearchTree.prototype.min = function () {
  return this._minNode(this.root);
};
```

### 특정 값을 찾는 이진 탐색

```js
BinarySearchTree.prototype._searchNode = function (node, value) {
  if (node === null) {
    return false;
  }

  if (node.value === value) {
    return true;
  } else if (node.value > value) {
    return this._searchNode(node.left, value);
  } else if (node.value < value) {
    return this._searchNode(node.right, value);
  }
};

BinarySearchTree.prototype.search = function (value) {
  return this._searchNode(this.root, value);
};
```

### 이진 탐색 트리에서의 값 삭제

이진 탐색트리에서 값을 삭제할때 해당 노드의 자식노드가 몇개인지에 따라 삭제하는 방법이 다르다.

```js
BinarySearchTree.prototype.findMinNode = function (node) {
  while (node && node.left !== null) {
    node = node.left;
  }
  return node;
};

BinarySearchTree.prototype._removeNode = function (node, value) {
  if (node === null) return null;
  if (node.value === value) {
    if (node.left === null && node.right === null) {
      node = null;
    } else if (node.left === null) {
      node = node.right;
    } else if (node.right === null) {
      node = node.left;
    } else {
      let aux = this.findMinNode(node.right);
      node.value = aux.value;
      node.right = this._removeNode(node.right, aux.value);
    }
  } else if (node.value > value) {
    node.left = this._removeNode(node.left, value);
  } else if (node.value < value) {
    node.right = this._removeNode(node.right, value);
  }
  return node;
};

BinarySearchTree.prototype.remove = function (value) {
  this.root = this._removeNode(this.root, value);
};
```

# 2022.03.25[30일차]

## 비선형 문제 풀이

### 후위 순회

입력값을 이진트리로 만들고 후위 순회하여 출력하는 문제

```js
BinaryTree.prototype.postSearch = function(node, result = []) {
    if(node === null) return;

    this.postSearch(node.left, result);
    this.postSearch(node.right, result);
    return.push(nmode.value);
}
```

### 바이러스

DFS 탐색을 통해 간선이 연결되어 하나의 네트워크를 구축하는 경우 얼마나 많은 컴퓨터가 바이러스에 감염되었는지 출력하는 문제

```js
function answer(v, e_list) {
  let g = new Graph();
  for (let i = 1; i <= v; i++) {
    g.addVertex(i);
  }

  for (let i = 0; i < e_list.length; i++) {
    let e = e_list[i];
    g.addEdge(e[0], e[1]);
  }

  g.dfs(1);
  for (const vertex in g.visited) {
    result += g.visited[vertex] ? 1 : 0;
  }

  return result;
}

Graph.prototype.dfs = function (vertex) {
  if (this.visited[vertex]) return;

  this.visited[vertex] = true;
  neighbors = this.edge[vertex];
  for (let i = 0; i < neighbors.length; i++) {
    this.dfs[neighbors[i]];
  }
};
```

### 미로찾기

미로를 찾는 문제 BFS를 사용하며, 입력받은 값을 2차원 배열로 만들고 모든 방향의 노드로 동시에 탐색한다.

```js
function answer(input) {
  let result = -1;

  let size = input.length;
  let dir = [
    [1, 0],
    [0, -1],
    [-1, 0],
    [0, 1],
  ];

  let map = [];
  for (let i = 0; i < size; i++) {
    map[i] = [];
    for (let j = 0; j < size; j++) {
      map[i][j] = Number(inpuit[i][j]);
    }
  }

  let s = [0, size - 1];
  let e = [size - 1, 0];

  let q = new Queue();
  q.enqueue(new Node(s[0], s[1], 1));

  while (!q.isEmpty()) {
    let y = q.dequeue();

    if (v.x < 0 || v.x >= size || v.y < 0 || v.y >= size) undefined;
    if (map[v.y][v.x]) continue;
    if (v.x === e[0] && v.y === e[1]) {
      result = v.c;
      break;
    }

    map[v.y][v.x] = 1;

    for (let i = 0; i < dir.length; i++) {
      q.enqueue(new Node(v.x + dir[i][0], v.y + dir[i][1], v.c + 1));
    }
  }
}
```

## 트라이(Tire)

탐색 트리의 일종으로, 문자열이나 연관 배열을 저장하는데 사용되는 트리 자료구조이다.

- 트라이 특징  
  문자열 검색에 특화된 자료구조이다.  
  문자열 길이나 M일경우 O(M)의 시간복잡도로 검색가능하다.

- 구현 메소드  
  데이터 추가: Trie.insert()  
  데이터 검색: Trie.search()  
  데이터 삭제: Trie.delete()

## 트라이 구현

### 트라이의 구현과 문자열 추가

```js
function TrieNode() {
  this.children = {};
  this.endOfNode = false;
}

function Trie() {
  this.root = new TrieNode();
}

Trie.prototype.insert = function (word) {
  let current = this.root;

  for (let i = 0; i < word.length; i++) {
    let ch = word[i];
    let node = current.children[ch];

    if (node === undefined) {
      node = new TrieNode();
      current.children[ch] = node;
    }
    current = node;
  }
  current.endOfNode = true;
};
```

### 트라이에서 문자열 검색

```js
Trie.prototype.search = function (word) {
  let current = this.root;

  for (let i = 0; i < word.length; i++) {
    let ch = word[i];
    let node = current.children[ch];

    if (node == undefined) return false;
    current = node;
  }
  return current.endOfNode;
};
```

### 트라이에서 문자열 삭제

```js
Trie.prototype.delete = function (word, current = this.root, index = 0) {
  if (index === word.length) {
    if (!current.endOfNode) return false;

    current.endOfNode = false;
    return Object.keys[current.children].length === 0;
  }

  let ch = word[index];
  let node = current.children[ch];

  if (node === undefined) return false;

  let isDeleteNode = this.delete(word, node, index + 1) && !node.endOfNode;
  if (isDeleteNode) {
    delete current.children[ch];
    return Object.keys(current.children).length === 0;
  }
  return false;
};
```

## 알고리즘

알고리즘 종류

- 정렬 알고리즘 (+ 이진탐색 알고리즘)
- 분할 정복 알고리즘: 겹치지 않는 서브 문제로 분활하여 하향식 접근법으로 문제를 푼다.
- 탐욕 알고리즘: 현재 주어진 조건에서 최선의 해를 구한다. (+백트리킹: 답이 될수 없는 요소를 미리 제거한다.)
- 동적 계획법: 상향식, 하향식, 메모리제이션 사용하는 특징을 가진다.

## 정렬

배열 내 원소들을 번호순이나 사전 순서와 같이 일정한 순서대로 열거하는 알고리즘이다.  
대표정렬 알고리즘별 구현 함수

- 시간복잡도 O(n^2)

  - 거품 정렬(Bubble Sort)
  - 선택 정렬(Selection Sort)
  - 삽입 정렬(Insert Sort)

- 시간복잡도 O(n log n)

  - 병합 정렬(Merge Sort): mergeSort()
  - 퀵 정렬(Quick Sort): quickSOrt()

- 공통 함수: Swap(), asscending(), descending()

### 정렬 알고리즘의 공통 함수 구현

```js
let swap = function(arr, idx_1, idx_2) {
    let temp = arr[idx_1];
    arr[idx_1] = arr[idx_2];
    arr[idx_2] = temp;
}

let ascending = fucntion(x, y) {
    return x > y;
}

let decending = function(x,y) {
    return x < y;
}
```

## 거품 정렬 (Bubble Sort)

서로 인접한 두 원소를 비교하면서 정렬하는 알고리즘  
편균 시간복잡도 O(n^2)  
알고리즘 동작 방식: 뒤쪽부터 정렬

1. 인접 값 비교
2. 큰값이면 뒤로 교화
3. index = n , 매 반복마다 n-i 만큼 반복

### 거품 정렬 구현

가장 효율적인 코드만 TIL에 작성 상세한 코드는 소스코드에서 확인 할 수 있다.

```js
let bubbleSort_3 = function (arr) {
  let swapped;

  for (let i = 0; i < arr.length - 1; i++) {
    swapped = false;
    for (let j = 0; j < arr.length - i - 1; j++) {
      if (arr[j] > arr[j + 1]) {
        swap(arr, j, j + 1);
        swapped = true;
      }
    }
    if (!swapped) break;
  }
};
```

## 선택 정렬(Selection Sort)

최솟값을 찾아 데이터 영역의 가장 앞으로 이동하는 방식을 반복하여 전체 데이터 영역을 정렬하는 알고리즘  
평균 시간 복잡도 O(n^2)
알고리즘 동작 방식: 앞쪽부터 정렬

1. 최솟값을 찾는다.
2. 정렬되지 않은 원소를 가장 앞쪽과 처리를 교체

### 선택 정렬의 구현

```js
let selectionSort = function (arr, compare) {
  for (let i = 0; i < arr.length; i++) {
    let k = i;
    for (let j = i + 1; j < arr.length; j++) {
      if (compare(arr[k], arr[j])) k = j;
    }
    swap(arr, i, k);
  }
};
```

## 삽입 정렬 (Insertion Sort)

이미 정렬된 데이터 영역과 비교하면서, 자신의 위치를 찾아 요소를 삽입하며 정렬하는 알고리즘  
평균 시간 복잡도 O(n^2)  
알고리즘 동작 방식: 요소를 뽑아 별도 공간에 저장하여 지정된 위치에 삽입

### 삽입 정렬의 구현

```js
let insertionSort = function (arr, compare) {
  for (let i = 1; i < arr.length; i++) {
    let temp = arr[i];
    let j;
    for (j = i - 1; j >= 0; j++) {
      arr[j + 1] = arr[j];
      if (ccompare(temp, arr[j])) break;
    }
    arr[j + 1] = temp;
  }
};
```

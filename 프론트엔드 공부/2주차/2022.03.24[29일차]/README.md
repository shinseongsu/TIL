# 2022.03.24[29일차]

그래프 자료구조는 별다른 상 하위 없이 노드들간의 간선을 통해 관계를 갖는 자료구조이다.

## 그래프(Graph)

정점과 간선으로 구성되어 네트워크 구조를 추상화한 비선형 자료 구조이다.

- 그래프 특징  
  정점(Vertex)과 간선(Edge)의 집합니다.  
  다양한 그래프 종류를 혼합하여 표현가능하다.

- 그래프 종류

  - 방향 그래프(Directed Graph): 간선에 특정 방향이 존재하는 그래프(A -> B로 표현, A에서 B로만 이동가능)
  - 무방향 그래프(Undirected Graph): 간선에 특정 방향이 존재하지 않는 그래프 (A-B로 표현, 양방향 이동 가능)
  - 가중치 그래프(Weighted Graph): 간선에 비용이나 가중치가 할당된 그래프
  - 연결 그래프(Connected Graph): 무방향 그래프에 있는 모든 정점쌍에 대해 항상 ㅅ경로가 존재하는 그래프
  - 비연결 그래프(Disconnected Graph): 무방향 그래프에서 특성 점정쌍 사이에 경로가 존재하지 않는 그래프
  - 순환 그래프(Cycle): 단순 경로의 시작 점검과 종료 지점이 동일하여 순환 지점이 존재하는 그래프
  - 비순환 그래프(Asyclic Graph): 순환 지점이 존재하지 않는 그래프

- 완전 그래프(Complete Graph): 그래프에 속해 있는 모든 정점이 서로 연결되어 있는 그래프

- 그래프 표현 방법  
  인접 리스트 (Adjaceny List): 정점에 연결된 다른 정점을 리스트로 표현한다.  
  인접 행렬 (Adjacency Matrix): 정점에 연결된 다른 정점을 정점x정점 크기의 매트릭스로 표현한다.

- 구현 메소드  
  정점/간선 추가: Graph.addVertex(), Graph.addEdge()  
  정점/간선 삭제: Graph.removeVertex(), Graph.removeEdge()  
  정점/간선 개수, 그래프 출력: Graph.sizeVertex(), Graph.sizeEdge(), Graph.print()

## 그래프 구현하기

### 방향 그래프 구현

```js
function Graph() {
  this.edge = {};
}

Graph.prototype.addVertex = function (v) {
  this.edge[v] = [];
};

Graph.prototype.addEdge = function (v1, v2) {
  this.edge[v1].push(v2);
};

Graph.prototype.removeEdge = function (v1, v2) {
  if (this.edge[v1]) {
    let idx = this.dege[v1].indexOf(v2);

    if (idx != -1) {
      this.edge[v1].splice(udx, 1);
    }

    if (this.edge[v1].length === 0) {
      delete this.edge[v1];
    }
  }
};
```

### 무방향 그래프의 구현

```js
Graph.prototype.addEdge = function (v1, v2) {
  this.edge[v1].push(v2);
  this.edge[v2].push(v1);
};

Graph.prototype.removeEdge = function (v1, v2) {
  if (this.edge[v1]) {
    let idx = this.edge[v1].indexOf(v2);

    if (idx != -1) {
      this.edge[v1].splice(idx, 1);
    }

    if (this.edge[v1].length === 0) {
      delete this.edge[v1];
    }
  }

  if (this.edge[v2]) {
    let idx = this.edge[v2].indexOf(v1);

    if (idx != -1) {
      this.edge[v2].splice(idx, 1);
    }

    if (this.edge[v2].length === 0) {
      delete this.edge[v2];
    }
  }
};
```

### 그래프 반환과 출력

```js
Graph.prototype.sizeVertex = function () {
  return Object.keys(this.edge).length;
};

Graph.prototype.sizeEdge = function (vertex) {
  return this.edge[vertex] ? Object.keys(this.edge[vertex]).length : 0;
};

Graph.prototype.print = function () {
  for (let vertex in this.edge) {
    let neighbors = this.edge[vertex];
    if (neighbors.length === 0) continue;
    process.stdout.write(`${vertex} -> `);
    for (let j = 0; j < neighbors.length; j++) {
      process.stdout.write(`${neighbors[j]}`);
    }
    console.log();
  }
};
```

## DFS (Depth First SEarch)

깊이 우선 탐색  
트리나 그래프 등에서 하나의 노드를 최대한 깊게 들어가면서 해를 찾는 탐색 기법이다.

- 장/단점  
  장점: 인접한 후보 노드만 기억하면되므로 적은 기억공간을 소모한다.  
  노드가 깊은 단계에 있을 경우 빠르게 정답 산출한다.  
  단점: 선택한 경로가 답이 아닐 경우 불필요한 탐색을 할 수 있다.  
  최단 경로를 구할 시 찾은 해가 정답이 아닌 경우가 발생한다.

- 구현 메소드  
  재귀를 이용한 탐색: Graph.\_dfsResursiveVisit()  
  스택을 이용한 탐색: Graph.\_dfsLoopVisit()

## DFS 구현하기

### 재귀를 이용한 DFS 구현

```js
function Graph() {
  this.edge = {};
  this.visited = {};
}

Graph.prototype.addVertex = function (v) {
  this.edge[v] = [];
  this.visited[v] = false;
};

Graph.prototype.dfs = function (startVertex) {
  this._dfsRecursiveVisit(startVertex);
};

Graph.prototype._dfsRecursiveVisit = function (vertex) {
  if (this.visited[vertex]) return;

  this.visited[vertex] = true;
  console.log(`visit "${vertex}"`);

  let neighbors = this.edge[vertex];
  for (let i = 0; i < neighbors.length; i++) {
    this._dfsRecursiveVisit(neighbors[i]);
  }
};
```

### 스택을 이용한 DFS 구현

```js
import { Stack } from "./stack.mjs";

Graph.prototype.addVertex = function (v) {
  this.edge[v] = [];
  this.visited[v] = false;
};

Graph.prototype.addEdge = function (v1, v2) {
  this.edge[v1].push(v2);
};

Graph.prototype.dfs = fucntion(startVertex) {
    this._dfsLoopVisit(startVertex);
}

Graph.prototype._dfsLoopVisit = function(vertex) {
    let stack = new Stack();
    stack.push(vertex);

    while(!stack.isEmpty()) {
        let vertex = stack.pop();
        if(this.visited[vertex]) {
            continue;
        }

        this.visited[vertex] = true;
        console.log(`visit "${vertex}"`);

        let neighbors = this.edge[vertex];
        for(let i = neighbors.length-1 ; i >= 0 ; i--) {
            stack.push(neighbors[i]);
        }
    }
}
```

## BFS(Breadth First Search)

너비 우선 탐색  
트리나 그래프 등에서 인접한 노드를 우선 방문 하면서 넓게 움직이며 해를 찾는 탐색 기법이다.

- 장/단점  
  장점:  
  최단 경로 탐색에서 구한 해가 정답임을 보장한다.  
  단점:  
  경로가 매우 길어질 경우 탐색 범위가 증가하면서 DFS보다 많은 기억 공간이 필요하다.

- 구현 메서드  
  큐를 이용한 탐색: Graph.bfs(), Graph.\_bfsLoopVisit()  
  최단 경로 탐색: Graph.shortestPath(), Graph.bfsSortestPath(), Graph.\_from_to_path()

## BFS 구현

### 큐를 사용해 BFS에서 최단거리의 비용을 탐색하는 코드

```js
import { Queue } from "./queue.mjs";

Graph.prototype.bfs = function (startVertex) {
  this._bfsLoopVisit(startVertex);
};

Graph.prototype._bfsShortestPath = function (vertex) {
  let queue = new Queue();
  queue.enqueue(vertex);

  let distance = {};
  let pre_visit = {};
  for (let vertex in this.edge) {
    distance[vertex] = 0;
    pre_visit[vertex] = null;
  }

  while (!queue.isEmpty()) {
    let vertex = queue.dequeue();

    this.visited[vertex] = true;
    console.log(`visit "${vertex}"`);

    let neighbors = this.edge[vertex];
    for (let i = 0; i < neighbors.length; i++) {
      if (!this.visited[neighbors[i]]) {
        distance[neighbors[i]] = distance[vertex] + 1;
        pre_visit[neighbors[i]] = vertex;
        queue.enqueue(neighbors[i]);
      }
    }
  }
  return { distance, pre_visit };
};
```

### 두 정점간 최단 거리를 구하는 코드

```js
import { Queue } from "./queue.mjs";
import { Stack } from "./stack.mjs";

Graph.prototype.from_to_path = function (pre_visit, from, to) {
  let stack = new Stack();
  for (let v = to; v !== from; v = pre_visit[v]) {
    stack.push(v);
  }
  stack.push(from);

  while (!stack.isEmpty()) {
    let v = stack.pop();
    process.stdout.write(`${v} -> `);
  }
  console.log("end");
};

Graph.prototype.shortestPath = function (startVertex) {
  let result = this._bfsShortestPath(startVertex);

  console.log(result.distance);
  console.log(result.pre_visit);

  for (let vertex in this.edge) {
    if (vertex === startVertex) continue;
    this._from_to_path(result.pre_visit, startVertex, vertex);
  }
};
```

## 힙 (Heap)

최댓값 혹은 최솟값을 빠르게 찾기 위해 완전 이진트리 형태로 연산을 수행하는 자료구조이다.

- 힙 대표속성  
  정렬: 각 노드의 값은 자식 노드가 가진 값보다 작거나 혹은 큰 순서대로 정렬한다.  
  현태: 트리의 형태는 완전 이진트리 모양을 한다.

- 힙 종류  
  최소 힙(Min Heap): 부모 노드의 값이 자식 노드의 값보다 작거나 같은 완전 이진 트리  
  최대 힙(Max Heap): 부모 노드의 값이 자식 노드의 값보다 크거나 같은 완전 이진 트리

- 힙 구현 완전 이진 트리 성질을 만족하기 때문에 1차원 배열로 표현 가능 현재노드: N, 부모 노드: N-1, 왼쪽 자식 노드: (N*2)+1, 오른쪽 자식 노드: (N*2)+2

- 구현 메서드  
  노드 위치 계산: Heap.parentIndex(), Heap.leftChildIndex(), Heap.rightChildIndex()  
  노드 값 확인: Heap.parentIndex(), Heap.leftChildIndex(), Heap.rightChildIndex()  
  노드 추가/삭제 : Heap.insert(), Heap.bubbleUp(), Heap.extract, Heap.bubbleDown()

## 힙 구현

### 힙의 기본 구성 요소

```js
function Heap() {
  this.items = [];
}

Heap.prototype.swap = function (index1, index2) {
  let tmp = this.items[index1];
  this.items[index1] = this.items[index2];
  this.items[index2] = tmp;
};

Heap.prototype.parentIndex = function (index) {
  return Math.floor((index - 1) / 2);
};

Heap.prototype.leftChildIndex = function (index) {
  return index * 2 + 1;
};

Heap.prototype.rightChildIndex = function (index) {
  return index * 2 + 2;
};

Heap.prototype.parent = function (index) {
  return this.items[this.parentIndex(index)];
};

Heap.prototype.leftChild = function (index) {
  return this.items[this.leftChildIndex(index)];
};

Heap.prototype.rightChild = function (index) {
  return this.items[this.rightChildIndex(index)];
};

Heap.prototype.peek = function () {
  return this.items[0];
};

Heap.prototype.size = function () {
  return this.items.length;
};
```

### 최소힙의 구현

```js
Heap.prototype.insert = function (item) {
  this.items[this.size()] = item;
  this.bubbleUp();
};

Heap.prototype.bubbleUp = function () {
  let index = this.size() - 1;
  while (this.parent(index) && this.parent(index) > this.items[index]) {
    this.swap(this.parentIndex(index), index);
    index = this.parentIndex(index);
  }
};
```

### 요소의 반환, 삭제

힙의 요소를 root부터 삭제하며 이후 가장 끝은 정점을 root에 놓고 버블 다운한다.

```js
Heap.prototype.extract = function () {
  let item = this.items[0];
  this.items[0] = this.items[this.size() - 1];
  this.items.pop();
  this.bubbleDown();
  return item;
};

Heap.prototype.bubbleDown = function () {
  let index = 0;
  while (
    this.leftChild(index) &&
    (this.leftChild(index) < this.items[index] ||
      this.rightChild(index) < this.items[index])
  ) {
    let childIndex = this.leftChildIndex(index);
    if (
      this.rightChild(index) &&
      this.rightChild(index < this.items[childIndex])
    ) {
      childIndex = this.rightChildIndex(index);
    }

    this.swap(childIndex, index);
    index = childIndex;
  }
};
```

### 최대힙의 구현

위의 최소힙 구현, 요소의 반환, 삭제의 부등호를 전부 반대 방향으로 바꾸면 최대힙을 구현한다.

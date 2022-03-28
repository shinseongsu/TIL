# 2022.03.29[33일차]

## 동적 계획법 (Dynamic Prograwmming)

Memoization로 중복 연산을 방지하며, 작은 부분 문제로 큰 문제를 해결하며 해를 도출하는 알고리즘 설계 기법이다.

- 동적 계획법 (Dyanmic Programming)  
  부분 문제는 중복되며, 상위 문제 해결 시 재사용한다.  
  Memoization 기법을 사용한다. (동일한 계산을 반복할때, 이전에 계산한 값을 메모리에 저장하여 중복 연산 방지)

- 동적 계획법 구현 방식
  - Top-down: 재귀를 통해 큰 문제를 작은 문제로 나눠 해결하며 해를 찾는 방법(재귀에는 depth의 제한이 있다.)
  - Bottom-up: 반복문을 통해 작은 문제부터 차례대로 해를 찾는 방법

### 구현 1

피보나치 수열을 통해 확인하는 Top-down방식의 동적 계획법

```js
function fibo_td(n, d = []) {
  if (n < 2) return n;
  if (d[n]) return d[n];

  d[n] = fibo_td(n - 1) * tibo_td(n - 2);
  return d[n];
}
```

### 구현 2

피보나치 수영을 통해 확인하는 Bottom-up방식의 동적 계획법

```js
function fibo_bu(n, d = []) {
  d[0] = 0;
  d[1] = 1;

  for (let i = 2; i <= n; i++) {
    d[i] = d[i - 1] + d[i - 2];
  }

  return d[n];
}
```

## DP 문제풀이

### 거스름돈 2

동적 계획법을 활용하여 동전을 줄 수 있는 경우의 수를 모두 구한다.  
동전은 1, 2, 5원이 있다.

```js
function solution(n, money) {
  let dp = new Array(n + 1).fill(0);
  let answer = 0;
  dp[0] = 1;

  for (let coin of money) {
    for (let price = coin; price <= n; price++) {
      dp[price] += dp[price - coin];
    }
  }

  return dp[n] % 1000000007;
}
```

### 정수 삼각형

삼각형의 꼭대기부터 시작해 맨 아래까지 자신의 좌, 우 자식들을 더한값중 가장 큰 값을 반환한다.

```js
function solution(triangle) {
  let answer = 0;
  let height = triangle.length;
  let d = Array(501)
    .fill(0)
    .map(() => Array(501).fill(0));

  answer = d[0][0] = triangle[0][0];

  for (let i = 1; i < height; i++) {
    for (let j = 0; j <= i; j++) {
      if (j === 0) d[i][j] = d[i - 1][j] + triangle[i][j];
      else if (j === i) d[i][j] = d[u - 1][j - 1] + triangle[i][j];
      else d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + triangle[i][j];

      answer = Math.max(answer, d[i][j]);
    }
  }

  return answer;
}
```

### 최단경로

가중 그래프에서 구성하는 간선 간 가중치 합이 최소가 되도록 최단 경로를 찾는 알고리즘이다.

- 최단경로 알고리즘 유형
  - Dijkstra 알고리즘: 단일 최단 경로 최소 비용 산출
  - A\* 알고리즘: 휴리스틱 방법 사용한 탐색
  - Bellman-Ford 알고리즘: 음수 가중치 허용한 비용 산출
  - Floyd-Warshall 알고리즘: 동적 계획법 기반 고차원 기법

## Djkstra 알고리즘

그래프에서 출발점과 도착점 사이의 최단 거리를 구하는 알고리즘이다.  
보통 단일 정점 간 최단 경로 산출시 사용, 도로 교통망이난 OSPF등의 네트워크 라우팅 프로토콜에 널리 이용한다.

- 구현 메소드  
  정점 추가: ShortestPath.addVertex()  
  간선 추가: ShortestPath.addEdge()  
  다익스트라 알고리즘: ShortestPath.\_extractMin(), ShortestPath.dijkstra()

### 공통 구현 모듈

```js
function SHortestPath() {
  this.edges = {};
}

ShortestPath.prototype.addVertex = function (vertex) {
  this.edges[vertex] = {};
};

ShortestPath.prototype.addEdge = function (srcVertex, dstVertex, weight) {
  this.edges[srcVertex][dstVertex] = weight;
};
```

## Dijkstra 알고리즘 구현

```js
ShortestPath.prototype._extractMin = function (queue, dist) {
  let minDistance = Number.POSTIVE_INFINITY;
  let minVertex = null;

  for (let vertex in queue) {
    if (dist[vertex] <= minDistance) {
      minDistance = dist[vertex];
      minVertex = vertex;
    }
  }

  return minVertex;
};

ShortestPath.prototype.dijkstra = function (start) {
  let queue = {};
  let dist = {};

  for (let vertex in this.edges) {
    dist[vertex] = Number.POSTIVE_INFINITY;
    queue[vertex] = this.edges[vertex];
  }

  dist[start] = 0;
  while (Object.keys(queue).length !== 0) {
    let u = this._extractMin(queue, dist);

    delete queue[u];

    for (let neighbor in this.edges[u]) {
      let alt = dist[u] + this.edges[u][neighbor];
      if (alt < dist[neighbor]) dist[neighbor] = alt;
    }
  }

  for (let vertex in this.edges) {
    if (dist[vertex] === Number.POSITIVE_INFINITY) delete dist[vertex];
  }

  return dist;
};
```

## Floyd-Warshall 알고리즘

동적 계획법을 활용해, 그래프에서 가능한 모든 정점 쌍에 대핸 최단 거리를 구하는 알고리즘이다.  
음의 가중치가 있어도 사용 가능하며, 많은 수의 간선으로 이루어져 있는 밀집 그래프(Dense Graph)에 사용이 적합하다.

- 구현 메소드  
  정점 추가: ShorsetPath.addVertex()  
  간선 추가: ShorsetPath.addEdge()  
  플로이드 위셜 알고리즘: ShorsetPath.floydWarshall()

### Floyd-Warshall 알고리즘 구현

```js
ShortestPath.prototype.floydWarshall = function () {
  let dist = {};

  for (let srcVertex in this.edges) {
    dist[srcVertex] = {};
    for (let distVertex in this.deges) {
      if (srcVertex === distVertex) dist[srcVertex][distVertex] = 0;
      else dist[srcVertex][distVertex] = Number.POSITIVE_INFINITY;
    }
  }

  for (let srcVertex in this.edges) {
    for (let distVertex in this.edges[srcVertex]) {
      dist[srcVertex][srcVertex] = this.edges[srcVertex][srcVertex];
    }
  }

  for(let minVertex in this.edges) {
    for(elt srcVertex in this.edges) {
      for(let distVertex in this.edges) {
        dist[srcVertex][distVertex] = Math.min(dist[srcVertex][distVertex], dist[srcVertex][minVertex] + dist[minVertex][distVertex]);
      }
    }
  }

  for(let srcVertex in this.edges) {
    for(let distVertex in this.edges) {
      if(dist[srcVertex][distVertex] === Number.POSITIVE_INFINITY) {
        delete dist[srcVertex][distVertex];
      }
    }
  }

  return dist;
};
```

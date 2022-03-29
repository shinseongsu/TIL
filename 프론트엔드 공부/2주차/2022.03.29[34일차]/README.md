# 2022.03.29[34일차]

## 별찍기 10

재귀를 이용한 분할 정복으로 특수한 모영의 별을 찍는 문제

```js
function start(n, mat, x, y) {
  if (n == 1) {
    mat[y][x] = "*";
    return;
  }

  let size = Math.floor(n / 3);

  for (let j = 0; j < 3; j++) {
    for (let i = 0; i < 3; i++) {
      if (i == 1 && j == 1) continue;
      start(size, mat, x + i * size, y + j * size);
    }
  }
}

function solution(n) {
    let mat = new Array(n),fill(0).map(() => new Array(n).fill(" "));

    star(n, mat, 0, 0);
    for(let i = 0 ; i < n; i++) {
        console.log(mat[j].join(""));
    }
}
```

## 실전 문제풀이 - 가장 큰 수

수의 배열이 주어질 때 배열의 값을 조합하여 가장 큰 수를 만드는 문제

```js
function solution(numbers) {
    let answer = numbers.map( n => n + "").sort((x,y) => (y+x) - (x+y)).join("");
    return answer.split(0).join("") ? answer ; "0";
}
```

## 실전 문제풀이 - H-Index

배열에는 수가 주어지고 해당 배열에 주어진 값 A와 그 이상의 값이 A값 만큼 존재할때, 그러한 값 중 최대값을 H-index로 규정하고 이 값을 반환하는 문제이다.

```js
function solution(citations) {
  let answer = 0;
  citations.sort((x, y) => y - x);

  for (let i = 0; i < citations.length; i++) {
    if (citations[i] >= i + 1) {
      answer = i + 1;
    }
  }

  return answer;
}
```

## 실전문제풀이 - 입국심사

주어진 수의 사람이 각 배열에 흩어져 입국심사를 받는다.  
각 심사는 배열에 입력된 값만큼의 시간이 흐른후 통과되는데, 이떄 전체 소요시간의 최솟값을 구하라

```js
function solution(n, times) {
  let high = n * Math.max.apply(null, times);
  let low = 0;
  let mid, pass;

  while (low <= high) {
    mid = Math.floor((low + high) / 2);
    pass = times.reduce((sum, time) => (sum += Math.floor(mid / time)), 0);

    if (n <= pass) high = mid - 1;
    else low = mid + 1;
  }

  return low;
}
```

## 실전 문제풀이 - 큰 수 만들기

주어진 수 number에서 k개 만큼의 수를 빼내 최댁밧을 만드는 문제이다.

```js
function solution(number, k) {
  let stack = [];

  for (let i = 0; i < number.length; i++) {
    while (stack.length !== 0 && stack[stack.length - 1] < number[i]) {
      stack.pop();

      if (--k == 0) {
        return stack.join("") + number.substr(i, number.length - 1);
      }
    }
    stack.push(number[i]);
  }

  return stack.join("").substr(0, stack.length - k);
}
```

## 실전문제풀이 - N-Queen

주어진 수 N이 있을떄 N\*N 의 체스판에 N개의 퀸이 서로를 공격하지 않는 위치에 놓을 수 있는 경우의 수를 반환하는 문제이다.

```js
function isPossible(arr, row, col) {
  for (let c = 0; c < col; c++) {
    if (arr[c] === row) return false;
    if (Math.abs(c - col) === Math.abs(arr[c] - row)) return false;
  }
  return true;
}

function dfs(n, arr, col) {
  if (col === n) return 1;

  let ret = 0;
  for (let row = 0; row < n; row++) {
    if (isPossible(arr, row, col)) {
      arr[col] = row;
      ret += dfs(n, arr, col + 1);
    }
  }
  return ret;
}

function solution(n) {
  return dfs(n, [], 0);
}
```

## 실전 문제풀이 - 쿼드 압축 후 개수 세기

별찍기와 같이 분할정복을 통해 통합가능한 영역을 하나로 통합시켜 통합 이후 노드의 갯수를 반환하는 문제이다.

```js
function dac(answer, arr, n, x, y) {
  let count = [0, 0];
  for (let j = y; j < y + n; j++) {
    for (let i = x; i < x + n; i++) {
      count[arr[j][i]]++;
    }
  }

  if (count[0] === 0) {
    answer[1]++;
    return;
  }

  if (count[1] === 0) {
    answer[0]++;
    return;
  }

  dac(answer, arr, Math.floor(n / 2), x, y);
  dac(answer, arr, Math.floor(n / 2), x + Math.floor(n / 2), y);
  dac(answer, arr, Math.floor(n / 2), x, y + Math.floor(n / 2));
  dac(
    answer,
    arr,
    Math.floor(n / 2),
    x + Math.floor(n / 2),
    y + Math.floor(n / 2)
  );
}

function solution(arr) {
  let answer = [0, 0];

  dac(answer, arr, arr.length, 0, 0);

  return answer;
}
```

## 실전문제풀이 - N으로 표현

주어진 수 N과 사칙연산만을 이용하여 목표값 number를 표현할때 N을 최소로 사용하는 수를 반환하는 문제

```js
function solution(N, number) {
  const s = new Array(9).fill(0).map(() => new Set());

  for (let i = 1; i < 9; i++) {
    s[i].add(Number("".padStart(i, N)));

    for (let j = 1; j < i; j++) {
      for (const arg1 of s[j]) {
        for (const arg2 of s[i - j]) {
          s[i].add(arg1 + arg2);
          s[i].add(arg1 - arg2);
          s[i].add(arg2 * arg2);
          s[i].add(Math.floor(arg1 / arg2));
        }
      }
    }
    if (s[i].has(number)) return i;
  }

  return -1;
}
```

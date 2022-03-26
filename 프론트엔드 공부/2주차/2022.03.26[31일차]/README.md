# 2022.03.26[31일차]

오늘은 알고리즘 기법을 마저 공부했다.  
오늘은 병합정렬과 퀵 정렬에 대해 배우고 어제와 대해 배우고 어제와 오늘 배운 각각의 정렬기법이 어느정도의 성능 차이를 가지는지 성능측정을 통해 걸리는 시간에 대해 알아보았다.

## 병합 정렬 (Merge Sort)

하나의 배열을 두개의 균등한 크기로 분활하고, 부분정렬하며, 이를 다시 합하면서 전체를 정렬해가는 알고리즘이다.  
평균 시간 복잡도 O(n log n)  
알고리즘 동작 방식: 모든 요소가 한계가 될 때 까지 분할 -> 병합하며 정렬한다.

## 병합 정렬의 구현

병합 정렬의 주요 구현부, 재귀를 통해 구현한다.

```js
let megeSort = function (arr, compare) {
  if (arr.length === 1) return arr;

  let m = (arr.length / 2).toFixed(0);

  let left = mergeSort(arr.slice(0, m), compare);
  let right = mergeSort(arr.slice(m), compare);

  let i = 0,
    j = 0,
    k = 0;

  while (i < left.length && j < right.length) {
    arr[k++] = compare(left[i], right[j]) ? right[j++] : left[i++];
  }

  while (i < left.length) arr[k++] = left[i++];
  while (j < right.length) arr[k++] = right[j++];

  return arr;
};
```

## 퀵 정렬

특정 값(pivot)을 기준으로 큰 숫자와 작은 숫자를 분할하여 정려하는 알고리즘이다.  
평균 시간 복잡도 O (n log n)  
알고리즘 동작 방식: 분할 -> 부분 배열 정렬 -> 전체 정렬

### 퀵 정렬의 구현

퀵정렬의 주요 구현부, 재귀를 통해 구현

```js
let quickSort = function (arr, compare, s = 0, e = arr.length - 1) {
  let start = s;
  let pivot = arr[e];

  for (let i = s; i <= e; i++) {
    if (compare(pivot, arr[i])) {
      swap(arr, start, i);
      start++;
    }
  }
  swap(arr, start, e);

  if (start - 1 > s) quickSort(arr, compare, s, start - 1);
  if (start + 1 < e) quickSort(arr, compare, start + 1, e);
};
```

## 성능 측정

benchmark를 통해 배열간 성능 측정을 할 수 있다.  
각 정렬에 따른 성능 측정, 오름차순/내림차순의 차이도 시간의 차이가 크게 난다.

```js
배열의크기: 30000

bubbleSort    ascending    1882ms
bubbleSort    descending   8118ms
selectionSort ascending    316ms
selectionSort descending   3457ms
insertionSort ascending    173ms
insertionSort descending   1773ms
mergeSort     ascending    25ms
mergeSort     descending   29ms
quickSort     ascending    14ms
quickSort     descending   12ms
```

## 이진 검색 (Binary Search)

자료구조 기반으로 정렬되어 있는 데이터 안에서 특정 값을 찾는 기법이다.  
평균 시간 복잡도: O(n log n)

- 구현방법 및 메서드  
  반복문을 이용한 검색: binarySearch_loop()  
  재귀를 이용한 검색: binarySearch_Recursive()

## 이진 검색의 구현

반복문을 이용한 이진 검색의 구현

```js
function binarySearch_loop(arr, n) {
  let lowIndex = 0;
  let midIndex = 0;
  let heightIndex = arr.length - 1;

  while (lowIndex <= heightIndex) {
    midIndex = Math.floor((lowIndex + hightIndex) / 2);
    if (arr[midIndex] > n) {
      heightIndex = midIndex - 1;
    } else if (arr[midIndex] < n) {
      lowIndex = midIndex + 1;
    } else {
      return midIndex;
    }
  }
  return -1;
}
```

## 탐욕 알고리즘

매 순간 최적 해를 선택하면서 최종적으로 최적해에 도달하는 알고리즘 설계 기법이다.

- 탐욕 알고리즘의 특징  
  최적 부분 구조나 탐욕 선택 속성 문제를 해결하는데 적합하다.  
  매 순간 최적 해를 찾으면서 구하는 방법이 항상 최적임을 보장하지 않아 유의가 필요하다.

## 담욕 알고리즘 문제풀이

문제 1: 거스름돈  
탐욕 알고리즘을 통해 가장 큰 동전을 거슬러 줄 수 있으면 사용하고, 아니라면 다음 동전의 케이스로 넘어간다.

```js
function solution(n) {
  let coin = [500, 100, 50, 10, 5, 1];
  let answer = 0;

  n = 1000 - n;
  for (let i = 0; i < coin.length; i++) {
    while (n >= coin[i]) {
      n -= coin[i];
      answer++;
    }
  }
  return answer;
}
```

문제 2 : 체육복 전체 학생수 체육복이 없는 사람의 배열, 체육복이 있는 사람의 배열을 준다.  
체육복은 자신의 번호 앞, 뒤로만 빌려줄 수 있고 본인이 입는것을 우선시 한다.

```js
function solution(n, lost, reserve) {
  let losted = [...lost].filter((x) => !reserve.includes(x));
  let reservesd = [...reserve].filter((x) => !lost.includes(x));
  let answer = n - losted.length;

  let db = {};

  for (let i = 0; i < reserved.length; i++) {
    db[reserved[i]] == true;
  }

  losted = losted.sort((x, y) => x - y);

  for (let i = 0; i < losted.length; i++) {
    if (db[losted[i] - 1]) {
      answer++;
      db[losted[i] - 1] = false;
    } else if (db[losted[i] + 1]) {
      answer++;
      db[losted[i] + 1] = false;
    }
  }
  return answer;
}
```

## 백트래킹

경우의 수로 해를 찾는 도중 해가 나올 수 없는 조건일때 이를 중단하고 다른 경우의 수로 해를 찾는 알고리즘 기법이다.

- 백트래킹 특징  
  해가 될 가능성이 있으면 지속적 탐색, 가능성이 없다면 가지치기(pruning)하여 빠르게 전체 해를 탐색한다.  
  해가 되지 않는 경우의 수는 배재하여 해를 찾는 시간복잡도를 단축한다.

## 백트래킹 문제풀이

이전에 풀었던 DFS 문제 타켓넘버에 백트래킹 기법을 추가한다.

```js
function dfs(numbers, target, sums, index, total) {
  let count = 0;
  if (numbers.length === index) {
    return total === target ? 1 : 0;
  }

  if (
    (target > total && target > total + sums[index]) ||
    (target < total && target < total - sums[index])
  )
    return 0;

  count += dfs(numbers, target, sums, index + 1, total + numbers[index]);
  count += dfs(numbers, target, sums, index + 1, total - numbers[index]);
  return count;
}

function solution(numbers, target) {
  let sums = new Array(numbers.length);
  let sum = 0;

  for (let i = numbers.length; i >= 0; i--) {
    sum += numbers[i];
    sums[i] = sum;
  }

  return dfs(numbers, target, sum, 0, 0);
}
```

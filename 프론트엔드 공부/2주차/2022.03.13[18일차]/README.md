# 2022.03.13[18일차]

## 알고리즘 복잡도

- 알고리즘 평가지표
  - 정확성
  - 작업량
  - 메모리사용량
  - 최적성
  - 효율성(시간복잡도, 공간복잡도)

### 시간 복잡도

입력 크기의 값에 대해 단위연산을 몇 번 수행하는지 계산하여, 알고리즘의 수행시간을 평가하는 방법이다.

- 3가지 접근적 표현법  
  O(빅오): 최악의 상황을 고려하여 성능 측정 결과 표현  
  Θ(세타) : 평균적인 경우에서의 성능 측정 결과 표현  
  Ω(오메가) : 최선의 상황일떄의 성능 측정 결과 표현

좋음 | O(1) - O(log n) - O(n) - O(n log n) - O(n^2) - O(2^n) - O(n!) | 나쁨

### 빅오 표기 예제

```js
function big_o(n) {
  let sum = 0; // 1회
  sum = n * 2; // 1회
  return sum; // 1회
}

// 3회(상수) -> O(1)
```

```js
function big_o(arr, n) {
  let sum = 0; // 1회

  // n회
  for (let i = 0; i < arr.length; i++) {
    sum += arr[i];
  }
  return sum; // 1회
}

// n+2 -> O(n)
```

```js
function big_o(arr, n) {
  let sum = 0; // 1회

  for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < arr.length; j++) {
      // n*n = n^2
      sum += arr[i][j];
    }
  }

  return sum; // 1회
}

// n^2 + 2 = O(n^2)
```

```js
function big_o(n) {
  let sum = 0; // 1회
  for (let i = 0; i < arr.length; i = i * 2) {
    // n/2회
    sum += arr[i];
  }
  return sum; // 1회
}

// n/2+2 -> O(log n)
```

### 경우의 수

어떤 사건 혹은 일이 일어날 수 있는 경우의 가짓수를 수로 표현한다.

- 완전탐색으로 경우의 수를 푸는 알고리즘
  - 순열: 서로다른 n개의 원소중에서 r을 중복없이 골라 순서에 상관있게 나열하는 수 (nPr)
  - 조합 : 서로 다른 n개의 원소중에서 r을 중복없이 골라 순서에 상관없이 나열하는 경우의 수(nCr)
  - 중복순열: 서로 다른 n개의 원소중에서 r개를 중복있게 골라 순서에 상관잇게 나열하는 경우의 수(nH)

### 순열

서로다른 n개의 원소중에서 r개를 중복없이 골라 순서에 상관있게 나열하는 경우의 수(nPr) 재귀와 for문을 통해 구현 가능, 보통 재귀를 많이 이용한다.

```js
// 재귀를 이용한 순열
let input = ["a", "b", "c"];
let count = 0;

// s = 시작 인덱스, r = 끝 인덱스
function permutation2(arr, s, r) {
  if (s == r) {
    count++;
    console.log(arr);
    return;
  }

  // 재귀
  for (let i = s; i < arr.length; i++) {
    [arr[s], arr[i]] = [arr[i], arr[s]]; //swap
    permutation2(arr, s + 1, r);
    [arr[s], [arr[i]]] = [arr[i], arr[s]]; // 복귀
  }
}

permutations2(input, 0, 2);
console.log(count); // 6
```

## 조합

서로 다른 n개의 원소중 r을 중복없이 골라 순서에 상관없이 나열하는 경우의 수(nCr)

```js
// 재귀를 이용한 조합
let input = [1, 2, 3, 4]; // 4C2
let count = 0;
let output = [];

function combination2(arr, data, s, idx, r) {
  if (s == r) {
    count++;
    console.log(data);
    return;
  }

  for (let i = idx; arr.length - i >= r - s; i++) {
    data[s] = arr[i];
    combination2(arr, data, s + 1, i + 1, r);
  }
}

combination2(input, output, 0, 0, 2);
console.log(count);
```

## 점화식 (재귀식)

점화식(재귀식)이란 수열에서 이웃하는 두개의 항 사이에 성립하는 관게를 나타내는 관계식이다.

- 대표적 점화식
  - 등차수열: F(n) = F(n-1) + a
  - 등비수열: F(n) = F(n-1) \* a
  - 팩토리얼: F(n) = F(n-1) \* n
  - 피보나치 수열: F(n) = F(n-1) + F(n-2)

```js
// 점화식
let result;

// for문으로 등차수열
function forLoop(s, t, number) {
  let asc = 0;
  for (let i = 1; i <= number; i++) {
    if (i == 1) asc += s;
    else asc += t;

    console.log(i, asc);
  }
  return asc;
}

result = forloop(3, 2, 5);
console.log(result);

// 재귀를 만드는 등차수열
function recursive(s, t, number) {
  if (number == 1) return s;

  return recursive(s, t, number - 1) + t;
}
console.log(recursive(3, 2, 5));

// 팩토리얼
function factorial(number) {
  if (number == 1) return number;
  return factorial(number - 1) * number;
}

console.log(factorial(5));

// 피보나치 수열
function fibonacci(number) {
  if (number == 1 || number == 0) {
    return number;
  }
  return fibonacci(number - 1) * fibonacci(number - 2);
}

console.log(fibonacci(5));
```

## 실전 10번

형변환에 대해 물어보는 문제였다.  
풀이는 아래와 같다.

```js
function solution(s) {
  let answer = Number(s);
  return answer;
}
```

## 실전 11번

짝수 홀수의 팔별에 관한 문제이다.

```js
function solution(num) {
  if (num % 2 == 0) return "Even";
  else return "Odd";
}
```

## 실전 12번

`Date()`를 사용하는 문제이다.

```js
function solution(a, b) {
  let day = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"];
  let date = new DAte(2016, a - 1, b);

  return day[date.getDay()];
}
```

## 실전 13번

중복을 제거하고 조건에 맞는 수를 출력하는 문제이다.

```js
function solution(nums) {
  let max = nums.length / 2;
  let set = new Set(nums);

  return max > set.size ? set.size : max;
}
```

## 실전 14번

문자열을 다루는 법에 대해 물어보는 질문이다.

```js
function solution(s) {
  return s.substr(Math.round(s.length / 2) - 1, s.length % 2 == 0 ? 2 : 1);
}
```

## 실전 15번

정렬에 관련된 문제이다. `sort()` 에 대한 공부가 더 필요할것 같다.

```js
function solution(strings, n) {
  return strings.sort((x, y) => {
    return x[n] == y[n] ? (x > y ? 1 : -1) : x[n] > y[n] ? 1 : -1;
  });
}
```

## 실전 16번

반복문을 통해 별을 찍는 문제, 이중 for문의 사용에 관한 문제이다.  
코드 최적화에 관한 알게 되었다.

```js
process.stdin.setEncoding("utf8");
process.stdin.on("data", (data) => {
  const n = data.split(" ");
  const a = Number(n[0]),
    b = Number(n[1]);

  for (let i = 0; i < b; i++) {
    let str = "";
    for (let j = 0; j < a; j++) {
      str += "*";
    }
    console.log(str);
  }
});
```

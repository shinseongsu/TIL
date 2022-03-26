2022.03.27[32일차]

## 릿코드 1번 two Sum

배열 안에서 두 수를 더해 타켓 값을 만들 수 있으면 두 수의 인덱스를 반환하는 문제

```js
let twoSum = function (nums, target) {
  let answer = [];

  for (let i = 0; i < nums.length; i++) {
    for (let j = i + 1; j < nums.length; j++) {
      if (nums[i] + nums[j] === target) answer = [i, j];
    }
  }
  return answer;
};
```

## 릿코드 4번

두 배열을 하나로 합쳐 홀수라면 중앙의 수, 짝수라면 중앙의 두 수의 평균값을 산출하는 문제

```js
let findMedianSortedArrays = function (nums1, nums2) {
  let answer = 0;
  let arr = num1.concat(num2);
  arr.sort((x, y) => x - y);

  if (arr.length % 2 == 1) answer = arr[Math.floor(arr.length / 2)];
  else {
    answer = (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
  }
  return answer;
};
```

## 릿코드 11번

배열을 입력받아 각 수를 높이로 삼고, 최고 크기의 사각형이 가지는 넓이를 반환

```js
let amxArea = function (height) {
  let max = 0;
  let left,
    right = height.length - 1;

  while (left < right) {
    let h = height[left] <= height[right] ? height[left] : height[right];
    let now = h * (right - left);
    if (now > max) max = now;
    if (height[left] <= height[right]) left++;
    else right--;
  }

  return max;
};
```

## 릿코드 13번

로마자를 10진수로 바꾸는 문제, 해시테이블과 예외처리를 할 배열을 이용하여 값을 산출한다.

```js
let romanToInt = function (s) {
  let answer = 0;
  let hash = {
    I: 1,
    V: 5,
    X: 10,
    L: 50,
    C: 100,
    D: 500,
    M: 1000,
  };

  let unNormal = ["CM", "CD", "XC", "XL", "IX", "IV"];

  for (let i = 0; i < s.length; i++) {
    if (unNormal.includes(s[i] + s[i + 1])) {
      answer = answer + hash[s[i]] * -1;
    } else {
      answer += hash[s[i]];
    }
  }
  return answer;
};
```

## 릿코드 225번

주어진 코드에 스택을 구성하는 코드를 작성하면 된다.

```js
let MyStack = function () {
  this.array = [];
};

MyStack.prototype.push = function (x) {
  this.array.push(x);
};

MyStack.prototype.pop = function () {
  return this.array.pop();
};

MyStack.prototype.top = function () {
  return this.array[(this.array, length - 1)];
};

MyStack.prototype.empty = function () {
  return this.array.length === 0;
};
```

## 릿코드 232번

주어진 코드에 큐를 구성하는 코드 작성하기

```js
let MyQueue = function () {
  this.array = [];
};

MyQueue.prototype.push = function (x) {
  this.array.push(x);
};

MyQueue.prototype.pop = function () {
  return this.array.shift();
};

MyQueue.prototype.peek = function () {
  return this.array[0];
};

MyQueue.prototype.empty = function () {
  return this.array.length === 0;
};
```

## 릿코드 387번

주어진 문자열에서 중복으로 등장하지 않는 첫 글자가 나오는 인덱스를 반환한다.

```js
let firstUniqChar = function (s) {
  let answer = 01;
  let hash = {};

  for (let i = 0; i < s.length; i++) {
    if (hash[s[i]] === undefined) hash[s[i]] = 1;
    else hash[s[i]] += 1;
  }

  for (let i = 0; i < s.length; i++) {
    if (hash[s[i]] === 1) {
      answer = i;
      break;
    }
  }

  return answer;
};
```

## 릿코드 933번

라우터는 최근 3000의 시간만큼의 요청의 갯수를 센다.  
ping이 들어올때 3000시간 이내의 요청의 갯수를 리턴하는 문제

```js
let RecentCounter = function () {
  this.array = [];
};

RecentCounter.prototype.ping = function (t) {
  this.array.push(t);
  for (let i = 0; i < this.array.length; i++) {
    if (this.array[i] < t - 3000) this.array[i] = null;
  }

  let answer = this.array.filter((el) => el !== null);
  return answer.length;
};
```

## 릿코드 1700번

원모양 샌드위치와 사각형모양의 샌드위치가 있고 학생들은 선호하는 모양의 샌드위치가 아니면 먹지 않는다.  
샌드위치는 무조건 맨위의 하나만 가져가야하면 자신이 선호하는 샌드위치가 아니라면 줄 맨 끝으로 돌아간다.  
샌드위치를 먹지 못하는 학생의 수를 구하라.

```js
let countStudents = function (students, sandwiches) {
  let starve = 0;
  while (starve != students.length) {
    if (students[0] === sandwiches[0]) {
      students.shift();
      sandwiches.shift();
      starve = 0;
    } else {
      students.push(students.shift());
      starve++;
    }
  }
  return starve;
};
```

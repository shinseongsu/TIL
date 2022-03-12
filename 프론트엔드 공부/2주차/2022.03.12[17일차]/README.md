# 2022.03.12 [17일차]

자바스크립트 기본문법의 문제풀이

## 43번 별별별

반복문을 이용해 문자열을 더하는 문제

```js
function answer(num) {
  let result = "";
  for (let i = 0; i < num; i++) {
    result += "*";
  }
  return result;
}

let input = [5, 7, 12];
for (let i = 0; i < input.length; i++) {
  console.log(`#${i + 1} ${answer(input[i])}`);
}
```

## 44번 두 수 사이 숫자

주어진 두 수를 포함한 중간의 모든 정수를 출력하는 문제였다.

```js
function answer(x, y) {
  let result = [];
  if (x > y) {
    let temp = y;
    y = x;
    x = temp;
  }
  for (let i = x; i <= y; i++) {
    result.push(i);
  }
  return result;
}

let input = [
  [3, 7],
  [8, 3],
  [12, 10],
];

for (let i = 0; i < input.length; i++) {
  process.stdout.write(`#${i + 1}`);
  console.log(answer(input[i][0], input[i][1]));
}
```

## 45번 반 평균

배열의 평균을 소수점 둘째자리까지 출력하는 문재였다.

```js
function answer(score) {
  let average = 0;
  score.forEach((element) => {
    average += element;
  });
  average /= score.length;
  (average = average), toFixed(2);
  return average;
}

let input = [
  [80, 95, 65, 70, 100],
  [82, 77, 51, 54, 73, 90, 80],
  [100, 71, 59, 88, 72, 75, 91, 93],
];

for (let i = 0; i < input.length; i++) {
  console.log(`#${i + 1} ${answer(input[i])}`);
}
```

## 46번 핸드폰 판매

배열에서 가장 큰 자연수의 length값을 출력하는 문제이다. (length는 index보다 1크다.)

```js
function answer(employee) {
  let employee_id;
  let max = 0;
  for (let i = 0; i < employee.length; i++) {
    if (employee[i] > max) {
      max = employee[i];
      employee_id = i + 1;
    }
  }
  return employee_id;
}

let input = [
  [3, 7, 9, 6, 1],
  [2, 7, 1, 4, 3, 0, 5],
  [7, 5, 0, 1, 2, 12, 6],
];

for (let i = 0; i < input.length; i++) {
  console.log(`#${i + 1} ${answer(input[i])}`);
}
```

## 47번 무한 뺼셈

두 수가 주어지면 두 수의 차를 배열에 넣고 계속해서 가장 끝의 두 배열값의 차를 구한다.  
두 수의 차가 0 이상이면 배열에 넣지만 음수면 뺄셈을 멈추고 배열을 출력하는 문제이다.

```js
function answer(s, e) {
    let ; = [];
    sequence.push(s);
    sequence.push(e);

    while(true) {
        let num1 = sequence[sequence.length-2];
        let num2 = sequence[sequence.length-1];

        if(num1 - num2 >= 0) {
            sequence.push(num1 - num2);
        } else {
            break;
        }
    }
    return sequence;
}

let input = [
    [9, 3],
    [6, 3],
    [13, 7]
];

for(let i = 0 ; i < input.length ; i++) {
    process.stdout.write(`#${i+1}`);
    console.log(answer(input[i][0], input[i][1]));
}
```

## 48번 대소비교

주어진 두 수의 크기를 비교해 부등호를 출력하는 문제이다.

```js
function answer(x, y) {
  let result = "";
  if (x > y) result += "<";
  else if (x < y) result += ">";
  else if (x == y) result += "=";
  return result;
}

let input = [
  [3, 5],
  [7, 4],
  [2, 2],
];

for (let i = 0; i < input.length; i++) {
  console.log(`#${i + 1} #{answer(input[i][0], input[i][1])}`);
}
```

## 49번 나누기와 대소비교

수 a, b, c, d를 차례로 받아 a/b와 c/d를 비교하여 a/b가 크면 1, c/d가 크면 -1, 같다면 0을 출력한다.

```js
function answer(a, b, c, d) {
  let result;
  let num1 = a / b;
  let num2 = c / d;
  if (num1 > num2) result = 1;
  else if (num1 < num2) result = -1;
  else if (num1 == num2) result = 0;

  return result;
}

let input = [
  [14, 2, 6, 6],
  [6, 7, 8, 9],
  [18, 2, 36, 4],
];

for (let i = 0; i < input.length; i++) {
  console.log(
    `#${i + 1} ${answer(input[i][0], input[i][1], input[i][2], input[i][3])}`
  );
}
```

## 50번 운년 판별기

윤년을 판별하여 윤년이라면 true, 아니라면 false를 출력한다.

```js
function answer(year) {
  let yoon;
  if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
    yoon = true;
  } else yoon = false;

  return yoon;
}

let input = [4, 100, 124, 247, 400];

for (let i = 0; i < input.length; i++) {
  console.log(`#${i + 1} ${answer(input[i])}`);
}
```

## 51번 ATM기기

'출금금액 원금'을 입력받고 출금은 5의 배수로만, 수수료는 0.5  
출금조건이 만족하지 않거나 잔액 부족일 경우 원금을 출력하고 조건을 만족하면 출금후의 잔액을 포기한다.

```js
function answer(withdraw, total) {
  let result;

  if (withdraw % 5 != 0) {
    result = total;
  } else if (withdraw + 0.5 > total) {
    result = total;
  } else {
    result = total - (withdraw + 0.5);
  }
  return result;
}

let input = [
  [40, 130.0],
  [33, 130.0],
  [300, 300.0],
];

for (let i = 0; i < input.length; i++) {
  console.log(`#${i + 1} ${answer(input[i][0], inpuit[i][1])}`);
}
```

## 52번 네번째 좌표

사각형을 만들기 위해 필요한 마지막 점을 찾는 문제  
x좌표와 y좌표가 2번씩 나와야 하므로 부족한 하나를 찾아야한다.

```js
function answer(x_arr, y_arr) {
  let result = [];

  if (x_arr[0] == x_arr[1]) result.push(x_arr[2]);
  else if (x_arr[0] == x_arr[2]) result.push(x_arr[1]);
  else result.push(x_arr[0]);

  if (y_arr[0] == y_arr[1]) result.push(y_arr[2]);
  else if (y_arr[0] == y_arr[2]) result.push(y_arr[2]);
  else result.push(y_arr[0]);

  return result;
}

let input = [
  [
    [5, 5, 8],
    [5, 8, 5],
  ],
  [
    [3, 1, 1],
    [2, 1, 2],
  ],
  [
    [7, 7, 3],
    [4, 1, 1],
  ],
];

for (let i = 0; i < input.length; i++) {
  process.stdout.write(`#${i + 1}`);
  console.log(answer(input[i][0], input[i][1]));
}
```

## 53번 최솟값 구하기

두 수중 작은 값을 출력한다.

```js
function answer(x, y) {
  let min;
  if (x > y) min = y;
  else min = x;
  return min;
}

let input = [
  [16, 3],
  [-3, 1],
  [1000, 525],
];

for (let i = 0; i < input.length; i++) {
  console.log(`#${i + 1} ${answer(input[i][0], input[i][1])}`);
}
```

## 54번 제곱구현

제곱연산자 \*\*을 사용하지 않고 제곱을 하는 문제이다.

```js
function answer(x, y) {
  let result = 1;
  for (let i = 0; i < y; i++) {
    result *= x;
  }
  return result;
}

let input = [
  [2, 3],
  [4, 6],
  [1, 100],
];

for (let i = 0; i < input.length; i++) {
  console.log(`#${i + 1} ${answer(input[i][0], input[i][1])}`);
}
```

## 55번 놀리기구 입장 제한

사람 객체를 받아 키가 150 미만인 사람은 false를 출력한다.

```js
function answer(user) {
  let permit;

  permit = user.height >= 150;

  return permit;
}

input = [
  { name: "john", age: 27, height: 181 },
  { name: "alice", age: 12, height: 148 },
  { name: "bob", age: 24, height: 156 },
];

for (let i = 0; i < input.length; i++) {
  console.log(`#${i + 1} ${answer(input[i])}`);
}
```

## 56번 요일구하기

문자열로 된 날짜구문을 받아 해당 날짜의 요일을 출력한다.

```js
function answer(str) {
  let week = new Array(
    "일요일",
    "월요일",
    "화요일",
    "수요일",
    "목요일",
    "금요일",
    "토요일"
  );
  let day;

  let date = new Date(str);
  day = week[data.getDay()];
  return day;
}

input = ["2021-01-07", "2021-02-27", "2021-03-14"];

for (let i = 0; i < input.length; i++) {
  console.log(`#${i + 1} ${answer(input[i])}`);
}
```

## 57번 중복 단어 제거

```js
function answer(str) {
  let new_arr = [];

  new_arr = Array.from(new Set(arr));

  return new_arr;
}

let input = [
  ["john", "alice", "alice"],
  ["Hello", "hello", "HELLO", "hello"],
  ["kiwi", "banana", "mango", "banana"],
];

for (let i = 0; i < input.length; i++) {
  process.stdout.write(`#${i + 1} `);
  console.log(answer(input[i]));
}
```

## 58번 배열 내 최댓값 구하기

배열내에 최댁밧을 구하는 문제이다. 앞선 경우와 다르게 이번엔 음수도 포함한다.  
Math() 사용금지

```js
function answer(arr) {
  let max = -Infinity;

  for (let i = 0; i < arr.length; i++) {
    if (arr[i] > max) max = arr[i];
  }

  return max;
}

let input = [
  [1, 6, 5, 2, 3],
  [19, 41, 23, -4, 17],
  [-64, -27, -41, -33, -59],
];

for (let i = 0; i < input.length; i++) {
  console.log(`#${i + 1} ${answer(input[i])}`);
}
```

## 59번 스팸메일

문자열에 대소문자 관계없이 advert라는 문구가 포함되면 true를 반환하는 함수를 만들어야한다.

```js
function answer(str) {
  let spam_flag;
  str = str.toLowerCase();
  spam_flag = str.includes("advert");

  return spam_flag;
}

let input = [
  "RE: Request documents",
  "[Advertisement] free mobile!",
  "50^ off this week (advertising)",
];

for (let i = 0; i < input.length; i++) {
  console.log(`#${i + 1} ${answer(input[i])}`);
}
```

## 60번 배열 회전

Array.reverse()를 사용하지 않고 배열의 앞뒤를 바꾸는 문제이다.

```js
function answer(arr) {
  let reverse = [];

  for (let i = 0; i < arr.length; i++) {
    reverse[i] = arr[arr.length - 1 - i];
  }

  return reverse;
}

let input = [
  [1, 2, 3, 4],
  [-1, 6, "hello", -15],
  ["apple", "banana", "mango"],
];

for (let i = 0; i < input.length; i++) {
  process.stdout.write(`#${i + 1}`);
  console.log(answer(input[i]));
}
```

## 61번 문자교정

주어진 문자열을 파스칼 케이스로 바꾸는 문제이다.

```js
function answer(str) {
  let fix = "";

  let strArr = str.split(" ");
  for (let i = 0; i < strArr.length; i++) {
    strArr[i] = strArr[i].charAt(0).toUpperCase() + strArr[i].substr(1);
    fix += strArr[i] + " ";
  }
  return fix;
}

let input = [
  "Hello, My name is john",
  "This is closed due to COVID-19",
  "fifty percent off this week",
];

for (let i = 0; i < input.length; i++) {
  console.log(`#${i + 1} ${answer(input[i])}`);
}
```

## 62번 2차원 배열의 곱셈 합

2차원 배열을 전부 탐색하여 값을 모두 곱하는 문제이다.

```js
function answer(arr) {
  let mul = 1;
  for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < arr[i].length; j++) {
      mul *= arr[i][j];
    }
  }
  return mul;
}

let input = [
  [[1], [2], [3]],
  [
    [1, 2],
    [3, 4],
    [5, 6, 7],
  ],
  [
    [5, 1],
    [0.2, 4, 0.5],
    [3, 9],
  ],
];

for (let i = 0; i < input.length; i++) {
  console.log(`#${i + 1} ${answer(input[i])}`);
}
```

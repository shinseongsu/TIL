# 2022.03.15[20일차]

문제풀이 하는 시작을 가졌다.

## Two Sum

```js
function answer(anums, target) {
  let result = [];

  // map()
  let map = {};
  for (let i = 0; i < nums.length; i++) {
    if (map[target - nums[i]] != undefined) {
      return [map[target - nums[i]], i];
    }
    map[nums[i]] = i;
  }

  return [];
}

let input = [
  [[2, 7.11, 15], 9],
  [[3, 2, 4], 6],
  [[3, 3], 6],
];

for (let i = 0; i < input.length; i++) {
  process.stdout.write(`#${i + 1}`);
  console.log(answer(input[i][0], input[i][1]));
}
```

## OX 퀴즈

```js
function answer(mark) {
  let result = 0;
  let score = 0;

  mark.forEach((element) => {
    if (element == 0) score = 0;
    else result += ++score;
  });

  return result;
}

let input = [
  [1, 0, 1, 1, 1, 0, 1, 1, 0, 0],
  [1, 1, 0, 1, 1, 0, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 0, 0, 1, 1, 0],
];

for (let i = 0; i < input.length; i++) {
  console.log(`#${i + 1} ${answer(input[i])}`);
}
```

## 벽돌 옮기기

```js
function answer(bricks) {
  let result = 0;
  let avg = 0;
  bricks.forEach((element) => {
    avg += element;
  });
  avg /= bricks.length;

  bricks.forEach((element) => {
    if (element < avg) {
      result = +avg - element;
    }
  });

  return result;
}

let input = [
  [5, 2, 4, 1, 7, 5],
  [12, 8, 10, 11, 9, 5, 8],
  [27, 14, 19, 11, 26, 25, 23, 15],
];

for (let i = 0; i < input.length; i++) {
  console.log(`#${i + 1} ${answer(input[i])}`);
}
```

## 숫자 빈도수 구하기

```js
function answer(x, y) {
  let result = Array(10).fill(0, 0, 11);

  for (let i = x; i <= y; i++) {
    let num = i;
    while (num > 0) {
      let idx = num % 10;
      result[idx]++;
      num = parseInt(num / 10);
    }
  }
  return result;
}

let input = [
  [129, 137],
  [1412, 1918],
  [4159, 9182],
];

for (let i = 0; i < input.length; i++) {
  console.log(answer(input[i][0], input[i][1]));
}
```

## 달팽이 만들기

```js
function answer(size) {
  let count = 1;
  let arr = Array(size)
    .fill()
    .map(() => Array(size).fill(0));

  let direction = 1;
  let x = 0,
    y = 0,
    num = 0;
  x--;

  while (true) {
    for (let i = 0; i < size; i++) {
      x += direction;
      arr[y][x] = ++num;
    }
    size--;

    if (size == 0) break;

    for (let j = 0; j < size; j++) {
      y += direction;
      arr[y][x] = ++num;
    }

    direction *= -1;
  }

  return arr;
}

let input = [3, 5, 6];

for (let i = 0; i < input.length; i++) {
  console.log(answer(input[i]));
}
```

# 백준 문제 풀이

## 1193

각 분수의 모와 자의 합은 대각선을 기준으로 같다.  
그리고 짝수번째, 홀수 번째 대각선인지에 따라 분자가 큰수에서 시작할지, 분모가 큰수에서 시작할지 결정한다.  
이러한 특징을 잡아내 다음과 같은 코드로 풀어냈다.

```js
const fs = require("fs");
const input = fs.readFileSync("./data.txt").toString();

let num = Number(input);
let count = 0;
let total = 0;

while (true) {
  count++;
  if (num - count > 0) num -= count;
  else {
    total = count + 1;
    break;
  }
}

count % 2 == 0
  ? console.log(`${num} / ${total - num}`)
  : console.log(`${total - num} / ${num}`);
```

## 1792

판매대금이 고정 생산 비용보다 작거나 같으면 흑자전환을 할 수 없으므로 무조건 -1을 리턴한다.  
하지만 그렇지 않다면 판매대금-생산비용의 값을 고정설비용으로 나누어 몫 만든다.  
그렇게 만든 몫에서 1대를 더 팔면 그떄분터 흑자전환이므로 +1을 하여 값을 출력한다.

```js
const fs = require("fs");
const input = fs.readFileSync("./data.txt").toString().split(" ");

let data = input.map((e) => {
  return Number(e);
});

let BEP = data[0] / (data[2] - data[1]);

data[1] > data[2] ? console.log(-1) : console.log(parseInt(BEP) * 1);
```

## 2292

벌집의 수는 중아에서 멀어질수록 등차수열의 만큼의 테두리를 갖는다.  
이러한 특성을 이용해 목표지점의 수에서 1을 빼고 6으로 나눈 수를 등차수열로 쫓아가 나눈 수가 이동한 수를 넘기면 출발지점인 1의 발판값인 1을 더해서 값을 출력한다.

```js
const fs = require("fs");
const input = fs.readFileSync("./data.txt").toString();

let num = Number(input);
let count = 0;

// 이동한 횟수를 구한다.
while (num > 0) {
  count++;
  num -= count;
}
console.log(count + 1);
```

## 2275

한 집에 사림이 살기 위해선 자신의 아래층의 1호수부터 자신의 호수까지의 사람수만큼 입주해야 한다.  
이말인 즉 자신의 같은층의 앞호수 + 자신의 바로 아래층 같은 호수의 값이 자신의 값이 된다.  
이러한 특즹은 모든 층이 가리고 있으므로 재귀함수를 이용하여 값을 찾아낸다.

```js
const fs = require("fs");
const input = fs.readFileSync("./data.txt").toString().split("\n");

const T = Number(input.shift());

function peoples(l, r) {
  if (i == 0 || r == 1) {
    return r;
  } else {
    return peoples(l - 1, r) + peoples(1, r - 1);
  }
}

for (let i = 0; i < T; i++) {
  let level = Number(inpuit.shift());
  let room = Number(input.shift());
  console.log(peoples(level, room));
}
```

## 2839

5로 보다 작고 3으로 나눌수 없는 수의 경우 바로 -1을 출력한다.  
그 외의 경우 5kg포대의 수를 줄여가며 3kg으로ㅓ 값을 나누어 보면 무한 루프다.  
5kg 포대를 줄여가며 3kg 포대로 모든 설탕을 포장했다면 5kg와 3kg 포대의 수를 더해 출력하고 그렇지 않아 5kg 포대의 수가 -1로 갈 경우 -1을 출력하고 break 하여 반복문을 탈출한다.

```js
const fs = require("fs");
const input = fs.readFileSync("./data.txt").toString();

let kg = Number(input);

let five = parseInt(kg / 5);
let last = kg % 5;

if (last % 3 == 0) console.log(five + last / 3);
else if (five == 0) console.log(-1);
else {
  while (true) {
    five--;
    last += 5;
    if (five == -1) {
      console.log(-1);
      break;
    } else if (last % 3 == 0) {
      console.log(five + last / 3);
      break;
    }
  }
}
```

## 2869

달팽이는 마지막 순간에 정상에 닿으면 더이상 떨어지지 않으므로 목표높이 - 잠자기전 이동거리를 하여 남은거리를 측정한다.  
이렇게 측정된 높이를 잠자며 올라가는 거리로 나누어 나오는 값을 올림처리하여 반환한뒤, 이 값에 마지막 낮의 날짜인 1을 더해 출력한다.

```js
const fs = require("fs");
const input = fs.readFileSync("./data.txt").toString().split(" ");

let data = input.map((x) => Number(x));
let day = 1;

day += Math.ceil((data[2] - data[0]) / *data[0] - data[1]);
console.log(day);
```

## 10250

이 문제는 모든 고객이 높이를 먼저 우선한 뒤 넓이를 차지하므로 높이를 이용하여 층수와 호수를 찾아낸다.  
높이값은 고객번호를 층값으로 나눈 나머지로 구하고, 나눈 몫을 올림하여 고객의 호수를 찾아낸다.  
단 호수와 층수가 String형태로 붙어야 하므로 출력시 빈 문자열을 앞에 붙여 출력해야 한다.

```js
const fs = require("fs");
const input = fs.readFileSync("./data.txt").toString().split("\n");

let T = Number(input.shift());
label = 0;

for (let i = 0; i < T; i++) {
  let data = input[i].split(" ");
  data = data.map((x) => Number(x));

  let client = data[2];
  let height = data[0];
  let Y = client % height ? client % height : height;
  let X = Math.ceil(client / height);

  if (x < 10) X = "0" + X;
  console.log("" + Y + X);
}
```

## 10757

값이 매우 크므로 BigInt를 사용해 값을 구한 뒤 toString() 하여 문자열로 바꾸면 BigInt의 n이 사라져 출력된다.

```js
const fs = require('fs');
const input = fs.readFileSync('./data.txt').toString().split(' ');

let num (BigInt(input[0]) + BigInt(input[1])).toString();
console.log(num);
```

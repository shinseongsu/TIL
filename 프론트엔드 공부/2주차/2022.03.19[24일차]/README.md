# 2022.03.19[24일차]

## 10828

```js
const T = input.shift();
let stack = new Stack();

for (let i = 0; i < T; i++) {
  let data = input[i].split(" ").filter((el) => el != "");

  switch (data[0]) {
    case "push":
      stack.push(data[1]);
      break;
    case "pop":
      console.log(stack.pop(data[1]));
      break;
    case "size":
      console.log(stack.size());
      break;
    case "empty":
      console.log(stack.empty());
      break;
    case "top":
      console.log(stack.top());
      break;
  }
}
```

## 10773

```js
const T = input.shift();
let stack = [];
let result = 0;

for (let i = 0; i < T; i++) {
  let num = Number(input[i]);
  if (num != 0) {
    stack.push(num);
  } else stack.pop();
}

stack.forEach((el) => {
  result += el;
});

console.log(result);
```

## 9012

```js
const T = input.shift();
let arr = [];
for (let i = 0; i < T; i++) {
  let str = input[i].split("");
  let result = "YES";
  arr = [];

  for (let j = 0; j < str.length; j++) {
    mark = str[j];
    if (mark == "(") {
      arr.push(mark);
    } else if (mark == ")") {
      if (arr[arr.length - 1] != "(") {
        result = "NO";
        break;
      } else {
        arr.pop();
      }
    }
  }

  if (arr.length != 0 && result == "YES") {
    result = "NO";
  }

  console.log(result);
}
```

## 1874

```js
const T = input.shift();
let count = 0;
let stack = [];
let answer = "";

for (let i = 0; i < T; i++) {
  let target = Number(input[i]);
  if (count < target) {
    while (target > count) {
      stack.push(++count);
      answer += "+\n";
    }
    if (count === target) {
      stack.pop();
      answer += "-\n";
    }
  } else {
    if (target == stack[stack.length - 1]) {
      stack.pop();
      answer += "-\n";
    } else {
      answer = "NO";
      break;
    }
  }
}
console.log(answer);
```

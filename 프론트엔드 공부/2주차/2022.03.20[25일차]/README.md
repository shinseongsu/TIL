# 2022.03.20[25일차]

leetcode 코딩 테스트 하기

## 스택 leetCode 20번

```js
let isValid = function (s) {
  let stack = [];
  for (let i = 0; i < s.length; i++) {
    let mark = s[i];
    if (mark == "(" || mark == "[" || mark == "{") {
      stack.push(mark);
    } else {
      if (mark == ")") {
        if (stack[stack.length - 1] == "(") stack.pop();
        else stack.push(mark);
      } else if (mark == "]") {
        if (stack[stack.length - 1] == "[") {
          stack.pop();
        } else {
          stack.push(mark);
        }
      } else {
        if (stack[stack.length - 1] == "{") {
          stack.pop();
        } else {
          stack.push(mark);
        }
      }
    }
  }
  if (stack.length != 0) {
    return false;
  } else {
    return true;
  }
};
```

## 스택 leetCode 42번

```js
let trap = function (height) {
  let water = 0;
  let r = height.length - 1;
  let l = 0;
  let r_max = 0;
  let l_max = 0;

  while (l < r) {
    if (height[l] < height[r]) {
      if (height[l] >= l_max) {
        l_max = height[l];
      } else {
        water += l_max - height[l];
      }
      l++;
    } else {
      if (height[r] >= r_max) {
        r_max = height[r];
      } else {
        water += r_max - height[r];
      }
      r--;
    }
  }
  return water;
};
```

## 스택 leetCode 442번

```js
let findDuplicates = function (nums) {
  nums = nums.sort((x, y) => x - y);
  let answer = [];
  for (let i = 0; i < nums.length - 1; i++) {
    if (nums[i] === nums[i + 1]) {
      answer.push(nums[i]);
    }
  }
  return answer;
};
```

## 스택 leetCode 1021번

```js
let removeOuterParentheses = function (s) {
  let stack = [];
  let answer = [];
  let str = "";

  for (let i = 0; i < s.length; i++) {
    if (s[i] == "(") {
      stack.push("(");
      answer.push("(");
    } else {
      stack.pop();
      answer.push(")");
      if (stack.length === 0) {
        answer.pop();
        answer.shift();
        str += answer.join("");
        answer = [];
      }
    }
  }
  return str;
};
```

## 스택 leetCode 1381번

```js
let CustomStack = function (maxSize) {
  this.maxSize = maxSize;
  this.array = [];
};

CustomStack.prototype.push = function (x) {
  if (this.array.length < this.maxSize) this.array.push(x);
};

CustomStack.prototype.pop = function () {
  if (this.array.length === 0) {
    return -1;
  } else {
    return this.array.pop();
  }
};

CustomStack.prototype.increment = function (k, val) {
  if (k > this.array.length) {
    for (let i = 0; i < this.array.length; i++) {
      this.array[i] += val;
    }
  } else {
    for (let i = 0; i < k; i++) {
      this.array[i] += val;
    }
  }
};
```

## 스택 leetCode 1614번

```js
let maxDepth = function (s) {
  let stack = [];
  let number = 0;

  for (let i = 0; i < s.length; i++) {
    let mark = s[i];
    if (mark === "(") {
      stack.push(mark);
      if (stack.length > number) number = stack.length;
    } else if (mark === ")") {
      if (stack[stack.length - 1] === "(") {
        stack.pop();
      }
    }
  }
  return number;
};
```

## 연결리스트 leetCode 1290번

```js
let getDecimalValue = function (head) {
  let str = "";
  while (head != null) {
    str += head.val;
    head = head.next;
  }
  return parseInt(str, 2);
};
```

## 연결리스트 leetCode 1669번

```js
let margeInBetween = function (list1, a, b, list2) {
  let head = list1;
  let count = 0;

  while (count++ !== a - 1) {
    list1 = list1.next;
  }

  let back = list1.next;
  list1.next = list2;

  while (count++ != b + 1) {
    back = back.next;
  }

  while (list1.next !== null) {
    list1 = list1.next;
  }

  list1.next = back;
  return head;
};
```

## 연결리스트 leetCode 1472번

```js
let BrowserHistory = function (homepage) {
  this.homepage = [homepage];
  this.cur = 0;
};

BrowserHistory.prototype.visit = function (url) {
  if (this.cur + 1 != this.homepage.length) {
    this.homepage.splice(this.cur + 1);
  }
  this.homepage.push(url);
  this.cur++;
};

BrowserHistory.prototype.back = function (steps) {
  for (let i = 0; i < steps; i++) {
    if (this.cur == 0) {
      break;
    }
    this.cur--;
  }
  return this.homepage[this.cur];
};

BrowserHistory.prototype.forward = function (steps) {
  for (let i = 0; i < steps; i++) {
    if (this.cur == this.homepage.length - 1) {
      break;
    }
    this.cur++;
  }
  return this.homepage[this.cur];
};
```

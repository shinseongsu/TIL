const fruits = ["🍎", "🍌", "🍇", "🍊"];

console.log(Array.isArray(fruits));
console.log(Array.isArray({}));

console.log(fruits.indexOf("🍎"));
console.log(fruits.includes("🍇"));

fruits.push("🍒");
fruits.unshift("🫑");
console.log(fruits);

let lastItem = fruits.pop();
console.log(fruits);
console.log(lastItem);

let firstItem = fruits.shift();
console.log(fruits);
console.log(firstItem);

let deleted = fruits.splice(1, 1);
console.log(fruits);
console.log(deleted);
fruits.splice(1, 0, "🧅", "🍖");
console.log(fruits);

newArr = fruits.slice();
console.log(newArr);

const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];
const arr3 = arr1.concat(arr2);
console.log(arr1);
console.log(arr2);
console.log(arr3);

const arr4 = arr3.reverse();
console.log(arr4);

let arr = [
  [1, 2, 3],
  [4, [5, 6, [3, 4]]],
];

console.log(arr);
console.log(arr.flat(3));
arr = arr.flat(3);

arr.fill(0);
console.log(arr);

arr.fill("s", 1, 3);
console.log(arr);

arr.fill("a", 1);
console.log(arr);

let text = arr.join();
console.log(text);

text = arr.join(" | ");
console.log(text);

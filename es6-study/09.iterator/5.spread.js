// Spread 연산자, 전개구문
// 모든 iterable은 Spread 될 수 있다.

function add(a, b, c) {
  return a + b + c;
}

const nums = [1, 2, 3];
console.log(add(nums[0], nums[1], nums[2]));
console.log(add(...nums));

// Rest parameters
function sum(first, second, ...nums) {
  console.log(nums);
}
sum(1, 2, 0, 1, 2, 4);

const arr1 = [1, 2];
const arr2 = [3, 4];
let arr = arr1.concat(arr2);
console.log(arr);
arr = [...arr1, 5, ...arr2];
console.log(arr);

const ellie = { name: "Ellie", age: 20, home: { addres: "home" } };
const updated = {
  ...ellie,
  job: "s/w engineer",
};

ellie.home.address = "korea";

console.log(ellie);
console.log(updated);

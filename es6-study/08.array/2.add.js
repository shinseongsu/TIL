const fruits = ["🍎", "🍌", "🍇", "🍊"];

console.log(fruits[0]);
console.log(fruits[1]);

console.log(fruits.length);

for (let i = 0; i < fruits.length; i++) {
  console.log(fruits[i]);
}

// 추가, 삭제 - 안좋은 방식
fruits[6] = "🍓";

delete fruits[1];
console.log(fruits);

const fruits = ["🍌", "🍒", "🍓", "🍎", "🍌", "🍎", "🍊"];
const result = new Set(fruits);
console.log([...result]);

const set1 = new Set([1, 2, 3, 4, 5]);
const set2 = new Set([1, 2, 3]);

function findIntersection(set1, set2) {
  return new Set([...set1].filter((item) => set2.has(item)));
}

console.log(findIntersection(set1, set2));

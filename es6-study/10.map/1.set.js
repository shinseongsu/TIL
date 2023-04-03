const set = new Set([1, 2, 3]);
console.log(set);

console.log(set.size);

console.log(set.has(2));
console.log(set.has(6));

set.forEach((item) => console.log(item));
for (const value of set.values()) {
  console.log(value);
}

set.add(6);
console.log(set);
set.add(6);
console.log(set);

set.delete(6);
console.log(set);

set.clear();
console.log(set.size);

// 오브젝트 Set
const obj1 = { name: "apple", price: 8 };
const obj2 = { name: "banana", price: 5 };
const objs = new Set([obj1, obj2]);
console.log(objs);

obj1.price = 10;
objs.add(obj1);
console.log(objs);

const obj3 = { name: "banana", price: 5 };
objs.add(obj3);
console.log(objs);
obj3.price = 3;
console.log(objs);

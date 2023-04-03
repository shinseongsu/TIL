const map = new Map([
  ["key1", "🍎"],
  ["key2", "🍌"],
]);
console.log(map);

console.log(map.size);

console.log(map.has("key1"));
console.log(map.has("key6"));

map.forEach((value, key) => console.log(key, value));
console.log(map.keys());
console.log(map.values());
console.log(map.entries());

console.log(map.get("key1"));
console.log(map.get("key2"));
console.log(map.get("key3"));

map.set("key3", "🍖");
console.log(map);

map.delete("key3");

map.clear();
console.log(map.size);

// 오브젝트와 차이점?
const key = { name: "milk", price: 10 };
const milk = { name: "milk", price: 10, description: "맛있는 우유" };
const obj = {
  [key]: milk,
};
console.log(obj);

const map2 = new Map([[key, milk]]);
console.log(map2);
console.log(obj[key]);
console.log(map2[key]);
console.log(map2.get(key));

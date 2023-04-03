const map = new Map();

const key1 = Symbol("key");
const key2 = Symbol("key");
map.set(key1, "Hello");
console.log(map.get(key2));
console.log(key1 === key2);

const k1 = Symbol.for("key");
const k2 = Symbol.for("key");
console.log(k1 === k2);

console.log(Symbol.keyFor(k1));
console.log(Symbol.keyFor(key1));

const obj = { [k1]: "Hello", [Symbol("key")]: 1 };
console.log(obj);
console.log(obj[k1]);
console.log(obj[Symbol("key")]);

// Iterable: 순회가 가능하다는 것

const array = [1, 2, 3];
for (const item of array.values()) {
  console.log(item);
}

for (const item of array.keys()) {
  console.log(item);
}

for (const item of array.entries()) {
  console.log(item);
}

const obj = { 0: 1, 1: 2 };
for (const item in obj) {
  console.log(item);
}

const iterator = array.values();
while (true) {
  const item = iterator.next();
  if (item.done) break;
  console.log(item.value);
}

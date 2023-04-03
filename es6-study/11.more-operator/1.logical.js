const obj1 = { name: "🍎" };
const obj2 = { name: "🍏", owner: "Ellie" };

if (obj1 || obj2) {
  console.log("둘다 true!");
}

let result = obj1 && obj2;
console.log(result);
result = obj1 || obj2;
console.log(result);

function changeOwner(animal) {
  if (!animal.owner) {
    throw new Error("주인이 없어");
  }
  animal.owner = "바뀐주인!";
}

function makeNewOwner(animal) {
  if (animal.owner) {
    throw new Error("주인이 있어");
  }
  animal.owner = "새로운 주인!";
}

obj1.owner && changeOwner(obj1);
obj2.owner && changeOwner(obj2);
console.log(obj1);
console.log(obj2);

obj1.owner || makeNewOwner(obj1);
obj2.owner || makeNewOwner(obj2);
console.log(obj1);
console.log(obj2);

let item = { price: 1 };
const price = item && item.price;
console.log(price);

// default parameter는 null과 undefined인 경우
// || Falshy한 경우 -> 0, -0, null, undefined, ''
function print(message = "Hi") {
  const text = message || "hello";
  console.log(text);
}

print("안녕!");
print();
print("");

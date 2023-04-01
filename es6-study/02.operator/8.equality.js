console.log(2 == 2);
console.log(2 != 2);
console.log(2 != 3);
console.log(2 == "2");
console.log(2 === "2");

console.log(true == 1);
console.log(true === 1);
console.log(false == 0);
console.log(false === 0);

const obj1 = {
  name: "js",
};

const obj2 = {
  name: "js",
};

console.log(obj1 == obj2);
console.log(obj1 === obj2);
console.log(obj1.name == obj2.name);
console.log(obj1.name === obj2.name);

let obj3 = obj2;
console.log(obj2 == obj3);
console.log(obj2 === obj3);

const obj = {
  name: "엘리",
  age: 20,
};

console.log(obj.name);
console.log(obj.age);

function getValue(obj, key) {
  return obj[key];
}

getValue(obj, "name");
console.log(obj);

function addKey(obj, key, value) {
  obj[key] = value;
}

addKey(obj, "job", "engineer");
console.log(obj);

function deleteKey(obj, key) {
  delete obj[key];
}
deleteKey(obj, "job");
console.log(obj);

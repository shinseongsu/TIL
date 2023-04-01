function display(num) {
  num = 5;
  console.log(num);
}

const value = 4;
display(value);
console.log(value);

function displayObj(obj) {
  obj.name = "Bob";
  console.log(obj);
}

const ellie = { name: "Ellie" };
displayObj(ellie);
console.log(ellie);

function changeName(obj) {
  return { ...obj, name: "Bob" };
}

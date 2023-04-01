let add = function (a, b) {
  return a + b;
};
console.log(add(1, 2));

add = (a, b) => {
  return a + b;
};

add = (a, b) => a + b;

console.log(add(1, 2));

const object = new Function();

// IIFE(Immedicately-Invoked Function Expressions)
(function run() {
  console.log("start");
});

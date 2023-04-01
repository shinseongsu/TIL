function add(a = 1, b = 1) {
  console.log(a);
  console.log(b);
  console.log(arguments);
  return a + b;
}

add(1, 2, 3);
add();

function sum(a, b, ...numbers) {
  console.log(a);
  console.log(b);
  console.log(numbers);
}

sum(1, 2, 3, 4, 5, 6, 7, 8);

let apple = {
  name: "apple",
  "hello-bye": "Good",
  0: 1,
  ["hello-by"]: "orange",
  helloBy: "aaaa",
};

console.log(apple);

console.log(apple.name);
console.log(apple["hello-bye"]);
console.log(apple["name"]);

apple.emoji = "🙅";
console.log(apple.emoji);
console.log(apple["emoji"]);

delete apple.emoji;
console.log(apple);

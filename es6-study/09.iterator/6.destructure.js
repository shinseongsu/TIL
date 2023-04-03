// 구조 분해 할당 Destructuring Assignment
const fruits = ["apple", "kiwi", "strawberry", "banana"];
const [first, second, ...others] = fruits;

console.log(fruits);
console.log(first);
console.log(second);

const point = [1, 2];
const [x, y, z = 0] = point;
console.log(x);
console.log(y);
console.log(z);

function createEmoji() {
  return ["apple", "🍎"];
}

const [title, emoji] = createEmoji();
console.log(title);
console.log(emoji);

const ellie = { name: "Ellie", age: 20, job: "s/w engineer" };
function display({ name, age, job }) {
  console.log("이름", name);
  console.log("나이", age);
  console.log("직업", job);
}

display(ellie);

const { name, age, job: occupation, pet = "강아지" } = ellie;
console.log(name);
console.log(age);
console.log(occupation);
console.log(pet);

const prop = {
  name: "Button",
  styles: {
    size: 20,
    color: "black",
  },
};

function changeColor({ style: { color } }) {
  console.log(color);
}

changeColor(prop);

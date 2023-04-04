const dog = {
  name: "Dog",
  play: () => console.log("논다잉!"),
};
dog.play();
// const obj = new dog.play();
// console.log(obj);

// ES6
const cat = {
  name: "cat",
  play() {
    console.log("냐옹");
  },
};
cat.play();
// const obj1 = new cat.play(); // 생성자 함수로 사용x

/**
 * 화살표 함수의 특징
 * 1. 문법이 깔끔함
 * 2. 생성자 함수로 사용이 불가능(무거운 프로토타입을 만들지 x)
 * 3. 함수 자체 arguments
 * 4. this에 대한 바인딩이 정적으로 결정됨
 * - 함수에 제일 근접한 상위 스코프의 this에 정적으로 바인딩 됨
 */

function sum(a, b) {
  console.log(arguments);
}
sum(1, 2);

const add = () => {
  console.log(arguments); // arrow 함수 외부의 arguments를 참조함
};
add(1, 2);

const printArrow = () => {
  console.log(this);
};
printArrow();
cat.printArrow = printArrow;
cat.printArrow();

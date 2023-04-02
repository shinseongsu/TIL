class Animal {
  constructor(color) {
    this.color = color;
  }

  eat() {
    console.log("먹자!");
  }
  sleep() {
    console.log("잔다");
  }
}

class Tiger extends Animal {}
const tiger = new Tiger("노랑이");
tiger.sleep();

class Dog extends Animal {
  constructor(color, ownerName) {
    // super는 부모클래스를 가리킴
    super(color);
    this.ownerName = ownerName;
  }
  play() {
    console.log("놀자");
  }
  eat() {
    super.eat();
    console.log("개같이 먹는다!");
  }
}

const dog = new Dog("발강이", "엘리");
console.log(dog);
dog.sleep();
dog.play();
dog.eat();

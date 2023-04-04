// 클래스를 베이스로한 객체지향 프로그래밍
class Animal {
  constructor(name, emoji) {
    this.name = name;
    this.emoji = emoji;
  }
  printName() {
    console.log(`${this.name} ${this.emoji}`);
  }
}

class Dog extends Animal {
  play() {
    console.log("같이 놀자옹!");
  }
}

class Tiger extends Animal {
  hunt() {
    console.log("사냥하자....");
  }
}

const dog1 = new Dog("멍멍", "🐱", "엘리");
const tiger1 = new Tiger("어흥", "🐱");
dog1.play();
dog1.printName();
tiger1.printName();
tiger1.hunt();

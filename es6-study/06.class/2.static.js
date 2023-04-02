class Fruit {
  static MAX_FRUITS = 4;

  constructor(name, emoji) {
    this.name = name;
    this.emoji = emoji;
  }

  static makeRandomFruit() {
    return new Fruit("banana", "🍌");
  }

  display = () => {
    console.log(`${this.name}: ${this.emoji}`);
  };
}

const banana = Fruit.makeRandomFruit();
console.log(banana);
console.log(Fruit.MAX_FRUITS);
console.log(Fruit);

Math.pow();
console.log(Number.isFinite(1));

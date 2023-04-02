class Fruit {
  constructor(name, emoji) {
    this.name = name;
    this.emoji = emoji;
  }

  display = () => {
    console.log(`${this.name}: ${this.emoji}`);
  };
}

const apple = new Fruit("apple", "🍎");
const orange = new Fruit("orange", "🍊");
orange.display();

const obj = { name: "ellie" };

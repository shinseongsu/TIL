class Counter {
  #value;

  constructor(startValue) {
    if (isNaN(startValue) || startValue < 0) {
      this.#value = 0;
    } else {
      this.#value = startValue;
    }
  }

  get value() {
    return this.#value;
  }

  add = () => {
    this.#value++;
  };
}

const counter = new Counter(0);
counter.add();
counter.add();
console.log(counter.value);

function* multipleGenerator() {
  try {
    for (let i = 0; i < 10; i++) {
      console.log(i);
      // 사용자에게 제어권 양도
      yield i ** 2;
    }
  } catch (error) {
    console.log(error);
  }
}

const multiple = multipleGenerator();
let next = multiple.next();
console.log(next.value, next.done);

multiple.throw("Error!");

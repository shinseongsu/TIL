function loop() {
  const array = [];

  for (let i = 0; i < 5; i++) {
    array.push(function () {
      console.log(i);
    });
  }

  return array;
}

const array = loop();
array.forEach((func) => func());

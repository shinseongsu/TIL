let array = new Array(3);
console.log(array);

array = new Array(1, 2, 3);
console.log(array);

array = Array.of(1, 2);
console.log(array);

const anotherArray = [1, 2, 3, 4];
console.log(anotherArray);

array = Array.from("text");
array = Array.from(anotherArray);
console.log(array);

// 일반적으로 배열은 동일한 메모리 크기를 가지며, 연속적으로 이어져 있어야함.
// 하지만 자바스크립트에서는 배열은 연속적으로 이어져 있지 않음
array = Array.from({
  0: "안",
  1: "녕",
  length: 2,
});
console.log(array);

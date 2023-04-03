const num1 = 123;
const num2 = new Number(123);
console.log(typeof num1);
console.log(typeof num2);

console.log(Number.MAX_VALUE);

if (num1 == Number.NaN) {
}
if (Number.isNaN(num1)) {
}

const num3 = 102;
console.log(num3.toExponential()); // 1.02e+2

const num4 = 1234.12;
console.log(num4.toFixed()); // 1234

console.log(num4.toString()); // 1234.12
console.log(num4.toLocaleString()); // 1,234.12

// 원하는 자릿수까지 유효하도록 반올림
console.log(num4.toPrecision(5));

console.log(Number.EPSILON);

function isEqual(original, expected) {
  return Math.abs(original - expected) < Number.EPSILON;
}

console.log(isEqual(1, 1));
console.log(isEqual(0.1, 0.1));

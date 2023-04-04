// 동결 Object.freeze
// 추가, 삭제, 쓰기, 속성 재정의 안됨
// (단, 얕은 복사는 가능)
const ellie = { name: "엘리" };
const dog = { name: "와우", emoji: "🐕", owner: ellie };

Object.freeze(dog);

dog.name = "멍멍";
console.log(dog);
dog.age = 4;
console.log(dog);
delete dog.name;
console.log(dog);

// 밀봉 Object.seal
// 값의 수정은 가능
// 추가, 삭제, 재정의 안됨
const cat = { ...dog };

Object.seal(cat);
console.log(cat);
cat.name = "냐옹";
console.log(cat);
delete cat.emoji;
console.log(cat);

console.log(Object.isFrozen(dog));
console.log(Object.isSealed(cat));

// 확장 금지 preventExtensions
// 추가만 안됨
const tiger = { name: "어흥" };
Object.preventExtensions(tiger);
console.log(Object.isExtensible(tiger));
tiger.name = "어흐응";
console.log(tiger);
delete tiger.name;
console.log(tiger);
tiger.age = 1;
console.log(tiger);

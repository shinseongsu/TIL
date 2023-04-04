// JSON: Javascript Object Notation
// 오브젝트 형태의 텍스트 포맷
// stringify(object): JSON
// parse(JSON): object

const ellie = {
  name: "ellie",
  age: 20,
  eat: () => {
    console.log("eat");
  },
};

// 직렬화 Serializing: 객체를 문자열로 변환
const json = JSON.stringify(ellie);
console.log(ellie);
console.log(json);

// 역직렬화 Deserializing: 문자열 데이터\를 자바스크립트 객체로 변환
const obj = JSON.parse(json);
console.log(obj);

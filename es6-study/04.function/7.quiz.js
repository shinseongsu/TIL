const print = (a) => console.log(a);
const doublePrint = (a) => console.log(a * 2);

function iterate(max, action) {
  for (let i = 0; i <= max; i++) {
    action(i);
  }
}

iterate(5, doublePrint);

setTimeout(() => {
  console.log("3초뒤 이 함수가 실행됨");
}, 3000);

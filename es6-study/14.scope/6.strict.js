// 엄격 모드 strict mode
// 리액트와 같은 프레임워크 사용 시 기본적으로 엄격 모드임
// 'use strict';
// 'use strict'

var x = 1;
delete x;

function add(x) {
  var a = 2;
  var b = a + x;
  console.log(this);
}
add(1);

const array = [1, 2, 3];
for (const num of array) {
  console.log(num);
}

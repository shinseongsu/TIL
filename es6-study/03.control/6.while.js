let num = 5;
while (num >= 0) {
  console.log(num);
  num--;
}

let isActive = false;
let i = 0;
while (isActive) {
  console.log("아직 살아있다.");
  if (i === 1000) {
    break;
  }
  i++;
}

do {
  console.log("do-while 아직 살아있다.");
} while (isActive);

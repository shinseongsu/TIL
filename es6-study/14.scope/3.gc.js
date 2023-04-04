// 글로벌 변수는 앱이 종료될때까지 계속 메모리에 유지됨
const global = 1;
{
  // 블록 내부에서만 존재하고, 블록이 끝나면 자동으로 소멸됨 (GC)
  const local = 1;
}

function print() {
  if (true) {
    let temp = 0;
  }
}

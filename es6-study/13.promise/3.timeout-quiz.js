function runInDelay(callback, seconds) {
  if (!callback) {
    throw new Error("callback함수를 전달해야함");
  }
  if (!seconds || seconds < 0) {
    throw new Error("seconds는 0보다 커야함");
  }
  setTimeout(callback, seconds * 1000);
}

try {
  runInDelay(() => {
    console.log("타이머 완료!");
  }, 2);
} catch (error) {
  console.log(error);
}

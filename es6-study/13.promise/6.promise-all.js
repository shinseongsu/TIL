function getBanana() {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve("🍌");
    }, 1000);
  });
}

function getApple() {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve("🍎");
    }, 3000);
  });
}

function getOrange() {
  return Promise.reject(new Error("no orange"));
}

getBanana().then((banana) => getApple().then((apple) => [banana, apple]));

// Promise.all 병렬적으로 한번에 모든 Promise들을 실행
Promise.all([getBanana(), getApple()]).then((fruits) =>
  console.log("all", fruits)
);

// Promise중에 제일 빨리 수행된 것이 이김
Promise.race([getBanana(), getApple()]).then((fruits) =>
  console.log("race", fruits)
);

// 모든 결과를 받아보고 싶다면
Promise.allSettled([getBanana(), getApple(), getOrange()])
  .then((fruits) => console.log("all-settle", fruits))
  .catch(console.log());

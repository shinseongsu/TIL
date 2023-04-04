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

// 같이 가져옴
async function fetchFruits() {
  const banana = await getBanana();
  const apple = await getApple();

  return [banana, apple];
}

fetchFruits().then((fruits) => console.log(fruits));

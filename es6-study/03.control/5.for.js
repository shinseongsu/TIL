for (let i = 0; i < 5; i++) {
  console.log(i);
}

for (let i = 1; i < 10; i++) {
  console.log(`${i}단`);
  for (let j = 1; j < 10; j++) {
    console.log(`${i} * ${j} = ${i * j}`);
  }
}

// 무한루프
// for(;;) { console.log('무한') }

for (let i = 0; i < 20; i++) {
  if (i === 10) {
    continue;
    console.log("i 가 드디어 10이 되었다.");
  }
  console.log(i);
}

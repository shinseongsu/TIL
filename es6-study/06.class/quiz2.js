class Staff {
  constructor(name, partment, workTime, payRate) {
    this.name = name;
    this.partment = partment;
    this.workTime = workTime;
    this.payRate = payRate;
  }

  get calc() {
    return this.payRate * this.workTime;
  }
}

class RegularWorker extends Staff {
  static PAY_RATE = 10000;
  constructor(name, partment, workTime, payRate) {
    super(name, partment, workTime, RegularWorker.PAY_RATE);
  }
}

class NonRegularWorker extends Staff {
  static PAY_RATE = 8000;
  constructor(name, partment, workTime, payRate) {
    super(name, partment, workTime, NonRegularWorker.PAY_RATE);
  }
}

const regularWorker = new RegularWorker("홍길동", "영업부", 82);
console.log(regularWorker.calc);

const nonRegularWorker = new NonRegularWorker("임꺽정", "서비스팀", 56);
console.log(nonRegularWorker.calc);

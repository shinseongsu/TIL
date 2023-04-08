{
  // 객체지향적으로 커피기계 만들기

  type CoffeeCup = {
    shots: number;
    hasMilk: boolean;
  };

  class CoffeeMachine {
    static BEANS_GRAM_PER_SHOT = 7;
    static MILK_LITER_PER_CUP = 0.35;

    coffeeBeans: number = 0;
    milk: number = 0;

    constructor(coffeeBeans: number, milk: number) {
      this.coffeeBeans = coffeeBeans;
      this.milk = milk;
    }

    makeCoffee(shots: number, isMilk: boolean): CoffeeCup {
      if (shots < 1) throw new Error(`${shots}샷은 잘못된 입력입니다.`);
      if (this.coffeeBeans < CoffeeMachine.BEANS_GRAM_PER_SHOT * shots)
        throw new Error("커피콩이 부족합니다.");
      if (isMilk && this.milk < CoffeeMachine.MILK_LITER_PER_CUP)
        throw new Error("우유가 부족합니다.");

      this.coffeeBeans -= CoffeeMachine.BEANS_GRAM_PER_SHOT * shots;
      if (isMilk) this.milk -= CoffeeMachine.MILK_LITER_PER_CUP;

      return { shots, hasMilk: isMilk };
    }
  }

  const coffeeBrewer = new CoffeeMachine(70, 2);
  const espresso = new CoffeeMachine(50, 0);

  const coffee1 = coffeeBrewer.makeCoffee(2, true);
  const coffee2 = espresso.makeCoffee(3, false);

  console.log(coffeeBrewer);
  console.log(espresso);

  console.log(coffee1);
  console.log(coffee2);
}

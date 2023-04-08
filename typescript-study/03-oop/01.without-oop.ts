{
  // 절차지향적으로 커피기계 만들기

  type CoffeeCup = {
    shots: number;
    hasMilk: boolean;
  };

  const BEANS_GRAM_OER_SHOT = 7;
  let totalCoffeeBeans: number = 0;

  function makeCoffee(shots: number): CoffeeCup {
    if (shots < 1) throw new Error(`${shots}샷은 잘못된 입력입니다.`);
    if (totalCoffeeBeans < BEANS_GRAM_OER_SHOT * shots)
      throw new Error("커피콩이 부족합니다.");

    totalCoffeeBeans -= BEANS_GRAM_OER_SHOT * shots;

    return { shots, hasMilk: false };
  }

  // 실행 테스트
  totalCoffeeBeans += BEANS_GRAM_OER_SHOT * 10;
  const coffee = makeCoffee(2);
  console.log(coffee, totalCoffeeBeans);
}

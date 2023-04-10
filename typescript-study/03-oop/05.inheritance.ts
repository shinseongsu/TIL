{
  /**
   * 객체지향적으로 커피기계 만들기 (+상속)
   * 상속
   * - 공통적인 기능을 재사용하며 자식 클래스에 특화된 기능만 구현하는 것
   * 상속의 장점
   * - 코드 중복 감소
   * - 유지 보수 시간 감소
   * 상속이 제한되는 경우
   * - 부모 클래스에서 private 접근 제한을 갖는 필드와 메소드
   * 메소드 오버라이딩(method overriding)
   * - 상속받은 부모 클래스의 메소드를 재정의하여 사용하는 것
   * super
   * - 부모클래스의 함수를 호출하거나 접근할 때 사용
   * 보모 클래스에 이미 정의되어진 멤버 변수의 경우 자식 클래스에서 따로 접근제어자를 사용해 멤버 변수로 재정의할 필요가 없다.
   */

  // 커피 타입
  type CoffeeCup = {
    shots: number;
    hasMilk: boolean;
  };

  interface CoffeeMaker {
    makeCoffee(shots: number): CoffeeCup;
  }

  class CoffeeMachine implements CoffeeMaker {
    private static BEANS_GRAM_PER_SHOT = 7;

    private coffeeBeans: number = 0;
    private milk: number = 0;

    constructor(coffeeBeans: number, milk: number) {
      this.coffeeBeans = coffeeBeans;
      this.milk = milk;
    }

    static makeCoffeeMachine(coffeeBeans: number, milk: number) {
      if (coffeeBeans < 0)
        throw new Error(`커피콩은 0보다 커야합니다.(입력: ${coffeeBeans})`);
      return new CoffeeMachine(coffeeBeans, milk);
    }

    fillCoffeeBeans(coffeeBeans: number) {
      if (coffeeBeans < 0)
        throw new Error(`커피콩은 0보다 커야합니다.(입력: ${coffeeBeans})`);
      this.coffeeBeans += coffeeBeans;
      console.log(`커피 콩이 채워졌습니.(잔여 : ${this.coffeeBeans})`);
    }

    private grindBeans(shots: number) {
      if (shots < 1) throw new Error(`${shots}샷은 0보다 커야합니다.`);
      if (this.coffeeBeans < CoffeeMachine.BEANS_GRAM_PER_SHOT * shots)
        throw new Error("커피콩이 부족합니다.");

      this.coffeeBeans -= CoffeeMachine.BEANS_GRAM_PER_SHOT * shots;

      console.log("커피 가는중...");
    }

    private preheat() {
      console.log("기계를 데우는 중...");
    }

    private extract(shots: number): CoffeeCup {
      console.log("커피를 추출하는 중...");
      return { shots, hasMilk: false };
    }

    makeCoffee(shots: number): CoffeeCup {
      this.grindBeans(shots);
      this.preheat();
      return this.extract(shots);
    }

    clean() {
      console.log("기계를 청소중입니다....");
    }
  }

  class CaffeLatteMachine extends CoffeeMachine {
    // 자식 클래스에서 생성자를 구현하는 경우, super()를 호출해야만 한다.
    // readonly: public으로 보여주는데, 한번 설정 후 바뀌지 않는 경우 사용
    constructor(
      beans: number,
      milk: number,
      public readonly serialiNumber: String
    ) {
      super(beans, milk);
    }

    private steamMilk() {
      console.log("우유를 데우는 중...");
    }

    makeCoffee(shots: number): CoffeeCup {
      const coffee = super.makeCoffee(shots);
      this.steamMilk();
      return { ...coffee, hasMilk: true };
    }
  }

  const machine = new CoffeeMachine(30, 0);
  const latteMachine = new CaffeLatteMachine(30, 0, "SSSSS");
  const coffee = latteMachine.makeCoffee(1);

  console.log(coffee);
  console.log(latteMachine.serialiNumber);
}

{
  /**
   * 객체지향적으로 커피기계 만들기 ( 캡슐화 )
   * 정보은닉, 캡슐화
   * - 외부에서 알면 안되는 정보, 알필요 없는 정보, 직접적으로 수정하면 안되는 정보(상태와 내부에서만 쓰이는 함수)들을 숨기는 테크닉
   * - 외부에서 접근이 가능하고, 해도 되고, 필요한 것들만 노출하는 것
   * 다양한 레벨로 정보를 은닉하기 위한 접근제어자들
   * public: default값. 외부에서 다 볼 수 있도록 공개적으로 설정된 상태
   * private: 외부에서 절대볼수 없고, 접근도 할 수 없는 상태
   * protected: 외부에서는 접근할 수 없지만, 이 클래스를 상속한 자식 클래스에서는 접근 가능한 상태
   */

  type CoffeeCup = {
    shots: number;
    hasMilk: boolean;
  };

  class CoffeeMachine {
    private static BEANS_GRAM_PER_SHOT = 7;
    private static MILK_LITER_PER_CUP = 0.35;

    private coffeeBeans: number = 0;
    private milk: number = 0;

    private constructor(coffeeBeans: number, milk: number) {
      this.coffeeBeans = coffeeBeans;
      this.milk = milk;
    }

    static makeCoffeeMachine(coffeeBeans: number, milk: number) {
      if (coffeeBeans < 0)
        throw new Error(`커피콩은 0보다 커야합니다. (입력: ${coffeeBeans})`);
      if (milk < 0) throw new Error(`우유는 0보다 커야합니다. (입력 : ${milk}`);
      return new CoffeeMachine(coffeeBeans, milk);
    }

    fillCoffeeBeans(coffeeBeans: number) {
      if (coffeeBeans < 0)
        throw new Error(`커피콩은 0보다 커야합니다. (입력: ${coffeeBeans})`);
      this.coffeeBeans += coffeeBeans;
      console.log(`커피 콩이 채워졌습니다.(잔여 : ${this.coffeeBeans})`);
    }

    fillMilk(milk: number) {
      if (milk < 0) throw new Error(`우유는 0보다 커야합니다.(입력 : ${milk})`);
      this.milk += milk;
      console.log(`우유가 채워졌습니다.(잔여: ${this.milk})`);
    }

    makeCoffee(shots: number, isMilk: boolean): CoffeeCup {
      if (shots < 1) throw new Error(`${shots}샷은 0보다 커야합니다.`);
      if (this.coffeeBeans < CoffeeMachine.BEANS_GRAM_PER_SHOT * shots)
        throw new Error("커피콩이 부족합니다.");
      if (isMilk && this.milk < CoffeeMachine.MILK_LITER_PER_CUP)
        throw new Error("우유가 부족합니다.");

      this.coffeeBeans -= CoffeeMachine.BEANS_GRAM_PER_SHOT * shots;
      if (isMilk) this.milk -= CoffeeMachine.MILK_LITER_PER_CUP;

      return { shots, hasMilk: isMilk };
    }
  }

  const coffeeBrewer = CoffeeMachine.makeCoffeeMachine(70, 2);
  const espresso = CoffeeMachine.makeCoffeeMachine(75, 0);

  espresso.fillCoffeeBeans(20);

  class User {
    private internalAge = 20;
    get age(): number {
      return this.internalAge;
    }
    set age(age: number) {
      if (age < 0)
        throw new Error(`나이는 0보다 작게 설명할 수없습니다.(입력 : ${age})`);
      this.internalAge = age;
    }

    set firstName(firstName: string) {
      this.firstNm = firstName;
    }
    get fullName(): string {
      return `${this.firstNm} ${this.lastNm}`;
    }

    constructor(private firstNm: string, private lastNm: string) {
      this.firstNm = firstNm;
      this.lastNm = lastNm;
    }
  }

  const user = new User("Steve", "Jobs");
  console.log(user.fullName);
  user.firstName = "Lani";
  console.log(user.fullName);
  user.age = 24;
  console.log(user.age);
}

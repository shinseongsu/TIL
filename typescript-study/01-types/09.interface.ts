{
  /**
   * 타입 추론(Type Inference)
   * 타입이 알아서 결정되는 경우를 말한다.
   */

  // 1. 선언과 동시에 할당
  // - 이런 원시 타입처럼 뻔한 경우에는 생략해서 작성하는 것도 괜찮다.
  let text = "hello";
  text = "hi";
  // text = 1; //변수 text는 선언과 동시에 문자열이 할당되여 string타입으로 유추되기 때문에 error발생!

  //2. 함수 인자의 default값을 설정한 경우
  // - return 타입이 void인 경우 생략 가능
  function print(message = "hello") {
    console.log(message);
  }
  print("hello");
  // print(1); //default값에 의해 string타입으로 추론되기 때문에 error발생!

  //3. return 타입: number을 정확하게 명시해주는 것이 더 좋다
  function add(x: number, y: number) {
    return x + y;
  }
  const result = add(1, 2); //추론을 통한 추론. 함수의 리턴값이 number이기 때문에 result도 number.
}

{
  /**
   * Discriminated Union
   * 유니온 타입에 차변화되는 이름이 동일한 타입을 두어 간편하게 구분할 수 있는 것을 말한다.
   */
  type SuccessState = {
    result: "success";
    response: { body: string };
  };
  type FailState = {
    result: "fail";
    reason: string;
  };
  type LoginState = SuccessState | FailState;
  function login(id: string, password: string): LoginState {
    return { result: "success", response: { body: "logged in!" } };
  }

  function printLoginState(state: LoginState) {
    if (state.result === "success") {
      console.log(`${state.response.body}`);
    } else {
      console.log(`${state.reason}`);
    }
  }
  printLoginState({ result: "success", response: { body: "Login Success!" } });
}

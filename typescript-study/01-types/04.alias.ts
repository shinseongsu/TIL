{
  /**
   * Typescript를 쓰는 이유, Typescript의 type이 강력한 이유!
   * Type Alias : 새로운 타입을 정의하는 것
   */

  type Text = string;
  const name: Text = "triple";
  const address: Text = "korea";
  type Num = number;
  type Student = {
    name: string;
    age: number;
  };
  const studnet: Student = {
    name: "triple",
    age: 12,
  };

  // String Literal Types : 문자열을 타입으로 지정
  type Name = "name";
  let laniName: Name;
  laniName = "name";
  type JSON = "json";
  const json: JSON = "json";
}

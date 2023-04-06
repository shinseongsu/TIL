{
  // var 호이스팅과 여러가지 예상하지 못하는 문제 발생 위험이 있다.
  var age = 5;
  age = 1;

  // let es6
  let name = "hello";
  name = "hi";

  // const
  const id = "0001";
}

{
  /**
   * JavaScript
   * Primitive: number, string, boolean, bigint, symbol, null, undefined
   * Object: function, array, ...
   */

  const num: number = -6;

  const str: string = "hello";

  const bool: boolean = false;

  // undefined
  let name: undefined;
  let age: number | undefined;
  age = undefined;
  age = 1;
  function find(): number | undefined {
    return undefined;
  }

  // null
  let person: null;
  let person2: string | null;

  // unknown : 난 어떤 것을 담을지 잘 모르겠어
  let notSure: unknown = 0;
  notSure = "he";
  notSure = true;

  // any: 난 어떤것이든 담을 수 있어!
  let anything: any = 0;
  anything = "hello";

  // void: 아무것도 리턴하지 않을 때 사용. 비어있는
  function print(): void {
    console.log("hello");
    return;
  }
  let unusable: void = undefined;

  // never: 함수에서 절대 리턴하지 않는 경우에 명시하기 위해 사용
  function throwError(message: string): never {
    throw new Error(message);
  }
  let neverEnding: never;

  // object
  let obj: object;
  function acceptSomeObject(obj: object) {}
  acceptSomeObject({ name: "lani" });
  acceptSomeObject({ animal: "dog" });
}

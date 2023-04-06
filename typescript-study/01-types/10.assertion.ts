{
  /**
   * Type Assertions
   * 타입을 강제로 캐스팅할 때 사용한다.
   * 내가 정말X100 타입을 장담할 때, 자신감 1000%있을 때만 사용해야 한다.
   */
  function jsStrFunc(): any {
    return 2;
  }
  const result = jsStrFunc();
  console.log((result as string).length); //undefined
  console.log((<string>result).length); //undefined

  const wrong: any = 5;
  // console.log((wrong as Array<number>).push(1)); //😱

  //! : '무조건 null이 아니야!'라는 뜻. option이 아니라 정말 확신할 때 사용.
  function findNumbers(): number[] | undefined {
    return undefined;
  }
  const numbers = findNumbers();
  // numbers!.push(2); //😱

  const button = document.querySelector("class")!;
  // if(button) button.nodeValue;
}

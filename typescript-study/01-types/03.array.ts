{
  // array
  // 배열을 정의하는 2가지 방법
  const fruits: string[] = ["🍎", "🍏"];
  const scroes: Array<number> = [1, 3, 4]; // 아직은 readonly
  // readOnly: object의 불변성 보장. 전달된 인자를 함수 내부에서 변경하지 않도록 타입으로 보장하기 위해 사용

  function printArray(fruits: readonly string[]) {}

  // Tuple: 서로 다른 타입의 데이터를 담을 수 있는 배열
  // index로 접근하여 가독성이 떨어지므로 권장x
  // Tuple 사용시 고민해볼 내용
  // 1. 동적으로 다른 타입의 데이터를 return 하여 사용자가 정의해서 사용해야 하는가?
  // 2. interface, type alias, class로 대체하기엔 어려운가?
  let student: [string, number];
  student = ["name", 123];
  student[0];
  student[1];

  // 가독성 보완 방법 : 구조 분해 할당
  // Tuple 사용 예시 : React에서 사용하는 useState()
  const [name, age] = student; //데이터가 정의되는 곳이 아닌 사용하는 곳에서 임의로 결정하고 사용
}

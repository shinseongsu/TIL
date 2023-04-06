{
  /**
   * Intersection Type: And
   * Union Types와 반대되는 개념. 다양한 타입들을 하나로 묶어 선언할 때 사용,
   * 사용할 때는 하나로 묶은 타입들의 모든 속성이 정의된 오브젝트를 만들어야 한다.
   */
  type Student = {
    name: string;
    score: number;
  };
  type Worker = {
    employeeId: number;
    work: () => void;
  };

  function internWork(person: Student & Worker) {
    console.log(person.name, person.score, person.employeeId, person.work());
  }

  // Student와 Worker 두 타입의 모든 속성이 정의된 오브젝트를 전달해야 한다.
  internWork({
    name: "lani",
    score: 100,
    employeeId: 27,
    work: () => {},
  });
}

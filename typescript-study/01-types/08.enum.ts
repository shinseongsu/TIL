{
  /**
   * Enum
   * 여러 관련된 상수 값들을 한 곳에 모아서 정의할 수 있게 도와주는 타입
   * 타입의 값이 변화되지 않고 보장되어 조금 더 안전하게 쓸 수 있다.
   */
  // JS
  const MAX_NUM = 6;
  const MAX_STUDNETS_PER_CLASS = 10;

  // 관련된 상수를 묶어 관리하고 싶을 때,
  const DAYS_ENUM = Object.freeze({ MONDAY: 0, TUESDAY: 1, WEDNESDAY: 2 });
  const daysOfToday = DAYS_ENUM.MONDAY;

  // TS
  // - 값을 지정하지 않을 경우 숫자 0부터 시작
  // - 문자열로 값을 지정할 경우 다음 할당 값을 자동으로 알기 어렵기 때문에 수동적으로 하나씩 할당해야 한다.
  // 타입이 보장되지 않기 때문에 Typescript에서는 사용을 권한하지 않는다.
  enum Days {
    Monday = 1,
    Tuesday,
    Wednesday,
    Friday,
    Saturday,
    Sunday,
  }
  console.log(Days.Tuesday);
  let day: Days = Days.Saturday;
  day = Days.Wednesday;
  console.log(day);

  // enum이 필요하다면, union타입으로 대체
  type DaysOfWeek = "Monday" | "Tuesday" | "Wednesday";
  let daysOfWeek: DaysOfWeek = "Monday";
  daysOfWeek = "Wednesday";
  console.log(daysOfWeek);
}

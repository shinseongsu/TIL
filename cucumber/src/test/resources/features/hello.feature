Feature: cucumber 테스트

  Scenario: Spring bean을 주입받아 결과 맞춰보기
    Given 현재 시간을 가져온다.
    When 현재 시간에 3 일을 더한다.
    Then 현재 시간에 3 더한 시간하고 Then 에서 계산한 값이 맞는지 확인한다.
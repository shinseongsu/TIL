package com.example.acceptance.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.util.DateUtil;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ComponentScan(basePackages = "com.example")
public class HelloIntegrationTest {

    private final DateUtil dateUtil;

    private LocalDateTime now;

    public HelloIntegrationTest(final DateUtil dateUtil) {
        this.dateUtil = dateUtil;
    }

    @Given("현재 시간을 가져온다.")
    public void createNotification() {
        now = dateUtil.now();
    }

    @When("현재 시간에 {int} 일을 더한다.")
    public void retrieveNotification(int days) {
        this.now = now.plusDays(1);
    }

    @Then("현재 시간에 {int} 더한 시간하고 Then 에서 계산한 값이 맞는지 확인한다.")
    public void verifyNotificationDetails(int days) {
        assertEquals(now.getMonth(), LocalDateTime.now().plusDays(1).getMonth());
    }

}

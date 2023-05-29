package com.example.springselenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

    @FindBy(how = How.LINK_TEXT, using = "Login")
    public WebElement lnkLogin;

    @FindBy(how = How.LINK_TEXT, using = "Employee List")
    public WebElement lnkEmployeeList;

    public LoginPage clickLogin() {
        // lnkLogin.click();
        System.out.println("Click the home page login");
        return new LoginPage();
    }

    public void clickEmployeeList() {
        lnkEmployeeList.click();
    }

}

package com.example.springselenium.pages;

public class MainPage {

    private LoginPage loginPage;
    private HomePage homePage;

    public MainPage(LoginPage loginPage, HomePage homePage) {
        this.loginPage = loginPage;
        this.homePage = homePage;
    }

    public void performLogin() {
        homePage.clickLogin();
        loginPage.login("admin", "adminpassword23432");
        loginPage.clickLogin();
    }

}

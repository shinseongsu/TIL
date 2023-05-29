package com.example.springselenium;

import com.example.springselenium.pages.HomePage;
import com.example.springselenium.pages.LoginPage;
import com.example.springselenium.pages.MainPage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSeleniumApplicationTests {

    @Test
    void contextLoads() {
//        HomePage page = new HomePage();
//        LoginPage loginPage = page.clickLogin();
//        loginPage.clickLogin();

        HomePage homepage = new HomePage();
        LoginPage loginPage = new LoginPage();

        MainPage mainPage = new MainPage(loginPage, homepage);
        mainPage.performLogin();
    }

}

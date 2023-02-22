package com.orangehrmlive.pom.test;

import com.orangehrmlive.pom.basepage.BaseTest;
import com.orangehrmlive.pom.pages.HomePage;
import com.orangehrmlive.pom.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void init() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test
    public void verifyLoginTextExist() {
        loginPage.loginText();
    }

    @Test
    public void loginShouldSucceed() {
        implicitWait();
        homePage = loginPage.login("Admin", "admin123");
        Assert.assertTrue(homePage.hasUserName());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

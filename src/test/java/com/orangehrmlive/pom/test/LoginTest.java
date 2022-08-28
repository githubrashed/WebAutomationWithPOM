package com.orangehrmlive.pom.test;

import com.orangehrmlive.pom.base.BaseTest;
import com.orangehrmlive.pom.pages.HomePage;
import com.orangehrmlive.pom.pages.LoginPage;
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
    public void loginShouldSucceed() {
        homePage = loginPage.login("Admin", "admin123");
        Assert.assertTrue(homePage.hasWelcome());
    }

    @AfterMethod
    public void teatDown() {
        driver.quit();
    }
}

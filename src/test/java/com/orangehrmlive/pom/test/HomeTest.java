package com.orangehrmlive.pom.test;

import com.orangehrmlive.pom.basepage.BaseTest;
import com.orangehrmlive.pom.pages.HomePage;
import com.orangehrmlive.pom.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void init() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login("Admin", "admin123");
    }

    @Test
    public void checkHomePageShouldSucceed() {
        Assert.assertTrue(homePage.hasUserName());
        System.out.println("");
    }

    @Test
    public void checkHomePageTitleShouldSucceed() {
        Assert.assertTrue(homePage.hasUserName());
        System.out.println("");
    }

    @AfterMethod
    public void teatDown() {
        driver.quit();
    }
}

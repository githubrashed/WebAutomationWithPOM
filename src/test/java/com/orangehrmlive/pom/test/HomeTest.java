package com.orangehrmlive.pom.test;

import com.orangehrmlive.pom.orangehrmbasepage.OrangeHrmBaseTest;
import com.orangehrmlive.pom.pages.HomePage;
import com.orangehrmlive.pom.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomeTest extends OrangeHrmBaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void init() throws IOException {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login("Admin", "admin123");
    }

    @Test(priority = 0)
    public void checkWelcomeUserShouldSucceed() {
        Assert.assertTrue(homePage.hasUserName());
    }

    @Test(priority = 1)
    public void checkDashboardTextShouldSucceed() {
        Assert.assertTrue(homePage.isDashboardTextAvailable());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

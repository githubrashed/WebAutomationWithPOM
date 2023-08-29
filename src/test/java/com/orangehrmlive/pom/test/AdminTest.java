package com.orangehrmlive.pom.test;

import com.orangehrmlive.pom.orangehrmbasepage.OrangeHrmBaseTest;
import com.orangehrmlive.pom.pages.AdminPage;
import com.orangehrmlive.pom.pages.HomePage;
import com.orangehrmlive.pom.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class AdminTest extends OrangeHrmBaseTest {
    LoginPage loginPage;
    HomePage homePage;
    AdminPage adminPage;

    @BeforeMethod
    public void init() throws IOException {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login("Admin", "admin123");
        adminPage = homePage.clickAdmin();
    }

    @Test(priority = 0)
    public void checkAdminTextShouldSucceed() {
        Assert.assertTrue(adminPage.hasAdminText());
    }

    @Test(priority = 1)
    public void hasAdminPageTitle() {
        Assert.assertTrue(adminPage.hasAdminText());
    }

    @Override
    public String getPageTitle() {
        return null;
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

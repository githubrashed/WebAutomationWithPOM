package com.qa.orangehrms.pom.test;

import com.qa.orangehrms.pom.orangehrmsbasepage.OrangeHrmBaseTest;
import com.qa.orangehrms.pom.pages.HomePage;
import com.qa.orangehrms.pom.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends OrangeHrmBaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test
    public void loginApplicationShouldSucceed() {
        loginPage.setUserName("Admin", "admin123");
        loginPage.clickOnLoginBtn();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}

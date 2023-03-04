package com.ex.se.qa.team.test;

import com.ex.se.qa.team.hrmbasetest.BaseTestSeQATeam;
import com.ex.se.qa.team.pages.SeHomePage;
import com.ex.se.qa.team.pages.SeLoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeLoginTest extends BaseTestSeQATeam {
    SeLoginPage seLoginPage;
    SeHomePage seHomePage;

    @BeforeMethod
    public void setUp() {
        initialization();
        seLoginPage = new SeLoginPage();
    }

    @Test(priority = 0, enabled = true)
    public void loginShouldSucceed() {
        seHomePage = seLoginPage.login("Admin", "admin123");
        Assert.assertTrue(seHomePage.hasUserName());
    }

    @Test(priority = 1, enabled = true)
    public void verifyHomePageTitleShouldSucceed() {
        seLoginPage.login("Admin", "admin123");
        System.out.println(seHomePage.getHomePageTitle());
        Assert.assertTrue(seHomePage.getHomePageTitle().contains(driver.getTitle()));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

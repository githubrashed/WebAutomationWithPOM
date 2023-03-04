package com.ex.se.qa.team.test;

import com.ex.se.qa.team.hrmbasetest.BaseTestSeQATeam;
import com.ex.se.qa.team.pages.SeHomePage;
import com.ex.se.qa.team.pages.SeLoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeHomePageTest extends BaseTestSeQATeam {
    SeLoginPage seLoginPage;
    SeHomePage seHomePage;

    @BeforeMethod
    public void setUp() {
        initialization();
        seLoginPage = new SeLoginPage();
        seHomePage = seLoginPage.login("Admin", "admin123");
    }

    @Test
    public void verifyHomePageTitle() {
        seHomePage = seHomePage;
        String homePageTitle = seHomePage.getHomePageTitle();
        Assert.assertTrue(seHomePage.getHomePageTitle().contains(homePageTitle));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

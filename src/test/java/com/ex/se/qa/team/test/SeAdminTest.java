package com.ex.se.qa.team.test;

import com.ex.se.qa.team.hrmbasetest.BaseTestSeQATeam;
import com.ex.se.qa.team.pages.SeAdminPage;
import com.ex.se.qa.team.pages.SeHomePage;
import com.ex.se.qa.team.pages.SeLoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeAdminTest extends BaseTestSeQATeam {
    SeLoginPage seLoginPage;
    SeHomePage seHomePage;
    SeAdminPage seAdminPage;

    @BeforeMethod
    public void init() {
        initialization();
        seLoginPage = new SeLoginPage();
        seHomePage = seLoginPage.login("Admin", "admin123");
        seAdminPage = seHomePage.clickAdmin();
    }

    @Test
    public void checkAdminTextShouldSucceed() {
        Assert.assertTrue(seAdminPage.hasAdminText());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}


package com.ex.se.qa.team.pages;

import com.ex.se.qa.team.hrmbasetest.BaseTestSeQATeam;
import com.orangehrmlive.pom.pages.AdminPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SeHomePage extends BaseTestSeQATeam {

    @FindBy(css = "p.oxd-userdropdown-name")
    WebElement userDropdownNameEle;

    @FindBy(css = "a[href$='/admin/viewAdminModule']")
    WebElement adminLinkElement;

    public SeHomePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean hasUserName() {
        return userDropdownNameEle.isDisplayed();
    }

    public String getHomePageTitle() {
        String pageTitle = driver.getTitle();
        String expectedPageTitle = "OrangeHRM";
        if (pageTitle.equals(expectedPageTitle)) {
            System.out.println("Home Page Title is:" + pageTitle);
        } else {
            System.out.println("Wrong Page Title");
        }

        return pageTitle;
    }

    public AdminPage clickAdmin() {
        adminLinkElement.isDisplayed();
        adminLinkElement.click();
        return new AdminPage();
    }
}

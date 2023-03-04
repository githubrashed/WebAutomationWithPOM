package com.ex.se.qa.team.pages;

import com.ex.se.qa.team.hrmbasetest.BaseTestSeQATeam;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeHomePage extends BaseTestSeQATeam {

    @FindBy(css = "p.oxd-userdropdown-name")
    WebElement userDropdownName;

    public SeHomePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean hasUserName() {
        return userDropdownName.isDisplayed();
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
}

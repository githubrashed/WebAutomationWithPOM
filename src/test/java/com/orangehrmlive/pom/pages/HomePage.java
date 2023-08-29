package com.orangehrmlive.pom.pages;

import com.orangehrmlive.pom.orangehrmbasepage.OrangeHrmBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends OrangeHrmBaseTest {

    @FindBy(css = "p.oxd-userdropdown-name")
    List<WebElement> welcomeElement;

    @FindBy(css = "a[href$='/admin/viewAdminModule']")
    WebElement adminLinkElement;

    @FindBy(css = ".oxd-topbar-header-breadcrumb-module")
    WebElement dashboardEle;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean hasUserName() {
        return welcomeElement.size() >= 0;
    }

    public boolean isDashboardTextAvailable() {
        dashboardEle.isDisplayed();
        return dashboardEle.getText().trim().contains("Dashboard");
    }

    public AdminPage clickAdmin() {
        adminLinkElement.isDisplayed();
        adminLinkElement.click();
        return new AdminPage();
    }

    @Override
    public String getPageTitle() {
        return null;
    }
}

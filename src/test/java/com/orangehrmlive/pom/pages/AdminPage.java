package com.orangehrmlive.pom.pages;

import com.orangehrmlive.pom.orangehrmbasepage.OrangeHrmBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends OrangeHrmBaseTest {

    @FindBy(css = ".oxd-topbar-header-breadcrumb-module")
    WebElement adminTitleElement;

    public AdminPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean hasAdminText() {
        return adminTitleElement.getText().trim().contains("Admin");
    }

    @Override
    public String getPageTitle() {
        return null;
    }
}

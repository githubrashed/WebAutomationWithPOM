package com.ex.se.qa.team.pages;

import com.ex.se.qa.team.hrmbasetest.BaseTestSeQATeam;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeAdminPage extends BaseTestSeQATeam {
    @FindBy(css = ".oxd-topbar-header-breadcrumb-module")
    WebElement adminTitleElement;

    public SeAdminPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean hasAdminText() {
        return adminTitleElement.getText().trim().contains("Admin");
    }

}

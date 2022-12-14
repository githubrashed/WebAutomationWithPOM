package com.orangehrmlive.pom.pages;

import com.orangehrmlive.pom.basepage.BaseTest;
import com.orangehrmlive.pom.utils.GeneralUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class AdminPage extends BaseTest {

    @FindBy(css = ".oxd-topbar-header-breadcrumb-module")
    WebElement adminTitleElement;

    public AdminPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean hasAdminTitle() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GeneralUtils.IMPLICIT_WAIT));
        return adminTitleElement.getText().trim().contains("Admin");
    }

}

package com.orangehrmlive.pom.pages;

import com.orangehrmlive.pom.basepage.BaseTest;
import com.orangehrmlive.pom.utils.GeneralUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage extends BaseTest {

    @FindBy(css = "p.oxd-userdropdown-name")
    WebElement welcomeElement;

    @FindBy(css = "a[href$='/admin/viewAdminModule']")
    WebElement adminLinkElement;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean hasUserName() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GeneralUtils.IMPLICIT_WAIT));
        return welcomeElement.getText().trim().contains("Paul Collings");
    }

    public AdminPage clickAdmin() {
        adminLinkElement.isDisplayed();
        adminLinkElement.click();
        return new AdminPage();
    }


}

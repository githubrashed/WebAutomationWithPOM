package com.orangehrmlive.pom.pages;

import com.orangehrmlive.pom.base.BaseTest;
import com.orangehrmlive.pom.utils.GeneralUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage extends BaseTest {

    @FindBy(css = "p.oxd-userdropdown-name")
    WebElement welcomeElement;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean hasWelcome() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GeneralUtils.IMPLICIT_WAIT));
        return welcomeElement.getText().trim().contains("Paul Collings");
    }

}

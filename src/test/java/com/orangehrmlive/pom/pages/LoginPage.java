package com.orangehrmlive.pom.pages;

import com.orangehrmlive.pom.basepage.BaseTest;
import com.orangehrmlive.pom.utils.GeneralUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage extends BaseTest {
    @FindBy(name = "username")
    WebElement userName;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(css = "button.oxd-button")
    WebElement loginBtn;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public HomePage login(String user, String pas) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GeneralUtils.IMPLICIT_WAIT));

        userName.clear();
        userName.sendKeys(user);

        password.clear();
        password.sendKeys(pas);

        loginBtn.click();

        return new HomePage();
    }

}

package com.orangehrmlive.pom.pages;

import com.orangehrmlive.pom.orangehrmbasepage.OrangeHrmBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends OrangeHrmBaseTest {
    @FindBy(name = "username")
    WebElement userName;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(css = "button.oxd-button")
    WebElement loginBtn;

    @FindBy(css = ".orangehrm-login-title")
    WebElement loginTextEle;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean loginText() {
        return loginTextEle.getText().trim().contains("Login");
    }

    public HomePage login(java.lang.String user, java.lang.String pas) {
        implicitWait();
        userName.clear();
        userName.sendKeys(user);
        password.clear();
        password.sendKeys(pas);
        loginBtn.click();
        return new HomePage();
    }

    @Override
    public String getPageTitle() {
        return "dfdf";
    }
}

package com.ex.se.qa.team.pages;

import com.ex.se.qa.team.hrmbasetest.BaseTestSeQATeam;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class SeLoginPage extends BaseTestSeQATeam {

    @FindBy(name = "username")
    WebElement userNameEle;

    @FindBy(name = "password")
    WebElement passwordEle;

    @FindBy(css = "button.oxd-button")
    WebElement loginBtn;

    public SeLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public SeHomePage login(String user, String pass) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        userNameEle.isDisplayed();
        userNameEle.sendKeys(user);
        passwordEle.isDisplayed();
        passwordEle.sendKeys(pass);
        loginBtn.click();

        return new SeHomePage();
    }

}

package com.orangehrmlive.pom.basepage;

import com.orangehrmlive.pom.utils.GeneralUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void initialization() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GeneralUtils.IMPLICIT_WAIT));
        driver.get("https://opensource-demo.orangehrmlive.com");
    }
}

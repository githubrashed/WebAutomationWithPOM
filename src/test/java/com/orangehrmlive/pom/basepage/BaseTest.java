package com.orangehrmlive.pom.basepage;

import com.orangehrmlive.pom.utils.GeneralUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void initialization() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        implicitWait();
        driver.get("https://opensource-demo.orangehrmlive.com");
    }

    public WebDriver.Timeouts implicitWait() {
        return driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GeneralUtils.IMPLICIT_WAIT));
    }

    public void waitThreadSleep() throws InterruptedException {
        try {
            Thread.sleep(3);
        } catch (Exception ex) {
            System.out.println("Please extend time");
        }
    }

    public void tearDown() {
        driver.quit();
    }

}

package com.orangehrmlive.pom.orangehrmbasepage;

import com.orangehrmlive.pom.utils.GeneralUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class OrangeHrmBaseTest {
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

    public static void takeScreenShot() {
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenSavedDir = System.getProperty("user.dir") + "/build/screenshots/";
            FileUtils.copyFile(screenshotFile, new File(screenSavedDir + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void tearDown() {
        driver.quit();
    }

}

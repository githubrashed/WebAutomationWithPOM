package com.orangehrmlive.pom.orangehrmbasepage;

import com.orangehrmlive.pom.utils.GeneralUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class OrangeHrmBaseTest {
    public static WebDriver driver;

    public void initialization() throws IOException {
        Properties prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream("D:\\Official\\WebAutomationWithPOM\\src\\test\\resources\\credential.properties");
        prop.load(fileInputStream);

        String browserName = prop.getProperty("browser");
        if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            implicitWait();
        } else if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            implicitWait();
        } else {
            System.out.println("value not found");
        }

        driver.get(prop.getProperty("applicationUrl"));

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

package com.orangehrmlive.pom.orangehrmbasepage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.orangehrmlive.pom.utils.GeneralUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public abstract class OrangeHrmBaseTest {

    public abstract String getPageTitle();

    public static WebDriver driver;

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    @BeforeClass
    public void initialization() throws IOException {

        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\build\\extendReport\\ExtendReport.html");
        sparkReporter.config().setDocumentTitle("QA Automation Report");
        sparkReporter.config().setReportName("Extend Report");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();

        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Host IP", "xptrackstaging.com");
        extent.setSystemInfo("OS", "Windows 10");
        extent.setSystemInfo("Environment", "QA Environment");
        extent.setSystemInfo("Browser", "Firefox");
        extent.setSystemInfo("Author", "Rashedul Islam");

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

    @AfterClass
    public void endReport() {
        extent.flush();
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

    public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        String source = ts.getScreenshotAs(OutputType.BASE64);
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(new File(source), finalDestination);
        return destination;
    }
}

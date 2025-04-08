package Packt.com.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;


// Cross Browser Testing
public class BaseTest {
    // open a new web driver
    protected WebDriver driver;

    // create a logger
    protected Logger log;

    // set up the driver according to the browser
    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser, ITestContext ctx) {
        // create a logger instance
        String testName = ctx.getCurrentXmlTest().getName();
        log = Logger.getLogger(testName);

        // set up browser's driver
        log.info("[setting up driver: " + browser + " ]");

        // create a web driver follow to browser
        try {
            BrowserDriverFactory browserDriverFactory = new BrowserDriverFactory(browser);
            driver = browserDriverFactory.createDriver();
        } catch (Exception e) {
            log.warning("[setting up driver failed" + browser + " ] :  " + e.getMessage());
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            // closing driver
            log.info("[closing driver]");
            driver.quit();
        }
    }

    // Write a method for data-driven testing
    @DataProvider(name = "dataLogin")
    public Object[][] Data() {
        return new Object[][]{
                {"tomsmith", "SuperSecretPassword", "Your password is invalid!"},
                {"toms", "SuperSecretPassword!", "Your username is invalid!"},
                {"toms", "SuperSecretPassword", "Your username is invalid!"}
        };
    }

    // Write a method to take screenshots like below
    protected void takeSnapShot(WebDriver webdriver, String fileWithPath) throws StaleElementReferenceException, IOException {
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile = new File(fileWithPath);
        try {
            //Copy file at destination
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            log.warning("Error taking screenshot: " + e.getMessage());
        }
    }

    // write a method to wait for a specific time
    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log.warning(e.getMessage());
        }
    }

}

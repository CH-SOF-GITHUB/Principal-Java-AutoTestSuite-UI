package Packt.com.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

// Cross Browser Testing
public class BaseTest {
    // open a new web driver
    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        // creating a driver
        System.out.println("[setting up driver: " + browser + " ]");
        // and here we can add some code to use this browser variable
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        } else {
            System.out.println("[setting up driver failed" + browser + " ]");
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            // closing driver
            System.out.println("[closing driver]");
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
            System.out.println("Error taking screenshot: " + e.getMessage());
        }

    }

    // write a method to wait for a specific time
    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}

package Lambdatest.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class TestBase {

    public static WebDriver driver;

    @BeforeSuite
    public void initializeWebDriver() {
        // Initialize WebDriver here
        driver = new ChromeDriver();
        // Set the URL for the test
        driver.get("https://workspace.google.com/intl/fr/gmail/");
        // Maximize the browser window
        driver.manage().window().maximize();
        // implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterSuite
    public void quitDriver() {
        // Quit the WebDriver
        if (driver != null) {
            driver.quit();
        }
    }
}

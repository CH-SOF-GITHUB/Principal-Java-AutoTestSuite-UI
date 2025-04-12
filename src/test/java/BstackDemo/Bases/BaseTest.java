package BstackDemo.Bases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static String baseUrl = "https://www.bstackdemo.com/";

    @BeforeTest
    public void setUp() {
        // Code to set up the test environment
        System.out.println("Setting up the test environment...");
        // Initialize WebDriver, set timeouts, etc.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void tearDown() {
        // Code to clean up after the test
        System.out.println("Cleaning up after the test...");
        if (driver != null) {
            driver.quit();
        }
    }
}

package Lambdatest.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestBase {

    public static WebDriver driver;

    @BeforeSuite
    public void initializeWebDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // Capabilities conformes au protocole W3C
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "73.0");
        capabilities.setCapability("platformName", "Windows 10");

        // Capabilities spécifiques à LambdaTest
        var ltOptions = new java.util.HashMap<String, Object>();
        ltOptions.put("build", "Selenium_POM_Project");
        ltOptions.put("name", "Verify Gmail Login Flow");
        ltOptions.put("visual", false);
        ltOptions.put("network", false);
        ltOptions.put("console", false);
        ltOptions.put("tunnel", false);

        capabilities.setCapability("LT:Options", ltOptions);

        String username = "bchaker28";
        String accesskey = "LT_z3NSTniUUMFpDiAk87KaVuhA3mv5NQsKHK12MwZ8lLLuqlS";
        String lambdaTestGridURL = "@hub.lambdatest.com/wd/hub";

        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + lambdaTestGridURL), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        }

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

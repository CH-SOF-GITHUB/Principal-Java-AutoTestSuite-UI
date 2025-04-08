package Packt.com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserDriverFactory {

    public BrowserDriverFactory() {
    }

    /**
     *
     * @param browser
     * @return
     */
    public static WebDriver createDriver(String browser) {
        // set up browser's driver
        System.out.println("[setting up driver: " + browser + " ]");
        // declare a web driver
        WebDriver driver;

        browser = browser.toLowerCase();

        // set up the driver according to the browser
        driver = switch (browser) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            case "edge" -> new EdgeDriver();
            case "ie" -> new InternetExplorerDriver();
            default -> null;
        };
        if (driver != null) {
            driver.manage().window().maximize();
        }
        return driver;
    }
}
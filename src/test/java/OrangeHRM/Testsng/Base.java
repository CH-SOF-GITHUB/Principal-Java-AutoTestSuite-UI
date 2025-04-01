package OrangeHRM.Testsng;

import OrangeHRM.PageModels.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Base {
    private static final Logger log = LoggerFactory.getLogger(Base.class);

    // chaque test  son propre web driver
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    // définir un web driver
    // WebDriver driver;

    public static WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    public void AvantTest() {
        System.out.println("Avant chaque Test");
        // controle et ouverture d'un navigateur chrome
        driver.set(new ChromeDriver());
    }

    @AfterMethod
    public void ApresTest() {
        if (driver != null) {
            getDriver().quit();
            driver.remove();
        }
        System.out.println("Aprés chaque test");
    }
}
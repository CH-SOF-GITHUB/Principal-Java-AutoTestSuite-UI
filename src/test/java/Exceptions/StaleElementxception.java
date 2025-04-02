package Exceptions;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class StaleElementxception {

    @Test
    public void ExampleTest01() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        // Open the webpage
        driver.get("https://google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // declare web element search input
        WebElement ele = driver.findElement(By.name("q"));
        for (int i = 0; i < 3; i++) {
            try {
                ele.click();
                break;
            } catch (StaleElementReferenceException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Test 1 passed");
        // close the browser
        driver.quit();
    }

    @Test
    public void Test02() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        // Open the webpage
        driver.get("https://google.com");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // declare web element search input
        try {
            WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("qq")));
            ele.sendKeys("test");
            ele.sendKeys(Keys.ENTER);
            // vérifier le resultat attendu
            Assert.assertTrue("search failed", driver.getCurrentUrl().contains("test"));
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getMessage());
            // refresh la page
            driver.navigate().refresh();
        }

        System.out.println("Test 2 passed");
        // close the browser
        driver.quit();
    }
}

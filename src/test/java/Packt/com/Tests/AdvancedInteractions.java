package Packt.com.Tests;

import Packt.com.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdvancedInteractions extends BaseTest {
    // cache all errors except critic errors
    static {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }

    protected Logger log = Logger.getLogger(AdvancedInteractions.class.getName());

    @Test(priority = 1)
    @Parameters("browser")
    public void switchWindowTest(String browser) throws InterruptedException {
        // display the browser name
        log.info("[Browser opened: ] + " + browser);
        // opening page
        driver.get("https://the-internet.herokuapp.com/windows");
        log.info("page opened!");

        // wait for 1 seconds to handle page response
        sleep(1000);

        // click on the link
        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();

        sleep(2000);

        // get page title and url after clicking the link
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();
        log.info("Page Title after click link: " + title);
        log.info("Page URL after click link: " + url);

        // switch to the new window
        // get handle of the first window
        String firstWindow = driver.getWindowHandle();
        // read and set all handles
        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> windowsIterator = allWindows.iterator();
        while (windowsIterator.hasNext()) {
            String windowHandle = windowsIterator.next().toString();
            if (!windowHandle.equals(firstWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        //  compare page title and url after switch to new window
        title = driver.getTitle();
        url = driver.getCurrentUrl();
        log.info("Page Title after switch new window: " + title);
        log.info("Page URL after switch new window: " + url);
    }


    @Test(priority = 2)
    @Parameters("browser")
    public void iframeTest(String browser) {
        // display the browser name
        log.info("[Browser : ] + " + browser);
        // open page
        driver.get("https://the-internet.herokuapp.com/iframe");
        log.info("page opened!");

        // wait for 3 seconds to handle page response
        sleep(3000);

        // close the alert
        try {
            WebElement closeAlert = driver.findElement(By.xpath("/html/body/div[4]/div/div/button"));
            closeAlert.click();
            log.info("Alert closed!");
        } catch (Exception e) {
            log.warning("Alert not found: " + e.getMessage());
        }

        // first switch to the iframe
        WebElement iFrame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrame);
        log.info("Switched to iframe!");

        // wait for 3 seconds to handle text
        sleep(3000);

        // wait for the text area to be visible and interactable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement textArea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tinymce")));

        try {
            textArea.clear();
        } catch (Exception e) {
            log.warning("Error test: " + e.getMessage());
        }

        // javascript to enter text in the iframe
        ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '<p>Hello World!</p>';", textArea);
        sleep(5000);
        log.info("Modify iframe passed");
    }
}
package Packt.com.Tests;

import Packt.com.base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Troubleshooting extends BaseTest {
    // Cache les logs Selenium sauf erreurs critiques
    static {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }

    @Test
    @Parameters({"browser"})
    public void waitTest(String browser) {
        // This method is not used in the test wait of presence of element located
        System.out.println("[browser: ]" + browser);
        // open the page web
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        System.out.println("page opened!");
        try {
            // check start button and click it
            WebElement startButton = driver.findElement(By.xpath("//button"));
            startButton.click();

            // check for web element "Hello World!"
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));

            // verify the "Hello World!" text
            WebElement finishElement = driver.findElement(By.id("finish"));
            String finishText = finishElement.getText();
            Assert.assertEquals(finishText, "Hello World!", "'Hello World! text is not present on the page.'");

            // display Thread of parallel tests
            System.out.println("Running test on: " + driver.getTitle() + " | Thread ID: " + Thread.currentThread().getId());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        } finally {
            driver.quit();
        }
    }

    /*
    @Test(priority = 2)
    @Parameters({"browser"})
    public void visibilityTest(String browser) {
        System.out.println("[browser: ]" + browser);
        //opening the page
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        System.out.println("page opened !");

        // click start button
        WebElement startButton = driver.findElement(By.xpath("//button"));
        System.out.println("Is start button visible before clicking: " + startButton.isDisplayed());
        startButton.click();

        // waiting for Hello World! text
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

        // verify Hello World text
        WebElement finishElement = driver.findElement(By.id("finish"));
        String finishText = finishElement.getText();
        Assert.assertEquals(finishText, "Hello World!", "Hello World! text is not visible on the page !");
        System.out.println("Is start button visible after clicking: " + startButton.isDisplayed());
    }
    */
    /*
    @Test(priority = 3)
    @Parameters({"browser"})
    public void staleElementTest() {
        // opening page
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
        System.out.println("page opened !");

        // click on the link
        WebElement Link = driver.findElement(By.linkText("Click here"));
        Link.click();

        // waiting for message 1
        try {
            WebElement message1 = driver.findElement(By.id("flash"));
            String messageText1 = message1.getText();
            System.out.println("Message 1:  " + messageText1);
            //Call take screenshot function
            this.takeSnapShot(driver, "src/test/java/Packt/com/screenshots/message1.png");
        } catch (StaleElementReferenceException | IOException e) {
            System.out.println(e.getMessage());
        }

        // click on the link
        Link = driver.findElement(By.linkText("Click here"));
        Link.click();

        // waiting for message 2
        try {
            WebElement message2 = driver.findElement(By.id("flash"));
            String messageText2 = message2.getText();
            System.out.println("Message 2:  " + messageText2);
            //Call take screenshot function
            this.takeSnapShot(driver, "src/test/java/Packt/com/screenshots/message2.png");
        } catch (StaleElementReferenceException | IOException e) {
            throw new RuntimeException(e);
        }

        // click on the link
        Link = driver.findElement(By.linkText("Click here"));
        Link.click();

        // waiting for message 3
        try {
            WebElement message3 = driver.findElement(By.id("flash"));
            String messageText3 = message3.getText();
            System.out.println("Message 3:  " + messageText3);
            //Call take screenshot function
            this.takeSnapShot(driver, "src/test/java/Packt/com/screenshots/message3.png");
        } catch (StaleElementReferenceException | IOException e) {
            throw new RuntimeException(e);
        }

        // click on the link
        Link = driver.findElement(By.linkText("Click here"));
        Link.click();

        // waiting for message 4
        try {
            WebElement message4 = driver.findElement(By.id("flash"));
            String messageText4 = message4.getText();
            System.out.println("Message 4:  " + messageText4);
            //Call take screenshot function
            this.takeSnapShot(driver, "src/test/java/Packt/com/screenshots/message4.png");
        } catch (StaleElementReferenceException | IOException e) {
            throw new RuntimeException(e);
        }

        // display Thread of parallel tests
        System.out.println("Running test on: " + driver.getTitle() + " | Thread ID: " + Thread.currentThread().getId());

        // fermer le navigateur
        driver.quit();
    }*/
}
package Packt.com.herokuapp;

import Packt.com.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class SecurePage extends BasePageObject {
    // declare a Logout button web element
    @FindBy(xpath = "//a[@class='button secondary radius']")
    public WebElement logoutButton;

    By MessageLocator = By.id("flash-messages");

    public SecurePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void waitForSecurePage(long millis) {
        System.out.println("Waiting for secure page");
        waitForElementPresent(By.xpath("//a[@class='button secondary radius']"), Duration.ofMillis(millis).toSecondsPart());
    }

    public boolean isSecurePageLoaded() {
        try {
            return logoutButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // check success login messages
    public void visibilityOfMessages(long millis) {
        System.out.println("Visibility of success messages");
        waitForVisibilityOf(MessageLocator, Duration.ofMillis(millis).toSecondsPart());
    }

    public WebElement findMessages() {
        return driver.findElement(MessageLocator);
    }

    public String MessagesText() {
        return findMessages().getText();
    }

}
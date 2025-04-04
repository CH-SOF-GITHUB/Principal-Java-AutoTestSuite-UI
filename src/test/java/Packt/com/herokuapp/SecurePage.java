package Packt.com.herokuapp;

import Packt.com.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurePage extends BasePageObject {
    // declare a Logout button web element
    @FindBy(xpath = "//a[@class='button secondary radius']")
    public WebElement logoutButton;

    public SecurePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void waitForSecurePage(long millis) {
        System.out.println("Waiting for secure page");
        waitForElementPresent(By.xpath("//a[@class='button secondary radius']"), 15);
    }

    public boolean isSecurePageLoaded() {
        try {
            return logoutButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}

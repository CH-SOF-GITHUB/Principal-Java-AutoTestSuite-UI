package Lambdatest.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailInboxPage {
    // declare an instance of WebDriver
    WebDriver driver;

    public GmailInboxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // implement locator of web element
    @FindBy(xpath = "//a[@title='Gmail']")
    private WebElement gmailTitle;

    public boolean visibleGmailTitle() {
        return gmailTitle.isDisplayed();
    }

    public String getGmailTitle() {
        return gmailTitle.getText();
    }
}

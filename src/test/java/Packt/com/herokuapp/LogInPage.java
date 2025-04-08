package Packt.com.herokuapp;

import Packt.com.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BasePageObject {

    public LogInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // declare an URL of page herokuapp
    public String loginPageUrl = "http://the-internet.herokuapp.com/login";

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(css = "input[name=password]")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    By errorMessageLocator = By.id("flash-messages");
    //@FindBy(id = "flash-messages")
    //private WebElement errorMessages;

    public SecurePage LogIn(String username, String password) {
        System.out.println("Entering username and password");
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        System.out.println("Clicking Login button");
        loginButton.click();
        return new SecurePage(driver);
    }

    // positive test
    public SecurePage PositiveLogIn(String username, String password) {
        System.out.println("Entering username and password");
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        System.out.println("positive Clicking Login button");
        loginButton.click();
        return new SecurePage(driver);
    }

    public void NegativeLogIn(String username, String password) {
        System.out.println("Entering username and password");
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        System.out.println("Clicking Login button");
        loginButton.click();

        visibilityOfErrorMessages();
    }

    public void visibilityOfErrorMessages() {
        System.out.println("Visibility of error messages");
        waitForVisibilityOf(errorMessageLocator, 10);
    }

    public WebElement findErrorMessages() {
        return driver.findElement(errorMessageLocator);
    }

    public String ErrorMessagesText() {
        return findErrorMessages().getText();
    }

    public void open() {
        openURL(loginPageUrl);
    }
}
package BstackDemo.PageModels;

import BstackDemo.Bases.BasePageObject;
import BstackDemo.Locations.Locators;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageLogin extends BasePageObject {

    // declare a web driver
    // WebDriver driver;

    // Instancie la classe Locators
    Locators locators = new Locators();

    // constructor to initialize the web elements and the web driver
    public PageLogin(WebDriver driver) {
        super(driver);
        //this.driver = driver;
        //PageFactory.initElements(driver, this);
    }

    // implement locators for web elements
    WebElement usernameField = find(locators.usernameLocator);

    WebElement passwordField = find(locators.passwordLocator);

    WebElement loginButton = find(locators.loginBtnLocator);

    // page factory methods
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void LoginBstack(String username, String password) {
        // Enter username
        usernameField.sendKeys(username + Keys.ENTER);
        // Enter password
        passwordField.sendKeys(password + Keys.ENTER);
        // Click on the login button
        loginButton.click();
        System.out.println("Login button clicked");
    }

    // error message if login fails
    public boolean visibilityOfErrorMessageDisplayed() {
        try {
            WebElement errorMessage = find(locators.errorMessageLocator);
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            System.out.println("Error message not displayed: " + e.getMessage());
            return false;
        }
    }

    public String getErrorMessage() {
        WebElement errorMessage = find(locators.errorMessageLocator);
        return errorMessage.getText();
    }

    // username display for login success
    public DashboardPage visibilityOfUsername() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locators.usernameDashboardLocator));
        return new DashboardPage(driver);
    }
}
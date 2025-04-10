package Lambdatest.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPage {
    // declare an instance of WebDriver
    WebDriver driver;

    // a constructor to initialize the WebDriver
    public GmailLoginPage(WebDriver driver) {
        this.driver = driver;
        // initialize the elements using PageFactory
        PageFactory.initElements(driver, this);
    }

    // implement locator of web element
    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//div[@id='identifierNext']")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    // add methods to interact with the elements
    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    // ghjt012SZED
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    /* Simule un clic sur le bouton "Suivant".
     Retourne une instance de la page suivante (GmailInboxPage),
    permettant de continuer les interactions avec cette nouvelle page.
     */
    public GmailInboxPage clickNextButton() {
        nextButton.click();
        return new GmailInboxPage(driver);
    }

}

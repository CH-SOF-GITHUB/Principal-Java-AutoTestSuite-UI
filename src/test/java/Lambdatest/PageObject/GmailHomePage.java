package Lambdatest.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailHomePage {
    WebDriver driver;

    // implement locator of web element
    @FindBy(linkText = "Se connecter")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@data-email='chakerbensaid1@gmail.com']")
    private WebElement emailToClick;

    public GmailHomePage(WebDriver driver) {
        this.driver = driver;
        // initialize the elements using PageFactory
        PageFactory.initElements(driver, this);
    }

    /* Simule un clic sur le bouton "Se connecter".
     Retourne une instance de la page suivante (GmailLoginPage),
    permettant de continuer les interactions avec cette nouvelle page.
     */
    /*
    public GmailLoginPage clickEmailToNext() {
        emailToClick.click();
        return new GmailLoginPage(driver);
    }
     */

    public GmailLoginPage clickSignInButton() {
        signInButton.click();
        return new GmailLoginPage(driver);
    }

}

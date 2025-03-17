package OrangeHRM.PageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    // définir le web driver
    WebDriver driver;

    // constructeur initialisation des web elements
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // définir les web elements de la page login
    @FindBy(name = "username")
    WebElement usernameField;
    @FindBy(name = "password")
    WebElement passwordField;
    @FindBy(className = "orangehrm-login-button")
    WebElement loginButton;

    // définir les méthodes des actions des web elements
    public void saisirUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void saisirPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    // définir les web élèments de la page login herokuapp
    @FindBy(className = "success")
    WebElement successMessage;
    @FindBy(className = "error")
    WebElement errorMessage;
    @FindBy(className = "fa-sign-in")
    WebElement signInButton;

    // définir les méthodes des actions des web élèments
    public void ClickToLogin() {
        signInButton.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    // messages possibles:  Your username is invalid! || Your password is invalid!
    public String getErrorMessage() {
        return errorMessage.getText();
    }

}

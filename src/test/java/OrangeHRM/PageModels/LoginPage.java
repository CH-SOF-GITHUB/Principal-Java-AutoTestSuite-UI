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
}

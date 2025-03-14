package OrangeHRM.PageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    // définir le web driver
    WebDriver driver;

    // constructeur initialisation des web elements
    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // définir les web elements de la page logout
    @FindBy(className = "oxd-userdropdown-icon")
    WebElement userDropdownIcon;
    @FindBy(linkText = "Logout")
    WebElement logoutLink;

    // définir les méthodes des actions des web elements
    public void clickOnUserDropdownIcon() {
        userDropdownIcon.click();
    }

    public void clickOnLogoutLink() {
        logoutLink.click();
    }
}

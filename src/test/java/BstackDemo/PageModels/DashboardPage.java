package BstackDemo.PageModels;

import BstackDemo.Bases.BasePageObject;
import BstackDemo.Locations.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage extends BasePageObject {
    // declare an instance of WebDriver
    // WebDriver driver;

    // Instancie la classe Locators
    Locators locators = new Locators();

    public DashboardPage(WebDriver driver) {
        super(driver);
        //this.driver = driver;
        //PageFactory.initElements(driver, this);
    }

    // implement locator of web element
    WebElement UsernameIfAccess = find(locators.usernameDashboardLocator);

    public String getUsernameText() {
        return UsernameIfAccess.getText();
    }
}

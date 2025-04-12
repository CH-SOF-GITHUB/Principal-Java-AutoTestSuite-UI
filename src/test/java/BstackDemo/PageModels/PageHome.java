package BstackDemo.PageModels;

import BstackDemo.Bases.BasePageObject;
import BstackDemo.Bases.BaseTest;
import BstackDemo.Locations.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageHome extends BasePageObject {
    // declare an instance of WebDriver
    // WebDriver driver;
    // Instancie la classe Locators
    Locators locators = new Locators();

    public PageHome(WebDriver driver) {
        super(driver);
        // this.driver = driver;
        // PageFactory.initElements(driver, this);
    }

    // implement locator of web elements
    WebElement clickSign_In = find(locators.signInLocator);
    List<WebElement> noOfLinks = finds(locators.LinkNavbar);


    // page factory methods
    // Méthode pour cliquer sur "Sign In"
    public PageLogin clickSignInLink() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            // Attendre que l'élément soit présent dans le DOM
            wait.until(ExpectedConditions.presenceOfElementLocated(locators.signInLocator));
            // Attendre que l'élément soit cliquable
            wait.until(ExpectedConditions.elementToBeClickable(clickSign_In));
            clickSign_In.click();
            // Attendre que l'URL change vers /signin
            wait.until(ExpectedConditions.urlContains("/signin"));
        } catch (Exception e) {
            System.out.println("Erreur lors du clic sur 'Sign In': " + e.getMessage());
        }
        return new PageLogin(driver);
    }

    // Méthode pour compter les liens visibles
    public int countLinks() {
        int count = 0;
        for (WebElement link : noOfLinks) {
            if (link.isDisplayed()) {
                count++;
            }
        }
        return count;
    }
}

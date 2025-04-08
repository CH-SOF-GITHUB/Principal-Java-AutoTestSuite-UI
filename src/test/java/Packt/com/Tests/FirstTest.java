package Packt.com.Tests;

import Packt.com.base.BaseTest;
import Packt.com.base.CsvDataProvider;
import Packt.com.herokuapp.LogInPage;
import Packt.com.herokuapp.SecurePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FirstTest extends BaseTest {
    // Cache les logs erreurs sauf les erreurs critiques
    static {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }

    // protected String username = "tomsmith";
    // protected String password = "SuperSecretPassword!";


    @Test(priority = 1)
    @Parameters({"username", "password", "browser"})
    public void TC01(String username, String password, String browser) throws IOException {
        // Thread name and id
        System.out.println("Thread: " + Thread.currentThread().getName() + " on Thread ID: " + Thread.currentThread().getId());
        // Votre code de test ici
        SoftAssert softAssert = new SoftAssert();
        LogInPage logInPage = new LogInPage(driver);
        logInPage.open();
        // take a screenshot opened loginIn page
        this.takeSnapShot(driver, "src/test/java/Packt/com/screenshots/open_login_In_Page_with_" + browser + ".png");

        // login and clicking login button
        SecurePage securePage = logInPage.LogIn(username, password);
        securePage.waitForSecurePage(10000);

        // take a screenshot opened secure page
        this.takeSnapShot(driver, "src/test/java/Packt/com/screenshots/open_secure_Page_with_" + browser + ".png");

        // verifications
        softAssert.assertTrue(securePage.isSecurePageLoaded(), "Logout button is not visible");
        softAssert.assertTrue(securePage.getPageSource().contains("You logged into a secure area!"), "Page source doesn't contain expected text: 'You logged into a secure area!'");
        softAssert.assertAll();
    }
}

package Packt.com.Tests;

import OrangeHRM.PageModels.LoginPage;
import Packt.com.base.BaseTest;
import Packt.com.base.CsvDataProvider;
import Packt.com.herokuapp.LogInPage;
import Packt.com.herokuapp.SecurePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NegativeTest extends BaseTest {
    // Cache les logs erreurs sauf les erreurs critiques
    static {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }

    /* data provider:
     * fournir des données à ce test sous forme du tableau. Cela permet d'exécuter le meme test
     * avec plusieurs ensemble de données facilitant ainsi les tests paramétrés.
     * */

    @Test(dataProvider = "dataLogin")
    public void negativeTest(String username, String password, String expectedMessage) throws IOException {
        // Your test code here
        SoftAssert softAssert = new SoftAssert();
        LogInPage logInPage = new LogInPage(driver);

        // open the login page
        logInPage.open();

        // take a screenshot opened loginIn page
        this.takeSnapShot(driver, "src/test/java/Packt/com/screenshots/open_login_In_Page_negative_" + username + "_" + password + ".png");

        // after access to page, click login button
        logInPage.NegativeLogIn(username, password);

        // take a screenshot for each negative test case
        this.takeSnapShot(driver, "src/test/java/Packt/com/screenshots/negative_" + username + "_" + password + ".png");

        // verifications of data driver testing with negative data
        String actualMessage = logInPage.findErrorMessages().getText();
        System.out.println("Actual message: " + actualMessage + " | Expected message: " + expectedMessage);
        softAssert.assertTrue(actualMessage.contains(expectedMessage), "Error message is not as expected");
    }

    /*
     * j'utilise des fichiers de données comme excel, ou avec les bases de données pour gérer les données de test.
     * */
    //use datProvider attribute to specify the data provider with dataProviderClass to specify the class
    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
    public void negativeCsvTest(Map<String, String> setData) throws IOException {
        // Your test code here
        SoftAssert softAssert = new SoftAssert();
        LogInPage logInPage = new LogInPage(driver);

        // open the login page
        logInPage.open();

        // re-définir username, password AND expectedMessage from setData
        String username = setData.get("username");
        String password = setData.get("password");
        String expectedMessage = setData.get("expectedError");

        // take a screenshot opened loginIn page
        this.takeSnapShot(driver, "src/test/java/Packt/com/screenshots/login_In_Page_negative_csv_" + username + "_" + password + ".png");

        // after access to page, click login button
        logInPage.NegativeLogIn(username, password);

        // take a screenshot for each negative test case
        this.takeSnapShot(driver, "src/test/java/Packt/com/screenshots/negative_csv_" + username + "_" + password + ".png");

        // verifications of data driver testing with negative data
        String actualMessage = logInPage.ErrorMessagesText();
        System.out.println("Actual message: " + actualMessage + " | Expected message: " + expectedMessage);
        softAssert.assertTrue(actualMessage.contains(expectedMessage), "Error message is not as expected");
    }
}
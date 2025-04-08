package Packt.com.Tests;

import Packt.com.base.BaseTest;
import Packt.com.base.CsvDataProvider;
import Packt.com.herokuapp.LogInPage;
import Packt.com.herokuapp.SecurePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Map;

public class PositiveTest extends BaseTest {
    // positive test: login in secure page
    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
    public void positiveCsvTest(Map<String, String> DataFile) throws IOException {
        SoftAssert softAssert = new SoftAssert();
        LogInPage logInPage = new LogInPage(driver);
        logInPage.open();

        // get username and password from data file
        String username = DataFile.get("username");
        String password = DataFile.get("password");
        String expectedMessage = DataFile.get("expectedMessage");

        // take a screenshot opened loginIn page
        this.takeSnapShot(driver, "src/test/java/Packt/com/screenshots/open_login_In_Page_positive_" + username + "_" + password + ".png");

        // login and clicking login button
        SecurePage securePage = logInPage.PositiveLogIn(username, password);
        securePage.visibilityOfMessages(10000);
        securePage.waitForSecurePage(10000);

        // take a screenshot opened Secure login in page
        this.takeSnapShot(driver, "src/test/java/Packt/com/screenshots/secure_login_In_Page_positive_" + username + "_" + password + ".png");

        // Vérification des tests
        String actualMessage = securePage.MessagesText();
        System.out.println("Actual message: " + actualMessage);
        System.out.println("Expected message: " + expectedMessage);

        softAssert.assertTrue(actualMessage.contains(expectedMessage), "Message success login not displayed!");
        softAssert.assertTrue(securePage.isSecurePageLoaded(), "Logout button is not visible");

        softAssert.assertAll();
    }
}

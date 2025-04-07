package Packt.com.Tests;

import OrangeHRM.PageModels.LoginPage;
import Packt.com.base.BaseTest;
import Packt.com.herokuapp.LogInPage;
import Packt.com.herokuapp.SecurePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class NegativeTest extends BaseTest {


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
}

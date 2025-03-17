package OrangeHRM.Testsng;

import OrangeHRM.PageModels.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestLogin1 extends Base {

    @DataProvider(name = "DP")
    public Object[][] Data() {
        return new Object[][]{
                // cas 1: username and password valides:
                {"tomsmith", "SuperSecretPassword!", "You logged into a secure area!"},
                // cas 2: username invalide et password valide
                {"tomsh", "SuperSecretPassword!", "Your username is invalid!"},
                // cas 3: username valide et password invalide
                {"tomsmith", "SuperSecretPass", "Your password is invalid!"},
                // cas 4: username et password invalide
                {"tomsh", "SuperSecretPass", "Your username is invalid!"},
        };
    }

    @Test(timeOut = 2000)
    public void Test1() {
        System.out.println("je suis sur l'interface login");
    }

    @Test(priority = 1, dataProvider = "DP")
    public void Login(String username, String password, String expectedMessage) throws InterruptedException {
        // définir une instance de la classe LoginPage
        WebDriver driver = getDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        // définir l'attente implicite de 10 s avant de lancer une exception
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoginPage loginPage = new LoginPage(driver);
        // saisir username
        loginPage.saisirUsername(username);
        // saisir password
        loginPage.saisirPassword(password);
        // cliquer sur le bouton Login
        loginPage.ClickToLogin();
        // attendre un temps de 5s pour charger la page
        Thread.sleep(5000);
        // vérifier les résultats de connexion
        if (expectedMessage.equals("You logged into a secure area!")) {
            String msgSuccess = loginPage.getSuccessMessage();
            msgSuccess = msgSuccess.replace("×", "").trim();
            //System.out.println("msgSuccess: " + msgSuccess);
            Assert.assertEquals(expectedMessage, msgSuccess);
        } else {
            String msgError = loginPage.getErrorMessage();
            msgError = msgError.replace("×", "").trim();
            //System.out.println("msgError: " + msgError);
            Assert.assertEquals(expectedMessage, msgError);
        }
    }
}

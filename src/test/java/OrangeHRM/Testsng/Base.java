package OrangeHRM.Testsng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Base {
    // définir un web driver
    WebDriver driver;

    @BeforeTest
    public void AvantTest() {
        System.out.println("Avant chaque Test");
        // controle et ouverture d'un navigateur chrome
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        // définir l'attente implicite de 10 s avant de lancer une exception
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void ApresTest() {
        driver.close();
        System.out.println("Aprés chaque test");
    }
}

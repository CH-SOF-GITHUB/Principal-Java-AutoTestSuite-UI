package OrangeHRM.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Hooks {

    @Before("@AddVacancy")
    public void AvantChaqueScenario() {
        System.out.println("-------Début de scenario---------");
        System.out.println("je suis sur l'interface login");
    }

    @After("@AddVacancy")
    public void ApresChaqueScenario() {
        System.out.println("--------Fin de scenario-----------");
    }
}

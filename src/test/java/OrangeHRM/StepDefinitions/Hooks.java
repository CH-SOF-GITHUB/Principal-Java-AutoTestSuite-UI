package OrangeHRM.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before("@CreateClaimRequest")
    public void AvantChaqueScenario() {
        System.out.println("-------Début de scenario---------");
        System.out.println("je suis sur l'interface login");
    }

    @After("@CreateClaimRequest")
    public void ApresChaqueScenario() throws InterruptedException {
        System.out.println("--------Fin de scenario-----------");
    }
}

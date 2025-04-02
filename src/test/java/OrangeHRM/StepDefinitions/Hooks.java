package OrangeHRM.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.HelperClass;

import java.io.File;
import java.time.Duration;

public class Hooks {

    @Before
    public static void setUp() {
        HelperClass.setUpDriver();
    }

    @After
    public static void tearDown(Scenario scenario) throws Exception {
        // validate if scenario is failed
        if (scenario.isFailed()) {
            takeScreenShot(HelperClass.getDriver(), "OrangeHRM/resources");
            //final byte[] screenshot = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BYTES);
            //scenario.attach(screenshot, "image/png", scenario.getName());
        }

        HelperClass.tearDown();
    }

    public static void takeScreenShot(WebDriver webdriver, String fileWithPath) throws Exception {
        //1. We need to convert webdriver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        //2. Calling the method getScreenshotAs and specify the output type of screenshot.
        File SourceFile = scrShot.getScreenshotAs(OutputType.FILE);
        //3. Then move the screenshot to the destination path where we need to copy our file
        File DestinationFile = new File(fileWithPath);
        //4. copy the file
        FileUtils.copyFile(SourceFile, DestinationFile);
    }
    /*
    @Before("@AddVacancy")
    public void AvantChaqueScenario() {
        System.out.println("-------Début de scenario---------");
        System.out.println("je suis sur l'interface login");
    }*/
    /*
    @After("@AddVacancy")
    public void ApresChaqueScenario() {
        System.out.println("--------Fin de scenario-----------");
    }
     */
}

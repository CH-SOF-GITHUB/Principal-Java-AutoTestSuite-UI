package OrangeHRM.TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/OrangeHRM/Features/EmployeeManagement.feature",
        glue = "OrangeHRM.StepDefinitions",
        tags = "@Logout",
        plugin = {"pretty", "html:target\\cucmber\\rapport.html"}
)
public class Runner {
}

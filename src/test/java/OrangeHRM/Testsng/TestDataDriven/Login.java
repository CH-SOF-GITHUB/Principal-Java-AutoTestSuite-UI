package OrangeHRM.Testsng.TestDataDriven;

import OrangeHRM.Testsng.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login extends Base {

    @DataProvider(name = "ExcelData")
    public Object[][] GetDataFromExcel() {
        ReadExcelFile configuration = new ReadExcelFile("C:\\Users\\chaker\\Desktop\\TestDataLogin.xlsx");
        int rows = configuration.getRowCount(0) - 1;
        Object[][] signin_credentials = new Object[rows][3];
        for (int i = 0; i < rows; i++) {
            signin_credentials[i][0] = configuration.getData(0, i + 1, 0);
            signin_credentials[i][1] = configuration.getData(0, i + 1, 1);
            signin_credentials[i][2] = configuration.getData(0, i + 1, 2);
        }
        return signin_credentials;
    }

    @Test(dataProvider = "ExcelData")
    public void Test_Login(String email, String password, String expectedResult) throws InterruptedException {
        // controle et ouverture un navigateur
        WebDriver driver = getDriver();
        driver.get("https://demo.empire-training.tn/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        // to perform scroll on an application using Selenium
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 400);");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id=\"login-button\"]")).click();
        Thread.sleep(7000);
        if (expectedResult.equals("success")) {
            /* assert success: title page dashboard */
            Assert.assertTrue(driver.getTitle().matches("RH Empire Training - Admin Dashboard"));
        } else {
            /* assert failure: title page login */
            Assert.assertTrue(driver.getTitle().matches("RH Empire Training - Login"));
        }
        System.out.println("Login successful");
    }
}

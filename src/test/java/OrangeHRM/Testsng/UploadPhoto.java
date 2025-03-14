package OrangeHRM.Testsng;

import OrangeHRM.PageModels.LoginPage;
import OrangeHRM.PageModels.PIMPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;

public class UploadPhoto extends Base {

    @Test
    public void TestUploadPhoto() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        PIMPage pimPage = new PIMPage(driver);
        // connecter et rediriger vers le tableau du board
        loginPage.saisirUsername("Admin");
        System.out.println("je saisie username: Admin");
        loginPage.saisirPassword("admin123");
        System.out.println("je saisie password: admin123");
        loginPage.clickLogin();
        System.out.println("je clique sur le bouton Login");
        // attente time de 3s pour charger la page
        Thread.sleep(3000);
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", url);
        pimPage.ClickPIMLink();
        System.out.println("je clique sur PIM en sidebar");
        pimPage.ClickPlusButton();
        System.out.println("je clique sur bouton Add");
        /* cliquer sur le bouton "Ajouter Photo"
        pimPage.ClickAddImageButton(); */
        // localiser l'élément input type="file" et upload photo
        File uploadFile = new File("src/test/resources/Selenium_Logo.png");
        WebElement fileInput = pimPage.getFileInput();
        fileInput.sendKeys(uploadFile.getAbsolutePath());
        // Attendre et vérifier si l'image s'affiche correctement
        WebElement uploadedImage = driver.findElement(By.cssSelector("img.employee-image"));
        if (!(uploadedImage.getAttribute("src").equals("/web/images/default-photo.png"))) {
            System.out.println("upload image avec succès");
        } else {
            System.out.println("échec upload image");
        }
        // System.out.println("Image src: " + uploadedImage.getAttribute("src"));
        // Assert.assertTrue(uploadedImage.isDisplayed());
    }
}

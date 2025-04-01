package OrangeHRM.Testsng.BrowserStack;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BStackDemoTest extends SeleniumTest {
    static {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE); // Cache les logs Selenium sauf erreurs critiques
    }

    // Création du logger
    // private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BStackDemoTest.class);

    @Test
    public void AddProductToCart() throws Exception {
        // navigate to bstackdemo
        driver.navigate().to("https://www.bstackdemo.com/");
        // check the title
        Assert.assertTrue(driver.getTitle().matches("StackDemo"));
        // Save the text of the product for later verify
        String productOnScreenText = driver.findElement(By.xpath("//*[@id=\"1\"]/p")).getText();
        // Click on add to cart button
        driver.findElement(By.xpath("//*[@id=\"1\"]/div[4]")).click();
        // See if the cart is opened or not
        driver.findElement(By.className("float-cart--open")).isDisplayed();
        // Check if the product inside the cart is same as in the main page
        String table_cart_container = driver.findElement(By.className("float-cart__shelf-container")).getText();
        //String productOnCartText = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[2]/div/div[3]/p[1]")).getText();
        Assert.assertTrue(table_cart_container.contains(productOnScreenText));
        System.out.println("produit ajouté avec succès");
    }
}
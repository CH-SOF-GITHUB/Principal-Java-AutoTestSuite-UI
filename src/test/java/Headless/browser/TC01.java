package Headless.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC01 {
    public static void main(String[] args) {
        System.out.println("Open a browser in memory!");

        // Configure Chrome en mode headless
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        // Initialiser le WebDriver
        WebDriver driver = new ChromeDriver(options);

        // Ouvrir une page web
        driver.get("https://www.google.com");

        // Obtenir le titre de la page
        String title = driver.getTitle();
        System.out.println("Headless page web's title: " + title);

        // Fermer le navigateur
        driver.quit();
    }
}

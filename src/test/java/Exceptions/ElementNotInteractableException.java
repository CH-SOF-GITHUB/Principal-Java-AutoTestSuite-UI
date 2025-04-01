package Exceptions;

/*
* How to handle ElementNotInteractable Exception in Selenium
ElementNotInteractableException can only be handled by making the web element to
* be interactable. Different approaches should be implemented to make the web element
* interactable before attempting to interact with it such as scroll until the web element
* is in view, enable the web element if disabled or apply a retry mechanism.
* */

// 1.  Wait for the element to be visible

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ElementNotInteractableException {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ElementNotInteractableException.class);

    static {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE); // Cache les logs Selenium sauf erreurs critiques
    }

    @Test
    public void verifyPageTitleExample1() {
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        // wait implicit time of 2s before generate an exception
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        // Open the webpage
        driver.get("https://www.browserstack.com/");
        // Maximize navigateur Web
        driver.manage().window().maximize();
        // Initialize WebDriverWait with a timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Find the element which may not be interactable
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("signupModalProductButton")));
        // Perform action on the element
        element.click();
        // verify the expected result
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.browserstack.com/users/sign_up", "page title browserstack passed");
        // close the browser
        driver.quit();
    }

    // 2 éme méthode: scroll into the view: make web element visible using javascript
    @Test
    public void verifyPageTitleExample2() {
        // définir selenium web driver
        WebDriver driver = new ChromeDriver();
        // ouvrir la page web
        driver.get("https://www.browserstack.com/");
        // maximize la page web
        driver.manage().window().maximize();
        // attendre implicit wait de 2s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        // définir un web element: bouton Get started free
        WebElement btnSignin = driver.findElement(By.id("signupModalProductButton"));
        // scroll into the view to web element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", btnSignin);
        // click to the button
        btnSignin.click();
        // verifier le résultat attendu
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.browserstack.com/users/sign_up", "page title browserstack passed");
        // close the browser
        driver.quit();
    }

    // Enable the web element
    // if is not enabled and any action performed by Selenium on such elements will throw an exception.
    @Test
    public void verifyPageTitleExample3() {
        // définir selenium web driver
        WebDriver driver = new ChromeDriver();
        // ouvrir la page web
        driver.get("https://www.browserstack.com/");
        // maximize la page web
        driver.manage().window().maximize();
        // attendre implicit wait de 2s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        // définir un web element: bouton Get started free
        WebElement btnSignin = driver.findElement(By.id("signupModalProductButton"));
        // check enabled web element
        if (btnSignin.isEnabled()) {
            // if the element is enabled, perform desired actions
            btnSignin.click();
        } else {
            // if the element is disabled, handle the situation accordingly
            System.out.println("Button Get started free is disabled");
        }
        // verifier le résultat attendu
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.browserstack.com/users/sign_up", "page title browserstack passed");
        // close the browser
        driver.quit();
    }

    // handle overlapping elements
    /*
    In some scenarios, the web element to be interacted with is blocked or overlapped
    by some other elements on the web page.
    The element such as modal dialog or pop-ups which are blocking
    the desired web element should be moved or dismissed from the view.
    Dismissing such overlapping elements is necessary to interact
    with the desired web element.
    * */
    @Test
    public void verifyPageTitleExample4() {
        // définir selenium web driver
        WebDriver driver = new ChromeDriver();
        // ouvrir la page web
        driver.get("https://www.browserstack.com/");
        // maximize la page web
        driver.manage().window().maximize();
        // attendre implicit wait de 2s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        // définir un web element: button products-dd-toggle
        WebElement Products = driver.findElement(By.id("products-dd-toggle"));
        if (Products.isDisplayed()) {
            Products.click();
            driver.findElement(By.xpath("//a[@title='Live']")).click();
        }
        // verifier le résultat attendu
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.browserstack.com/live", "page title browserstack passed");
        // close the browser
        driver.quit();
    }

    // Handle switching to correct frame
    @Test
    public void verifyPageTitleExample5() {
        // définir selenium web driver
        WebDriver driver = new ChromeDriver();
        // ouvrir la page web
        driver.get("https://demoqa.com/frames");
        // maximize la page web
        driver.manage().window().maximize();
        // attendre implicit wait de 2s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        // find the total number of frames
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));
        System.out.println("The total number of iframes are " + frames.size());
        // switch to frame by id
        WebElement iframeElement = driver.findElement(By.id("frame1Wrapper")).findElement(By.tagName("iframe"));
        // Now try to get width and height attributes
        String SrcUrl = iframeElement.getAttribute("src");
        // Switch to the iframe
        driver.switchTo().frame(iframeElement);
        // String height = iframeElement.getAttribute("height");
        // System.out.println("Iframe width: " + width);
        // System.out.println("Iframe height: " + height);
        // vérifier le resultat attendu de frame
        // String srcURL = iframeElement.getAttribute("src");
        Assert.assertEquals(SrcUrl, "https://demoqa.com/sample", "échec affichage frame 1");
        // Switch back to default content after iframe actions
        driver.switchTo().defaultContent();
        System.out.println("test iframe passed");
        // close the browser
        driver.quit();
    }
}

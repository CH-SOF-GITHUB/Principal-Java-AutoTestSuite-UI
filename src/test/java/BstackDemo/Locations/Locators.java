package BstackDemo.Locations;

import org.openqa.selenium.By;

public class Locators {


    // find all locators here
    public By signInLocator = By.id("signin");
    public By LinkNavbar = By.xpath("//div[contains(@class, 'space-x-4')]//a");


    // Selectors for the login page
    public By usernameLocator = By.cssSelector("#username input");
    public By passwordLocator = By.cssSelector("#password input");
    public By loginBtnLocator = By.id("login-btn");

    // error message if login fails
    public By errorMessageLocator = By.className("api-error");

    // message for login success
    public By usernameDashboardLocator = By.className("username");
}

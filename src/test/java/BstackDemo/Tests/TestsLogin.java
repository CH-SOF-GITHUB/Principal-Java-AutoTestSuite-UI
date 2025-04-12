package BstackDemo.Tests;

import BstackDemo.Bases.BaseTest;
import BstackDemo.PageModels.DashboardPage;
import BstackDemo.PageModels.PageHome;
import BstackDemo.PageModels.PageLogin;
import OrangeHRM.PageModels.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestsLogin extends BaseTest {
    // Cache les logs erreurs sauf les erreurs critiques
    static {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }

    @Test
    public void TestLogin1() {
        PageHome pageHome = new PageHome(driver);
        Assert.assertEquals(pageHome.countLinks(), 3, "Number of links an Navbar is not as expected");
        System.out.println("Number of links an Navbar: " + pageHome.countLinks());
        PageLogin pageLogin = pageHome.clickSignInLink();
        System.out.println(pageLogin.getCurrentUrl());
        // enter username and password and click login button
        pageLogin.LoginBstack("demouser", "testingisfun99");
        DashboardPage dashboardPage = pageLogin.visibilityOfUsername();
        System.out.println("username after accessing dashboard: " + dashboardPage.getUsernameText());
        Assert.assertEquals(dashboardPage.getUsernameText(), "demouser", "Error message after login: username is not as expected");
        System.out.println("Login Test passed");
    }

    @Test
    public void TestLoginFails() {
        PageHome pageHome = new PageHome(driver);
        Assert.assertEquals(pageHome.countLinks(), 3, "Number of links an Navbar is not as expected");
        System.out.println("Number of links an Navbar: " + pageHome.countLinks());
        PageLogin pageLogin = pageHome.clickSignInLink();
        System.out.println(pageLogin.getCurrentUrl());
        // enter username and password and click login button
        pageLogin.LoginBstack("locked_user", "testingisfun99");
        Assert.assertEquals(pageLogin.getErrorMessage(), "Your account has been locked.", "Error message after login is not as expected");
        System.out.println("Test login_fails passed");
    }
}

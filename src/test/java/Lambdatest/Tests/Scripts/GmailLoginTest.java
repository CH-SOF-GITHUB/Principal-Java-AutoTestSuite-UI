package Lambdatest.Tests.Scripts;


import Lambdatest.PageObject.GmailHomePage;
import Lambdatest.PageObject.GmailInboxPage;
import Lambdatest.PageObject.GmailLoginPage;
import Lambdatest.TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GmailLoginTest extends TestBase {

    @Test
    public void testGmailLogin() {
        try {
            GmailHomePage gmailHomePage = new GmailHomePage(driver);
            // click to the specify email for next step
            GmailLoginPage gmailLoginPage = gmailHomePage.clickSignInButton();
            // enter the email and password
            gmailLoginPage.enterEmail("chakerbensaid1@gmail.com");
            gmailLoginPage.clickNextButton();
            Thread.sleep(10000);
            gmailLoginPage.enterPassword("ghjt012SZED");
            // click to the next button
            GmailInboxPage gmailInboxPage = gmailLoginPage.clickNextButton();
            // verify the visibility of title of the page
            Assert.assertTrue(gmailInboxPage.visibleGmailTitle());
            // verify the title of the page
            Assert.assertEquals(gmailInboxPage.getGmailTitle(), "Gmail");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

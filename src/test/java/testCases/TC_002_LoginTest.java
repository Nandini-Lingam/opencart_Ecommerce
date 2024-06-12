package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{

    @Test(groups = {"sanity", "master"})
    public void verify_login()
    {
        logger.info("*** Starting TC_002_LoginTest ***");
        try
        {
            //Home Page
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("clicked on my account link on the home page..");
            hp.clickLogin(); //Login link under MyAccount
            logger.info("clicked on login link under myaccount");

            //Login page
            LoginPage lp = new LoginPage(driver);
            lp.enterEmail(p.getProperty("email"));
            lp.enterPass(p.getProperty("password"));
            lp.clickLogin(); //Login button
            logger.info("clicked on login button");


            //My Account Page
            MyAccountPage macc = new MyAccountPage(driver);
            //boolean targetPage=macc.isMyAccountPageExists();
           // Assert.assertTrue(targetPage, "Login failed");

            macc.clickLogout();
        }
        catch(Exception e)
        {
            Assert.fail();
        }
        logger.info("*** Finished TC_002_LoginTest ***");

    }
}

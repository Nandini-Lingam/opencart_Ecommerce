package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)

    public void verify_loginDDT(String email, String Password, String exp) {
        logger.info("*** Starting TC_003_LoginDDT ***");

        try {
            //Home Page
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin(); //Login link under MyAccount

            //Login page
            LoginPage lp = new LoginPage(driver);
            lp.enterEmail(email);
            lp.enterPass(Password);
            lp.clickLogin(); //Login button

            //My Account Page
            MyAccountPage macc = new MyAccountPage(driver);
            boolean targetPage = macc.isMyAccountPageExists();

            if (exp.equalsIgnoreCase("Valid")) {
                if (targetPage == true) {
                    macc.clickLogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }
            if (exp.equalsIgnoreCase("Invalid")) {
                if (targetPage == true) {
                    macc.clickLogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }
        }
        catch(Exception e)
            {
                Assert.fail();
            }
        logger.info("*** Finished TC_003_LoginDDT *** ");
    }

}

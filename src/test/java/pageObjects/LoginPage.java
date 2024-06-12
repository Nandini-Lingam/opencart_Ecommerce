package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{

    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement lEmail;

    @FindBy(xpath = "//input[@id='input-password']") WebElement lPassword;

    @FindBy(xpath = "//input[@value='Login']") WebElement lLogin;


    public void enterEmail(String email)
    {
        lEmail.sendKeys(email);
    }

    public void enterPass(String pswd)
    {
        lPassword.sendKeys(pswd);
    }

    public void clickLogin()
    {
        lLogin.click();
    }

}

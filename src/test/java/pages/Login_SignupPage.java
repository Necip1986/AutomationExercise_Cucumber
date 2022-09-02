package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Login_SignupPage extends CommonPageElements {

    public Login_SignupPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @CacheLookup
    @FindBy(css = "div.login-form h2")
    public WebElement loginToYourAccountMessage;

    @CacheLookup
    @FindBy(css = "div[class='signup-form'] h2")
    public WebElement newUserSignUpHeader;

    @CacheLookup
    @FindBy (xpath = "//input[@data-qa='login-email']")
    public WebElement emailTextBoxForLogin;

    @CacheLookup
    @FindBy(name = "password")
    public WebElement passwordTextBox;

    @CacheLookup
    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginButton;

    @CacheLookup
    @FindBy(name = "name")
    public WebElement nameBox;

    @CacheLookup
    @FindBy(css = "div[class='signup-form'] input[name='email']")
    public WebElement EmailTextBoxForSignUp;

    @CacheLookup
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signUpButton;

    @CacheLookup
    @FindBy(xpath = "//p[contains(text(),'incorrect!')]")
    public WebElement errorMessageForLogin;

    @CacheLookup
    @FindBy(xpath = "//p[contains(text(),'exist!')]")
    public WebElement emailUsedError;

    public void login() {
        emailTextBoxForLogin.sendKeys(ConfigReader.getProperty("valid_email"));
        passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        ReusableMethods.waitFor(1);
        Driver.waitAndClick(loginButton, 2);
        ReusableMethods.waitFor(2);
    }


}

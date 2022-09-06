package stepdefinitions.uiSteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Login_SignupPage;
import pages.SignUpPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Login_Steps {

    Login_SignupPage login_signupPage=new Login_SignupPage();
    SignUpPage signUpPage=new SignUpPage();
    Faker faker=new Faker();

    @Then("Verify -Login to your account- is visible")
    public void verifyLoginToYourAccountIsVisible() {
        Assert.assertTrue(login_signupPage.loginToYourAccountMessage.isDisplayed());
    }

    @Given("Enter correct email address and password {string} , {string}")
    public void enterCorrectEmailAddressAndPassword(String email, String password) {
        Driver.waitAndSendText(login_signupPage.emailTextBoxForLogin, email,2);
        Driver.waitAndSendText(login_signupPage.passwordTextBox, password,2);

    }

    @Given("Enter correct email address and password")
    public void enterCorrectEmailAddressAndPassword() {
        Driver.waitAndSendText(login_signupPage.emailTextBoxForLogin,
                ConfigReader.getProperty("valid_email"),2);
        Driver.waitAndSendText(login_signupPage.passwordTextBox,
                ConfigReader.getProperty("valid_password"),2);
    }

    @And("Click login button")
    public void clickLoginButton() {
        Driver.waitAndClick(login_signupPage.loginButton,3);
    }

    @Given("Enter incorrect email address and password")
    public void enterIncorrectEmailAddressAndPassword() {
        Driver.waitAndSendText(login_signupPage.emailTextBoxForLogin,
                faker.internet().emailAddress(),2);
        Driver.waitAndSendText(login_signupPage.passwordTextBox,
                faker.internet().password(),2);

    }


    @Then("Verify error -Your email or password is incorrect!- is visible")
    public void verifyErrorYourEmailOrPasswordIsIncorrectIsVisible() {
        Assert.assertTrue(login_signupPage.errorMessageForLogin.isDisplayed());
    }

    @When("Click Logout button")
    public void clickLogoutButton() {
        Driver.waitAndClick(login_signupPage.logoutBtn,3);

    }

    @Then("Verify that user is navigated to login page")
    public void verifyThatUserIsNavigatedToLoginPage() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Login to your account"));
    }



}

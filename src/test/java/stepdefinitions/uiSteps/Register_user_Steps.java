package stepdefinitions.uiSteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.apache.commons.math3.linear.ConjugateGradient;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.Login_SignupPage;
import pages.SignUpPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Register_user_Steps {

    Login_SignupPage login_signupPage=new Login_SignupPage();
    SignUpPage signUpPage=new SignUpPage();
    Faker faker=new Faker();


    @When("Navigate to url {string}")
    public void navigate_to_url(String url) {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }

    @Then("Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {

        Assert.assertTrue(Driver.getDriver().getTitle().contains("Automation Exercise"));

    }

    @When("Click on Signup-Login link")
    public void clickOnSignupLoginLink() {
        Driver.waitAndClick(login_signupPage.signInLink,3);
    }

    @Then("Verify {string} is visible")
    public void verifyNewUserSignupIsVisible(String text) {
        Assert.assertTrue(Driver.getDriver().getPageSource().toLowerCase().contains(text.toLowerCase()));
    }

    @When("Enter name and email address")
    public void enter_name_and_email_address() {
        login_signupPage.nameBox.sendKeys(faker.name().username());
        login_signupPage.EmailTextBoxForSignUp.sendKeys(faker.internet().emailAddress());

    }

    @When("Click Signup button")
    public void click_signup_button() {
        login_signupPage.signUpButton.click();

    }

    @Then("Verify that -ENTER ACCOUNT INFORMATION- is visible")
    public void verifyThatENTERACCOUNTINFORMATIONIsVisible() {
        Assert.assertTrue(signUpPage.SignUpPageTitle.isDisplayed());
    }


    @When("Fill details: Title, Name, Email, Password, Date of birth")
    public void fill_details_title_name_email_password_date_of_birth() {
        signUpPage.radioBtnforMr.click();
        signUpPage.passwordTextBox.sendKeys(faker.internet().password());
        Select selectDay=new Select(signUpPage.dayDropdown);
        selectDay.selectByValue("8");
        Select selectMonth=new Select(signUpPage.monthsDropdown);
        selectMonth.selectByVisibleText("January");
        Select selectYear=new Select(signUpPage.yearDropdown);
        selectYear.selectByValue("2002");

    }

    @When("Select checkbox -Sign up for our newsletter!-")
    public void selectCheckboxSignUpForOurNewsletter() {
        Driver.waitAndClick(signUpPage.checkBoxNewsletter,3);

    }

    @And("Select checkbox -Receive special offers from our partners!-")
    public void selectCheckboxReceiveSpecialOffersFromOurPartners() {
        Driver.waitAndClick(signUpPage.checkBoxSpecialOffer,3);
    }

    @When("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void fill_details_first_name_last_name_company_address_address2_country_state_city_zipcode_mobile_number() {
        signUpPage.firstNameTexBox.sendKeys(faker.name().firstName());
        signUpPage.lastNameTexBox.sendKeys(faker.name().lastName());
        signUpPage.companyTexBox.sendKeys(faker.company().name());
        signUpPage.address1TexBox.sendKeys(faker.address().fullAddress());
        signUpPage.address2TexBox.sendKeys(faker.address().secondaryAddress());
        Select selectCountry=new Select(signUpPage.countryDropDown);
        selectCountry.selectByValue("Canada");
        signUpPage.stateTextBox.sendKeys(faker.name().title());
        signUpPage.cityTextBox.sendKeys(faker.name().name());
        signUpPage.zipcodeTextBox.sendKeys(faker.address().zipCode());
        signUpPage.mobileNumberTextBox.sendKeys(faker.phoneNumber().cellPhone());

    }

    @When("Click Create Account button")
    public void clickCreateAccountButton() {
        Driver.waitAndClick(signUpPage.createAccountButton,3);

    }

    @Then("Verify that ACCOUNT CREATED! is visible")
    public void verifyThatACCOUNTCREATEDIsVisible() {
        Assert.assertTrue(signUpPage.accountCreatedMessage.isDisplayed());
    }

    @When("Click Continue button")
    public void clickContinueButton() {
        Driver.waitAndClick(signUpPage.continueButton,2);
        Driver.wait(1);
        Driver.getDriver().navigate().refresh();
    }

    @Then("Verify that -Logged in as username- is visible")
    public void verifyThatLoggedInAsUsernameIsVisible() {
        Driver.waitAndClick(signUpPage.logo,2);
        Assert.assertTrue(signUpPage.loggedInExpression.isDisplayed());
    }


    @When("Click Delete Account button")
    public void click_delete_account_button() {
       // Driver.getDriver().navigate().refresh();

    }

    @Then("Verify that {string} is visible and click Continue button")
    public void verify_that_is_visible_and_click_continue_button(String string) {

    }


    @And("Close driver")
    public void closeDriver() {
        Driver.closeDriver();
    }

    @When("Enter name and already registered email address")
    public void enterNameAndAlreadyRegisteredEmailAddress() {
        Driver.waitAndSendText(login_signupPage.nameBox,
                               faker.name().firstName(),2);
        Driver.waitAndSendText(login_signupPage.EmailTextBoxForSignUp,
                                ConfigReader.getProperty("valid_email"),2);
    }


    @Then("Verify error {string} is visible")
    public void verifyErrorIsVisible(String isTextVisible) {
        Driver.wait(1);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains(isTextVisible));
    }



}

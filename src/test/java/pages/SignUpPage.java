package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import utilities.ReusableMethods;

public class SignUpPage extends CommonPageElements{

    public SignUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @CacheLookup
    @FindBy(xpath = "(//h2[@class='title text-center'])[1]")
    public WebElement SignUpPageTitle;

    @CacheLookup
    @FindBy(id = "id_gender1")
    public WebElement radioBtnforMr;

    @CacheLookup
    @FindBy(id ="id_gender2")
    public WebElement radioBtnforMrs;

    @CacheLookup
    @FindBy(id = "password")
    public WebElement passwordTextBox;

    @CacheLookup
    @FindBy(id = "days")
    public WebElement dayDropdown;

    @CacheLookup
    @FindBy(id = "months")
    public WebElement monthsDropdown;

    @CacheLookup
    @FindBy(id = "years")
    public WebElement yearDropdown;

    @CacheLookup
    @FindBy(id = "newsletter")
    public WebElement checkBoxNewsletter;

    @CacheLookup
    @FindBy(id = "optin")
    public WebElement checkBoxSpecialOffer;

    @CacheLookup
    @FindBy(id = "first_name")
    public WebElement firstNameTexBox;

    @CacheLookup
    @FindBy(id = "last_name")
    public WebElement lastNameTexBox;

    @CacheLookup
    @FindBy(id = "company")
    public WebElement companyTexBox;

    @CacheLookup
    @FindBy(id = "address1")
    public WebElement address1TexBox;

    @CacheLookup
    @FindBy(id = "address2")
    public WebElement address2TexBox;

    @CacheLookup
    @FindBy(id = "country")
    public WebElement countryDropDown;

    @CacheLookup
    @FindBy(id = "state")
    public WebElement stateTextBox;

    @CacheLookup
    @FindBy(id = "city")
    public WebElement cityTextBox;

    @CacheLookup
    @FindBy(id = "zipcode")
    public WebElement zipcodeTextBox;

    @CacheLookup
    @FindBy(id = "mobile_number")
    public WebElement  mobileNumberTextBox;

    @CacheLookup
    @FindBy(xpath = "//button[@data-qa='create-account']")
    public WebElement createAccountButton;

    @CacheLookup
    @FindBy(xpath = "//h2[@class=\"title text-center\"]")
    public WebElement accountCreatedMessage;

    @CacheLookup
    @FindBy(xpath = "//*[@data-qa=\"continue-button\"]")
    public WebElement continueButton;

    public String userAddress;
    public void registerUser(){
        Faker faker=new Faker();
        Login_SignupPage login_signupPage=new Login_SignupPage();

        Driver.waitAndSendText(login_signupPage.nameBox,faker.name().username(),2);
        Driver.waitAndSendText(login_signupPage.EmailTextBoxForSignUp,faker.internet().emailAddress(),2);
        Driver.waitAndClick(login_signupPage.signUpButton,3);
        Driver.wait(2);
        Driver.waitAndClick(radioBtnforMr,3);
        Driver.waitAndSendText(passwordTextBox,faker.internet().password(),2);
        Driver.selectByValue(dayDropdown,"8");
        Driver.selectByVisibleText(monthsDropdown,"January");
        Driver.selectByValue(yearDropdown,"2002");
        Driver.waitAndClick(checkBoxNewsletter,3);
        Driver.waitAndClick(checkBoxSpecialOffer,3);
        Driver.waitAndSendText(firstNameTexBox,faker.name().firstName(),2);
        Driver.waitAndSendText(lastNameTexBox,faker.name().lastName(),2);
        Driver.waitAndSendText(companyTexBox,faker.company().name(),2);

        userAddress=faker.address().fullAddress();

        Driver.waitAndSendText(address1TexBox,userAddress,2);
        Driver.waitAndSendText(address2TexBox,faker.address().secondaryAddress(),2);
        Driver.selectByValue(countryDropDown,"Canada");

        Driver.waitAndSendText(stateTextBox,faker.name().title(),2);
        Driver.waitAndSendText(cityTextBox,faker.name().name(),2);
        Driver.waitAndSendText(zipcodeTextBox,faker.address().zipCode(),2);
        Driver.waitAndSendText(mobileNumberTextBox,faker.phoneNumber().cellPhone(),2);
        Driver.waitAndClick(createAccountButton,3);
        Driver.wait(1);

    }


}

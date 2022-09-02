package stepdefinitions.uiSteps;

import com.github.javafaker.Faker;
import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import pages.ContactUsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class ContactUs_Steps {

    ContactUsPage contactUsPage=new ContactUsPage();
    Faker faker=new Faker();

    @When("Click on Contact Us button")
    public void clickOnContactUsButton() {
        Driver.waitAndClick(contactUsPage.contactUsLink,3);
    }


    @Given("Enter name, email, subject and message")
    public void enterNameEmailSubjectAndMessage() {
        Driver.waitAndSendText(contactUsPage.nameTxtBox,faker.name().firstName(),2);
        Driver.waitAndSendText(contactUsPage.emailTxtBox,faker.internet().emailAddress(),2);
        Driver.waitAndSendText(contactUsPage.subjectTxtBox,faker.book().title(),2);
        Driver.waitAndSendText(contactUsPage.messageTxtArea,faker.ancient().hero(),2);
    }

    @And("Upload file")
    public void uploadFile() {
        Driver.waitAndSendText(contactUsPage.uploadFile, Hooks.path,2);
        Driver.wait(2);
        
    }

    @And("Click Submit button")
    public void clickSubmitButton() {
        ReusableMethods.clickWithJS(contactUsPage.submitBtn);
        Driver.wait(1);
    }

    @And("Click OK button")
    public void clickOKButton() {

        String alertMessage=Driver.getDriver().switchTo().alert().getText();
        System.out.println(alertMessage);
        Driver.getDriver().switchTo().alert().accept();

        Driver.wait(2);

    }

    @Then("Verify success message {string} is visible")
    public void verifySuccessMessageSuccessYourDetailsHaveBeenSubmittedSuccessfullyIsVisible(String text) {
            Assert.assertTrue(Driver.getDriver().getPageSource().contains(text));

    }

    @Then("Click Home button and verify that landed to home page successfully")
    public void clickHomeButtonAndVerifyThatLandedToHomePageSuccessfully() {
        Driver.waitAndClick(contactUsPage.homeBtn,3);
        Driver.wait(1);
        Assert.assertEquals(ConfigReader.getProperty("url"),Driver.getDriver().getCurrentUrl());
    }
}

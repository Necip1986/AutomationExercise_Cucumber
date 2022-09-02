package stepdefinitions.uiSteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPageElements;
import utilities.Driver;

public class Subscription_Steps {

    CommonPageElements commonPageElements=new CommonPageElements();
    Actions actions=new Actions(Driver.getDriver());
    Faker faker=new Faker();

    @When("Scroll down to footer")
    public void scrollDownToFooter() {
        actions.sendKeys(Keys.END).build().perform();
        Driver.wait(1);
    }


    @Then("Verify text {string} is visible")
    public void verifyTextSUBSCRIPTIONIsVisible(String text) {
        Assert.assertEquals(text,commonPageElements.subscriptionHeader.getText().toUpperCase());

    }


    @Given("Enter email address in input and click arrow button")
    public void enterEmailAddressInInputAndClickArrowButton() {
        Driver.waitAndSendText(commonPageElements.subscribeEmailBox,faker.internet().emailAddress(),3);
        Driver.wait(1);
        Driver.waitAndClick(commonPageElements.subscribeButton,2);
    }

    @When("Click Cart button")
    public void clickCartButton() {
        Driver.waitAndClick(commonPageElements.cartLinkOnHeaderMenu,2);
        Driver.wait(1);
    }
}

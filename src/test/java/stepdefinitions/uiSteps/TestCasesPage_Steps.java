package stepdefinitions.uiSteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPageElements;
import utilities.Driver;

public class TestCasesPage_Steps {

    CommonPageElements commonElements=new CommonPageElements();

    @When("Click on Test Cases button")
    public void clickOnTestCasesButton() {
        Driver.waitAndClick(commonElements.testCasesBtn,3);

    }

    @Then("Verify user is navigated to test cases page successfully")
    public void verifyUserIsNavigatedToTestCasesPageSuccessfully() {
        Assert.assertTrue(Driver.getDriver().getPageSource().toUpperCase().contains("TEST CASES"));
    }



}

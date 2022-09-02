package stepdefinitions.uiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;
import utilities.Driver;
import utilities.ReusableMethods;

public class PlaceOrder_Steps {

    HomePage homePage=new HomePage();
    CartPage cartPage=new CartPage();
    SignUpPage signUpPage=new SignUpPage();
    PaymentPage paymentPage=new PaymentPage();
    Login_SignupPage login_signupPage=new Login_SignupPage();

    @When("Add products to cart")
    public void addProductsToCart() {
        Driver.waitAndClick(homePage.addToCartProductList.get(0),3);
    }

    @Then("Verify that cart page is displayed")
    public void verifyThatCartPageIsDisplayed() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("view_cart"));
    }

    @When("Click Proceed To Checkout button")
    public void clickProceedToCheckoutButton() {
        Driver.waitAndClick(cartPage.proceedToCheckoutBtn,2);
        Driver.wait(1);
    }

    @And("Click Register_Login button")
    public void clickRegister_LoginButton() {
        Driver.waitAndClick(cartPage.register_loginLink,2);
        Driver.wait(1);
    }

    @And("Fill all details in Signup and create account")
    public void fillAllDetailsInSignupAndCreateAccount() {
        signUpPage.registerUser();

    }

    @And("Click Cart button on landing page")
    public void clickCartButtonOnLandingPage() {
        Driver.clickWithJS(cartPage.cartLinkOnHeaderMenu);

    }

    @When("Click Proceed To Checkout btn")
    public void clickProceedToCheckoutBtn() {
        Driver.getDriver().navigate().refresh();
        ReusableMethods.hover(cartPage.proceedToCheckoutButon);
        Driver.doubleClick(cartPage.proceedToCheckoutButon);
        Driver.wait(1);
    }


    @Then("Verify {string} and {string} are visible")
    public void verifyAndAreVisible(String text1, String text2) {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains(text1)&
                                   Driver.getDriver().getPageSource().contains(text2)  );
    }

    @And("Enter description in comment text area and click Place Order button")
    public void enterDescriptionInCommentTextAreaAndClickPlaceOrderButton() {
        Driver.waitAndSendText(cartPage.commentTxtArea,"buying product",2);
        Driver.waitAndClick(cartPage.placeOrderBtn,3);

    }

    @And("Enter payment details: Name on Card, Card Number, CVC, Expiration date")
    public void enterPaymentDetailsNameOnCardCardNumberCVCExpirationDate() {
        paymentPage.paymentInfo();
        Driver.wait(2);
    }


    @And("Fill email, password and click Login button")
    public void fillEmailPasswordAndClickLoginButton() {
        login_signupPage.login();
        Driver.getDriver().navigate().refresh();
    }
}

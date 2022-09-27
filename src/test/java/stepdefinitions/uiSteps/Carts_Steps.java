package stepdefinitions.uiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.*;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class Carts_Steps {

    CartPage cartPage=new CartPage();
    ProductsPage productsPage=new ProductsPage();
    ProductDetailPage productDetailPage=new ProductDetailPage();
    Login_SignupPage login_signupPage=new Login_SignupPage();
    HomePage homePage=new HomePage();
    Actions actions=new Actions(Driver.getDriver());

    String  firstProductName;
    int firstProductPrice;
    String secondProductName;
    int secondProductPrice;


    @And("Hover over first product and click Add to cart")
    public void hoverOverFirstProductAndClickAddToCart() {

        firstProductName=productsPage.productsNameList.get(0).getText();
        firstProductPrice=Integer.parseInt(productsPage.productPriceList.get(0).getText().replaceAll("\\D",""));

        actions.moveToElement(productsPage.hiddenPartAddToCart.get(0)).pause(2).build().perform();
        ReusableMethods.waitFor(1);
        Driver.waitAndClick(productsPage.addToCartOnHiddenPart.get(0),2);
        ReusableMethods.waitFor(1);

    }

    @And("Click Continue Shopping button")
    public void clickContinueShoppingButton() {
        Driver.waitAndClick(productsPage.continueShoppingBtn);
        Driver.wait(1);

    }

    @And("Hover over second product and click Add to cart")
    public void hoverOverSecondProductAndClickAddToCart() {
        secondProductName=productsPage.productsNameList.get(1).getText();
        secondProductPrice=Integer.parseInt(productsPage.productPriceList.get(1).getText().replaceAll("\\D",""));

        actions.moveToElement(productsPage.hiddenPartAddToCart.get(1)).pause(2).build().perform();
        ReusableMethods.waitFor(1);
        Driver.waitAndClick(productsPage.addToCartOnHiddenPart.get(1),2);
        ReusableMethods.waitFor(1);
    }

    @And("Click View Cart button")
    public void clickViewCartButton() {
        Driver.waitAndClick(productsPage.viewCartLink,2);
    }

    @Then("Verify both products are added to Cart")
    public void verifyBothProductsAreAddedToCart() {
        String firstProductAtCart=cartPage.productsName.get(0).getText();
        int firstProductPriceAtCart=Integer.parseInt(cartPage.productPriceList.get(0).getText().replaceAll("\\D",""));
        String secondProductAtCart=cartPage.productsName.get(1).getText();
        int secondProductPriceAtCart=Integer.parseInt(cartPage.productPriceList.get(1).getText().replaceAll("\\D",""));

        Assert.assertEquals(firstProductName,firstProductAtCart);
        Assert.assertEquals(firstProductPrice,firstProductPriceAtCart);
        Assert.assertEquals(secondProductName,secondProductAtCart);
        Assert.assertEquals(secondProductPrice,secondProductPriceAtCart);
    }

    String qtty;

    @When("Increase quantity to {string}")
    public void increaseQuantityTo(String quantity) {
        qtty=quantity;
        productDetailPage.quantityBox.clear();
        Driver.wait(1);
        Driver.waitAndSendText(productDetailPage.quantityBox,quantity,2);
        Driver.wait(1);
    }

    @And("Click Add to cart button")
    public void clickAddToCartButton() {
        Driver.waitAndClick(productDetailPage.addToCartBtn,2);
        Driver.wait(1);
    }

    @Then("Verify that product is displayed in cart page with exact quantity")
    public void verifyThatProductIsDisplayedInCartPageWithExactQuantity() {
        Assert.assertEquals(qtty,cartPage.productsQuantity.get(0).getText());
    }

    @When("Click X button corresponding to particular product")
    public void clickXButtonCorrespondingToParticularProduct() {
        Driver.waitAndClick(cartPage.removeBtn,3);
    }

    @Then("Verify that product is removed from the cart")
    public void verifyThatProductIsRemovedFromTheCart() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Cart is empty!"));
    }

    List<String> productNames;
    @When("Add those products to cart")
    public void addThoseProductsToCart() {

        productNames=new ArrayList<>();
        for(int i=0; i<productsPage.productsNameList.size();i++){
            productNames.add(productsPage.productsNameList.get(i).getText());
            productsPage.addToCart.get(i).click();
            ReusableMethods.waitFor(1);
            productsPage.continueShoppingBtn.click();
            Driver.wait(2);
        }

    }

    @Then("Click Cart button and verify that products are visible in cart")
    public void clickCartButtonAndVerifyThatProductsAreVisibleInCart() {
        Driver.waitAndClick(productsPage.cartLinkOnHeaderMenu,3);
        List<String > addedProductNamesBeforeSignIn=new ArrayList<>();
        for(int i=0; i<cartPage.productsName.size();i++){
            addedProductNamesBeforeSignIn.add(cartPage.productsName.get(i).getText());
        }
        System.out.println("before signin "+addedProductNamesBeforeSignIn);

        Assert.assertEquals(addedProductNamesBeforeSignIn,productNames);
    }

    @Then("Click Signup-Login button and submit login details")
    public void clickSignupLoginButtonAndSubmitLoginDetails() {
        Driver.waitAndClick(cartPage.signInLink,3);
        Driver.wait(1);
        login_signupPage.login();
    }


    @And("Again, go to Cart page")
    public void againGoToCartPage() {
        Driver.waitAndClick(productsPage.cartLinkOnHeaderMenu1,3);
    }

    @Then("Verify that those products are visible in cart after login as well")
    public void verifyThatThoseProductsAreVisibleInCartAfterLoginAsWell() {

        List<String > addedProductNamesAfterSignIn=new ArrayList<>();
        for(int i=0; i<cartPage.productsNameList.size();i++){
            addedProductNamesAfterSignIn.add(cartPage.productsNameList.get(i).getText());
        }

        System.out.println("after signin "+addedProductNamesAfterSignIn);


        Assert.assertEquals(productNames,addedProductNamesAfterSignIn);

    }

    @When("Scroll to bottom of page")
    public void scrollToBottomOfPage() {
        ReusableMethods.hover(homePage.recommendedItemsHeader);
        Driver.wait(2);

    }
    private int ne=0;


    @And("Click on Add To Cart on Recommended product")
    public void clickOnAddToCartOnRecommendedProduct() {
        Driver.waitAndClick(homePage.addToCartRecommendedItems.get(0),3);
        Driver.wait(2);
    }

    @And("Click on View Cart button")
    public void clickOnViewCartButton() {
        Driver.waitAndClick(homePage.cartLinkOnHeaderMenu,3);
        Driver.wait(2);

    }

    @Then("Verify that product is displayed in cart page")
    public void verifyThatProductIsDisplayedInCartPage() {
        String recProductOnCart=cartPage.productsNameList.get(0).getText();
        Assert.assertEquals("Blue Top",recProductOnCart);
    }


}

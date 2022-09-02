package stepdefinitions.uiSteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductsPage;
import utilities.Driver;

public class Products_Steps {
    
    ProductsPage productsPage=new ProductsPage();
    ProductDetailPage productDetailPage=new ProductDetailPage();
    Faker faker=new Faker();

    @When("Click on Products button")
    public void clickOnProductsButton() {
        Driver.waitAndClick(productsPage.productsBtn,3);
        Driver.wait(1);
    }

    @Then("Verify user is navigated to ALL PRODUCTS page successfully")
    public void verifyUserIsNavigatedToALLPRODUCTSPageSuccessfully() {

        Assert.assertTrue(Driver.getDriver().getPageSource().toUpperCase().contains("ALL PRODUCTS"));
    }

    @When("Click on View Product of first product")
    public void clickOnViewProductOfFirstProduct() {
        Driver.waitAndClick(productsPage.viewProductsList.get(0),2);
        Driver.wait(1);
    }

    @Then("Verify user is landed to product detail page")
    public void verifyUserIsLandedToProductDetailPage() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Product Details"));

    }

    @Then("Verify that detail detail is visible: product name, category, price, availability, condition, brand")
    public void verifyThatDetailDetailIsVisibleProductNameCategoryPriceAvailabilityConditionBrand() {
        Assert.assertTrue(productDetailPage.productName.isDisplayed()&
                productDetailPage.productCategoryInfo.isDisplayed()&
                productDetailPage.productPriceInfo.isDisplayed()&
                productDetailPage.productAvailabilityInfo.isDisplayed()&
                productDetailPage.productConditionInfo.isDisplayed()&
                productDetailPage.productBrandName.isDisplayed());

    }

    @When("Enter product name in search input and click search button")
    public void enterProductNameInSearchInputAndClickSearchButton() {
        Driver.waitAndSendText(productsPage.searchBox,"Blue",2);
        Driver.waitAndClick(productsPage.searchButton,3);
        Driver.wait(1);
    }

    @Then("Verify all the products related to search are visible")
    public void verifyAllTheProductsRelatedToSearchAreVisible() {

        int count=0;
        for(int i=0; i<productsPage.productsNameList.size();i++){
            if(productsPage.productsNameList.get(i).getText().toLowerCase().contains("blue")){

            }else{
                count++;
            }
        }
        System.out.println(count);
        Assert.assertTrue(count==0);

    }

    @Then("Verify that categories are visible on left side bar")
    public void verifyThatCategoriesAreVisibleOnLeftSideBar() {
        Assert.assertEquals("CATEGORY",productsPage.categoryHeaderLeftSideBar.getText());
    }

    @When("Click on Women category")
    public void clickOnWomenCategory() {
        Driver.waitAndClick(productsPage.categoryTypesWomen,3);
        Driver.wait(1);

    }

    @And("Click on any category link under Women category, for example: Dress")
    public void clickOnAnyCategoryLinkUnderWomenCategoryForExampleDress() {
        Driver.waitAndClick(productsPage.subCategoriesOfWomen.get(0),3);
        Driver.wait(2);

    }

    @Then("Verify that category page is displayed and confirm text {string}")
    public void verifyThatCategoryPageIsDisplayedAndConfirmTextWOMENTOPSPRODUCTS(String text) {
        Assert.assertTrue(Driver.getDriver().getPageSource().toUpperCase().contains(text));
    }

    String chosensubCategoryofMen;

    @When("On left side bar, click on any sub-category link of Men category")
    public void onLeftSideBarClickOnAnySubCategoryLinkOfMenCategory() {
        Driver.waitAndClick(productsPage.categoryTypesMen,3);
        Driver.wait(1);
        chosensubCategoryofMen=productsPage.subCategoriesOfMen.get(0).getText().toLowerCase();
        Driver.waitAndClick(productsPage.subCategoriesOfMen.get(0),3);
        Driver.wait(2);
    }

    @Then("Verify that user is navigated to that category page")
    public void verifyThatUserIsNavigatedToThatCategoryPage() {

        Assert.assertTrue(Driver.getDriver().getPageSource().toLowerCase().contains(chosensubCategoryofMen));

    }

    @Then("Verify that Brands are visible on left side bar")
    public void verifyThatBrandsAreVisibleOnLeftSideBar() {
        Assert.assertTrue(productsPage.brandHeaderLeftSideBar.isDisplayed());
    }

    String chosenBrandName;
    @When("Click on any brand name")
    public void clickOnAnyBrandName() {
        chosenBrandName=productsPage.brandNameList.get(0).getText().toLowerCase().replaceAll("[^a-zA-Z]","");
        Driver.waitAndClick(productsPage.brandNameList.get(0),3);
        Driver.wait(2);
    }

    @Then("Verify that user is navigated to brand page and brand products are displayed")
    public void verifyThatUserIsNavigatedToBrandPageAndBrandProductsAreDisplayed() {

        Assert.assertTrue(productsPage.brandHeaderOnCenter.getText().toLowerCase().contains(chosenBrandName));
    }

    String chosenBrandName2;
    @And("On left side bar, click on any other brand link")
    public void onLeftSideBarClickOnAnyOtherBrandLink() {

        chosenBrandName2=productsPage.brandNameList1.get(2).getText().toLowerCase().replaceAll("[^a-zA-Z]","");
        Driver.waitAndClick(productsPage.brandNameList1.get(2),3);
        Driver.wait(2);

    }

    @Then("Verify that user is navigated to that brand page and can see products")
    public void verifyThatUserIsNavigatedToThatBrandPageAndCanSeeProducts() {
        Assert.assertTrue(productsPage.brandHeaderOnCenter1.getText().toLowerCase().contains(chosenBrandName2));


    }

    @And("Click on View Product button")
    public void clickOnViewProductButton() {
        Driver.waitAndClick(productsPage.viewProductsList.get(0),3);
        Driver.wait(2);
    }

    @When("Enter name, email and review")
    public void enterNameEmailAndReview() {
        Driver.waitAndSendText(productDetailPage.nameTxtBox,faker.name().fullName(),3);
        Driver.waitAndSendText(productDetailPage.emailTxtBox,faker.internet().emailAddress(),3);
        Driver.waitAndSendText(productDetailPage.reviewTxtArea,faker.book().title(),3);
        Driver.wait(2);
    }

    @And("Click submit button")
    public void clickSubmitButton() {

        Driver.waitAndClick(productDetailPage.submitReviewBtn,3);
    }
}

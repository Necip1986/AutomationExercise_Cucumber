package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProductDetailPage extends CommonPageElements {

    public ProductDetailPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @CacheLookup
    @FindBy(css = "div.product-information span span")
    public WebElement productPriceInfo;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-information']/p[contains(text(),'Category')]")
    public WebElement productCategoryInfo;

    @CacheLookup
    @FindBy(css = "div.product-information h2")
    public WebElement productName;

    @CacheLookup
    @FindBy (xpath = "//div[@class='product-information']/p/b[text()='Availability:']")
    public WebElement productAvailabilityInfo;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-information']/p/b[text()='Condition:']")
    public WebElement productConditionInfo;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-information']/p/b[text()='Brand:']")
    public WebElement productBrandName;

    @CacheLookup
    @FindBy(xpath = "//title[contains(text(),'Product Details')]")
    public WebElement productDetailsPageTitle;

    @CacheLookup
    @FindBy(id = "quantity")
    public WebElement quantityBox;

    @CacheLookup
    @FindBy(css = "button i[class='fa fa-shopping-cart']")
    public WebElement addToCartBtn;

    @CacheLookup
    @FindBy (css = "div.modal-content u")
    public WebElement viewCartLink;

    @CacheLookup
    @FindBy(id = "name")
    public WebElement nameTxtBox;

    @CacheLookup
    @FindBy(id = "email")
    public WebElement emailTxtBox;

    @CacheLookup
    @FindBy(id = "review")
    public WebElement reviewTxtArea;

    @CacheLookup
    @FindBy(id = "button-review")
    public WebElement submitReviewBtn;

    @CacheLookup
    @FindBy(xpath = "//*[contains(text(),'Thank you for your review.')]")
    public WebElement reviewSubmittedMessage;

    @CacheLookup
    @FindBy(css = "a[data-toggle='tab']")
    public WebElement writeYourReviewHeader;









}

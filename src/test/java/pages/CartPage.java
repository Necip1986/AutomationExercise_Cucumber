package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CartPage extends CommonPageElements{

    public CartPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @CacheLookup
    @FindBy(xpath = "//footer[@id='footer']//h2")
    public WebElement subscriptionHeader;

    @CacheLookup
    @FindBy (id = "susbscribe_email")
    public WebElement subscribeEmailBox;

    @CacheLookup
    @FindBy(id = "subscribe")
    public WebElement subscribeButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert-success alert']")
    public WebElement subscribedSuccessfullyMessage;

    @CacheLookup
    @FindBy(css = "tbody tr td h4 a")
    public List<WebElement>productsName;

    @CacheLookup
    @FindBy(css = "tbody tr td h4 a")
    public List<WebElement>productsNameList;

    @CacheLookup
    @FindBy(css = "tbody tr td[class='cart_price']")
    public List<WebElement>productPriceList;

    @CacheLookup
    @FindBy(css = "tbody tr td[class='cart_quantity']")
    public List<WebElement>productsQuantity;

    @CacheLookup
    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    public WebElement proceedToCheckoutBtn;

    @CacheLookup
    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    public WebElement proceedToCheckoutButon;

    @CacheLookup
    @FindBy(css = "div.modal-content u")
    public WebElement register_loginLink;

    @CacheLookup
    @FindBy(css = "ul#address_delivery")
    public WebElement deliveryAddressDetail;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Review Your Order')]")
    public WebElement reviewYourOrderHeader;

    @CacheLookup
    @FindBy(css = "textarea.form-control")
    public WebElement commentTxtArea;

    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    public WebElement placeOrderBtn;

    @CacheLookup
    @FindBy (css = "li.active")
    public WebElement shoppingCartExpression;

    @CacheLookup
    @FindBy (css = "i[class='fa fa-times']")
    public WebElement removeBtn;

    @CacheLookup
    @FindBy(id = "empty_cart")
    public WebElement cartEmptyExpression;

    @CacheLookup
    @FindBy(xpath = "//ul[@id='address_invoice']")
    public WebElement invoiceAddress;










}

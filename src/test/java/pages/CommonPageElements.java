package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CommonPageElements {


    public CommonPageElements(){

        PageFactory.initElements(Driver.getDriver(),this);
    }


    @CacheLookup
    @FindBy(xpath = "//div[@class=\"logo pull-left\"]")
    public WebElement logo;

    @FindBy (xpath = "(//input[@name='email'])[2]")
    public WebElement signUpEmailBox;


    @CacheLookup
    @FindBy(xpath = "//i[@class='fa fa-user']")
    public WebElement loggedInExpression;

    @CacheLookup
    @FindBy(css = "a i[class='fa fa-lock']")
    public WebElement signInLink;

    @CacheLookup
    @FindBy(css = "div i[class='fa fa-lock']")
    public WebElement logoutBtn;

    @CacheLookup
    @FindBy(css = "span i[class='fa fa-angle-double-left']")
    public WebElement homeBtn;

    @CacheLookup
    @FindBy(css = "div i[class='fa fa-envelope']")
    public WebElement contactUsLink;

    @CacheLookup
    @FindBy(xpath = "//button[@class='btn btn-success' and text()='Test Cases']")
    public WebElement testCasesBtn;

    @CacheLookup
    @FindBy(css = "i[class='material-icons card_travel']")
    public WebElement productsBtn;

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
    @FindBy(xpath = "//div[@class='shop-menu pull-right']//li//a[@href='/view_cart']//i")
    public WebElement cartLinkOnHeaderMenu;

    @CacheLookup
    @FindBy(xpath = "//div[@class='shop-menu pull-right']//li//a[@href='/view_cart']//i")
    public WebElement cartLinkOnHeaderMenu1;

    @CacheLookup
    @FindBy(xpath = "//div[@class='left-sidebar']/h2")
    public WebElement categoryHeaderLeftSideBar;

    @CacheLookup
    @FindBy(xpath = "//div[@id='accordian']//div[@class='panel panel-default']//i")
    public List<WebElement> categoryTypes;

    @CacheLookup
    @FindBy(xpath = "//div[@class='brands_products']//h2")
    public WebElement brandHeaderLeftSideBar;




}

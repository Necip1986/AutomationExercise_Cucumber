package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HomePage extends CommonPageElements{

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='productinfo text-cente']//a[@class='btn btn-default add-to-cart']")
    public List<WebElement> addToCartProductList;

    @CacheLookup
    @FindBy (css = "button[class='btn btn-success close-modal btn-block']")
    public WebElement continueShoppingBtn;

    @CacheLookup
    @FindBy(xpath = "//div[@class='recommended_items']/h2")
    public WebElement recommendedItemsHeader;

    @CacheLookup
    @FindBy(xpath = "//div[@class='recommended_items']//a//i[@class='fa fa-shopping-cart']")
    public List<WebElement> addToCartRecommendedItems;

    @CacheLookup
    @FindBy(css = "div[id='recommended-item-carousel'] div[class='single-products'] p")
    public List<WebElement> recommendedItemName;

    @CacheLookup
    @FindBy(xpath = "//div[@id='recommended-item-carousel']//div[@class='single-products']//p")
    public List<WebElement> recommendedItemName1;


}

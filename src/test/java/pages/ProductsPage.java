package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ProductsPage extends CommonPageElements {

    public ProductsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @CacheLookup
    @FindBy(css = "div.features_items h2[class='title text-center']")
    public WebElement allProductsHeader;

    @CacheLookup
    @FindBy(css = "i[class='fa fa-plus-square']")
    public List<WebElement>viewProductsList;

    @CacheLookup
    @FindBy(xpath = "//div[@class='productinfo text-center']//p")
    public List<WebElement>productsNameList;

    @CacheLookup
    @FindBy(xpath = "//div[@class='single-products']//div[@class='productinfo text-center']//h2")
    public List<WebElement> productPriceList;

    @CacheLookup
    @FindBy(id = "search_product")
    public WebElement searchBox;

    @CacheLookup
    @FindBy(id = "submit_search")
    public WebElement searchButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='features_items']/h2")
    public WebElement searchedProductHeader;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-overlay']//a")
    public List<WebElement> addToCartOnHiddenPart;

    @CacheLookup
    @FindBy(xpath = "//div[@class='productinfo text-center']/a/i")
    public List<WebElement>addToCart;

    @CacheLookup
    @FindBy (css = "button[class='btn btn-success close-modal btn-block']")
    public WebElement continueShoppingBtn;

    @CacheLookup
    @FindBy(css = "div.modal-content a")
    public WebElement viewCartLink;

    @CacheLookup
    @FindBy (css = "div.product-image-wrapper")
    public List<WebElement> hiddenPartAddToCart;

    @CacheLookup
    @FindBy(xpath = "//div[@id='accordian']//div[@class='panel panel-default']//i")
    public List<WebElement> categoryTypes;

    @CacheLookup
    @FindBy(xpath = "(//div[@id='accordian']//div[@class='panel panel-default']//i)[1]")
    public WebElement categoryTypesWomen;

    @CacheLookup
    @FindBy(xpath = "(//div[@id='accordian']//div[@class='panel panel-default']//i)[2]")
    public WebElement categoryTypesMen;

    @CacheLookup
    @FindBy(xpath = "//div[@id='Women']//a")
    public List<WebElement> subCategoriesOfWomen;

    @CacheLookup
    @FindBy(xpath = "//div[@id='Men']//a")
    public List<WebElement> subCategoriesOfMen;

    @CacheLookup
    @FindBy(xpath = "//h2[text()='Women - Dress Products']")
    public WebElement womenCategoryTitle;

    @CacheLookup
    @FindBy(xpath = "//div[@class='brands-name']//ul//li")
    public List<WebElement> brandNameList;

    @CacheLookup
    @FindBy(xpath = "//div[@class='brands-name']//ul//li")
    public List<WebElement> brandNameList1;

    @CacheLookup
    @FindBy(css = "h2[class='title text-center']")
    public WebElement brandHeaderOnCenter;

    @CacheLookup
    @FindBy(css = "h2[class='title text-center']")
    public WebElement brandHeaderOnCenter1;








}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PaymentPage extends CommonPageElements {


    public PaymentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @CacheLookup
    @FindBy(name = "name_on_card")
    public WebElement nameOnCardTxtBox;

    @CacheLookup
    @FindBy(name = "card_number")
    public WebElement cardNumberTxtBox;

    @CacheLookup
    @FindBy(name = "cvc")
    public WebElement cvcTxtBox;

    @CacheLookup
    @FindBy(name = "expiry_month")
    public WebElement expirationMonthTxtBox;

    @CacheLookup
    @FindBy(name = "expiry_year")
    public WebElement expiryYearTxtBox;

    @CacheLookup
    @FindBy(id = "submit")
    public WebElement pay_confirmBtn;

    @CacheLookup
    @FindBy(css = "div#success_message div[class='alert-success alert'")
    public WebElement orderPlacedSuccessfullyMes;

    @CacheLookup
    @FindBy(css = "a[data-qa='continue-button']")
    public WebElement continueBtn;

    @CacheLookup
    @FindBy(xpath = "//p[@style='font-size: 20px; font-family: garamond;']")
    public WebElement orderPlacedSuccessfullyMessage;

    @CacheLookup
    @FindBy (xpath = "//a[text()='Download Invoice']")
    public WebElement downloadInvoiceBtn;

    public void paymentInfo(){

        Driver.getDriver().navigate().refresh();
        Driver.waitAndSendText(nameOnCardTxtBox,"Yunus",3);
        Driver.waitAndSendText(cardNumberTxtBox,"1234562345667",3);
        Driver.waitAndSendText(cvcTxtBox,"511",3);
        Driver.waitAndSendText(expirationMonthTxtBox,"January",3);
        Driver.waitAndSendText(expiryYearTxtBox,"2000",3);
        Driver.waitAndClick(pay_confirmBtn,3);

    }




}

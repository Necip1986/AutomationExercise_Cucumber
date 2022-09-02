package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ContactUsPage extends CommonPageElements {

    public ContactUsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @CacheLookup
    @FindBy(xpath = "//i[@class='fa fa-envelope']")
    public WebElement contactUsLink;

    @CacheLookup
    @FindBy(name = "name")
    public WebElement nameTxtBox;

    @CacheLookup
    @FindBy(name = "email")
    public WebElement emailTxtBox;

    @CacheLookup
    @FindBy(name = "subject")
    public WebElement subjectTxtBox;

    @CacheLookup
    @FindBy(id = "message")
    public WebElement messageTxtArea;

    @CacheLookup
    @FindBy(name = "upload_file")
    public WebElement uploadFile;

    @CacheLookup
    @FindBy(name = "submit")
    public WebElement submitBtn;

    @CacheLookup
    @FindBy (xpath = "//div[contains(text(),'Success!')]")
    public WebElement successfullySubmittedMessage;




}

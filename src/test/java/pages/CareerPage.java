package pages;

import dev.failsafe.internal.util.DelegatingScheduler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumHelper;
import utils.TestData;

public class CareerPage extends BasePage{

    public CareerPage(WebDriver driver) {
        super(driver);
    }

    public String careerUrl = TestData.BASE_URL + "career/";

    @FindBy(xpath = "//div[@class='col-lg-10']/h4")
    WebElement careerMotto;

    @FindBy(xpath = "//div[contains(@class,'offer-show')]")
    WebElement careerItem;

    @FindBy(xpath = "//div[@class='career-item-title']/h4")
    WebElement careerTitle;

    @FindBy(xpath = "//div[@class='offer-modal--title']/h4")
    WebElement careerTitleInJobOffer;

    @FindBy(xpath = "//label[contains(text(),'CV')]")
    WebElement uploadCVButton;

    @FindBy(xpath = "//ul[contains(@class,'list-textSecondary')]")
    WebElement listOfRequirements;

    @FindBy(xpath = "//div[@class='offer-modal--benefits']")
    WebElement benefits;

    @FindBy(xpath = "//button[contains(text(),'Apply')]")
    WebElement applyButton;

    @FindBy(xpath="//input[@name='offer-email']")
    WebElement offerEmail;

    @FindBy(name="offer-cv")
    WebElement offerCV;

    @FindBy(xpath = "//label[@for='offer-regulamin-1']")
    WebElement acceptTerms;

    @FindBy(xpath="//h4[contains(text(),'Your application has been sent')]")
    WebElement applicationSent;

    @FindBy(xpath = "//div[@class='offer-modal--cv-dropzone error']")
    WebElement cvError;

    @FindBy(xpath = "//input[contains(@class,'error')]")
    WebElement emailError;

    public WebElement getCvError() {
        return cvError;
    }

    public WebElement getEmailError() {
        return emailError;
    }

    public WebElement getApplicationSent() {
        return applicationSent;
    }

    public WebElement getCareerTitle() {
        return careerTitle;
    }

    public WebElement getCareerTitleInJobOffer() {
        return careerTitleInJobOffer;
    }
    public String getCareerMottoText() {return careerMotto.getText().trim();}

    public CareerPage clickOnCareerItem() {
        careerItem.click();
        return this;
    }

    public String getTitle(WebElement element) {
        return element.getText();
    }

    public Boolean verifyElements() {
        if ((uploadCVButton.isDisplayed() &&
        listOfRequirements.isDisplayed() &&
        benefits.isDisplayed()&&
        applyButton.isDisplayed())) {
            return true;
        } else {
            return false;
        }


    }

    public CareerPage sendCV(String email, String cvPath){
        offerEmail.sendKeys(email);
        offerCV.sendKeys(cvPath);
        acceptTerms.click();
        applyButton.click();
        return this;
    }
    public CareerPage sendNoCV(String email){
        offerEmail.sendKeys(email);
        acceptTerms.click();
        applyButton.click();
        return this;
    }
}

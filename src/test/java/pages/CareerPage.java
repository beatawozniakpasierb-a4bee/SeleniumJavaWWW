package pages;

import dev.failsafe.internal.util.DelegatingScheduler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumHelper;
import utils.TestData;

import static utils.TestData.BASE_URL;

public class CareerPage extends BasePage{

    public CareerPage(WebDriver driver, String url) {
        super(driver, url);
        footer = new FooterPage(driver);
        upperBarMenuPage = new UpperBarMenuPage(driver);
    }

    @FindBy(xpath = "//div[@class='col-lg-10']/h4")
    public WebElement careerMotto;

    @FindBy(xpath = "//div[contains(@class,'offer-show')]")
    private WebElement careerItem;

    @FindBy(xpath = "//div[@class='career-item-title']/h4")
    private WebElement careerTitle;

    @FindBy(xpath = "//div[@class='offer-modal--title']/h4")
    private WebElement careerTitleInJobOffer;

    @FindBy(xpath = "//label[contains(text(),'CV')]")
    private WebElement uploadCVButton;

    @FindBy(xpath = "//ul[contains(@class,'list-textSecondary')]")
    private WebElement listOfRequirements;

    @FindBy(xpath = "//div[@class='offer-modal--benefits']")
    private WebElement benefits;

    @FindBy(xpath = "//button[contains(text(),'Apply')]")
    private WebElement applyButton;

    @FindBy(xpath="//input[@name='offer-email']")
    private WebElement offerEmail;

    @FindBy(name="offer-cv")
    private WebElement offerCV;

    @FindBy(xpath = "//label[@for='offer-regulamin-1']")
    private WebElement acceptTerms;

    @FindBy(xpath="//h4[contains(text(),'Your application has been sent')]")
    private WebElement applicationSent;

    @FindBy(xpath = "//div[@class='offer-modal--cv-dropzone error']")
    private WebElement cvError;

    @FindBy(xpath = "//input[contains(@class,'error')]")
    private WebElement emailError;

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

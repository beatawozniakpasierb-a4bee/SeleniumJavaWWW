package pages;

import models.ContactDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {

    public FooterPage footer;

    public HomePage(WebDriver driver) {
        super(driver);
        footer = new FooterPage(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@placeholder='Company e-mail']")
    private WebElement emailInput;

    @FindBy(xpath = "//textarea[@placeholder='Project description']")
    private WebElement descriptionInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitContactForm;

    @FindBy(xpath = "//label[@for='footer-regulamin']/span")
    private WebElement acceptTerms;

    @FindBy(xpath = "//input[contains(@class,'error')]")
    private List<WebElement> inputErrors;

    @FindBy(xpath = "//h4[@class='my-4']")
    private WebElement messageSentInfo;

    @FindBy(className = "lets-talk-box--plus")
    public WebElement letsTalkBox;

    @FindBy(xpath = "//div[@class='contact-us']/button[@type='button']")
    public WebElement contactUsButton;

    public HomePage clickContactUs(){
        contactUsButton.click();
        return this;
    }

    public WebElement getMessageSentInfo() {
        return messageSentInfo;
    }

    public Integer getInputErrors() {
        return inputErrors.size();
    }

    public void setNameInput(String name) {
        nameInput.sendKeys(name);
    }

    public void setEmailInput(String email) {
        emailInput.sendKeys(email);
    }

    public void setDescriptionInput(String description) {
        descriptionInput.sendKeys(description);
    }

    public void setAcceptTerms() {
        if (!acceptTerms.isSelected()) {
            acceptTerms.click();
        }
    }

    public void sendForm() {
        submitContactForm.click();
    }

    public void fillContactForm(WebElement contactElement, String name, String email, String description) {
        contactElement.click();
        setNameInput(name);
        setEmailInput(email);
        setDescriptionInput(description);
        setAcceptTerms();
        sendForm();
    }

    public void fillContactForm2(ContactDetails contactDetails) {
        nameInput.sendKeys(contactDetails.getName());
        emailInput.sendKeys(contactDetails.getEmail());
        descriptionInput.sendKeys(contactDetails.getDescription());
        setAcceptTerms();
        sendForm();
    }

    public String getMessageSentText() {
        return messageSentInfo.getText();
    }

}

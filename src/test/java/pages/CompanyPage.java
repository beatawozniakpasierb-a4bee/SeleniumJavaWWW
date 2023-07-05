package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CompanyPage extends BasePage {

    public CompanyPage(WebDriver driver, String url) {
        super(driver, url);
        upperBarMenuPage = new UpperBarMenuPage(driver);
        footer = new FooterPage(driver);
    }

    @FindBy(xpath = "//div[@class='col-lg-4']/h4")
    public WebElement companyMotto;

    @FindBy(xpath = "//div[contains(@class,'tns-slide-active')]")
    private List<WebElement> staffSlide;

    @FindBy(xpath = "//div[@class='hr-item--info']/p")
    private List<WebElement> staffNamesSlide;

    @FindBy(xpath = "//a[contains(@href,'@a4bee.com')]")
    private WebElement staffEmail;

    @FindBy(xpath = "//div[contains(@class,'bio-modal--close')]")
    private WebElement closeStaffModal;

    public WebElement getStaffEmail() {
        return staffEmail;
    }

    public Integer getStaffSlideSize() { return staffSlide.size();}

    public String clickOnStaff() {
        int i = 1;
        String email = null;
        while (i < 4) {
            staffSlide.get(i).click();
            email = staffEmail.getText();
            closeStaffModal.click();
            i++;
        }
        return email;
    }
}

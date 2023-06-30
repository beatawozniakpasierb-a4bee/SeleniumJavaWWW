package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.FooterData;
import utils.TestData;

import java.util.List;

public class CompanyPage extends BasePage {

    public UpperBarMenuPage upperBarMenuPage;
    public FooterPage footer;

    public CompanyPage(WebDriver driver) {
        super(driver);
        upperBarMenuPage = new UpperBarMenuPage(driver);
        footer = new FooterPage(driver);
    }

    public String companyUrl = TestData.BASE_URL + "company/";

    @FindBy(xpath = "//div[@class='col-lg-4']/h4")
    WebElement companyMotto;

    @FindBy(xpath = "//div[contains(@class,'tns-slide-active')]")
    List<WebElement> staffSlide;

    @FindBy(xpath = "//div[@class='hr-item--info']/p")
    List<WebElement> staffNamesSlide;

    @FindBy(xpath = "//a[contains(@href,'@a4bee.com')]")
    WebElement staffEmail;

    @FindBy(xpath = "//div[contains(@class,'bio-modal--close')]")
    WebElement closeStaffModal;

    public WebElement getStaffEmail() {
        return staffEmail;
    }

    public String getCompanyMottoText() {
        return companyMotto.getText().trim();
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

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumHelper;
import utils.TestData;

import java.util.List;
import java.util.stream.Collectors;

public class CompanyPage {

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

    @FindBy(xpath = "//button[@id='tech_hive--prev']")
    WebElement nextButtonStaff;

    public List<String> getStaffRoles() {
        return staffNamesSlide.stream()
                .map(el -> el.getText())
                .filter(el -> !el.isEmpty())
                .collect(Collectors.toList());
    }

    public String getCompanyMottoText() {
        return companyMotto.getText().trim();
    }

    public Integer getStaffSlideSize() { return staffSlide.size();}

    public void clickOnStaff(WebDriver driver) {
        int i = 1;
        while (i<getStaffSlideSize()) {
            staffSlide.get(i).click();
            System.out.println(staffEmail.getText());
            closeStaffModal.click();
            if (i>3) {
                SeleniumHelper.waitForClickable(nextButtonStaff, driver);
                nextButtonStaff.click();
            }
            i++;
        }
    }


    public CompanyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

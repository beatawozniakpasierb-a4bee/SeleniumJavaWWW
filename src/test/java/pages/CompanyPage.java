package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestData;

public class CompanyPage {

    public String companyUrl = TestData.BASE_URL + "company/";

    @FindBy(xpath = "//div[@class='col-lg-4']/h4")
    WebElement companyMotto;


    public String getCompanyMottoText() {
        return companyMotto.getText().trim();
    }

    public CompanyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

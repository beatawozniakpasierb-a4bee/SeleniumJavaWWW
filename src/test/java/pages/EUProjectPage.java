package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestData;

public class EUProjectPage {

    public String euProjectUrl = TestData.BASE_URL + "eu-projects/";

    @FindBy(xpath = "//h1[@class='mt-0']")
    WebElement euProjectsMotto;


    public String getEuProjectMottoText() {
        return euProjectsMotto.getText().trim();
    }

    public EUProjectPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

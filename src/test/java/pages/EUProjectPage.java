package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.FooterData;
import utils.TestData;

public class EUProjectPage extends BasePage{

    public UpperBarMenuPage upperBarMenuPage;
    public FooterPage footer;

    public EUProjectPage(WebDriver driver) {
        super(driver);
        upperBarMenuPage = new UpperBarMenuPage(driver);
        footer = new FooterPage(driver);
    }

    public String euProjectUrl = TestData.BASE_URL + "eu-projects/";

    @FindBy(xpath = "//h1[@class='mt-0']")
    WebElement euProjectsMotto;


    public String getEuProjectMottoText() {
        return euProjectsMotto.getText().trim();
    }

}

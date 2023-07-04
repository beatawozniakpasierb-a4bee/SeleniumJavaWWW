package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.TestData;

public class EUProjectPage extends BasePage{

    public EUProjectPage(WebDriver driver, String url) {
        super(driver, url);
        upperBarMenuPage = new UpperBarMenuPage(driver);
        footer = new FooterPage(driver);
    }

    @FindBy(xpath = "//h1[@class='mt-0']")
    private WebElement euProjectsMotto;


    public String getEuProjectMottoText() {
        return euProjectsMotto.getText().trim();
    }

}

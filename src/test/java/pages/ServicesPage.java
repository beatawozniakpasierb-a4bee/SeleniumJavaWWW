package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumHelper;
import utils.TestData;

import java.util.List;

public class ServicesPage extends BasePage {

    public UpperBarMenuPage upperBarMenuPage;

    public ServicesPage(WebDriver driver) {
        super(driver);
        upperBarMenuPage = new UpperBarMenuPage(driver);
    }

    public String servicesUrl = TestData.BASE_URL + "services/";

    @FindBy(xpath = "//div[@class='col-lg-5']/h4")
    WebElement servicesMotto;

    @FindBy(xpath = "//a[contains(@class,'arrow-right')]/h5")
    List<WebElement> listOfOptions;

    @FindBy(id = "submenu-bar")
    WebElement subMenuBar;

    @FindBy(xpath = "//div[@id='submenu-bar']/div")
    public List<WebElement> subMenuItems;

    public List<WebElement> getListOfOptions() {
        return listOfOptions;
    }

    public String getServicesMottoText() {
        return servicesMotto.getText().trim();
    }

    public UpperBarMenuPage selectOption(WebElement element, WebDriver driver) {
        element.click();
        SeleniumHelper.scrollPage(driver);
        SeleniumHelper.waitForVisible(subMenuBar, driver);
        boolean displayed = subMenuBar.isDisplayed();
        if (displayed) {
            for (WebElement item:subMenuItems) {
                item.click();
            }
        } return new UpperBarMenuPage(driver);
    }

}

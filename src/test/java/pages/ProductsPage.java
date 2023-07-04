package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestData;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
        upperBarMenuPage = new UpperBarMenuPage(driver);
        footer = new FooterPage(driver);
    }

    public String productsUrl = TestData.BASE_URL + "products/";

    @FindBy(xpath = "//div[@class='col-lg-4']/h4")
    private WebElement productsMotto;

    public String getProductsMottoText() {
        return productsMotto.getText().trim();
    }

}

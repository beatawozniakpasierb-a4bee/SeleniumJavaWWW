package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestData;

public class ProductsPage extends BasePage {

    public UpperBarMenuPage upperBarMenuPage;

    public ProductsPage(WebDriver driver) {
        super(driver);
        upperBarMenuPage = new UpperBarMenuPage(driver);
    }

    public String productsUrl = TestData.BASE_URL + "products/";

    @FindBy(xpath = "//div[@class='col-lg-4']/h4")
    WebElement productsMotto;

    public String getProductsMottoText() {
        return productsMotto.getText().trim();
    }

}

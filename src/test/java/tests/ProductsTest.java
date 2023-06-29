package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.UpperBarMenuPage;
import utils.TestData;

public class ProductsTest extends BaseTest {
    private UpperBarMenuPage upperBarMenuPage;
    private ProductsPage productsPage;

    @BeforeMethod
    public void setUpPage() {
        upperBarMenuPage = new UpperBarMenuPage(driver);
        productsPage = new ProductsPage(driver);
        upperBarMenuPage.clickOnMenuProducts();
    }

    @Test
    public void verifyProductsUrl() {
        upperBarMenuPage.verifyUrl(driver, upperBarMenuPage.clickOnMenuProducts().productsUrl);
    }

    @Test
    public void verifyProductsPage() {
        Assert.assertEquals(productsPage.getProductsMottoText(), TestData.PRODUCTS_MOTTO_TEXT);
    }

}

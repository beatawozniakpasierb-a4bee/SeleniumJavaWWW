package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductsPage;
import utils.FooterData;
import utils.TestData;

public class ProductsTest extends BaseTest {
    private ProductsPage productsPage;

    @BeforeMethod
    public void setUpPage() {
        productsPage = new ProductsPage(driver);
        productsPage.upperBarMenuPage.clickOnMenuProducts();
    }

    @Test
    public void verifyProductsUrl() {
        productsPage.upperBarMenuPage.verifyUrl(driver, productsPage.upperBarMenuPage.clickOnMenuProducts().productsUrl);
    }

    @Test
    public void verifyProductsPage() {
        Assert.assertEquals(productsPage.getProductsMottoText(), TestData.PRODUCTS_MOTTO_TEXT);
    }

    @Test
    public void verifyFooterAddress() {
        Assert.assertEquals(productsPage.footer.getFooterAddress(), FooterData.getListOfCompanyNames());
    }

    @Test
    public void socialMediaLinksAreDisplayed() {
        Assert.assertEquals(productsPage.footer.getListOfSocialMediaLinks(), FooterData.getListOfSocialMedia());
    }

}

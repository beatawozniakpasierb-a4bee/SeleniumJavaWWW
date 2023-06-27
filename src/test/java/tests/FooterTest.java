package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FooterPage;
import utils.FooterData;

public class FooterTest extends BaseTest {

    private FooterPage footerPage;

    @BeforeMethod
    public void setUpPage() {
        footerPage = new FooterPage(driver);
    }

    @Test
    public void verifyFooterAddress() {
        Assert.assertEquals(footerPage.getFooterAddress(), FooterData.getListOfCompanyNames());
    }
    @Test
    public void socialMediaLinksAreDisplayed() {
        Assert.assertEquals(footerPage.getListOfSocialMediaLinks(), FooterData.getListOfSocialMedia());
    }
}

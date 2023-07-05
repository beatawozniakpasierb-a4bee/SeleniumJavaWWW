package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.EUProjectPage;
import utils.FooterData;
import utils.TestData;

public class EUProjectTest extends BaseTest{

    private EUProjectPage euProjectPage ;

    @BeforeMethod
    public void setUpPage() {
        euProjectPage = new EUProjectPage(driver, TestData.BASE_URL + "eu-projects/");
        euProjectPage.upperBarMenuPage.clickOnMenuEUProjects();
    }

    @Test @Ignore
    public void verifyEUProjectUrl() {
        euProjectPage.verifyUrl(driver, euProjectPage.url);
    }

    @Test
    public void verifyEUProjectMotto() {
        Assert.assertEquals(euProjectPage.getMottoText(euProjectPage.euProjectsMotto), TestData.EU_PROJECT_MOTTO);
    }
    @Test
    public void verifyFooterAddress() {
        Assert.assertEquals(euProjectPage.footer.getFooterAddress(), FooterData.getListOfCompanyNames());
    }

    @Test
    public void socialMediaLinksAreDisplayed() {
        Assert.assertEquals(euProjectPage.footer.getListOfSocialMediaLinks(), FooterData.getListOfSocialMedia());
    }
}

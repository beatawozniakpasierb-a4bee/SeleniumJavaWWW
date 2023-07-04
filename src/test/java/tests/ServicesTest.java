package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ServicesPage;
import utils.FooterData;
import utils.TestData;


public class ServicesTest extends BaseTest {

    private ServicesPage servicesPage;

    @BeforeMethod
    public void setUpPage() {
        servicesPage = new ServicesPage(driver, TestData.BASE_URL + "services/");
        servicesPage.upperBarMenuPage.clickOnMenuServices();
    }

    @Test
    public void verifyServicesPage() {
        Assert.assertEquals(servicesPage.getServicesMottoText(), TestData.SERVICES_MOTTO_TEXT);
    }

    @Test
    public void verifyServicesUrl() {
        servicesPage.verifyUrl(driver, servicesPage.url);
    }

    @Test
    public void verifyEachService() {
        int i=0;
        while(i<servicesPage.getListOfOptions().size()) {
            servicesPage.selectOption(servicesPage.getListOfOptions().get(i), driver).clickOnMenuServices();
            i++;
        }
        Assert.assertTrue(servicesPage.subMenuItems.isEmpty());
    }
    @Test
    public void verifyFooterAddress() {
        Assert.assertEquals(servicesPage.footer.getFooterAddress(), FooterData.getListOfCompanyNames());
    }

    @Test
    public void socialMediaLinksAreDisplayed() {
        Assert.assertEquals(servicesPage.footer.getListOfSocialMediaLinks(), FooterData.getListOfSocialMedia());
    }

}

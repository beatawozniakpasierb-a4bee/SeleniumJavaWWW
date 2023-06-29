package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ServicesPage;
import pages.UpperBarMenuPage;
import utils.TestData;


public class ServicesTest extends BaseTest {

    private ServicesPage servicesPage;
    private UpperBarMenuPage upperBarMenuPage;

    @BeforeMethod
    public void setUpPage() {
        upperBarMenuPage = new UpperBarMenuPage(driver);
        servicesPage = new ServicesPage(driver);
        upperBarMenuPage.clickOnMenuServices();
    }

    @Test
    public void verifyServicesPage() {
        Assert.assertEquals(servicesPage.getServicesMottoText(), TestData.SERVICES_MOTTO_TEXT);
    }

    @Test
    public void verifyServicesUrl() {
        upperBarMenuPage.verifyUrl(driver, upperBarMenuPage.clickOnMenuServices().servicesUrl);
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

}

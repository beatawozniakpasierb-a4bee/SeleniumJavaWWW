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
        upperBarMenuPage.verifyUrl(driver, servicesPage.servicesUrl);
    }

    @Test
    public void verifySecurityAssessment() {
        servicesPage.selectOption(servicesPage.getListOfOptions().get(0), driver);
    }

    @Test
    public void verifyDigitalTransformation() {
        servicesPage.selectOption(servicesPage.getListOfOptions().get(1), driver);
    }

    @Test
    public void verifyVRARSolutions() {
        servicesPage.selectOption(servicesPage.getListOfOptions().get(2), driver);
    }

    @Test
    public void verifyEnterpriseApplications() {
        servicesPage.selectOption(servicesPage.getListOfOptions().get(3), driver);
    }

    @Test
    public void verifyCloudSolutions() {
        servicesPage.selectOption(servicesPage.getListOfOptions().get(4), driver);
    }

    @Test
    public void verifyIoTSolution() {
        servicesPage.selectOption(servicesPage.getListOfOptions().get(5), driver);
    }

}

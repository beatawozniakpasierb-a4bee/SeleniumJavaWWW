package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EUProjectPage;
import pages.UpperBarMenuPage;
import utils.TestData;

public class EUProjectTest extends BaseTest{

    private EUProjectPage euProjectPage ;
    private UpperBarMenuPage upperBarMenuPage;

    @BeforeMethod
    public void setUpPage() {
        upperBarMenuPage = new UpperBarMenuPage(driver);
        euProjectPage = new EUProjectPage(driver);
        upperBarMenuPage.clickOnMenuEUProjects();
    }

    //@Test
    public void verifyEUProjectUrl() {
        upperBarMenuPage.verifyUrl(driver, euProjectPage.euProjectUrl);
    }

    @Test
    public void verifyEUProjectMotto() {
        Assert.assertEquals(euProjectPage.getEuProjectMottoText(), TestData.EU_PROJECT_MOTTO);
    }
}

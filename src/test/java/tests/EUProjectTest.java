package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.EUProjectPage;
import utils.TestData;

public class EUProjectTest extends BaseTest{

    private EUProjectPage euProjectPage ;

    @BeforeMethod
    public void setUpPage() {
        euProjectPage = new EUProjectPage(driver);
        euProjectPage.upperBarMenuPage.clickOnMenuEUProjects();
    }

    @Test @Ignore
    public void verifyEUProjectUrl() {
        euProjectPage.upperBarMenuPage.verifyUrl(driver, euProjectPage.upperBarMenuPage.clickOnMenuEUProjects().euProjectUrl);
    }

    @Test
    public void verifyEUProjectMotto() {
        Assert.assertEquals(euProjectPage.getEuProjectMottoText(), TestData.EU_PROJECT_MOTTO);
    }
}

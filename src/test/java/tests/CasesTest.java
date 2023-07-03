package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CasesPage;
import utils.FooterData;
import utils.TestData;

import java.util.List;

public class CasesTest extends BaseTest {

    private CasesPage casesPage;

    @BeforeMethod
    public void setUpPage() {
        casesPage = new CasesPage(driver);
        casesPage.upperBarMenuPage.clickOnMenuCases();
    }

    @Test
    public void verifyCasesUrl() {
        casesPage.verifyUrl(driver, casesPage.upperBarMenuPage.clickOnMenuCases().casesUrl);
    }

    @Test
    public void verifyCasesMotto() {
        Assert.assertEquals(casesPage.getCasesMottoText(), TestData.CASES_MOTTO_TEXT);
    }

    @Test
    public void verifyListOfCases() {
        List<String> caseNames = casesPage.getListOfCaseStudies();
        Assert.assertTrue(caseNames.size() > 2);
    }
    @Test
    public void verifyFooterAddress() {
        Assert.assertEquals(casesPage.footer.getFooterAddress(), FooterData.getListOfCompanyNames());
    }

    @Test
    public void socialMediaLinksAreDisplayed() {
        Assert.assertEquals(casesPage.footer.getListOfSocialMediaLinks(), FooterData.getListOfSocialMedia());
    }

}

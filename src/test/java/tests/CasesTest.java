package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CasesPage;
import pages.UpperBarMenuPage;
import utils.TestData;

import java.util.List;

public class CasesTest extends BaseTest {

    private CasesPage casesPage;
    private UpperBarMenuPage upperBarMenuPage;

    @BeforeMethod
    public void setUpPage() {
        upperBarMenuPage = new UpperBarMenuPage(driver);
        casesPage = new CasesPage(driver);
        upperBarMenuPage.clickOnMenuCases();
    }

    @Test
    public void verifyCasesUrl() {
        upperBarMenuPage.verifyUrl(driver, casesPage.casesUrl);
    }

    @Test
    public void verifyCasesMotto() {
        Assert.assertEquals(casesPage.getCasesMottoText(), TestData.CASES_MOTTO_TEXT);
    }

    @Test
    public void verifyListOfCases() {
        List<String> caseNames = casesPage.getListOfCaseStudies();
        System.out.println(caseNames.size());
        Assert.assertTrue(caseNames.size() > 2);
    }

}

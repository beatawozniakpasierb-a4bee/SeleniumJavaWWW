package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CompanyPage;
import pages.UpperBarMenuPage;
import utils.TestData;

public class CompanyTest extends BaseTest{

    private CompanyPage companyPage;
    private UpperBarMenuPage upperBarMenuPage;

    @BeforeMethod
    public void setUpPage() {
        upperBarMenuPage = new UpperBarMenuPage(driver);
        companyPage = new CompanyPage(driver);
        upperBarMenuPage.clickOnMenuCompany();
    }

    @Test
    public void verifyCompanyUrl() {
        upperBarMenuPage.verifyUrl(driver, companyPage.companyUrl);
    }

    @Test
    public void verifyCareerMotto() {
        Assert.assertEquals(companyPage.getCompanyMottoText(), TestData.COMPANY_MOTTO_TEXT);
    }

}

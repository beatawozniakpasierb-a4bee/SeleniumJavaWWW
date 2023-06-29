package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
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
        upperBarMenuPage.verifyUrl(driver, upperBarMenuPage.clickOnMenuCompany().companyUrl);
    }

    @Test
    public void verifyCompanyMotto() {
        Assert.assertEquals(companyPage.getCompanyMottoText(), TestData.COMPANY_MOTTO_TEXT);
    }

    @Test
    public void verifyDisplayedStaff() {
        Assert.assertEquals(companyPage.getStaffSlideSize(), 8);
    }

    @Test @Ignore
    public void verifyStaffInfo() {
        companyPage.clickOnStaff();
        Assert.assertTrue(companyPage.clickOnStaff().contains("@a4bee.com"));
    }

}

package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.CompanyPage;
import utils.FooterData;
import utils.TestData;

public class CompanyTest extends BaseTest{

    private CompanyPage companyPage;

    @BeforeMethod
    public void setUpPage() {
        companyPage = new CompanyPage(driver, TestData.BASE_URL + "company/");
        companyPage.upperBarMenuPage.clickOnMenuCompany();
    }

    @Test
    public void verifyCompanyUrl() {
        companyPage.verifyUrl(driver, companyPage.url);
    }

    @Test
    public void verifyCompanyMotto() {
        Assert.assertEquals(companyPage.getCompanyMottoText(), TestData.COMPANY_MOTTO_TEXT);
    }

    @Test
    public void verifyDisplayedStaff() {
        Assert.assertTrue(companyPage.getStaffSlideSize()>3);
    }

    @Test @Ignore
    public void verifyStaffInfo() {
        companyPage.clickOnStaff();
        Assert.assertTrue(companyPage.clickOnStaff().contains("@a4bee.com"));
    }

    @Test
    public void verifyFooterAddress() {
        Assert.assertEquals(companyPage.footer.getFooterAddress(), FooterData.getListOfCompanyNames());
    }

    @Test
    public void socialMediaLinksAreDisplayed() {
        Assert.assertEquals(companyPage.footer.getListOfSocialMediaLinks(), FooterData.getListOfSocialMedia());
    }

}

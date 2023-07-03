package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CareerPage;
import utils.FooterData;
import utils.SeleniumHelper;
import utils.TestData;

public class CareerTest extends BaseTest {

    private CareerPage careerPage;

    @BeforeMethod
    public void setUpPage() {
        careerPage = new CareerPage(driver);
        careerPage.upperBarMenuPage.clickOnMenuCareer();
    }

    @Test
    public void verifyCareerUrl() {
        careerPage.verifyUrl(driver, careerPage.upperBarMenuPage.clickOnMenuCareer().careerUrl);
    }

    @Test
    public void verifyCareerMotto() {
        Assert.assertEquals(careerPage.getCareerMottoText(), TestData.CAREER_MOTTO_TEXT);
    }

    @Test
    public void verifyCurrentPositions() {
        String titleOnList = careerPage.getTitle(careerPage.getCareerTitle());
        careerPage.clickOnCareerItem();
        String titleOnOffer = careerPage.getTitle(careerPage.getCareerTitleInJobOffer());
        Assert.assertEquals(titleOnOffer, titleOnList);
    }

    @Test
    public void verifyOfferElements() {
        careerPage.clickOnCareerItem();
        Assert.assertTrue(careerPage.verifyElements());
    }

    @Test
    public void applyForAJob() {
        careerPage.clickOnCareerItem().sendCV(TestData.VALID_EMAIL, TestData.PATH_TO_CV);
        SeleniumHelper.waitForVisible(careerPage.getApplicationSent(), driver);
        Assert.assertTrue(careerPage.getApplicationSent().isDisplayed());
    }

    @Test
    public void applyForAJobInvalidEmail() {
        careerPage.clickOnCareerItem().sendCV(TestData.INVALID_EMAIL, TestData.PATH_TO_CV);
        Assert.assertTrue(careerPage.getEmailError().isDisplayed());
    }

    @Test
    public void applyForAJobNoCV() {
        careerPage.clickOnCareerItem().sendNoCV(TestData.VALID_EMAIL);
        Assert.assertTrue(careerPage.getCvError().isDisplayed());
    }

    @Test
    public void verifyFooterAddress() {
        Assert.assertEquals(careerPage.footer.getFooterAddress(), FooterData.getListOfCompanyNames());
    }

    @Test
    public void socialMediaLinksAreDisplayed() {
        Assert.assertEquals(careerPage.footer.getListOfSocialMediaLinks(), FooterData.getListOfSocialMedia());
    }
}

package tests;

import models.ContactDetails;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.SeleniumHelper;
import utils.TestData;


public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void setUpPage() {
        homePage = new HomePage(driver);
    }

    @Test
    public void sendBlankContactForm() {
        homePage.clickContactUs().sendForm();
        Assert.assertEquals(homePage.getInputErrors(), 3);
    }

    @Test
    public void sendInvalidEmailForm() {
        homePage.fillContactForm(homePage.contactUsButton, "tester", TestData.INVALID_EMAIL, "Description");
        Assert.assertEquals(homePage.getInputErrors(), 1);
    }

    @Test
    public void sendContactForm() {
        homePage.fillContactForm(homePage.contactUsButton, "tester", TestData.VALID_EMAIL, "Description");
        SeleniumHelper.waitForVisible(homePage.getMessageSentInfo(), driver);
        Assert.assertEquals(homePage.getMessageSentText(), TestData.MESSAGE_SENT_INFO);
    }

    @Test
    public void letsTalkSendContactForm() {
        homePage.fillContactForm(homePage.letsTalkBox, "Tester", TestData.VALID_EMAIL, "Let's talk");
        SeleniumHelper.waitForVisible(homePage.getMessageSentInfo(), driver);
        Assert.assertEquals(homePage.getMessageSentText(), TestData.MESSAGE_SENT_INFO);
    }

    //@Test
    public void sendContactForm2() {
        ContactDetails contactDetails = new ContactDetails();
        homePage.clickContactUs().fillContactForm2(contactDetails);
    }

}

package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.KnowledgePage;
import pages.UpperBarMenuPage;
import utils.TestData;

import java.util.List;

public class KnowledgeTest extends BaseTest {

    private UpperBarMenuPage upperBarMenuPage;
    private KnowledgePage knowledgePage;

    @BeforeMethod
    public void setUpPage() {
        upperBarMenuPage = new UpperBarMenuPage(driver);
        knowledgePage = new KnowledgePage(driver);
        upperBarMenuPage.clickOnMenuKnowledge();
    }

    @Test
    public void verifyKnowledgeUrl() {
        upperBarMenuPage.verifyUrl(driver, knowledgePage.knowledgeUrl);
    }

    @Test
    public void verifyKnowledgeMotto() {
        Assert.assertEquals(knowledgePage.getKnowledgeMottoText(), TestData.KNOWLEDGE_MOTTO_TEXT);
    }

    @Test
    public void verifyListOfArticles() {
        List<String> articleNames = knowledgePage.getListOfArticles();
        Assert.assertTrue(articleNames.size() > 6);
    }

}

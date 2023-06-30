package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.KnowledgePage;
import utils.TestData;

import java.util.List;

public class KnowledgeTest extends BaseTest {

    private KnowledgePage knowledgePage;

    @BeforeMethod
    public void setUpPage() {
        knowledgePage = new KnowledgePage(driver);
        knowledgePage.upperBarMenuPage.clickOnMenuKnowledge();
    }

    @Test
    public void verifyKnowledgeUrl() {
        knowledgePage.upperBarMenuPage.verifyUrl(driver, knowledgePage.upperBarMenuPage.clickOnMenuKnowledge().knowledgeUrl);
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

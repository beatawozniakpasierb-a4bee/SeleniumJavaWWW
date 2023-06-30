package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.TestData;

import java.util.List;
import java.util.stream.Collectors;

public class KnowledgePage extends BasePage {

    public UpperBarMenuPage upperBarMenuPage;

    public KnowledgePage(WebDriver driver) {
        super(driver);
        upperBarMenuPage = new UpperBarMenuPage(driver);
    }

    public String knowledgeUrl = TestData.BASE_URL + "knowledge-hub/";

    @FindBy(xpath = "//p[contains(@class,'text-p-responsive')]")
    WebElement knowledgeMotto;

    @FindBy(xpath = "//div[@class='article-box--info']")
    List<WebElement> listOfArticles;

    public String getKnowledgeMottoText() {
        return knowledgeMotto.getText().trim();
    }

    public List<String> getListOfArticles() {
        return listOfArticles.stream()
                .map(el -> el.getText())
                .collect(Collectors.toList());
    }

}

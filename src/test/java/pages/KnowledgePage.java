package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.TestData;

import java.util.List;
import java.util.stream.Collectors;

public class KnowledgePage extends BasePage {

    public KnowledgePage(WebDriver driver, String url) {
        super(driver, url);
        upperBarMenuPage = new UpperBarMenuPage(driver);
        footer = new FooterPage(driver);
    }

    @FindBy(xpath = "//p[contains(@class,'text-p-responsive')]")
    public WebElement knowledgeMotto;

    @FindBy(xpath = "//div[@class='article-box--info']")
    private List<WebElement> listOfArticles;

    public List<String> getListOfArticles() {
        return listOfArticles.stream()
                .map(el -> el.getText())
                .collect(Collectors.toList());
    }

}

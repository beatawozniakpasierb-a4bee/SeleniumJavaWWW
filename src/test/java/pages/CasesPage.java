package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.TestData;

import java.util.List;
import java.util.stream.Collectors;

public class CasesPage extends BasePage {

    public CasesPage(WebDriver driver) {
        super(driver);
        upperBarMenuPage = new UpperBarMenuPage(driver);
        footer = new FooterPage(driver);
    }

    public String casesUrl = TestData.BASE_URL + "cases/";

    @FindBy(xpath = "//h1[@class='mt-0']")
    private WebElement casesMotto;

    @FindBy(xpath = "//div[@class='case-box--captions']")
    private List<WebElement> listOfCaseStudies;

    public String getCasesMottoText() {
        return casesMotto.getText().trim();
    }

    public List<String> getListOfCaseStudies() {
        return listOfCaseStudies.stream()
                .map(el -> el.getText())
                .collect(Collectors.toList());
    }
}

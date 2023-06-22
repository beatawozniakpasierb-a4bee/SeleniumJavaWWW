package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestData;

import java.util.List;
import java.util.stream.Collectors;

public class CasesPage {

    public String casesUrl = TestData.BASE_URL + "cases/";

    @FindBy(xpath = "//h1[@class='mt-0']")
    WebElement casesMotto;

    @FindBy(xpath = "//div[@class='case-box--captions']")
    List<WebElement> listOfCaseStudies;

    public String getCasesMottoText() {
        return casesMotto.getText().trim();
    }

    public List<String> getListOfCaseStudies() {
        return listOfCaseStudies.stream()
                .map(el -> el.getText())
                .collect(Collectors.toList());
    }

    public CasesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

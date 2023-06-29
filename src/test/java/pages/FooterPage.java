package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class FooterPage extends BasePage{

    public FooterPage(WebDriver driver){
        super(driver);
    }


    @FindBy(xpath = "//div[@class='footer--social-media']/a")
    private List<WebElement> listOfSocialMedia;

    @FindBy(xpath = "//p[@class='address-caption mb-1']")
    List<WebElement> addressFooter;

    public List<String> getFooterAddress() {
        return addressFooter.stream().map(el -> el.getText()).collect(Collectors.toList());
    }

    public List<String> getListOfSocialMediaLinks() {
        return listOfSocialMedia.stream().map(el -> el.getAccessibleName()).collect(Collectors.toList());
    }

}

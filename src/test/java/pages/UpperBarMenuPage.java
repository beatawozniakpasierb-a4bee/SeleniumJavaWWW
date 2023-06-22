package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class UpperBarMenuPage {

    public WebDriver driver;

    @FindBy(xpath = "//li[contains(@id,'menu-item-')]")
    List<WebElement> menuItems;

    public List<String> getMenuItemsNames() {
        return menuItems.stream()
                .map(el -> el.getText())
                .collect(Collectors.toList());
    }

    @FindBy(xpath = "//div[@id='brand']")
    WebElement brand;

    @FindBy(id = "menu-item-445")
    WebElement menuServices;

    @FindBy(id = "menu-item-695")
    WebElement menuProducts;

    @FindBy(id = "menu-item-442")
    WebElement menuCareer;

    @FindBy(id = "menu-item-1042")
    WebElement menuKnowledge;

    @FindBy(id = "menu-item-443")
    WebElement menuCases;

    @FindBy(id = "menu-item-444")
    WebElement menuCompany;

    @FindBy(xpath = "//div[@class='contact-us']/button[@type='button']")
    WebElement contactUsButton;

    @FindBy(xpath = "//a[@href='https://a4bee.com/eu-projects/']")
    WebElement menuEUProjects;

    public UpperBarMenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickContactUsButton() {
        contactUsButton.click();
    }

    public Boolean brandIsDisplayed() {
        return brand.isDisplayed();
    }

    public void clickOnMenuServices() {
        menuServices.click();
    }

    public void clickOnMenuProducts() {
        menuProducts.click();
    }

    public void clickOnMenuCareer() {
        menuCareer.click();
    }

    public void clickOnMenuKnowledge() {
        menuKnowledge.click();
    }

    public void clickOnMenuCases() {
        menuCases.click();
    }

    public void clickOnMenuCompany() {
        menuCompany.click();
    }

    public void clickOnMenuEUProjects() {
        menuEUProjects.click();
    }

    public void verifyUrl(WebDriver driver, String expectedUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

}


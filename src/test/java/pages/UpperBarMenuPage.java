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

    public ServicesPage clickOnMenuServices() {
        menuServices.click();
        return new ServicesPage(driver);
    }

    public ProductsPage clickOnMenuProducts() {
        menuProducts.click();
        return new ProductsPage(driver);
    }

    public CareerPage clickOnMenuCareer() {
        menuCareer.click();
        return new CareerPage(driver);
    }

    public KnowledgePage clickOnMenuKnowledge() {
        menuKnowledge.click();
        return new KnowledgePage(driver);
    }

    public CasesPage clickOnMenuCases() {
        menuCases.click();
        return new CasesPage(driver);
    }

    public CompanyPage clickOnMenuCompany() {
        menuCompany.click();
        return new CompanyPage(driver);
    }

    public EUProjectPage clickOnMenuEUProjects() {
        menuEUProjects.click();
        return new EUProjectPage(driver);
    }

    public void verifyUrl(WebDriver driver, String expectedUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

}


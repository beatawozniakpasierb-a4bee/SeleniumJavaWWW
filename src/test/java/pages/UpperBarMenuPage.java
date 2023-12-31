package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class UpperBarMenuPage extends BasePage{

    public UpperBarMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[contains(@id,'menu-item-')]")
    private List<WebElement> menuItems;

    @FindBy(xpath = "//div[@id='brand']")
    private WebElement brand;

    @FindBy(xpath = "//li/a[text()='Services']")
    private WebElement menuServices;

    @FindBy(xpath = "//li/a[text()='Products']")
    private WebElement menuProducts;

    @FindBy(xpath = "//li/a[text()='Career']")
    private WebElement menuCareer;

    @FindBy(xpath = "//li/a[text()='Knowledge']")
    private WebElement menuKnowledge;

    @FindBy(xpath = "//li/a[text()='Case Studies']")
    private WebElement menuCases;

    @FindBy(xpath = "//li/a[text()='Company']")
    private WebElement menuCompany;

    @FindBy(xpath = "//div[@class='contact-us']/button[@type='button']")
    private WebElement contactUsButton;

    @FindBy(xpath = "//a[@href='https://a4bee.com/eu-projects/']")
    private WebElement menuEUProjects;

    public List<String> getMenuItemsNames() {
        return menuItems.stream()
                .map(el -> el.getText())
                .collect(Collectors.toList());
    }

    public Boolean brandIsDisplayed() {
        return brand.isDisplayed();
    }

    public ServicesPage clickOnMenuServices() {
        menuServices.click();
        return new ServicesPage(driver, url);
    }

    public ProductsPage clickOnMenuProducts() {
        menuProducts.click();
        return new ProductsPage(driver, url);
    }

    public CareerPage clickOnMenuCareer() {
        menuCareer.click();
        return new CareerPage(driver, url);
    }

    public KnowledgePage clickOnMenuKnowledge() {
        menuKnowledge.click();
        return new KnowledgePage(driver, url);
    }

    public CasesPage clickOnMenuCases() {
        menuCases.click();
        return new CasesPage(driver, url);
    }

    public CompanyPage clickOnMenuCompany() {
        menuCompany.click();
        return new CompanyPage(driver, url);
    }

    public EUProjectPage clickOnMenuEUProjects() {
        menuEUProjects.click();
        return new EUProjectPage(driver, url);
    }

}


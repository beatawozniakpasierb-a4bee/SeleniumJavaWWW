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

    @FindBy(id = "menu-item-445")
    private WebElement menuServices;

    @FindBy(id = "menu-item-695")
    private WebElement menuProducts;

    @FindBy(id = "menu-item-442")
    private WebElement menuCareer;

    @FindBy(id = "menu-item-1042")
    private WebElement menuKnowledge;

    @FindBy(id = "menu-item-443")
    private WebElement menuCases;

    @FindBy(id = "menu-item-444")
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

    //public void clickContactUsButton() {
     //   contactUsButton.click();
    //}

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

}


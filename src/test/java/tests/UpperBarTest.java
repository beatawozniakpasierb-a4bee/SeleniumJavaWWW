package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UpperBarMenuPage;
import java.util.List;
import java.util.stream.Collectors;


public class UpperBarTest extends BaseTest {
    private UpperBarMenuPage upperBarMenuPage;

    @BeforeMethod
    public void setUpPage() {
        upperBarMenuPage = new UpperBarMenuPage(driver);
    }

    @Test
    public void homePageLoads() {
        Assert.assertTrue(upperBarMenuPage.brandIsDisplayed());
    }

    @Test
    public void verifyMenuItemsNames() {
        List<String> menuItemsWithEmptyNames = upperBarMenuPage.getMenuItemsNames().stream().filter(el -> el.isEmpty()).collect(Collectors.toList());
        Assert.assertTrue((menuItemsWithEmptyNames).isEmpty());
    }


}

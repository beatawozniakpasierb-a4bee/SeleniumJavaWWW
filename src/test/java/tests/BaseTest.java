package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;
import utils.TestData;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void testSetUp() {
        driver = DriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(TestData.BASE_URL);
        Assert.assertEquals(driver.getTitle(), TestData.PAGE_TITLE);
        WebElement acceptCookies = driver.findElement(By.xpath(TestData.acceptCookies));
        acceptCookies.click();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

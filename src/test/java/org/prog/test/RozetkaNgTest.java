package org.prog.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class RozetkaNgTest {
    private WebDriver webDriver;
    private static final String SEARCH_STRING = "xiaomi redmi note 10 pro 6/64";

    @BeforeClass
    public void setUp() {
        webDriver = getDriver();
    }

    @BeforeMethod
    public void beforeEach() {
        loadRozetkaPage();
    }

    @AfterMethod
    public void endTest() {
        System.out.println("===========================");
    }

    @AfterClass
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Test
    public void testRozetkaSearch() throws InterruptedException {
        rozetkaSearch(SEARCH_STRING);
        new WebDriverWait(webDriver, Duration.ofSeconds(35))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.className("search-header"), SEARCH_STRING));
        Assert.assertEquals(webDriver.findElement(By.className("catalog-heading")).getText(),
                "«xiaomi redmi note 10 pro 6/64»");
    }

    @Test
    public void testList() throws InterruptedException {
        rozetkaSearch(SEARCH_STRING);
        new WebDriverWait(webDriver, Duration.ofSeconds(35))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.className("search-header"), SEARCH_STRING));
        List<WebElement> elements = webDriver.findElements(By.className("goods-tile__title"));
        boolean match = false;
        for (WebElement element : elements) {
            if (element.getText().toLowerCase().contains("xiaomi redmi note 10 pro 6/64")) {
                match = true;
                break;
            }
        }
        Assert.assertTrue(match);
    }

    private WebDriver getDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(chromeOptions);
    }

    private void loadRozetkaPage() {
        webDriver.get("https://rozetka.com.ua");
    }

    private void rozetkaSearch(String searchValue) {
        WebElement searchBar = webDriver.findElement(By.name("search"));
        searchBar.sendKeys(searchValue);
        searchBar.sendKeys(Keys.ENTER);
    }
}

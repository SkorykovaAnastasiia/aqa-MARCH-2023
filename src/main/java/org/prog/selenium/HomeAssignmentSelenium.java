package org.prog.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeAssignmentSelenium {

    private static final String SEARCH_STRING = "xiaomi redmi note 10 pro 6/64";

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get("https://rozetka.com.ua");
        rozetkaSearch(webDriver, SEARCH_STRING);
        new WebDriverWait(webDriver, Duration.ofSeconds(15))
                .until(ExpectedConditions.textToBePresentInElementLocated(By.className("search-header"), SEARCH_STRING));
        webDriver.quit();
    }

    private static void rozetkaSearch(WebDriver webDriver, String searchValue) {
        WebElement searchBar = webDriver.findElement(By.name("search"));
        searchBar.sendKeys(searchValue);
        searchBar.sendKeys(Keys.ENTER);
    }
}

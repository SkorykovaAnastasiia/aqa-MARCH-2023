package org.prog.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeAssignmentSelenium {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://rozetka.com.ua");
        rozetkaSearch(webDriver, "\"xiaomi redmi note 10\"");
        Thread.sleep(10000);
        webDriver.quit();
    }

    private static void rozetkaSearch(WebDriver webDriver, String searchValue) {
        WebElement searchBar = webDriver.findElement(By.name("search"));
        searchBar.sendKeys(searchValue);
        searchBar.sendKeys(Keys.ENTER);

    }
}



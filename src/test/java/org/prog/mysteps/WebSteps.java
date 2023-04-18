package org.prog.mysteps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.ProductDto.GoodsDto;
import org.prog.cucumber.CucumberHooks;
import org.testng.Assert;

import java.time.Duration;

public class WebSteps {

    private static final String PRODUCT_PRICE_CLASS = "product-price__big";

    @Given("compare product prices with site version")

    public void comparePrice() {
        WebDriver webDriver = CucumberHooks.getDriver();
        String text;
        for (GoodsDto goodsDto : SqlSteps.goods) {
            webDriver.get(goodsDto.getURl());
            new WebDriverWait(webDriver, Duration.ofSeconds(15))
                    .until(ExpectedConditions.presenceOfElementLocated(By.className(PRODUCT_PRICE_CLASS)));
            // delete last symbol
            text = webDriver.findElement(By.className(PRODUCT_PRICE_CLASS)).getText();
            text = text.substring(0, text.length() - 1).replaceAll(" ", "");

            Assert.assertEquals(goodsDto.getPrice(), Integer.valueOf(text));
        }
        webDriver.quit();
    }
}

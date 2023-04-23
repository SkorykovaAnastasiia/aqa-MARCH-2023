package org.prog.cucumber;

import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestRunStarted;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CucumberHooks implements EventListener {

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestRunStarted.class, this::setUp);
        eventPublisher.registerHandlerFor(TestRunFinished.class, this::tearDown);
    }

    public void setUp(TestRunStarted event) {
//        if (Objects.isNull(WebSteps.googlePage)) {
//            WebSteps.googlePage = new GooglePage(getDriver());
//        }
    }

    public void tearDown(TestRunFinished event) {
//        WebSteps.googlePage.quitDriver();
    }

    public static WebDriver getDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--headless");
        return new ChromeDriver(chromeOptions);
    }


}

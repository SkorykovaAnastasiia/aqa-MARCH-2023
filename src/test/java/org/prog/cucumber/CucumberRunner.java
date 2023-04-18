package org.prog.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
    glue = "org.prog.mysteps",
    plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json",
        "html:target/cucumber-report.html", "org.prog.cucumber.CucumberHooks"})
public class CucumberRunner extends AbstractTestNGCucumberTests {

}

package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "features", glue = {"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty"},
        monochrome = true)
public class CukesTestRunner extends AbstractTestNGCucumberTests {


}


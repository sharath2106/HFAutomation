package runners;

import core.config.webdriver.DriverFactory;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

@CucumberOptions(features = "features", glue = {"stepdefinitions"},
        plugin = {"json:target/cucumber-report/cucumber.json"},
        monochrome = true)
public class CukesTestRunner extends AbstractTestNGCucumberTests {

    private DriverFactory driverFactory;

    public CukesTestRunner() {
        driverFactory = new DriverFactory();
    }

    @BeforeMethod
    @Parameters(value = {"browser", "environment"})
    public void setUp(String browser, String environment) {
        driverFactory.driverSetUp(browser, environment);
    }

    @AfterMethod
    public void tearDown() {
        driverFactory.driverTearDown();
    }

    @AfterTest
    public void quitDriver(){
        driverFactory.quitDriver();
    }
}


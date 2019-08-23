package stepdefinitions.Hooks;

import core.webdriver.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class hooks {

    private DriverFactory driver;

    public hooks() {
        driver = new DriverFactory();
    }

    @Before()
    public void setUp() {
        driver.driverSetUp();
    }

    @After (order = 1)
    public void afterScenario() {
        String screenshotName = "test";
        try {
            TakesScreenshot takesScreenshot = ((TakesScreenshot) DriverFactory.getDriver());
            File SrcFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
            File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
            FileUtils.copyFile(SrcFile, destinationPath);
        } catch (IOException e) {
        }

    }

    @After (order = 0)
    public void tearDown() {
        driver.driverTearDown();
    }
}

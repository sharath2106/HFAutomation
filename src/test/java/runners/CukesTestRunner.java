package runners;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import core.webdriver.DriverFactory;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

@CucumberOptions(features = "features", glue = {"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty"},
        monochrome = true)
public class CukesTestRunner extends AbstractTestNGCucumberTests {

    private DriverFactory driverFactory;
    private static ExtentTest test;
    private static ExtentReports reports;

    public CukesTestRunner() {
        driverFactory = new DriverFactory();
    }


    @BeforeClass
    public static void startTest()
    {
        reports = new ExtentReports(System.getProperty("user.dir")+"/target/ExtentReportResults.html");
        test = reports.startTest("ExtentDemo");
    }


    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(String browser) {
        driverFactory.driverSetUp(browser);
    }

    @AfterMethod
    public void afterScenario() {
        String screenshotName = "test";
        try {
            TakesScreenshot takesScreenshot = ((TakesScreenshot) DriverFactory.getDriver());
            File SrcFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
            File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName +System.currentTimeMillis() + ".png");
            FileUtils.copyFile(SrcFile, destinationPath);
        } catch (IOException e) {
        }

    }

    @AfterMethod
    public void tearDown() {
        driverFactory.driverTearDown();
    }

    @AfterClass
    public static void endTest(){
        reports.endTest(test);
        reports.flush();
    }

}


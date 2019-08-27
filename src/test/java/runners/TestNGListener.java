package runners;

import core.config.Utilities;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

    private Utilities utilities;
    private Logger logger;

    public TestNGListener() {
        utilities  = new Utilities();
        logger = Logger.getRootLogger();
    }

    @Override
    public void onTestStart(ITestResult result) {
           utilities.deleteScreenshotsFolderFromProject();
    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    public void onTestFailure(ITestResult result) {
        logger.error("***** "+  result.getName() +" test has failed *****");
        utilities.takeScreenshotsForFailedTests(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}

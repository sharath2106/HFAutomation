package runners;

import core.config.Utilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

    private Utilities utilities;

    public TestNGListener() {
        utilities  = new Utilities();
    }

    @Override
    public void onTestStart(ITestResult result) {
           utilities.deleteScreenshotsFolderFromProject();
    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    public void onTestFailure(ITestResult result) {
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

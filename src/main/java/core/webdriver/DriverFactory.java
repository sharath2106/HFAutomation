package core.webdriver;

import core.webdriver.capabilities.CapabilityFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static WebDriver driver;
    private String nodeURL = "http://localhost:4444/wd/hub";
    private CapabilityFactory capabilityFactory =  new CapabilityFactory();

    public static WebDriver getDriver() {
        return driver;
    }

    public void driverSetUp(String browser) {
        try {
            driver = new RemoteWebDriver(new URL(nodeURL),  capabilityFactory.getCapabilities(browser));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        driver.navigate().to("http://automationpractice.com/index.php");
    }

    public void driverTearDown() {
        driver.quit();
    }
}

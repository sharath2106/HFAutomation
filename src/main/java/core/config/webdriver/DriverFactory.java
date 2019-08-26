package core.config.webdriver;

import core.config.Utilities;
import core.config.webdriver.capabilities.CapabilityFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static core.config.Constant.pathToConfigurationProperties;

public class DriverFactory {

    private static WebDriver driver;
    private Utilities utilities;
    private CapabilityFactory capabilityFactory =  new CapabilityFactory();

    public static WebDriver getDriver() {
        return driver;
    }

    public DriverFactory() {
        utilities = new Utilities();
    }

    public void driverSetUp(String browser) {
        try {
            driver = new RemoteWebDriver(new URL(utilities.getProperty(pathToConfigurationProperties, "SeleniumGridURL")),  capabilityFactory.getCapabilities(browser));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        driver.navigate().to(utilities.getProperty(pathToConfigurationProperties, "ApplicationURL"));
    }

    public void driverTearDown() {
        driver.quit();
    }
}

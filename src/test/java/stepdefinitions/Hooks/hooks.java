package stepdefinitions.Hooks;

import core.webdriver.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class hooks {

    private DriverFactory driver;

    public hooks() {
        driver = new DriverFactory();
    }

    @Before
    public void setUp() {
        driver.setUp();
    }

    @After
    public void tearDown() {
        driver.tearDown();
    }
}

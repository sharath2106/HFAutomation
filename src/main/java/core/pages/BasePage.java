package core.pages;

import core.config.webdriver.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;
    protected final LoginPage loginPage;
    protected final SignUpPage signUpPage;
    protected final CheckOutPage checkOutPage;
    protected Logger logger;


    public BasePage() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, 60);
        logger = Logger.getRootLogger();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        checkOutPage = PageFactory.initElements(driver, CheckOutPage.class);
    }

    protected void waitForElementToBeClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception ce) {
            System.err.println("Exception - " + ce.getMessage());
        }
    }

    protected void waitForElementToBeLocatedInThePage(By element) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(element));
        } catch (Exception ce) {
            System.err.println("Exception - " + ce.getMessage());
        }
    }

    protected boolean isElementDisplayed(WebElement elem) {
        try {
            return elem.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected void sendKeys(WebElement elem, String keys, String elementName) {
        try {
            logger.info("Typing "+ elementName+" in the textbox");
            elem.clear();
            elem.sendKeys(keys);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    protected void selectDropDownByValue(WebElement element, String option, String elementName) {
        logger.info("Select the "+elementName+" value from the drop down ");
        Select select = new Select(element);
        select.selectByValue(option);
    }

    protected void waitAndAssert(WebElement element, String assertMsg) {
        waitForElementToBeClickable(element);
        Assert.assertTrue(isElementDisplayed(element), assertMsg);
    }

    protected void click(WebElement webElement, String element){
        logger.info("Clicking on the " + element + " element");
        webElement.click();
    }



}

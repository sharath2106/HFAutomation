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
    public Logger logger;


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
            logger.error("Element is not clickable");
            ce.printStackTrace();
        }
    }

    protected void waitForElementToBeLocatedInThePage(By element) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(element));
        } catch (Exception ce) {
            logger.error("Element is not located in the page");
            ce.printStackTrace();
        }
    }

    protected boolean isElementDisplayed(WebElement element, String elementName) {
        try {
            logger.info("Element "+elementName+" is verified");
            return element.isDisplayed();
        } catch (Exception e) {
            logger.error("Element "+elementName+" is not verified");
            e.printStackTrace();
            return false;
        }
    }

    protected void sendKeys(WebElement elem, String keys, String elementName) {
        try {
            logger.info("Typing "+ elementName+" in the textbox");
            elem.clear();
            elem.sendKeys(keys);
        } catch (Exception e) {
            logger.error("Typing "+ elementName +" FAILED");
            e.getMessage();
        }
    }

    protected void selectDropDownByValue(WebElement element, String option, String elementName) {
        try {
            logger.info("Select the "+elementName+" value from the drop down ");
            Select select = new Select(element);
            select.selectByValue(option);
        } catch (Exception e){
            logger.error("Selecting "+ elementName +" FAILED");
            e.getMessage();
        }
    }

    protected void click(WebElement webElement, String elementName) {
        try {
            logger.info("Clicking on the " + elementName + " element");
            webElement.click();
        } catch (Exception e) {
            logger.error("Clicking " + elementName + " FAILED");
        }
    }
}

package tests;

import driver.DriverFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.SignUpPage;

import java.util.Date;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class WebTest extends DriverFactory {

    String existingUserEmail = "hf_challenge_123456@hf123456.com";
    String existingUserPassword = "12345678";

    private CheckOutPage checkOutPage;
    private LoginPage loginPage;
    private SignUpPage signUpPage;
    protected static WebDriver driver;

    public WebTest() {
        driver = DriverFactory.initializeDriver();
        checkOutPage = PageFactory.initElements(driver, CheckOutPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        signUpPage = PageFactory.initElements(driver, SignUpPage.class);

    }

    @Test
    public void signInTest() throws InterruptedException {
        loginPage.loginPanel.click();
        String timestamp = String.valueOf(new Date().getTime());
        String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
        String name = "Firstname";
        String surname = "Lastname";
        signUpPage.emailTextBoxCreateAccount.sendKeys(email);
        signUpPage.submitButtonCreateAccount.click();
        Thread.sleep(5000);
        signUpPage.selectGender.click();
        signUpPage.customersFirstName.sendKeys(name);
        signUpPage.customerLastName.sendKeys(surname);
        signUpPage.enterPassword.sendKeys("Qwerty");
        Select select = new Select(driver.findElement(By.id("days")));
        select.selectByValue("1");
        select = new Select(driver.findElement(By.id("months")));
        select.selectByValue("1");
        select = new Select(driver.findElement(By.id("years")));
        select.selectByValue("2000");
        signUpPage.enterCompany.sendKeys("Company");
        signUpPage.enterAddress1.sendKeys("Qwerty, 123");
        signUpPage.enterAddress2.sendKeys("zxcvb");
        signUpPage.enterCity.sendKeys("Qwerty");
        select = new Select(signUpPage.selectState);
        select.selectByVisibleText("Colorado");
        signUpPage.enterPostCode.sendKeys("12345");
        signUpPage.enterOthers.sendKeys("Qwerty");
        signUpPage.enterPhone.sendKeys("12345123123");
        signUpPage.enterMobilePhone.sendKeys("12345123123");
        signUpPage.enterAlias.sendKeys("hf");
        signUpPage.submitAccount.click();

        assertEquals("MY ACCOUNT", loginPage.landingPageHeaderAfterLogin.getText());
        assertEquals(name +" "+surname, loginPage.userNameInAccount.getText());
        assertTrue(loginPage.welcomeBannerAfterLogin.getText().contains("Welcome to your account."));
        assertTrue(loginPage.logoutIcon.isDisplayed());
        assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
    }

    @Test
    public void logInTest() {
        String fullName = "Joe Black";
//        wait.until(ExpectedConditions.vis);
        loginPage.loginPanel.click();
        loginPage.emailTextBox.sendKeys(existingUserEmail);
        loginPage.passwordTextBox.sendKeys(existingUserPassword);
        loginPage.submitButtonLoginPanel.click();
//        wait.until(ExpectedConditions.visibilityOf(loginPage.landingPageHeaderAfterLogin));

        assertEquals("MY ACCOUNT", loginPage.landingPageHeaderAfterLogin.getText());
        assertEquals(fullName, loginPage.userNameInAccount.getText());
        assertTrue(loginPage.welcomeBannerAfterLogin.getText().contains("Welcome to your account."));
        assertTrue(loginPage.logoutIcon.isDisplayed());
        assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
    }

    @Test
    public void checkoutTest() throws InterruptedException {
        loginPage.loginPanel.click();
        loginPage.emailTextBox.sendKeys(existingUserEmail);
        loginPage.passwordTextBox.sendKeys(existingUserPassword);
        loginPage.submitButtonLoginPanel.click();
        checkOutPage.womenCategory.click();
        checkOutPage.womenCategoryDress.click();
        Thread.sleep(5000);
        checkOutPage.womenCategoryDress.click();
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(checkOutPage.womenCategoryDressSelection));
        checkOutPage.womenCategoryDressSelection.click();
        checkOutPage.proceedToCheckout.click();
        checkOutPage.proceedToCheckoutFromCart.click();
        checkOutPage.processAddressOfCustomer.click();
        checkOutPage.uniformcgv.click();
        checkOutPage.termsAndConditions.click();
        checkOutPage.bankWirePayment.click();
        checkOutPage.clickOrderConfirmation.click();
//        WebElement heading = wait.until(ExpectedConditions.visibilityOf(loginPage.welcomeBannerAfterLogin));
//
//        assertEquals("ORDER CONFIRMATION", heading.getText());
        assertTrue(checkOutPage.orderConfirmationFirstStep.isDisplayed());
        assertTrue(checkOutPage.orderConfirmationSecondStep.isDisplayed());
        assertTrue(checkOutPage.orderConfirmationOnMyStoreBanner.getText().contains("Your order on My Store is complete."));
        assertTrue(driver.getCurrentUrl().contains("controller=order-confirmation"));
    }
}

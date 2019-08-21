package stepdefinitions;

import core.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class CheckOutSteps extends BasePage {

    String existingUserEmail = "hf_challenge_123456@hf123456.com";
    String existingUserPassword = "12345678";

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
//        WebDriverWait wait = new WebDriverWait(driver, 60);
//        wait.until(ExpectedConditions.visibilityOf(checkOutPage.womenCategoryDressSelection));
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
//        assertTrue(driver.getCurrentUrl().contains(checkOutPage.orderConfirmationURLPath));
    }
}
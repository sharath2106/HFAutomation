package core.actions;

import core.pages.BasePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutFacade extends BasePage {

    public void selectDress() {
        try{
            Thread.sleep(5000);
            checkOutPage.womenCategory.click();
            checkOutPage.womenCategoryDress.click();
            Thread.sleep(5000);
//            checkOutPage.womenCategoryDress.click();
            Thread.sleep(5000);
        } catch (InterruptedException ie){
            ie.printStackTrace();
        }

    }

    public void addProductToCart() {
        waitForElementToBeClickable(checkOutPage.womenCategoryDressSelection);
        checkOutPage.womenCategoryDressSelection.click();
    }

    public void proceedToCheckoutPageFromSummaryPage() {
        checkOutPage.proceedToCheckout.click();
        checkOutPage.proceedToCheckoutFromCart.click();
        checkOutPage.processAddressOfCustomer.click();
        checkOutPage.uniformcgv.click();
        checkOutPage.termsAndConditions.click();
    }

    public void performPaymentForTheProductAndValidateOrderConfirmation(){

        checkOutPage.bankWirePayment.click();
        checkOutPage.clickOrderConfirmation.click();
        waitForElementToBeClickable(loginPage.landingPageHeaderAfterLogin);

        assertEquals("ORDER CONFIRMATION", loginPage.landingPageHeaderAfterLogin.getText());
        assertTrue(isElementDisplayed(checkOutPage.orderConfirmationFirstStep));
        assertTrue(isElementDisplayed(checkOutPage.orderConfirmationSecondStep));
        assertTrue(checkOutPage.orderConfirmationOnMyStoreBanner.getText().contains("Your order on My Store is complete."));
        assertTrue(driver.getCurrentUrl().contains(checkOutPage.orderConfirmationURLPath));
    }

}

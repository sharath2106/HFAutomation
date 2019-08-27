package core.actions;

import core.actions.enums.CheckoutElements;
import core.pages.BasePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutActions extends BasePage {

    public void selectDressFromCategory() {
        click(checkOutPage.dressCategory, CheckoutElements.CATEGORY.getValue());
        click(checkOutPage.dressSelectedInTheCategory, CheckoutElements.DRESS_IN_CATEGORY.getValue());
    }

    public void addProductToCart() {
        waitForElementToBeClickable(checkOutPage.dressSelectionSubmit);
        click(checkOutPage.dressSelectionSubmit, CheckoutElements.SUBMIT.getValue());
    }

    public void proceedToCheckoutPageFromSummaryPage() {
        click(checkOutPage.proceedToCheckoutFromLayerCart,  CheckoutElements.CHECKOUT_FROM_LAYER_CART.getValue());
        click(checkOutPage.proceedToCheckoutFromCartPage,  CheckoutElements.CHECKOUT_FROM_CART_PAGE.getValue());
        click(checkOutPage.processAddressOfCustomer, CheckoutElements.ADDRESS_OF_CUSTOMER.getValue());
        click(checkOutPage.uniformcgv, CheckoutElements.UNIFORM_CGV.getValue());
        click(checkOutPage.termsAndConditions, CheckoutElements.TERMS_AND_CONDITIONS.getValue());
    }

    public void performPaymentForTheProductAndValidateOrderConfirmation(){
        click(checkOutPage.bankWirePayment, CheckoutElements.WIRE_PAYMENT.getValue());
        click(checkOutPage.clickOrderConfirmation, CheckoutElements.CLICK_ORDER_CONFIRMATION.getValue());
        waitForElementToBeClickable(loginPage.landingPageHeaderAfterLogin);

        assertEquals("ORDER CONFIRMATION", loginPage.landingPageHeaderAfterLogin.getText());
        assertTrue(isElementDisplayed(checkOutPage.orderConfirmationFirstStep));
        assertTrue(isElementDisplayed(checkOutPage.orderConfirmationSecondStep));
        assertTrue(checkOutPage.orderConfirmationOnMyStoreBanner.getText().contains("Your order on My Store is complete."));
        assertTrue(driver.getCurrentUrl().contains(checkOutPage.orderConfirmationURLPath));
    }

}

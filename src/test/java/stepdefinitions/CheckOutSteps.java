package stepdefinitions;

import core.actions.CheckoutFacade;
import core.pages.BasePage;
import cucumber.api.java.en.Then;

public class CheckOutSteps extends BasePage {

    private CheckoutFacade checkOut;

    public CheckOutSteps() {
        checkOut =  new CheckoutFacade();
    }

    @Then("I select Women dress from Women category")
    public void selectDressOfTheProductInTheSelectedCategory() {
        checkOut.selectDressFromCategory();
    }

    @Then("I should add the product to the cart")
    public void addingTheProductToCartForPurchase() {
        checkOut.addProductToCart();
    }

    @Then("I should be able to Proceed to Checkout from the summary page")
    public void proceedToCheckoutFromSummaryPage() {
        checkOut.proceedToCheckoutPageFromSummaryPage();
    }

    @Then("I should be able to complete payment and verify the order confirmation")
    public void completePaymentForProductAndConfirmOrder() {
        checkOut.performPaymentForTheProductAndValidateOrderConfirmation();
    }
}
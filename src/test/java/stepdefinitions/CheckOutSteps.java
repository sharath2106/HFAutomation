package stepdefinitions;

import core.facades.CheckOutFacade;
import core.pages.BasePage;
import cucumber.api.java.en.Then;

public class CheckOutSteps extends BasePage {

    private CheckOutFacade checkOutFacade;

    public CheckOutSteps() {
        checkOutFacade =  new CheckOutFacade();
    }

    @Then("I select Women dress from Women category")
    public void selectDressOfTheProductInTheSelectedCategory() {
        checkOutFacade.selectDress();
    }


    @Then("I should add the product to the cart")
    public void addingTheProductToCartForPurchase() {
        checkOutFacade.addProductToCart();
    }

    @Then("I should be able to Proceed to Checkout from the summary page")
    public void proceedToCheckoutFromSummaryPage() {
        checkOutFacade.proceedToCheckoutPageFromSummaryPage();
    }

    @Then("I should be able to complete payment and verify the order confirmation")
    public void completePaymentForProductAndConfirmOrder() {
        checkOutFacade.performPaymentForTheProductAndValidateOrderConfirmation();
    }
}
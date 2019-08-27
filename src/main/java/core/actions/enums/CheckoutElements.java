package core.actions.enums;

import lombok.Getter;

@Getter
public enum CheckoutElements {

    CATEGORY("Women category"),
    DRESS_IN_CATEGORY("Email address"),
    SUBMIT("Submit"),
    CHECKOUT_FROM_LAYER_CART("Proceed to checkout - Layer cart"),
    CHECKOUT_FROM_CART_PAGE("Proceed to checkout - Cart Page"),
    ADDRESS_OF_CUSTOMER("Address of customer"),
    UNIFORM_CGV("Uniform CGV"),
    TERMS_AND_CONDITIONS("Terms and conditions"),
    WIRE_PAYMENT("Bank wire payment"),
    CLICK_ORDER_CONFIRMATION("Order cofirmation"),
    ORDER_FIRST_STEP("Order confirmation first step"),
    ORDER_SECOND_STEP("Order confirmation second step");

    private String value;

    CheckoutElements(String value) {
        this.value = value;
    }
}

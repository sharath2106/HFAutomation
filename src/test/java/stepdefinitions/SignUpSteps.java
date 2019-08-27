package stepdefinitions;

import core.actions.SignUpActions;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignUpSteps {

    private SignUpActions signUpActions;

    public SignUpSteps() {
        signUpActions =  new SignUpActions();
    }

    @When("I create a new account for the new user")
    public void createNewAccountForTheUser() {
        signUpActions.enterEmailAddressAndRegisterUserByClickingCreateAccountButton();
    }

    @Then("I should land on the new user page")
    public void verifyLandingPageOfNewUserToCreateAccount() {
        signUpActions.validateLandingPageToCreateAccountForNewUser();
    }

    @Then("I should enter the personal details of the user")
    public void enterPersonalDetailsOfTheUser() {
        signUpActions.enterPersonalInformationOfNewUserToCreateAccount();
    }

    @Then("I should enter the address and phone number of the user")
    public void enterAddressAndPhoneNumberOfUser() {
        signUpActions.enterAddressAndPhoneNumberOfNewUserToCreateAccount();
    }

    @Then("I should register the user")
    public void clickOnRegisterToRegisterTheUser() {
        signUpActions.registerUserByClickingOnRegisterButton();
    }
}
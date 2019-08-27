package stepdefinitions;

import core.actions.LoginActions;
import core.actions.SignUpActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignUpAndLoginSteps {


    private SignUpActions signUpActions;
    private LoginActions loginActions;

    public SignUpAndLoginSteps() {
        signUpActions =  new SignUpActions();
        loginActions = new LoginActions();
    }

    @Given("I land on the home page and click on Sign In button")
    public void clickOnSignInButtonInHomePage() {
        loginActions.waitAndClickOnSignInButtonInHomePage();
    }

    @When("I login with the a username and password")
    public void loginToAppWithUsernameAndPasswordInLoginForm() {
        loginActions.enterUsernamePasswordAndLoginByClickingSubmitbutton();
    }

    @Then("I should land on the registered user page")
    public void verifyLandingPageOfTheUserAfterLogin() {
        loginActions.validateMyAccountPageOfUserAfterLogin();
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
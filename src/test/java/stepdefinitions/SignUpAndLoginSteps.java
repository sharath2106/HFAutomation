package stepdefinitions;

import core.actions.LoginFacade;
import core.actions.SignUpFacade;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignUpAndLoginSteps {


    private SignUpFacade signUpFacade;
    private LoginFacade loginFacade;

    public SignUpAndLoginSteps() {
        signUpFacade =  new SignUpFacade();
        loginFacade = new LoginFacade();
    }

    @Given("I land on the home page and click on Sign In button")
    public void clickOnSignInButtonInHomePage() {
        loginFacade.waitAndClickOnSignInButtonInHomePage();
    }

    @When("I login with the a username and password")
    public void loginToAppWithUsernameAndPasswordInLoginForm() {
        loginFacade.enterUsernamePasswordAndLoginByClickingSubmitbutton();
    }

    @Then("I should land on the registered user page")
    public void verifyLandingPageOfTheUserAfterLogin() {
        loginFacade.validateMyAccountPageOfUserAfterLogin();
    }

    @When("I create a new account for the new user")
    public void createNewAccountForTheUser() {
        signUpFacade.enterEmailAddressAndRegisterUserByClickingCreateAccountButton();
    }

    @Then("I should land on the new user page")
    public void verifyLandingPageOfNewUserToCreateAccount() {
        signUpFacade.validateLandingPageToCreateAccountForNewUser();
    }

    @Then("I should enter the personal details of the user")
    public void enterPersonalDetailsOfTheUser() {
        signUpFacade.enterPersonalInformationOfNewUserToCreateAccount();
    }

    @Then("I should enter the address and phone number of the user")
    public void enterAddressAndPhoneNumberOfUser() {
        signUpFacade.enterAddressAndPhoneNumberOfNewUserToCreateAccount();
    }

    @Then("I should register the user")
    public void clickOnRegisterToRegisterTheUser() {
        signUpFacade.registerUserByClickingOnRegisterButton();
    }


}
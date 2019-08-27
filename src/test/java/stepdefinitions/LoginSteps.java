package stepdefinitions;

import core.actions.LoginActions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {

    private LoginActions loginActions;

    public LoginSteps() {
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
}
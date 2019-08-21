package stepdefinitions;

import core.pages.BasePage;
import core.testmethods.SignUpAndLoginTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignUpAndLoginSteps extends BasePage {


    private SignUpAndLoginTest signUpAndLoginTest;

    public SignUpAndLoginSteps() {
        signUpAndLoginTest =  new SignUpAndLoginTest();
    }

    @Given("I land on the home page and click on Sign In button")
    public void clickOnSignInButtonInHomePage() {
        signUpAndLoginTest.waitAndClickOnSignInButtonInHomePage();
    }

    @When("I login with the a username and password")
    public void loginToAppWithUsernameAndPasswordInLoginForm() {
        signUpAndLoginTest.enterUsernameAndPasswordAndClickSubmitbutton();
    }

    @Then("I should land on the registered user page")
    public void verifyLandingPageOfTheUserAfterLogin() {
        signUpAndLoginTest.validateLandingPageAfterLogin();
    }

    @When("I create a new account for the new user")
    public void createNewAccountForTheUser() {
        signUpAndLoginTest.enterEmailAddressAndClickCreateAccount();
    }

    @Then("I should land on the new user page")
    public void verifyLandingPageOfNewUserToCreateAccount() {
        signUpAndLoginTest.validateLandingPageToCreateAccountForNewUser();
    }

    @Then("I should enter the personal details of the user")
    public void enterPersonalDetailsOftheUser() {
        signUpAndLoginTest.enterPersonalInformationOfNewUser();
    }

    @Then("I should enter the address and phone number of the user")
    public void enterAddressAndPhoneNumberOfUser() {
        signUpAndLoginTest.enterAddressAndPhoneNumberofUser();
    }

    @Then("I should register the user")
    public void clickOnRegisterToRegisterTheUser() {
        signUpAndLoginTest.clickOnRegisterButtonToRegisterUser();
    }
}
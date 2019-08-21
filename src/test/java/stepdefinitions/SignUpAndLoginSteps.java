package stepdefinitions;

import core.pages.BasePage;
import core.testmethods.SignUpAndLoginTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class SignUpAndLoginSteps extends BasePage {


    private SignUpAndLoginTest signUpAndLoginTest;

    public SignUpAndLoginSteps() {
        signUpAndLoginTest =  new SignUpAndLoginTest();
    }

    @Given("I login with user below")
    public void clickBookNow() {

        signUpAndLoginTest.loginToPage();

    }

    @When("I try something")
    public void signInTest() throws InterruptedException {
        signUpAndLoginTest.signUpToApplication();
    }
}
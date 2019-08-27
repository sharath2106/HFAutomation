package core.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import core.actions.enums.LoginElements;
import core.models.Login;
import core.pages.BasePage;

import java.io.File;
import java.io.IOException;

import static core.config.Constant.pathToLoginDataYaml;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginActions extends BasePage {

    private Login login;

    public LoginActions() {
        initializeLoginData();
    }

    public void waitAndClickOnSignInButtonInHomePage(){
        waitForElementToBeLocatedInThePage(loginPage.homePage);
        waitForElementToBeClickable(loginPage.loginPanel);
        click(loginPage.loginPanel, LoginElements.LOGIN.getValue());

    }

    public void enterUsernamePasswordAndLoginByClickingSubmitbutton() {
        waitForElementToBeLocatedInThePage(loginPage.loginForm);
        sendKeys(loginPage.emailTextBox, login.getEmailAddress(), LoginElements.EMAIL_ADDRESS.getValue());
        sendKeys(loginPage.passwordTextBox, login.getPassword(), LoginElements.PASSWORD.getValue());
        click(loginPage.submitButtonLoginPanel, LoginElements.SUBMIT.getValue());
    }

    public void validateMyAccountPageOfUserAfterLogin() {
        String firstName = "Joe";
        String lastName = "Black";

        assertEquals(LoginElements.MY_ACCOUNT.getValue(), loginPage.landingPageHeaderAfterLogin.getText());
//        assertEquals(firstName + " " + lastName, loginPage.userNameInAccount.getText());
        assertTrue(loginPage.welcomeBannerAfterLogin.getText().contains(LoginElements.WELCOME_TO_MY_ACCOUNT.getValue()));
        assertTrue(loginPage.logoutIcon.isDisplayed());
        assertTrue(driver.getCurrentUrl().contains(loginPage.userHomePageURLPath));
    }

    private void initializeLoginData() {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            login = objectMapper.readValue(new File(pathToLoginDataYaml), Login.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

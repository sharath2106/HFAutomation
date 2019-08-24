package core.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import core.models.Login;
import core.pages.BasePage;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginFacade extends BasePage {

    private Login login;
    private ObjectMapper objectMapper;

    public LoginFacade() {
        objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            login = objectMapper.readValue(new File("login.yaml"), Login.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void waitAndClickOnSignInButtonInHomePage(){
        waitForElementToBeLocatedInThePage(loginPage.homePage);
        waitForElementToBeClickable(loginPage.loginPanel);
        loginPage.loginPanel.click();
    }

    public void enterUsernamePasswordAndLoginByClickingSubmitbutton() {
        waitForElementToBeLocatedInThePage(loginPage.loginForm);
        sendKeys(loginPage.emailTextBox, login.getEmailAddress());
        sendKeys(loginPage.passwordTextBox, login.getPassword());
        loginPage.submitButtonLoginPanel.click();
    }

    public void validateMyAccountPageOfUserAfterLogin() {
        String firstName = "Joe";
        String lastName = "Black";

        assertEquals("MY ACCOUNT", loginPage.landingPageHeaderAfterLogin.getText());
        assertEquals(firstName + " " + lastName, loginPage.userNameInAccount.getText());
        assertTrue(loginPage.welcomeBannerAfterLogin.getText().contains("Welcome to your account."));
        assertTrue(loginPage.logoutIcon.isDisplayed());
        assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
    }
}

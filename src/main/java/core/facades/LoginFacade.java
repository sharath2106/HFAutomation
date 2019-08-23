package core.facades;

import core.dto.LoginDto;
import core.pages.BasePage;
import lombok.AllArgsConstructor;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@AllArgsConstructor
public class LoginFacade extends BasePage {

    private LoginDto loginDto;

    public void waitAndClickOnSignInButtonInHomePage(){
        waitForElementToBeLocatedInThePage(loginPage.homePage);
        waitForElementToBeClickable(loginPage.loginPanel);
        loginPage.loginPanel.click();
    }

    public void enterUsernamePasswordAndLoginByClickingSubmitbutton() {
        String existingUserEmail = "hf_challenge_123456@hf123456.com";
        String existingUserPassword = "12345678";

        waitForElementToBeLocatedInThePage(loginPage.loginForm);
//        sendKeys(loginPage.emailTextBox, existingUserEmail);
//        sendKeys(loginPage.passwordTextBox, existingUserPassword);
        sendKeys(loginPage.emailTextBox, loginDto.getEmailAddress());
        sendKeys(loginPage.passwordTextBox, loginDto.getPassword());
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

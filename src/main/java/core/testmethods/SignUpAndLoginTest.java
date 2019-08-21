package core.testmethods;

import core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignUpAndLoginTest extends BasePage {

    public void loginToPage() {

        String fullName = "Joe Black";
        loginPage.loginPanel.click();
        String existingUserEmail = "hf_challenge_123456@hf123456.com";
        String existingUserPassword = "12345678";
        loginPage.emailTextBox.sendKeys(existingUserEmail);
        loginPage.passwordTextBox.sendKeys(existingUserPassword);
        loginPage.submitButtonLoginPanel.click();

        assertEquals("MY ACCOUNT", loginPage.landingPageHeaderAfterLogin.getText());
        assertEquals(fullName, loginPage.userNameInAccount.getText());
        assertTrue(loginPage.welcomeBannerAfterLogin.getText().contains("Welcome to your account."));
        assertTrue(loginPage.logoutIcon.isDisplayed());
        assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
    }


    public void signUpToApplication() {
        loginPage.loginPanel.click();
        String timestamp = String.valueOf(new Date().getTime());
        String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
        String name = "Firstname";
        String surname = "Lastname";
        signUpPage.emailTextBoxCreateAccount.sendKeys(email);
        signUpPage.submitButtonCreateAccount.click();
        signUpPage.selectGender.click();
        signUpPage.customersFirstName.sendKeys(name);
        signUpPage.customerLastName.sendKeys(surname);
        signUpPage.enterPassword.sendKeys("Qwerty");
        Select select = new Select(driver.findElement(By.id("days")));
        select.selectByValue("1");
        select = new Select(driver.findElement(By.id("months")));
        select.selectByValue("1");
        select = new Select(driver.findElement(By.id("years")));
        select.selectByValue("2000");
        signUpPage.enterCompany.sendKeys("Company");
        signUpPage.enterAddress1.sendKeys("Qwerty, 123");
        signUpPage.enterAddress2.sendKeys("zxcvb");
        signUpPage.enterCity.sendKeys("Qwerty");
        select = new Select(signUpPage.selectState);
        select.selectByVisibleText("Colorado");
        signUpPage.enterPostCode.sendKeys("12345");
        signUpPage.enterOthers.sendKeys("Qwerty");
        signUpPage.enterPhone.sendKeys("12345123123");
        signUpPage.enterMobilePhone.sendKeys("12345123123");
        signUpPage.enterAlias.sendKeys("hf");
        signUpPage.submitAccount.click();

        assertEquals("MY ACCOUNT", loginPage.landingPageHeaderAfterLogin.getText());
        assertEquals(name +" "+surname, loginPage.userNameInAccount.getText());
        assertTrue(loginPage.welcomeBannerAfterLogin.getText().contains("Welcome to your account."));
        assertTrue(loginPage.logoutIcon.isDisplayed());
        assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
    }


}

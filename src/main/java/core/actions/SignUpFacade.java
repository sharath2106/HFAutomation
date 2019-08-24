package core.actions;

import core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import java.util.Date;

public class SignUpFacade extends BasePage {

    public void enterEmailAddressAndRegisterUserByClickingCreateAccountButton(){
        String timestamp = String.valueOf(new Date().getTime());
        String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";

        waitForElementToBeLocatedInThePage(signUpPage.createAccountForm);
        signUpPage.emailTextBoxCreateAccount.sendKeys(email);
        signUpPage.submitButtonCreateAccount.click();
    }

    public void validateLandingPageToCreateAccountForNewUser(){
        waitAndAssert(signUpPage.newAccountCreationForm, "User not landed in the create account form page");
    }

    public void enterPersonalInformationOfNewUserToCreateAccount(){
        String name = "Joe";
        String surname = "Black";
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
    }

    public void enterAddressAndPhoneNumberOfNewUserToCreateAccount() {
        Select select;
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
    }

    public void registerUserByClickingOnRegisterButton(){
        waitForElementToBeClickable(signUpPage.submitAccount);
        signUpPage.submitAccount.click();
    }




}

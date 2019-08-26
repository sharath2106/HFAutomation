package core.actions;

import core.config.Utilities;
import core.models.SignUp;
import core.pages.BasePage;

public class SignUpFacade extends BasePage {

    private SignUp signUp;


    public SignUpFacade() {
        signUp = new SignUp();

        initializeSignUpData();
    }

    public void enterEmailAddressAndRegisterUserByClickingCreateAccountButton(){
        waitForElementToBeLocatedInThePage(signUpPage.createAccountForm);
        signUpPage.emailTextBoxCreateAccount.sendKeys(signUp.getEmailAddress());
        signUpPage.submitButtonCreateAccount.click();
    }

    public void validateLandingPageToCreateAccountForNewUser(){
        waitAndAssert(signUpPage.newAccountCreationForm, "User not landed in the create account form page");
    }

    public void enterPersonalInformationOfNewUserToCreateAccount(){
        signUpPage.selectGender.click();
        signUpPage.customersFirstName.sendKeys(signUp.getFirstName());
        signUpPage.customerLastName.sendKeys(signUp.getLastName());
        signUpPage.enterPassword.sendKeys(signUp.getPassword());
        selectDropDownByValue(signUpPage.selectDays, "1");
        selectDropDownByValue(signUpPage.selectMonths, "1");
        selectDropDownByValue(signUpPage.selectYears, "2000");
    }

    public void enterAddressAndPhoneNumberOfNewUserToCreateAccount() {
        signUpPage.enterCompany.sendKeys(signUp.getCompany());
        signUpPage.enterAddress1.sendKeys(signUp.getAddressLine1());
        signUpPage.enterAddress2.sendKeys(signUp.getAddressLine2());
        signUpPage.enterCity.sendKeys(signUp.getCity());
        selectDropDownByValue(signUpPage.selectState, "1");
        signUpPage.enterPostCode.sendKeys(signUp.getPostalCode());
        signUpPage.enterOthers.sendKeys(signUp.getAdditionalInformation());
        signUpPage.enterPhone.sendKeys(signUp.getHomePhone());
        signUpPage.enterMobilePhone.sendKeys(signUp.getMobilePhone());
        signUpPage.enterAlias.sendKeys(signUp.getAddressAlias());
    }

    public void registerUserByClickingOnRegisterButton(){
        waitForElementToBeClickable(signUpPage.submitAccount);
        signUpPage.submitAccount.click();
    }

    private void initializeSignUpData() {
        Utilities randomGenerator = new Utilities();

        signUp.setEmailAddress(randomGenerator.getRandomString(5)+"@yourstore.com");
        signUp.setFirstName(randomGenerator.getRandomString(7));
        signUp.setLastName(randomGenerator.getRandomString(5));
        signUp.setPassword(randomGenerator.getRandomAlphanumeric(8));
        signUp.setCompany(randomGenerator.getRandomString(6));
        signUp.setAddressLine1(randomGenerator.getRandomString(6));
        signUp.setAddressLine2(randomGenerator.getRandomString(6));
        signUp.setCity(randomGenerator.getRandomString(6));
        signUp.setState(randomGenerator.getRandomString(6));
        signUp.setPostalCode(randomGenerator.getRandomNumber(5));
        signUp.setCountry(randomGenerator.getRandomString(6));
        signUp.setAdditionalInformation(randomGenerator.getRandomString(6));
        signUp.setHomePhone(randomGenerator.getRandomNumber(10));
        signUp.setMobilePhone(randomGenerator.getRandomNumber(10));
        signUp.setAddressAlias(randomGenerator.getRandomString(6));

    }
}

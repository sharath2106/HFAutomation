package core.actions;

import core.config.Utilities;
import core.actions.enums.LoginElements;
import core.actions.enums.SignUpElements;
import core.models.SignUp;
import core.pages.BasePage;
import org.testng.Assert;

public class SignUpActions extends BasePage {

    private SignUp signUp;


    public SignUpActions() {
        signUp = new SignUp();

        initializeSignUpData();
    }

    public void enterEmailAddressAndRegisterUserByClickingCreateAccountButton(){
        waitForElementToBeLocatedInThePage(signUpPage.createAccountForm);
        sendKeys(signUpPage.emailTextBoxCreateAccount, signUp.getEmailAddress(), LoginElements.EMAIL_ADDRESS.getValue());
        click(signUpPage.submitButtonCreateAccount, LoginElements.SUBMIT.getValue());
    }


    public void validateLandingPageToCreateAccountForNewUser(){
        waitForElementToBeClickable(signUpPage.newAccountCreationForm);
        Assert.assertTrue(isElementDisplayed(signUpPage.newAccountCreationForm, SignUpElements.NEW_ACCOUNT_FORM.getValue()), "User not landed in the create account form page");
    }

    public void enterPersonalInformationOfNewUserToCreateAccount(){
        click(signUpPage.selectGender, SignUpElements.GENDER.getValue());
        sendKeys(signUpPage.customersFirstName, signUp.getFirstName(),SignUpElements.FIRST_NAME.getValue());
        sendKeys(signUpPage.customerLastName, signUp.getLastName(), SignUpElements.LAST_NAME.getValue());
        sendKeys(signUpPage.enterPassword, signUp.getPassword(), LoginElements.PASSWORD.getValue());
        selectDropDownByValue(signUpPage.selectDays, "1", SignUpElements.DAYS.getValue());
        selectDropDownByValue(signUpPage.selectMonths, "1",SignUpElements.MONTHS.getValue());
        selectDropDownByValue(signUpPage.selectYears, "2000",SignUpElements.YEARS.getValue());
    }

    public void enterAddressAndPhoneNumberOfNewUserToCreateAccount() {
        sendKeys(signUpPage.enterCompany, signUp.getCompany(), SignUpElements.COMPANY.getValue());
        sendKeys(signUpPage.enterAddress1, signUp.getAddressLine1(), SignUpElements.ADDRESS_LINE_1.getValue());
        sendKeys(signUpPage.enterAddress2, signUp.getAddressLine2(), SignUpElements.ADDRESS_LINE_2.getValue());
        sendKeys(signUpPage.enterCity, signUp.getCity(), SignUpElements.CITY.getValue());
        sendKeys(signUpPage.enterPostCode, signUp.getPostalCode(), SignUpElements.POSTAL_CODE.getValue());
        sendKeys(signUpPage.enterOthers, signUp.getAdditionalInformation(), SignUpElements.ADDITIONAL_INFORMATION.getValue());
        sendKeys(signUpPage.enterPhone, signUp.getHomePhone(), SignUpElements.HOME_PHONE.getValue());
        sendKeys(signUpPage.enterMobilePhone, signUp.getMobilePhone(), SignUpElements.MOBILE_PHONE.getValue());
        sendKeys(signUpPage.enterAlias, signUp.getAddressAlias(), SignUpElements.ADDRESS_ALIAS.getValue());
        selectDropDownByValue(signUpPage.selectState, "1", SignUpElements.STATE.getValue());
    }

    public void registerUserByClickingOnRegisterButton(){
        waitForElementToBeClickable(signUpPage.submitAccount);
        click(signUpPage.submitAccount, LoginElements.SUBMIT.getValue());
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

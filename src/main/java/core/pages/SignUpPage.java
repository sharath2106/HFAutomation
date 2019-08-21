package core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {

    @FindBy(id = "email_create")
    public WebElement emailTextBoxCreateAccount;

    @FindBy(id = "SubmitCreate")
    public WebElement submitButtonCreateAccount;

    @FindBy(id = "id_gender2")
    public WebElement selectGender;

    @FindBy(id = "customer_firstname")
    public WebElement customersFirstName;

    @FindBy(id = "customer_lastname")
    public WebElement customerLastName;

    @FindBy(id = "passwd")
    public WebElement enterPassword;

    @FindBy(id = "days")
    public WebElement selectDays;

    @FindBy(id = "months")
    public WebElement selectMonths;

    @FindBy(id = "years")
    public WebElement selectYears;

    @FindBy(id = "company")
    public WebElement enterCompany;

    @FindBy(id = "address1")
    public WebElement enterAddress1;

    @FindBy(id = "address2")
    public WebElement enterAddress2;

    @FindBy(id = "city")
    public WebElement enterCity;

    @FindBy(id = "id_state")
    public WebElement selectState;

    @FindBy(id = "postcode")
    public WebElement enterPostCode;

    @FindBy(id = "other")
    public WebElement enterOthers;

    @FindBy(id = "phone")
    public WebElement enterPhone;

    @FindBy(id = "phone_mobile")
    public WebElement enterMobilePhone;

    @FindBy(id = "alias")
    public WebElement enterAlias;

    @FindBy(id = "submitAccount")
    public WebElement submitAccount;

}

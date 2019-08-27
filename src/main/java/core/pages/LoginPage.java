package core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(className = "columns-container")
    public By homePage;

    @FindBy(id = "login_form")
    public By loginForm;

    @FindBy(className = "login")
    public WebElement loginPanel;

    @FindBy(id = "email")
    public WebElement emailTextBox;

    @FindBy(id = "passwd")
    public WebElement passwordTextBox;

    @FindBy(id = "SubmitLogin")
    public WebElement submitButtonLoginPanel;

    @FindBy(css = "h1")
    public WebElement landingPageHeaderAfterLogin;

    @FindBy(className = "account")
    public WebElement userNameInAccount;

    @FindBy(className = "info-account")
    public WebElement welcomeBannerAfterLogin;

    @FindBy(className = "logout")
    public WebElement logoutIcon;

    public final String userHomePageURLPath = "controller=my-account";
}

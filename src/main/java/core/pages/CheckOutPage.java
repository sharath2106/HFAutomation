package core.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage {

    @FindBy(linkText = "Women")
    public WebElement dressCategory;

    @FindBy(partialLinkText = "Faded Short Sleeve T-shirts")
    public WebElement dressSelectedInTheCategory;

    @FindBy(name = "Submit")
    public WebElement dressSelectionSubmit;

    @FindBy(xpath = "//a[@title='Proceed to checkout']//span")
    public WebElement proceedToCheckoutFromLayerCart;

    @FindBy(xpath = "//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']")
    public WebElement proceedToCheckoutFromCartPage;

    @FindBy(name = "processAddress")
    public WebElement processAddressOfCustomer;

    @FindBy(id = "uniform-cgv")
    public WebElement uniformcgv;

    @FindBy(name = "processCarrier")
    public WebElement termsAndConditions;

    @FindBy(className = "bankw0ire")
    public WebElement bankWirePayment;

    @FindBy(xpath = "//*[@id='cart_navigation']/button")
    public WebElement clickOrderConfirmation;

    @FindBy(css = "h1")
    public WebElement orderConfirmationBanner;

    @FindBy(xpath = "//li[@class='step_done step_done_last four']")
    public WebElement orderConfirmationFirstStep;

    @FindBy(xpath = "//li[@id='step_end' and @class='step_current last']")
    public WebElement orderConfirmationSecondStep;

    @FindBy(xpath = "//*[@class='cheque-indent']/strong")
    public WebElement orderConfirmationOnMyStoreBanner;

    public String orderConfirmationURLPath = "controller=order-confirmation";


}

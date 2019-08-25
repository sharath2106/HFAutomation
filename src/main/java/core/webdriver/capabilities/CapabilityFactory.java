package core.webdriver.capabilities;

import org.openqa.selenium.Capabilities;

public class CapabilityFactory {
    private Capabilities capabilities;

    public Capabilities getCapabilities (String browser) {
        capabilities = browser.equals("firefox") ? OptionsManager.getFirefoxOptions() : OptionsManager.getChromeOptions();
        return capabilities;
    }
}
package supports;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.TemporaryFilesystem;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

public class DesiredCapsManager {
    private static final String BROWSER_CHROME = "chrome";

    public DesiredCapabilities getDesiredCapabilities(String browser) throws Exception  {
        //Set DesiredCapabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //Firefox Profile Settings
        switch (browser) {
            case "firefox":
                setFirefoxCaps(capabilities);
                break;
            case "chrome":
                setChromeCaps(capabilities);
                break;
        }
        //Set BrowserName
        capabilities.setCapability("browserName", browser);
        return capabilities;
    }

    //Set Firefox Capabilities
    public void setFirefoxCaps (DesiredCapabilities capabilities) {
    }

    //Set Chrome Options
    public void setChromeCaps (DesiredCapabilities capabilities) {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
        options.addArguments("test-type");
        options.addArguments("disable-popup-blocking");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("disable-translate");
        options.addArguments("disable-infobars");
        options.addArguments("start-maximized");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    }



}

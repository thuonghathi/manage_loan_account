package supports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    public DesiredCapabilities caps;
    public String browser = null;
    public WebDriver driver = null;
    private String driverPath;

    public DriverManager(DesiredCapabilities capabilities, String browser, String driverPath) {
        this.caps = capabilities;
        this.browser = browser;
        this.driverPath = driverPath;
    }

    public WebDriver createDriver() throws MalformedURLException, Exception {

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", this.driverPath + "chromedriver.exe");
                driver = new ChromeDriver(caps);
                break;
        }
        return driver;
    }
}

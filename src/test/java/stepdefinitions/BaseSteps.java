package stepdefinitions;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.OnboardingPage;
import pages.RegistrationPage;

public class BaseSteps {
    public static BaseSteps BASE_INSTANCE = null;

    public static BaseSteps getInstance() {
        if (BASE_INSTANCE == null) {
            synchronized (BaseSteps.class) {
                if (BASE_INSTANCE == null) {
                    BASE_INSTANCE = new BaseSteps();
                }
            }
        }
        return BASE_INSTANCE;
    }

    private String browser;
    private WebDriver driver;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private OnboardingPage onboardingPage;

    public OnboardingPage getOnboardingPage() {
        onboardingPage = new OnboardingPage(driver);
        return onboardingPage;
    }

    public void setOnboardingPage() {
        onboardingPage = new OnboardingPage(getDriver());
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        loginPage = new LoginPage(driver);
        return loginPage;
    }

    public void setLoginPage() {
        loginPage = new LoginPage(getDriver());
    }


    public RegistrationPage getRegistrationPage() {
        registrationPage = new RegistrationPage(driver);
        return registrationPage;
    }

    public void setRegistrationPage() {
        registrationPage = new RegistrationPage(getDriver());
    }
}

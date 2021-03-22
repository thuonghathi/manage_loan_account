package configuration;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import stepdefinitions.BaseSteps;
import supports.Commonfunction;
import supports.DesiredCapsManager;
import supports.DriverManager;
import supports.JSWaiter;

import java.io.IOException;


public class TestConfiguration {
    WebDriver driver;
    JSWaiter waiter;
    public BaseSteps web;
    private DesiredCapsManager desiredCapsManager = new DesiredCapsManager();
    public BaseSteps baseSteps = BaseSteps.getInstance();
    public Commonfunction commonfunction;


    @Before
    public void configTestEnvironment(Scenario scenario) throws Exception {
        try {
            String browser = "chrome";
            String driverPath =System.getProperty("user.dir")+"/driver/";
            //Get DesiredCapabilities
            DesiredCapabilities capabilities = desiredCapsManager.getDesiredCapabilities(browser);
            //Create Driver with capabilities
            driver = new DriverManager(capabilities, browser, driverPath).createDriver();
            //Maximize Window
            driver.manage().window().maximize();

            commonfunction = new Commonfunction(driver);
            baseSteps.setDriver(driver);
            baseSteps.setBrowser(browser);
            waiter = new JSWaiter(driver);
        } catch (Exception e) {
            throw e;
        }
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        try {
            if (scenario.isFailed()) {
                commonfunction.takeSnapShot(scenario.getName());
            }
            driver.quit();
        } catch (Exception e) {
            throw e;
        }
    }
}

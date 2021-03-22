package supports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Commonfunction {
    public WebDriver driver;
    public WebDriverWait wait;
    Wait<WebDriver> fluentWait;
    public int serverTimeout = 30;
    public JSWaiter waiter;

    public Commonfunction(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, serverTimeout);
        waiter = new JSWaiter(driver);
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(serverTimeout, SECONDS)
                .pollingEvery(1, SECONDS)
                .ignoring(NoSuchElementException.class);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public By by(How how, String locator){
        By el = null;
        switch (how){

            case CLASS_NAME:
                el =By.className(locator);
                break;
            case CSS:
                el=By.cssSelector(locator);
                break;
            case ID:
                el=By.id(locator);
                break;
            case ID_OR_NAME:
                el= ByIdOrName.id(locator);
                break;
            case LINK_TEXT:
                el=By.linkText(locator);
                break;
            case NAME:
                el=By.name(locator);
                break;
            case PARTIAL_LINK_TEXT:
                el=By.partialLinkText(locator);

                break;
            case TAG_NAME:
                el=By.tagName(locator);
                break;
            case XPATH:
                el=By.xpath(locator);
                break;
            case UNSET:
                break;
        }

        return el;
    }
    public WebElement find(By by){
        return driver.findElement(by);
    }
    public void fill(By by, String value){
        waiForElementPresent(by);
        clear(by);
        find(by).sendKeys(value);
    }
    public void click(By by){
        waiForElementPresent(by);
        find(by).click();
    }
    public void clear(By by){
        find(by).clear();
    }
    public void visit(String url){
        driver.get(url);
    }
    public void waiForElementPresent(By el){
        wait.until(ExpectedConditions.visibilityOfElementLocated(el));
    }
    public String getText(By by){
        return find(by).getText().trim();
    }
    public void clickcheckbox(By locator) {
        if (!find(locator).isSelected())
            find(locator).click();
    }
    public void takeSnapShot(String name) throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        String timeStamp = System.currentTimeMillis() / 1000 + "";
        File DestFile = new File("log/screenshot" +" - "+name+"-"+ timeStamp  + ".png");
        FileUtils.copyFile(SrcFile, DestFile);

    }
    public boolean isElementExist(By elementLocation) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(elementLocation));
            return driver.findElement(elementLocation).isDisplayed();
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }
    public void waitAnElementDisplay(By elementLocation){
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }
    public void waitUntilTheButtonClickable(By locator){
        WebDriverWait t = new WebDriverWait(driver, serverTimeout);
        t.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public String getCurrentURL() {
        String currentURL = driver.getCurrentUrl();
        return currentURL;
    }
    public void scrollToElement(By elementLocation){
        try {
            WebElement element = driver.findElement(elementLocation);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        }catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document "+ e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element was not found in DOM "+ e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Unable to scroll to element "+ e.getStackTrace());
        }
    }
    //Generate a random string
    public String randomNumeric(int count) {
        String NUMERIC = "123456789";
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * NUMERIC.length());
            builder.append(NUMERIC.charAt(character));
        }
        return builder.toString();
    }
    //Generate a random string
    public String randomAlphaNumeric(int count) {
        String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
}

package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import supports.Commonfunction;
import org.testng.Assert;

import java.util.List;

public class RegistrationPage extends Commonfunction {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public static String BASE_URL = "/register";
    private static By Title = By.cssSelector("aside div.text-h4");
    private static By FullName_TXT = By.cssSelector("input[name='full_name']");
    private static By Email_TXT = By.cssSelector("input[name='email']");
    private static By FlatCountry = By.cssSelector("div.flag-select__icon");
    private static String Country = "//div[contains(@class,'q-menu')]//div[contains(text(),'%s')]";
    private static By Phone_TXT = By.cssSelector("input[name='phone']");
    private static By DirectorRole_RAD = By.cssSelector("div[aria-label='Appointed director']");
    private static By NonDirectorRole_RAD = By.cssSelector("div[aria-label='Non-director']");
    private static By HearAbout_TXT = By.cssSelector("input[type='search']");
    private static By PromoCode_TXT = By.cssSelector("input[data-cy='register-person-referral-code']");
    private static By TermsCondition_CKB = By.cssSelector("div[class*='register']> div.q-checkbox");
    private static By Continue_BTN = By.cssSelector("div.auth-form__buttons button");
    private static By OTP_TXT = By.xpath("//form//div[@class='digit-input']/input");
    private static By OTPFail_msg = By.xpath("//div[contains(text(),'invalid')]");
    private static By OTPFocus_TXT = By.xpath("//form//div[@class='digit-input']/input/following-sibling::div/div[1]");
    private static By ResendOTP_BTN = By.cssSelector("button[data-cy='verify-otp-request-new']");

    public void isOnRegisterPage() throws InterruptedException {
        Assert.assertTrue(getTitle().equalsIgnoreCase("Let's get started"), "Title of register Page is not display correctly");
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.contains(BASE_URL), "URL is not correct. Not on register page.");

    }

    public String getTitle() {
        waitAnElementDisplay(Title);
        String title = getText(Title);
        return title;
    }

    public void inputFullName(String name) {
        fill(FullName_TXT, name);
    }

    public void inputEmail(String email) {
        System.out.println("email: " + randomAlphaNumeric(5) + email);
        fill(Email_TXT, randomAlphaNumeric(5) + email);
    }

    public void clickFlatCountry() {
        click(FlatCountry);
    }

    public void chooseCountry(String countryName) {
        scrollToElement(By.xpath(String.format(Country, countryName)));
        find(By.xpath(String.format(Country, countryName))).click();
    }

    public void inputPhoneNumber() {
        fill(Phone_TXT, randomNumeric(8));
    }

    public void selectDerectorRole() {
        clickcheckbox(DirectorRole_RAD);
    }

    public void selectNonDerectorRole() {
        clickcheckbox(NonDirectorRole_RAD);
    }

    public void inputHearAboutUs(String name) {
        click(HearAbout_TXT);
        waitAnElementDisplay(By.xpath(String.format(Country, name)));
        scrollToElement(By.xpath(String.format(Country, name)));
        find(By.xpath(String.format(Country, name))).click();
    }

    public void inputPromoCode(String code) {
        fill(PromoCode_TXT, code);
    }

    public void checkTermCondition() {
        clickcheckbox(TermsCondition_CKB);
    }

    public void clickContinueButton() {
        scrollToElement(Continue_BTN);
        waitUntilTheButtonClickable(Continue_BTN);
        click(Continue_BTN);
        wait.until(ExpectedConditions.urlContains("verify-otp"));
    }


    public void inputPhoneOTP() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(OTP_TXT));
        waitUntilTheButtonClickable(ResendOTP_BTN);
        find(OTP_TXT).sendKeys("1234");
    }
    public void isOnTheCompletePage() throws InterruptedException {
        wait.until(ExpectedConditions.urlContains("completed"));
    }
}

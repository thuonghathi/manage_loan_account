package pages;

import org.apache.poi.hssf.record.PageBreakRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import supports.Commonfunction;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OnboardingPage extends Commonfunction {
    public OnboardingPage(WebDriver driver) {
        super(driver);
    }

    public static String BASE_URL = "onboarding";
    public static String Incorporate_URL = "incorporate-selector";
    public static String Registration_URL = "register-select-method";
    public static String PersonView_URL = "person-view";
    public static String PersonEdit_URL = "person-edit";
    public static String BusinessView_URL = "business-view";
    public static String BusinessEdit_URL = "business-edit";
    public static String IdentifyView_URL = "identify-view";

    private static By Continue_BTN = By.xpath("//span[text()='Continue']");
    private static By BusinessContinue_BTN = By.cssSelector("div.auth-form__card > div:nth-child(1) button");
    private static By NonBusinessContinue_BTN = By.cssSelector("div.auth-form__card > div:nth-child(2) button");
    private static By MyInfoStarted_BTN = By.cssSelector("div.auth-form__card > div[class*='onboarding-step-registe'] button");
    private static By StandardStarted_BTN = By.xpath("//div[contains(text(),'Standard')]/following-sibling::button");

    //person-view step
    private static By ContinueEdit_BTN = By.cssSelector("main button");
    private static By IdentityCard_TXT = By.cssSelector("div[label='Identity Card Number'] input");
    private static By DayOfBirth_BTN = By.cssSelector("div[label='Date of Birth'] input");
    private static By Year = By.cssSelector("div.q-date__navigation > div:nth-child(5) button");
    private static By ListYearItem = By.cssSelector("div.q-date__years-item span.block");
    private static By Month = By.cssSelector("div.q-date__navigation > div:nth-child(2) button");
    private static String ListMonthItem = "//div[contains(@class,'q-date__months-item')]//span[text()='%s']";
    private static String ListDay = "//div[contains(@class,'q-date__calendar-item')]//span[text()='%s']";
    private static By Pre_BTN = By.cssSelector("div.q-date__years div.col-auto:nth-child(1)");
    private static By Next_BTN = By.cssSelector("div.q-date__years div.col-auto:nth-child(2)");
    private static By Nationality_TXT = By.cssSelector("div[label='Nationality'] input");
    private static String NationalityList = "//div[contains(@class,'q-menu')]//div[contains(text(),'%s')]";
    private static By Gender_TXT = By.cssSelector("div[label='Gender'] input");
    private static String GenderList = "//div[contains(@class,'q-menu')]//div[contains(text(),'%s')]";
    private static By ProductIntrest = By.cssSelector("div[label*='interested'] div[data-cy=person-edit-purposes]");
    private static String ProductIntrestList = "//div[contains(@class,'q-menu')]//div[contains(text(),'%s')]";
    private static By Submit_BTN = By.cssSelector("div.auth-form__buttons button");
    //business-viewstep
    private static By BusinessName_TXT = By.cssSelector("div[data-cy='register-business-name'] input");
    private static By RegistrationParent_TXT = By.cssSelector("div[data-cy='register-business-registration-type'] i");
    private static By RegistrationType_TXT = By.cssSelector("div[data-cy*='sub-registration-type'] input");
    private static By BusinessNumber_TXT = By.cssSelector("div[data-cy='register-business-registration-number'] input");
    private static By BusinessWebsite_TXT = By.cssSelector("div[data-cy*='website-url'] input");
    private static By Industry_TXT = By.cssSelector("div[data-cy*='industry'] input");
    private static By SubIndustry_TXT = By.cssSelector("div[data-cy*='sub-industry'] input");

    public void isOnBoardingPage() {
        wait.until(ExpectedConditions.urlContains(BASE_URL));
    }

    public void clickContinueButton() {
        waitAnElementDisplay(Continue_BTN);
        click(Continue_BTN);
    }

    public void isOnIncorporatePage() {
        wait.until(ExpectedConditions.urlContains(Incorporate_URL));
    }

    public void isOnRegistrationPage() {
        wait.until(ExpectedConditions.urlContains(Registration_URL));
    }

    public void isOnPersonalViewPage() {
        wait.until(ExpectedConditions.urlContains(PersonView_URL));
    }

    public void isOnPersonalEditPage() {
        wait.until(ExpectedConditions.urlContains(PersonEdit_URL));
    }
    public void isOnBusinessViewPage() {
        wait.until(ExpectedConditions.urlContains(BusinessView_URL));
    }
    public void isOnBusinessEditPage() {
        wait.until(ExpectedConditions.urlContains(BusinessEdit_URL));
    }
    public void isOnIdentifyViewPage() {
        wait.until(ExpectedConditions.urlContains(IdentifyView_URL));
    }

    public void chooseBusinessOrNonBusiness(String type) {
        switch (type) {
            case "Business":
                click(BusinessContinue_BTN);
                break;
            case "Non-Business":
                click(NonBusinessContinue_BTN);
                break;
        }
    }

    public void chooseInfoOrStandard(String type) {
        switch (type) {
            case "MyInfo":
                click(MyInfoStarted_BTN);
                break;
            case "Standard":
                click(StandardStarted_BTN);
                break;
        }
    }

    public void clickContinueEditButton() {
        waitAnElementDisplay(ContinueEdit_BTN);
        click(ContinueEdit_BTN);
    }

    public void inputIdentityCard() {
        fill(IdentityCard_TXT, randomNumeric(5));
    }

    public void selectDayOfBirth(String day) throws ParseException, InterruptedException {
        SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
        Date date = dt.parse(day);

        // *** same for the format String below
        SimpleDateFormat dt1 = new SimpleDateFormat("d-MMMM-yyyy");
        SimpleDateFormat dt2 = new SimpleDateFormat("MMM");
        String Target_day_of_birth = dt1.format(date);
        String[] parts = Target_day_of_birth.split("-");

        click(DayOfBirth_BTN);
        waitAnElementDisplay(Year);
        String year = getText(Year);
        String month = getText(Month);
        //get year
        if (year != parts[2]) {
            click(Year);
            year:
            while (year != parts[2]) {
                if (Integer.parseInt(year) > Integer.parseInt(parts[2])) {
                    click(Pre_BTN);
                    List<WebElement> lstYear = driver.findElements(ListYearItem);
                    for (WebElement lst : lstYear) {
                        String value = lst.getText().trim();
                        if (value.equalsIgnoreCase(parts[2])) {
                            lst.click();
                            break year;
                        }
                    }
                } else {
                    click(Next_BTN);
                    List<WebElement> lstYear = driver.findElements(ListYearItem);
                    for (WebElement lst : lstYear) {
                        String value = lst.getText().trim();
                        if (value == parts[2]) {
                            lst.click();
                            break year;
                        }
                    }
                }

            }
        }
        //get month
        if (month != parts[1]) {
            click(Month);
            waitUntilTheButtonClickable(By.xpath(String.format(ListMonthItem, dt2.format(date))));
            click(By.xpath(String.format(ListMonthItem, dt2.format(date))));
        }
        //get day
        waitUntilTheButtonClickable(By.xpath(String.format(ListDay, parts[0])));
        click(By.xpath(String.format(ListDay, parts[0])));

    }

    public void chooseNationality(String name) {
        waitUntilTheButtonClickable(Nationality_TXT);
        click(Nationality_TXT);
        waitAnElementDisplay(By.xpath(String.format(NationalityList, name)));
        scrollToElement(By.xpath(String.format(NationalityList, name)));
        find(By.xpath(String.format(NationalityList, name))).click();
    }

    public void chooseGender(String name) {
        waitUntilTheButtonClickable(Gender_TXT);
        click(Gender_TXT);
        waitAnElementDisplay(By.xpath(String.format(GenderList, name)));
        scrollToElement(By.xpath(String.format(GenderList, name)));
        find(By.xpath(String.format(GenderList, name))).click();
    }

    public void chooseProductsInterested(String name) {
        waitUntilTheButtonClickable(ProductIntrest);
        click(ProductIntrest);
        waitAnElementDisplay(By.xpath(String.format(ProductIntrestList, name)));
        scrollToElement(By.xpath(String.format(ProductIntrestList, name)));
        find(By.xpath(String.format(ProductIntrestList, name))).click();
    }

    public void clickSubmitButton() throws InterruptedException {
        waitUntilTheButtonClickable(Submit_BTN);
        click(Submit_BTN);
    }

    //---------------- Business step
    public void inputBusinessName(){
        waitAnElementDisplay(BusinessName_TXT);
        fill(BusinessName_TXT,randomAlphaNumeric(5));
    }
    public void selectRegistrationParentType(String type){
        waitAnElementDisplay(RegistrationParent_TXT);
        click(RegistrationParent_TXT);
        waitAnElementDisplay(By.xpath(String.format(NationalityList, type)));
        scrollToElement(By.xpath(String.format(NationalityList, type)));
        find(By.xpath(String.format(NationalityList, type))).click();
    }

    public void selectRegistrationType(String type){
        waitAnElementDisplay(RegistrationType_TXT);
        click(RegistrationType_TXT);
        waitAnElementDisplay(By.xpath(String.format(NationalityList, type)));
        scrollToElement(By.xpath(String.format(NationalityList, type)));
        find(By.xpath(String.format(NationalityList, type))).click();
    }

    public void inputBusinessNumber(){
        //format ^([0-9]{8,9}[a-zA-Z]{1})$
        waitAnElementDisplay(BusinessNumber_TXT);
        fill(BusinessNumber_TXT,randomNumeric(9)+randomAlphaNumeric(1));

    }
    public void inputBusinessWebsite(){
        String website ="https://www.google.com/";
        waitAnElementDisplay(BusinessWebsite_TXT);
        fill(BusinessWebsite_TXT,website);

    }
    public void selectIndustry(String type){
        waitAnElementDisplay(Industry_TXT);
        click(Industry_TXT);
        waitAnElementDisplay(By.xpath(String.format(NationalityList, type)));
        scrollToElement(By.xpath(String.format(NationalityList, type)));
        find(By.xpath(String.format(NationalityList, type))).click();

    }
    public void selectSubIndustry(String type){
        waitAnElementDisplay(SubIndustry_TXT);
        click(SubIndustry_TXT);
        waitAnElementDisplay(By.xpath(String.format(NationalityList, type)));
        scrollToElement(By.xpath(String.format(NationalityList, type)));
        find(By.xpath(String.format(NationalityList, type))).click();

    }
}

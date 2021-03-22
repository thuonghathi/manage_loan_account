package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import supports.Commonfunction;

public class LoginPage extends Commonfunction {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static String BASE_URL = "https://feature-qa.customer-frontend.staging.aspireapp.com/sg/";
    private static By Logo = By.cssSelector("img.auth-desktop-sidebar__logo");
    private static By Title = By.cssSelector("aside div.text-h4");
    private static By Register_BTN = By.cssSelector("a[class*='register-link']");
    private static By Login_BTN = By.cssSelector("button[type='submit']");
    private static By LoginEmail_BTN = By.xpath("//span[contains(text(),'email')]");
    private static By Phone_TXT = By.cssSelector("input[name='phone']");
    private static By Email_TXT = By.cssSelector("input[name='email']");

    public void navigateToLogin() {
        visit(BASE_URL);
    }

    public void isOnLoginPage() {
        String currentURL = getCurrentURL();
        Assert.assertTrue(currentURL.equals(BASE_URL), "URL is not correct. Not on Login page.");
        Assert.assertTrue(getLoginTitle().equalsIgnoreCase("Login to Aspire"), "Title of Login Page is not display");
    }

    public String getLoginTitle() {
        waitAnElementDisplay(Title);
        String title = getText(Title);
        return title;
    }

    public void clickRegisterButton() {
        waitAnElementDisplay(Register_BTN);
        click(Register_BTN);
    }
    public void clickLoginButton() {
        waitAnElementDisplay(Login_BTN);
        click(Login_BTN);
    }
    public void clickLoginEmailButton() {
        waitAnElementDisplay(LoginEmail_BTN);
        click(LoginEmail_BTN);
    }
    public void inputPhone(String phone) {
        fill(Phone_TXT, phone);
    }
    public void inputEmail(String email) {
        fill(Email_TXT, email);
    }
}

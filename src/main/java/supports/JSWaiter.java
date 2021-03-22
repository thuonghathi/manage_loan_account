package supports;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSWaiter {
    private static WebDriver jsWaitDriver;
    private static WebDriverWait jsWait;
    private static JavascriptExecutor jsExec;
    private WebDriver driver;
    private static int serverTimeout = 30;

    public JSWaiter(WebDriver driver) {
        jsWaitDriver = driver;
        jsWait = new WebDriverWait(jsWaitDriver, serverTimeout);
        jsExec = (JavascriptExecutor) jsWaitDriver;
    }

}



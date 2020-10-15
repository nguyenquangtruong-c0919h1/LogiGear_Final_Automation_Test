import helper.BrowserHelper;
import org.testng.annotations.*;
import utilities.Constants;

public class BaseTest {

    @BeforeMethod
    @Parameters("browser")
    public void setupStartMethod(String browser) {
        Constants.BROWSER = browser;
        BrowserHelper.startBrowser(BrowserHelper.SelectBrowser.valueOf(Constants.BROWSER.toUpperCase()));
        BrowserHelper.navigateToUrl(Constants.URL);
    }

    @AfterMethod
    public void setupAfterMethod() {
        BrowserHelper.closeDriver();
    }
}

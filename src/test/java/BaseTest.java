import helper.BrowserHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.LoginPage;
import utilities.Constants;

public class BaseTest {

    @BeforeMethod
    public void setupStartMethod() {
        BrowserHelper.startBrowser(BrowserHelper.TypeWeb.CHROME);
        BrowserHelper.navigateToUrl(Constants.URL);
    }

    @AfterMethod
    public void setupAfterMethod() {
        BrowserHelper.closeDriver();
    }
}

import helper.BrowserHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.LoginPage;
import utilities.Constants;

public class BaseTest {

    @BeforeTest
    public void setupStartTest() {
        BrowserHelper.startBrowser(BrowserHelper.TypeWeb.CHROME);
    }

    @BeforeMethod
    public void setupStartMethod() {
        BrowserHelper.navigateToUrl(Constants.URL);
    }

    @AfterMethod
    public void setupAfterMethod() {
        BrowserHelper.closeDriver();
    }
}

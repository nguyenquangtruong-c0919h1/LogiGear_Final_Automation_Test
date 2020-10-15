import helper.BrowserHelper;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.BannersPage;
import pageobject.ClientsPage;
import pageobject.CommonPage;
import pageobject.LoginPage;
import utilities.Constants;
import utilities.Log;

public class ClientsTest extends BaseTest {
    ClientsPage clientsPage;
    LoginPage loginPage;
    BannersPage bannersPage;

    @BeforeMethod
    public void startBeforeMethod() {
        clientsPage = new ClientsPage();
        loginPage = new LoginPage();
        bannersPage = new BannersPage();
        loginPage.login(Constants.USER_NAME_VALID, Constants.PASSWORD_VALID);
    }

    @Test(description = "Verify that user can publish a client")
    public void tc_Joomla_Banners_Clients_003() {
        Log.infoTestCase("TC_JOOMLA_BANNERS_CLIENTS_003: Verify that user can publish a client");

        Log.info("Step 1: Select Component -> Banners -> Clients");
        clientsPage.selectMenuTab(CommonPage.MenuTab.COMPONENTS, CommonPage.ListInMenuTab.BANNER);
        clientsPage.clickClientsNavBar();

        Log.info("Step 2: Click New button");
        clientsPage.clickNewButton();

        String titleForm = DataHelper.getTextRandom();

        Log.info("Step 3: Fill data for Clients form");
        clientsPage.fillDataForClientForm(titleForm, DataHelper.getNameRandom(), DataHelper.getEmailRandom());

        Log.info("Step 4: Click Unpublished");
        clientsPage.clickListDropDownAndSelect(Constants.PUBLISHED, Constants.UNPUBLISHED);

        Log.info("Step 5: Click Save and close");
        clientsPage.clickSaveAndCloseButton();

        Assert.assertEquals(clientsPage.getTextAlertMessage(), Constants.MESSAGE_CLIENT_SAVED, "Save failed");

        Log.info("Step 6: Click Sort Order");
        clientsPage.clickSortOrderAll();

        Assert.assertTrue(clientsPage.getTextTitleFormClient(titleForm), "Failed, Contact is not displayed");

        Log.info("Step 7: Click checkbox ");
        clientsPage.clickCheckBox(titleForm);

        Log.info("Step 8: Click Publish ");
        clientsPage.clickPublishButton();

        Assert.assertTrue(clientsPage.getTextTitleFormClient(titleForm), "Failed, Contact is not displayed");
    }

    @Test(description = "Verify that user can check in a client")
    public void tc_Joola_Banner_Clients_010() {
        Log.infoTestCase("TC_JOOMLA_BANNERS_CLIENTS_010: Verify that user can check in a client");

        Log.info("Step 1: Select Component -> Banners -> Clients");
        clientsPage.selectMenuTab(CommonPage.MenuTab.COMPONENTS, CommonPage.ListInMenuTab.BANNER);
        clientsPage.clickClientsNavBar();

        Log.info("Step 2: Click New button");
        clientsPage.clickNewButton();

        String titleForm = DataHelper.getTextRandom();

        Log.info("Step 3: Fill data for Clients form");
        clientsPage.fillDataForClientForm(titleForm, DataHelper.getNameRandom(), DataHelper.getEmailRandom());

        Log.info("Step 4: Select unpublished in Status");
        clientsPage.clickListDropDownAndSelect(Constants.PUBLISHED, Constants.UNPUBLISHED);

        Log.info("Step 5: Click Save and Close");
        clientsPage.clickSaveAndCloseButton();

        Assert.assertEquals(clientsPage.getTextAlertMessage(), Constants.MESSAGE_CLIENT_SAVED, "Save failed");

        Log.info("Step 6: Click Sort Order");
        clientsPage.clickSortOrderAll();

        Assert.assertTrue(clientsPage.getTextTitleFormClient(titleForm), "Failed, Contact is not displayed");

        Log.info("Step 7: Closer Browser");
        BrowserHelper.closeDriver();

        Log.info("Step 8: Start Browser");
        BrowserHelper.startBrowser(BrowserHelper.SelectBrowser.valueOf(Constants.BROWSER.toUpperCase()));

        Log.info("Step 9: Navigate login page");
        BrowserHelper.navigateToUrl(Constants.URL);

        Log.info("Step 10: Login with valid account");
        loginPage.login(Constants.USER_NAME_VALID, Constants.PASSWORD_VALID);

        Log.info("Step 11: Select Component -> Banners -> Clients");
        clientsPage.selectMenuTab(CommonPage.MenuTab.COMPONENTS, CommonPage.ListInMenuTab.BANNER);
        clientsPage.clickClientsNavBar();

        Log.info("Step 12: Click Sort Order");
        clientsPage.clickSortOrderAll();

        Assert.assertTrue(clientsPage.getTextTitleFormClient(titleForm), "Failed, Clients is not displayed");
        Assert.assertTrue(clientsPage.doesShowUnPublishInTable(titleForm), "Failed, Not in mode unPublish");

        Log.info("Step 13: Click checkbox of title");
        clientsPage.clickCheckBox(titleForm);

        Log.info("Step 14: Click Check In Button");
        clientsPage.clickCheckInButton();

        Assert.assertEquals(clientsPage.getTextAlertMessage(), Constants.MESSAGE_CLIENT_CHECK_IN, "Save failed");

    }

}

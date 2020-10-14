import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.BannerPage;
import pageObject.ClientsPage;
import pageObject.CommonPage;
import pageObject.LoginPage;
import utilities.Constants;
import utilities.Log;

public class ClientsTest extends BaseTest {
    ClientsPage clientsPage;
    LoginPage loginPage;
    BannerPage bannerPage;

    @BeforeMethod
    public void startBeforeMethod() {
        clientsPage = new ClientsPage();
        loginPage = new LoginPage();
        bannerPage = new BannerPage();
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
        bannerPage.fillDataForClientForm(titleForm, DataHelper.getNameRandom(), DataHelper.getEmailRandom());

        Log.info("Step 4: Click Unpublished");
        clientsPage.clickListDropDown(Constants.PUBLISHED);
        clientsPage.clickItemListDropDown(Constants.UNPUBLISHED);

        Log.info("Step 5: Click Save and close");
        clientsPage.clickSaveAndCloseButton();

        Assert.assertEquals(clientsPage.getTextAlertMessage(), Constants.MESSAGE_CLIENT_SAVED, "Save failed");

        Log.info("Step 7: Click Sort Order");
        clientsPage.clickSortOrderAll();

        Assert.assertTrue(clientsPage.getTextTitleFormClient(titleForm), "Failed, Contact is not displayed");

        Log.info("Step 8: Click checkbox ");
        clientsPage.clickCheckbox(Constants.ZERO);

        Log.info("Step 9: Click Publish ");
        clientsPage.clickPublishButton();

        Assert.assertTrue(clientsPage.getTextTitleFormClient(titleForm), "Failed, Contact is not displayed");

    }
}

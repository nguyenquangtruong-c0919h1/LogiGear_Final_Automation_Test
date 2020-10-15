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

public class BannerTest extends BaseTest {
    BannersPage bannersPage;
    LoginPage loginPage;
    ClientsPage clientsPage;

    @BeforeMethod
    public void startBeforeMethod() {
        bannersPage = new BannersPage();
        loginPage = new LoginPage();
        clientsPage = new ClientsPage();
        loginPage.login(Constants.USER_NAME_VALID, Constants.PASSWORD_VALID);
    }

//    @Test(description = "Verify that user can browse 'Banner help' page")
//    public void tc_Joomla_Banner_Banner_007() {
//        Log.infoTestCase("TO_JOOMLA_BANNERS_BANNERS_007: Verify that user can browse 'Banner help' page");
//
//        Log.info("Step 1: Select Components > Banner");
//        bannersPage.selectMenuTab(CommonPage.MenuTab.COMPONENTS, CommonPage.ListInMenuTab.BANNER);
//
//        Log.info("Step 2: CLick Toolbar Help");
//        bannersPage.clickToolbarHelp();
//
//        Assert.assertTrue(BrowserHelper.isShowTitleHelpBrowser(Constants.TEXT_TITLE_HELP), "Navigate Failed, can not get Help Screen");
//    }

    @Test(description = "Verify that user cannot create a new banner without entering the name of the banner")
    public void TC_Joomla_Banners_Banners_014() {
        Log.infoTestCase("TO_JOOMLA_BANNERS_BANNERS_014: Verify that user cannot create a new banner without entering the name of the banner");

        Log.info("Step 1: Select Components > Banner > Clients");
        bannersPage.selectMenuTab(CommonPage.MenuTab.COMPONENTS, CommonPage.ListInMenuTab.BANNER);
        bannersPage.clickNavBar(Constants.CLIENTS);

        Log.info("Step 2: Click New Button");
        bannersPage.clickNewButton();

        String nameClients = DataHelper.getTextRandom();

        Log.info("Step 3: Fill data For Client Form");
        clientsPage.fillDataForClientForm(nameClients, DataHelper.getNameRandom(), DataHelper.getEmailRandom());

        Log.info("Step 4: Click Save and Close");
        bannersPage.clickSaveAndCloseButton();

        Assert.assertEquals(bannersPage.getTextAlertMessage(), Constants.MESSAGE_CLIENT_SAVED, "Save failed");

        Log.info("Step 5: Click Sort Order");
        bannersPage.clickSortOrderAll();

        Assert.assertTrue(bannersPage.doesShowTitleTable(nameClients), "Failed, Title is not displayed");

        Log.info("Step 6: Click Categories Nav ");
        bannersPage.clickNavBar(Constants.CATEGORIES);

        Log.info("Step 7: Click New Button");
        bannersPage.clickNewButton();

        String nameCategory = DataHelper.getTextRandom();

        Log.info("Step 8: Fill data For Categories");
        bannersPage.fillDataForCategory(nameCategory);

        Log.info("Step 9: Click Save and Close");
        bannersPage.clickSaveAndCloseButton();

        Assert.assertEquals(bannersPage.getTextAlertMessage(), Constants.MESSAGE_CATEGORY_SAVED, "Save failed");

        Log.info("Step 10: Click Sort Order");
        bannersPage.clickSortOrderAll();

        Assert.assertTrue(bannersPage.doesShowTitleTable(nameCategory), "Failed, Title is not displayed");

        Log.info("Step 11: Click banners navBar");
        bannersPage.clickNavBar(Constants.BANNER);

        Log.info("Step 12: Click New Button");
        bannersPage.clickNewButton();

        Log.info("Step 13: Select in Category");
        bannersPage.clickListDropDownAndSelect(Constants.SAMPLE_DATA_BANNERS, nameCategory);

        Log.info("Step 14: click Banner Detail");
        bannersPage.clickBannerDetail();

        Log.info("Step 15: Select in Client");
        bannersPage.clickListDropDownAndSelect("- No client -", nameClients);

        Log.info("Step 16: Click Save and Close");
        bannersPage.clickSaveAndCloseButton();

        Assert.assertEquals(bannersPage.getAttributeFormTitle(), Constants.RED_COLOR, "Failed, Does not show red");
        Assert.assertEquals(bannersPage.getTitle(), Constants.TITLE_PAGE, "Failed, Create Success");
    }


}
import helper.BrowserHelper;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.BannerPage;
import pageObject.CommonPage;
import pageObject.LoginPage;
import utilities.Constants;
import utilities.Log;

public class BannerTest extends BaseTest {
    BannerPage bannerPage;
    LoginPage loginPage;

    @BeforeMethod
    public void startBeforeMethod() {
        bannerPage = new BannerPage();
        loginPage = new LoginPage();
        loginPage.login(Constants.USER_NAME_VALID, Constants.PASSWORD_VALID);
    }

    @Test(description = "Verify that user can browse 'Banner help' page")
    public void tc_Joomla_Banner_Banner_007() {
        Log.infoTestCase("TO_JOOMLA_BANNERS_BANNERS_007: Verify that user can browse 'Banner help' page");

        Log.info("Step 1: Select Components > Banner");
        bannerPage.selectMenuTab(CommonPage.MenuTab.COMPONENTS, CommonPage.ListInMenuTab.BANNER);

        Log.info("Step 2: CLick Toolbar Help");
        bannerPage.clickToolbarHelp();

        Assert.assertTrue(BrowserHelper.getTitleBrowser(Constants.TEXT_TITLE_HELP), "Navigate Failed, can not get Help Screen");
    }
    @Test(description = "Verify that user cannot create a new banner without entering the name of the banner")
    public void TC_Joomla_Banners_Banners_014(){
        Log.infoTestCase("TO_JOOMLA_BANNERS_BANNERS_014: Verify that user cannot create a new banner without entering the name of the banner");

        Log.info("Step 1: Select Components > Banner");
        bannerPage.selectMenuTab(CommonPage.MenuTab.COMPONENTS, CommonPage.ListInMenuTab.BANNER);

        Log.info("Step 2: Click Clients Tab");
        bannerPage.clickNavBar("Clients");

        Log.info("Step 3: Click New Button");
        bannerPage.clickNewButton();
        String nameClients = DataHelper.getTextRandom();

        Log.info("Step 4: Fill data For Client Form");
        bannerPage.fillDataForClientForm(nameClients,DataHelper.getNameRandom(),DataHelper.getEmailRandom());

        Log.info("Step 5: Click Save and Close");
        bannerPage.clickSaveAndCloseButton();


        Log.info("Step 6: Click Categories Nav ");
        bannerPage.clickNavBar("Categories");

        Log.info("Step 7: Click New Button");
        bannerPage.clickNewButton();

        String nameCategory = DataHelper.getTextRandom();

        Log.info("Step 8: Fill data For Categories");
        bannerPage.fillDataForCategory(nameCategory);

        Log.info("Step 9: Click Save and Close");
        bannerPage.clickSaveAndCloseButton();

        Assert.assertEquals(bannerPage.getTextAlertMessage(), Constants.MESSAGE_CATEGORY_SAVED, "Save failed");

        Log.info("Step 10: Click banners navBar");
        bannerPage.clickNavBar("Banners");

        Log.info("Step 11: Click New Button");
        bannerPage.clickNewButton();

        Log.info("Step 12: Select in Category");
        bannerPage.clickListDropDown("Sample Data-Banners");
        bannerPage.clickItemListDropDown(nameCategory);

        Log.info("Step 13: click Banner Detail");
        bannerPage.clickBannerDetail();

        Log.info("Step 14: Select in Client");
        bannerPage.clickListDropDown("- No client -");
        bannerPage.clickItemListDropDown(nameClients);

        Log.info("Step 15: Click Save and Close");
        bannerPage.clickSaveAndCloseButton();

        Assert.assertEquals(bannerPage.getAttributeFormTitle(),Constants.RED_COLOR,"Failed, Does not show red");
        Assert.assertEquals(bannerPage.getTitle(),Constants.TITLE_PAGE, "Failed, Create Success");
    }


}
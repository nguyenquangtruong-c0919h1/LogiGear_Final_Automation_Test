import helper.BrowserHelper;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.CommonPage;
import pageobject.LoginPage;
import pageobject.WebLinksPage;
import utilities.Constants;
import utilities.Log;

public class WebLinksTest extends BaseTest {
    WebLinksPage webLinksPage;
    LoginPage loginPage;

    @BeforeMethod
    public void startBeforeMethod() {
        webLinksPage = new WebLinksPage();
        loginPage = new LoginPage();
        loginPage.login(Constants.USER_NAME_VALID, Constants.PASSWORD_VALID);
    }

    @Test(description = "Verify user can create new web link with valid information")
    public void tc_Joola_WebLinks_001() {
        Log.infoTestCase("TC_JOOMLA_WEBLINKS_001: Verify user can create new web link with valid information");

        Log.info("Step 1: Select Component -> WebLinks");
        webLinksPage.selectMenuTab(CommonPage.MenuTab.COMPONENTS, CommonPage.ListInMenuTab.WEB_LINKS);

        Log.info("Step 2: Click New button");
        webLinksPage.clickNewButton();

        String titleName = DataHelper.getTextRandom();
        String urlName = DataHelper.getUrlRandom();

        Log.info("Step 3: Fill data to form WebLink");
        webLinksPage.fillDataFormWebLink(titleName, urlName);

        Log.info("Step 4: Click Save and Close button");
        webLinksPage.clickSaveAndCloseButton();

        Assert.assertEquals(webLinksPage.getTextAlertMessage(), Constants.MESSAGE_WEB_LINK_SAVED, "Save failed");

        Log.info("Step 5: Click Sort Order");
        webLinksPage.clickSortOrderAll();

        Assert.assertTrue(webLinksPage.doesShowTitleFormWebLink(titleName), "Failed, Contact is not displayed");

    }
    @Test(description ="Verify user can access webLink's help section")
    public void tc_Joomla_WebLink_008(){
        Log.infoTestCase("TC_JOOMLA_WEBLINKS_008: Verify user can access webLink's help section");

        Log.info("Step 1: Select Component -> WebLinks");
        webLinksPage.selectMenuTab(CommonPage.MenuTab.COMPONENTS, CommonPage.ListInMenuTab.WEB_LINKS);

        Log.info("Step 2: Click ToolBar Help");
        webLinksPage.clickToolbarHelp();

        Assert.assertTrue(BrowserHelper.isShowTitleHelpBrowser(Constants.TEXT_TITLE_HELP), "Navigate Failed, can not get Help Screen");

    }
    @Test(description = "Verify user can change the status of weblinks using the Status column")
    public void tc_Joomla_Weblinks_015(){
        Log.infoTestCase("TC_JOOMLA_WEBLINKS_015: Verify user can change the status of weblinks using the Status column");

        Log.info("Step 1: Select Component -> WebLinks");
        webLinksPage.selectMenuTab(CommonPage.MenuTab.COMPONENTS, CommonPage.ListInMenuTab.WEB_LINKS);

        Log.info("Step 2: Click New button");
        webLinksPage.clickNewButton();

        String titleName = DataHelper.getTextRandom();
        String urlName = DataHelper.getUrlRandom();

        Log.info("Step 3: Fill data to form WebLink");
        webLinksPage.fillDataFormWebLink(titleName, urlName);

        Log.info("Step 4: Click list dropdown and select Publish");
        webLinksPage.clickListDropDownAndSelect(Constants.PUBLISHED,Constants.PUBLISHED);

        Log.info("Step 5: CLick Save and Close");
        webLinksPage.clickSaveAndCloseButton();

        Assert.assertEquals(webLinksPage.getTextAlertMessage(), Constants.MESSAGE_WEB_LINK_SAVED, "Save failed");

        Log.info("Step 6: Click Sort Order");
        webLinksPage.clickSortOrderAll();

        Assert.assertTrue(webLinksPage.doesShowTitleFormWebLink(titleName), "Failed, Contact is not displayed");

        Log.info("Step 7: Click change status on table");
        webLinksPage.clickChangeStatusOnTable(titleName);

        Assert.assertEquals(webLinksPage.getTextAlertMessage(), Constants.MESSAGE_WEB_LINK_UN_PUBLISH, "Failed, Cannot change status");


    }



}

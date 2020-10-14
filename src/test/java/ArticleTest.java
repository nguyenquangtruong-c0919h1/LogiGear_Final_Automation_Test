import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.ArticlePage;
import pageObject.CommonPage;
import pageObject.LoginPage;
import utilities.Constants;
import utilities.Log;

public class ArticleTest extends BaseTest {
    LoginPage loginPage;
    ArticlePage articlePage;

    @BeforeMethod
    public void startBeforeMethod() {
        loginPage = new LoginPage();
        articlePage = new ArticlePage();
        loginPage.login(Constants.USER_NAME_VALID, Constants.PASSWORD_VALID);
    }

    @Test(description = "Verify user can move an article to trash section")
    public void tc_Joomla_Article_007() {
        Log.infoTestCase("TC_JOOLA_ARTICLE_007: Verify user can move an article to trash section");

        Log.info("Step 1: Select Content > Article");
        articlePage.selectMenuTab(CommonPage.MenuTab.CONTENT, CommonPage.ListInMenuTab.ARTICLES);

        Log.info("Step 2: Click New button");
        articlePage.clickNewButton();

        Log.info("Step 3: Fill data title form");
        articlePage.fillDataTitleForm(Constants.TEXT_TITLE_FORM);

        Log.info("Step 4: Select Published in Status");
        articlePage.clickListDropDown("Published");
        articlePage.clickItemListDropDown("Published");

        Log.info("Step 5: Select Sample Data-Articles in Category");
        articlePage.clickListDropDown("Sample Data-Articles");
        articlePage.clickItemListDropDown("Sample Data-Articles");

        Log.info("Step 6: Fill data Article Text");
        articlePage.fillDataArticleText(Constants.ARTICLE_CONTENT);

        Log.info("Step 7: Click Save and Close button");
        articlePage.clickSaveAndCloseButton();

        Assert.assertEquals(articlePage.getTextAlertMessage(), Constants.MESSAGE_ARTICLE_SAVED, "Save failed");
        Assert.assertEquals(articlePage.getTitleTable(), Constants.TEXT_TITLE_FORM, "Failed, Article is not displayed");

        Log.info("Step 8: Click Article Checkbox");
        articlePage.clickCheckbox(Constants.ZERO);

        Log.info("Step 9: Click Trash button");
        articlePage.clickTrashButton();

        Assert.assertEquals(articlePage.getTextAlertMessage(), Constants.MESSAGE_ARTICLE_TRASHED, "Trash Failed");

        Log.info("Step 10: Click Search Tool Button");
        articlePage.clickSearchToolButton();

        Log.info("Step 11: Click Trashed in Status");
        articlePage.clickListDropDown("- Select Status -");
        articlePage.clickItemListDropDown("Trashed");

        Assert.assertEquals(articlePage.getTitleTable(), Constants.TEXT_TITLE_FORM, "Trash Failed");

    }

    @Test(description = "Verify user can change the order of articles using the Ordering column")
    public void tc_Joola_Article_014() {
        Log.info("Step 1: Select Content > Article");
        articlePage.selectMenuTab(CommonPage.MenuTab.CONTENT, CommonPage.ListInMenuTab.ARTICLES);

        Log.info("Step 2: Click New butotn");
        articlePage.clickNewButton();

        Log.info("Step 3: Fill data title form");
        articlePage.fillDataTitleForm(Constants.TEXT_ARTICLE_ORDER_ONE_TITLE_FORM);

        Log.info("Step 4: Select Sample Data-Articles in Category");
        articlePage.clickListDropDown("Sample Data-Articles");
        articlePage.clickItemListDropDown("Sample Data-Articles");

        Log.info("Step 5: Fill data Article Text");
        articlePage.fillDataArticleText(Constants.ARTICLE_CONTENT);

        Log.info("Step 6: Click Save and Close button");
        articlePage.clickSaveAndCloseButton();

        Assert.assertEquals(articlePage.getTextAlertMessage(), Constants.MESSAGE_ARTICLE_SAVED, "Save failed");
        Assert.assertEquals(articlePage.getTitleTable(), Constants.TEXT_ARTICLE_ORDER_ONE_TITLE_FORM, "Failed, Article is not displayed");

        Log.info("Step 7: Select Content > Article");
        articlePage.selectMenuTab(CommonPage.MenuTab.CONTENT, CommonPage.ListInMenuTab.ARTICLES);

        Log.info("Step 8: Click New butotn");
        articlePage.clickNewButton();

        Log.info("Step 9: Fill data title form");
        articlePage.fillDataTitleForm(Constants.TEXT_ARTICLE_ORDER_TWO_TITLE_FORM);

        Log.info("Step 10: Select Sample Data-Articles in Category");
        articlePage.clickListDropDown("Sample Data-Articles");
        articlePage.clickItemListDropDown("Sample Data-Articles");

        Log.info("Step 11: Fill data Article Text");
        articlePage.fillDataArticleText(Constants.ARTICLE_CONTENT);

        Log.info("Step 12: Click Save and Close button");
        articlePage.clickSaveAndCloseButton();

        Assert.assertEquals(articlePage.getTextAlertMessage(), Constants.MESSAGE_ARTICLE_SAVED, "Save failed");
        Assert.assertEquals(articlePage.getTitleTable(), Constants.TEXT_ARTICLE_ORDER_TWO_TITLE_FORM, "Failed, Article is not displayed");

        Log.info("Step 13: Click Article Checkbox");
        articlePage.clickCheckbox(Constants.ONE);

        Log.info("Step 14: Click Order Column");
        articlePage.clickOrderColumn();

        Assert.assertFalse(articlePage.checkEqualTitleTable(Constants.TEXT_ARTICLE_ORDER_ONE_TITLE_FORM), "Soft failed");
    }

}

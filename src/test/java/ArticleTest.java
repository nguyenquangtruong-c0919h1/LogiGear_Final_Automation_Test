import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.ArticlePage;
import pageobject.CommonPage;
import pageobject.LoginPage;
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
        articlePage.clickListDropDownAndSelect(Constants.PUBLISHED, Constants.PUBLISHED);

        Log.info("Step 5: Select Sample Data-Articles in Category");
        articlePage.clickListDropDownAndSelectCategory(Constants.TRUONG_CATEGORY);

        Log.info("Step 6: Fill data Article Text");
        articlePage.fillDataArticleText(Constants.ARTICLE_CONTENT);

        Log.info("Step 7: Click Save and Close button");
        articlePage.clickSaveAndCloseButton();

        Assert.assertEquals(articlePage.getTextAlertMessage(), Constants.MESSAGE_ARTICLE_SAVED, "Save failed");
        Assert.assertTrue(articlePage.doesShowTitleTableArticle(Constants.TEXT_TITLE_FORM), "Failed, Article is not displayed");

        Log.info("Step 8: Click Article Checkbox");
        articlePage.clickCheckBox(Constants.TEXT_TITLE_FORM);

        Log.info("Step 9: Click Trash button");
        articlePage.clickTrashButton();

        Assert.assertEquals(articlePage.getTextAlertMessage(), Constants.MESSAGE_ARTICLE_TRASHED, "Trash Failed");

        Log.info("Step 10: Click Search Tool Button");
        articlePage.clickSearchToolButton();

        Log.info("Step 11: Click Trashed in Status");
        articlePage.clickListDropDownAndSelect(Constants.SELECT_STATUS, Constants.TRASHED);

        Assert.assertTrue(articlePage.doesShowTitleTableArticle(Constants.TEXT_TITLE_FORM), "Trash Failed");

    }

    @Test(description = "Verify user can change the order of articles using the Ordering column")
    public void tc_Joola_Article_014() {
        Log.info("Step 1: Select Content > Article");
        articlePage.selectMenuTab(CommonPage.MenuTab.CONTENT, CommonPage.ListInMenuTab.ARTICLES);

        Log.info("Step 2: Click New butotn");
        articlePage.clickNewButton();

        String textArticleOne = DataHelper.getTextRandom();

        Log.info("Step 3: Fill data title form");
        articlePage.fillDataTitleForm(textArticleOne);

        Log.info("Step 4: Select Sample Data-Articles in Category");
        articlePage.clickListDropDownAndSelectCategory(Constants.TRUONG_CATEGORY);

        Log.info("Step 5: Fill data Article Text");
        articlePage.fillDataArticleText(Constants.ARTICLE_CONTENT);

        Log.info("Step 6: Click Save and Close button");
        articlePage.clickSaveAndCloseButton();

        Assert.assertEquals(articlePage.getTextAlertMessage(), Constants.MESSAGE_ARTICLE_SAVED, "Save failed");
        Assert.assertTrue(articlePage.doesShowTitleTableArticle(textArticleOne), "Failed, Article is not displayed");

        Log.info("Step 7: Select Content > Article");
        articlePage.selectMenuTab(CommonPage.MenuTab.CONTENT, CommonPage.ListInMenuTab.ARTICLES);

        Log.info("Step 8: Click New butotn");
        articlePage.clickNewButton();

        String textArticleTwo = DataHelper.getTextRandom();

        Log.info("Step 9: Fill data title form");
        articlePage.fillDataTitleForm(textArticleTwo);

        Log.info("Step 10: Select Sample Data-Articles in Category");
        articlePage.clickListDropDownAndSelectCategory(Constants.TRUONG_CATEGORY);

        Log.info("Step 11: Fill data Article Text");
        articlePage.fillDataArticleText(Constants.ARTICLE_CONTENT);

        Log.info("Step 12: Click Save and Close button");
        articlePage.clickSaveAndCloseButton();

        Assert.assertEquals(articlePage.getTextAlertMessage(), Constants.MESSAGE_ARTICLE_SAVED, "Save failed");
        Assert.assertTrue(articlePage.doesShowTitleTableArticle(textArticleTwo), "Failed, Article is not displayed");

        Log.info("Step 13: Click Article Checkbox");
        articlePage.clickCheckBox(textArticleTwo);

        Log.info("Step 14: Click Order Column");
        articlePage.clickOrderColumn();

        Assert.assertTrue(articlePage.compareTitleTable(textArticleTwo), "Soft failed");
    }

}

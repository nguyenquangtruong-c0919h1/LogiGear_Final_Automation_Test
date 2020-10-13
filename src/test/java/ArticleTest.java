import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.ArticlePage;
import pageObject.CommonPage;
import pageObject.LoginPage;
import utilities.Constants;

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
    public void to_Joomla_Article_007() {
        articlePage.selectMenuTab(CommonPage.MenuTab.CONTENT, CommonPage.ListInMenuTab.ARTICLES);

        articlePage.clickNewButton();

        articlePage.fillDataTitleForm(Constants.TEXT_TITLE_FORM);

        articlePage.clickListDropDown("Published");
        articlePage.clickItemListDropDown("Published");

        articlePage.clickListDropDown("Sample Data-Articles");
        articlePage.clickItemListDropDown("Sample Data-Articles");

        articlePage.fillDataArticleText(Constants.ARTICLE_CONTENT);

        articlePage.clickSaveAndCloseButton();

        Assert.assertEquals(articlePage.getTextAlertMessage(),Constants.MESSAGE_ARTICLE_SAVED,"Save failed");
        Assert.assertEquals(articlePage.getTextTitleArticle(),Constants.TEXT_TITLE_FORM,"Failed, Article is not displayed");

        articlePage.clickArticleCheckbox();

        articlePage.clickTrashButton();

        Assert.assertEquals(articlePage.getTextAlertMessage(),Constants.MESSAGE_ARTICLE_TRASHED,"Trash Failed");
    }
}

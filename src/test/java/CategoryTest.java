import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.*;
import utilities.Constants;
import utilities.Log;

public class CategoryTest extends BaseTest {
    LoginPage loginPage;
    CategoryPage categoryPage;

    @BeforeMethod
    public void startBeforeMethod() {
        loginPage = new LoginPage();
        categoryPage = new CategoryPage();
        loginPage.login(Constants.USER_NAME_VALID, Constants.PASSWORD_VALID);
    }

    @Test(description = "Verify that user can create a new category")
    public void tc_Joomla_Category_Managet_001() {
        Log.infoTestCase("TC_JOOMLA_CATEGORY_MANAGER_001: Verify that user can create a new category");

        Log.info("Step 1: Select Content -> Category");
        categoryPage.selectMenuTab(CommonPage.MenuTab.CONTENT, CommonPage.ListInMenuTab.CATEGORIES);

        Log.info("Step 2: Click New button");
        categoryPage.clickNewButton();

        String titleName = DataHelper.getTextRandom();

        Log.info("Step 3: Fill data to Title");
        categoryPage.fillDataFormTitle(titleName);

        Log.info("Step 4: Click Save and Close button");
        categoryPage.clickSaveAndCloseButton();

        Assert.assertEquals(categoryPage.getTextAlertMessage(), Constants.MESSAGE_CATEGORY_SAVED, "Save failed");

        Log.info("Step 5: Click Sort Order");
        categoryPage.clickSortOrderAll();

        Assert.assertTrue(categoryPage.doesShowTitleFormCategory(titleName), "Failed, Contact is not displayed");

    }

    @Test(description = "Verify that user can search a category  by using filter text box")
    public void tc_Joomla_Category_Manager_008() {
        Log.infoTestCase("TC_JOOMLA_CATEGORY_MANAGER_008: Verify that user can search a category  by using filter text box");

        Log.info("Step 1: Select Content -> Category");
        categoryPage.selectMenuTab(CommonPage.MenuTab.CONTENT, CommonPage.ListInMenuTab.CATEGORIES);

        Log.info("Step 2: Click New button");
        categoryPage.clickNewButton();

        String titleName = DataHelper.getTextRandom();

        Log.info("Step 3: Fill data to Title");
        categoryPage.fillDataFormTitle(titleName);

        Log.info("Step 4: Click Save and Close button");
        categoryPage.clickSaveAndCloseButton();

        Assert.assertEquals(categoryPage.getTextAlertMessage(), Constants.MESSAGE_CATEGORY_SAVED, "Save failed");

        Log.info("Step 5: Click Sort Order");
        categoryPage.clickSortOrderAll();

        Assert.assertTrue(categoryPage.doesShowTitleFormCategory(titleName), "Failed, Contact is not displayed");

        Log.info("Step 6: Fill data search");
        categoryPage.fillDataSearchInput(titleName);

        Log.info("Step 7: Click Search button");
        categoryPage.clickSearchButton();

        Assert.assertTrue(categoryPage.doesShowTitleFormCategory(titleName), "Failed, Contact is not displayed");

    }


}

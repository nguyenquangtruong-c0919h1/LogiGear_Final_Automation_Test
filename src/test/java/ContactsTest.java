import helper.BrowserHelper;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.CommonPage;
import pageObject.ContactsPage;
import pageObject.LoginPage;
import utilities.Constants;
import utilities.Log;

public class ContactsTest extends BaseTest {
    LoginPage loginPage;
    ContactsPage contactsPage;

    @BeforeMethod
    public void startBeforeMethod() {
        loginPage = new LoginPage();
        contactsPage = new ContactsPage();
        loginPage.login(Constants.USER_NAME_VALID, Constants.PASSWORD_VALID);
    }

    @Test(description = "Verify user can move a contact to trash section")
    public void tc_Joola_Contacts_007() {
        Log.info("TC_JOOMLA_CONTACTS_007: Verify user can move a contact to trash section");

        Log.info("Step 1: Click Components --> Contacts");
        contactsPage.selectMenuTab(CommonPage.MenuTab.COMPONENTS, CommonPage.ListInMenuTab.CONTACTS);

        Log.info("Step 2: Click New Button");
        contactsPage.clickNewButton();

        String textForTitle = DataHelper.getTextRandom();

        Log.info("Step 3: Fill data for contacts form");
        contactsPage.fillDataFormName(textForTitle);

        Log.info("Step 4: Select Sample Data-Articles in Category");
        contactsPage.clickListDropDownAndSelect("Sample Data-Contact", "Sample Data-Contact");

        Log.info("Step 5: Select Published in Status");
        contactsPage.clickListDropDownAndSelect("Published", "Published");

        Log.info("Step 6: Click Save and Close button");
        contactsPage.clickSaveAndCloseButton();

        Assert.assertEquals(contactsPage.getTextAlertMessage(), Constants.MESSAGE_CONTACTS_SAVED, "Save failed");

        Log.info("Step 7: Click Sort Order");
        contactsPage.clickSortOrderAll();

        Assert.assertTrue(contactsPage.doesShowTitleTableContacts(textForTitle), "Failed, Contact is not displayed");

//        Log.info("Step 8: Click Id Table to sort");
//        contactsPage.clickIdTableSeveralTimes(2);

        Log.info("Step 9: Click checkbox Contacts first");
        contactsPage.clickCheckBoxContacts(textForTitle);

        Log.info("Step 10: Click Trash button to delete contacts first");
        contactsPage.clickTrashButton();

        Assert.assertEquals(contactsPage.getTextAlertMessage(), Constants.MESSAGE_CONTACTS_TRASHED, "Trash Failed");

        Log.info("Step 11: Click Search Tool Button");
        contactsPage.clickSearchToolButton();

        Log.info("Step 12: Click Trashed in Status");
        contactsPage.clickListDropDownAndSelect("- Select Status -", "Trashed");

        Assert.assertTrue(contactsPage.doesShowTitleTableContacts(textForTitle), "Trash Failed");
    }

    @Test(description = "Verify user can change the order of contacts using the Ordering column")
    public void tc_Joola_Contacts_014() {
        Log.info("TC_JOOMLA_CONTACTS_014: Verify user can change the order of contacts using the Ordering column");

        Log.info("Step 1: Click Components --> Contacts");
        contactsPage.selectMenuTab(CommonPage.MenuTab.COMPONENTS, CommonPage.ListInMenuTab.CONTACTS);

        Log.info("Step 2: Click New Button");
        contactsPage.clickNewButton();

        String textForTitleContact = DataHelper.getTextRandom();

        Log.info("Step 3: Fill data for contacts form");
        contactsPage.fillDataFormName(textForTitleContact);

        Log.info("Step 4: Select Sample Data-Articles in Category");
        contactsPage.clickListDropDownAndSelect("Sample Data-Contact", "Sample Data-Contact");

        Log.info("Step 5: Click Save and Close button");
        contactsPage.clickSaveAndCloseButton();

        Assert.assertEquals(contactsPage.getTextAlertMessage(), Constants.MESSAGE_CONTACTS_SAVED, "Save failed");

        Log.info("Step 6: Click Sort Order");
        contactsPage.clickSortOrderAll();

        Assert.assertTrue(contactsPage.doesShowTitleTableContacts(textForTitleContact), "Failed, Contact is not displayed");

        Log.info("Step 7: Click Components --> Contacts");
        contactsPage.selectMenuTab(CommonPage.MenuTab.COMPONENTS, CommonPage.ListInMenuTab.CONTACTS);

        Log.info("Step 8: Click New Button");
        contactsPage.clickNewButton();

        String textForTitleContactTwo = DataHelper.getTextRandom();

        Log.info("Step 9: Fill data for contacts form");
        contactsPage.fillDataFormName(textForTitleContactTwo);

        Log.info("Step 10: Select Sample Data-Articles in Category");
        contactsPage.clickListDropDownAndSelect("Sample Data-Contact", "Sample Data-Contact");

        Log.info("Step 11: Click Save and Close button");
        contactsPage.clickSaveAndCloseButton();

        Assert.assertEquals(contactsPage.getTextAlertMessage(), Constants.MESSAGE_CONTACTS_SAVED, "Save failed");

        Log.info("Step 12: Click Sort Order");
        contactsPage.clickSortOrderAll();

        Assert.assertTrue(contactsPage.doesShowTitleTableContacts(textForTitleContactTwo), "Failed, Contact is not displayed");

        Log.info("Step 13: Click Article Checkbox");
        contactsPage.clickCheckBoxContacts(textForTitleContactTwo);

        Log.info("Step 14: Click Order Column");
        contactsPage.clickOrderColumn();

        Assert.assertTrue(contactsPage.checkEqualTitleTable(textForTitleContactTwo), "Soft failed");
    }

}

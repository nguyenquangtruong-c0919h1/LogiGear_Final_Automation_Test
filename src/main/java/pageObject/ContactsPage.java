package pageObject;

import helper.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactsPage extends CommonPage {
    private By formName = By.id("jform_name");

    private By idTable = By.xpath("//table[@id='contactList']//a[contains(text(),'ID')]");
    private String titleTable = "//div[@class='pull-left break-word']/a[text()='%s']";
    private String checkBoxContacts = "//td//a[contains(text(),'%s')]//..//..//../td/input[@type='checkbox']";

    private WebElement getCheckBoxContacts(String text){
        return BrowserHelper.getWebDriver().findElement(By.xpath(String.format(checkBoxContacts,text)));
    }

    private WebElement getIdTable() {
        return BrowserHelper.getWebDriver().findElement(idTable);
    }

    private WebElement getFormName() {
        return BrowserHelper.getWebDriver().findElement(formName);
    }

    private WebElement getTitleTable(String text) {
        return BrowserHelper.getWebDriver().findElement(By.xpath(String.format(titleTable, text)));
    }

    public void clickCheckBoxContacts(String text){
        BrowserHelper.clickByJs(getCheckBoxContacts(text));
    }

    /***
     * Function fill data for Form Name
     * @param text
     */
    public void fillDataFormName(String text) {
        getFormName().sendKeys(text);
    }

    /***
     * Function click Id Table Several Times
     * @param times
     */

    /***\
     * Function get title table is displayed
     * @param text
     * @return
     */
    public boolean doesShowTitleTableContacts(String text) {
        return getTitleTable(text).isDisplayed();
    }

    /***
     * function check equal title table
     * @param textTitle
     * @return
     */
    public boolean checkEqualTitleTable(String textTitle) {
        return getTitleTable(textTitle).isDisplayed();
    }
}

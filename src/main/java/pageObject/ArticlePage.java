package pageObject;

import helper.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ArticlePage extends CommonPage {
    private final By newButton = By.cssSelector("#toolbar-new>button");
    private final By formTitle = By.cssSelector("input#jform_title");
    private final By articleText = By.id("jform_articletext_ifr");
    private final By saveAndCloseButton = By.cssSelector("#toolbar-save button");
    private final By alertMessage = By.cssSelector("div.alert.alert-success>div.alert-message");
    private final By searchToolButton = By.xpath("//div[@class='btn-wrapper hidden-phone']/button");
    private final By articleCheckbox = By.id("cb0");
    private final By trashButton = By.id("toolbar-trash");
    private final By totalTitleTablle = By.xpath("//td//a[@data-original-title='Edit']");
    private String listDropDown = "//span[text()='%s']";
    private String itemListDropDown = "//li[text()='%s']";

    private List<WebElement> getTotalTitleTable() {
        return BrowserHelper.getWebDriver().findElements(totalTitleTablle);
    }

    private WebElement getSearchToolButton() {
        return BrowserHelper.getWebDriver().findElement(searchToolButton);
    }

    private WebElement getArticleCheckbox() {
        return BrowserHelper.getWebDriver().findElement(articleCheckbox);
    }

    private WebElement getTrashButton() {
        return BrowserHelper.getWebDriver().findElement(trashButton);
    }

    private WebElement getNewButton() {
        return BrowserHelper.getWebDriver().findElement(newButton);
    }

    private WebElement getTitleForm() {
        return BrowserHelper.getWebDriver().findElement(formTitle);
    }

    private WebElement getArticleText() {
        return BrowserHelper.getWebDriver().findElement(articleText);
    }

    private WebElement getSaveAndCloseButton() {
        return BrowserHelper.getWebDriver().findElement(saveAndCloseButton);
    }

    private WebElement getAlertMessage() {
        return BrowserHelper.getWebDriver().findElement(alertMessage);
    }

    private WebElement getListDropDown(String nameText) {
        return BrowserHelper.getWebDriver().findElement(By.xpath(String.format(listDropDown, nameText)));
    }

    private WebElement getItemListDropDown(String itemList) {
        return BrowserHelper.getWebDriver().findElement(By.xpath(String.format(itemListDropDown, itemList)));
    }

    /***
     * Function click New button for create article
     */
    public void clickNewButton() {
        getNewButton().click();
    }

    /***
     * Function click Article Checkbox
     */
    public void clickArticleCheckbox() {
        getArticleCheckbox().click();
    }

    /***
     * Function click Trash button
     */
    public void clickTrashButton() {
        getTrashButton().click();
    }

    /***
     * Function click Save and Close
     */
    public void clickSaveAndCloseButton() {
        getSaveAndCloseButton().click();
    }

    /***
     * Click list Dropdown
     * @param nameText
     */
    public void clickListDropDown(String nameText) {
        getListDropDown(nameText).click();
    }

    /***
     * Function Click item List Dropdown
     * @param itemListDropDown
     */
    public void clickItemListDropDown(String itemListDropDown) {
        getItemListDropDown(itemListDropDown).click();
    }

    /***
     * Function Click Search Tool Button
     */
    public void clickSearchToolButton() {
        getSearchToolButton().click();
    }

    /***
     * Function fill data tile form
     * @param text
     */
    public void fillDataTitleForm(String text) {
        getTitleForm().sendKeys(text);
    }

    /***
     * Function fill data Article text
     * @param text
     */
    public void fillDataArticleText(String text) {
        getArticleText().sendKeys(text);
    }

    /***
     * Function get text alert message
     * @return
     */
    public String getTextAlertMessage() {
        return getText(getAlertMessage());
    }

    /***
     * Function get title table
     * @param Order
     * @return
     */
    public String getTitleTable(int Order) {
        return getTotalTitleTable().get(Order).getText();
    }
}

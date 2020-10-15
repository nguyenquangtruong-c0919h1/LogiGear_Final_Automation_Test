package pageObject;

import helper.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utilities.Log;

public class CommonPage {
    private By searchInput = By.id("filter_search");
    private By searchButton = By.cssSelector(".btn-wrapper.input-append>button[type=submit]");
    private By sortOrder = By.cssSelector("#list_limit_chzn span");
    private By allOrder = By.xpath("//div[@id='list_limit_chzn']//li[text()='All']");
    private By orderColumn = By.cssSelector("table.table span.icon-menu-2");
    private By searchToolButton = By.xpath("//div[@class='btn-wrapper hidden-phone']/button");
    private By trashButton = By.id("toolbar-trash");
    private By publishButton = By.id("toolbar-publish");
    private By checkInButton = By.id("toolbar-checkin");
    private By alertMessage = By.cssSelector("div.alert.alert-success>div.alert-message");
    private By saveAndCloseButton = By.cssSelector("#toolbar-save button");
    private By contentTab = By.xpath("//a[@class='dropdown-toggle' and contains(text(),'Content')]");
    private By systemTab = By.xpath("//a[@class='dropdown-toggle' and contains(text(),'System')]");
    private By componentsTab = By.xpath("//a[@class='dropdown-toggle' and contains(text(),'Components')]");
    private By newButton = By.cssSelector("#toolbar-new>button");
    private String listDropDown = "//span[contains(text(),'%s')]";
    private String itemListDropDown = "//li[contains(text(),'%s')]";
    private String checkBox = "//a[contains(text(),'')]//..//..//../td/input[@type='checkbox']";
    //list element in content tab
    private By articleTabList = By.xpath("//a[@class='dropdown-toggle menu-article' and contains(text(),'Articles')]");
    private By categoriesTabList = By.xpath("//a[@class='dropdown-toggle menu-category' and text()='Categories']");
    private By featuredArticlesTabList = By.xpath("//a[@class='no-dropdown menu-featured' and text()='Featured Articles']");
    private By fieldsTabList = By.xpath("//a[@class='no-dropdown menu-fields' and text()='Fields']");
    //List element in component tab
    private By bannerList = By.xpath("//a[@class='dropdown-toggle menu-banners' and text()='Banners']");
    private By contactsList = By.xpath("//a[@class='dropdown-toggle menu-contact' and text()='Contacts']");

    private WebElement getSearchInput(){
        return BrowserHelper.getWebDriver().findElement(searchInput);
    }
    private WebElement getSearchButton(){
        return BrowserHelper.getWebDriver().findElement(searchButton);
    }
    private WebElement getCheckInButton(){return BrowserHelper.getWebDriver().findElement(checkInButton);}
    private WebElement getCheckBox(String text){
        return BrowserHelper.getWebDriver().findElement(By.xpath(String.format(checkBox,text)));
    }
    private WebElement getPublishButton() {
        return BrowserHelper.getWebDriver().findElement(publishButton);
    }

    private WebElement getSortOrder() {
        return BrowserHelper.getWebDriver().findElement(sortOrder);
    }

    private WebElement getAllOrder() {
        return BrowserHelper.getWebDriver().findElement(allOrder);
    }

    private WebElement getOrderColumn() {
        return BrowserHelper.getWebDriver().findElement(orderColumn);
    }

    private WebElement getSearchToolButton() {
        return BrowserHelper.getWebDriver().findElement(searchToolButton);
    }

    private WebElement getTrashButton() {
        return BrowserHelper.getWebDriver().findElement(trashButton);
    }



    private WebElement getAlertMessage() {
        return BrowserHelper.getWebDriver().findElement(alertMessage);
    }

    private WebElement getSaveAndCloseButton() {
        return BrowserHelper.getWebDriver().findElement(saveAndCloseButton);
    }

    //Menu Tab
    private WebElement getContentTab() {
        return BrowserHelper.getWebDriver().findElement(contentTab);
    }

    private WebElement getSystemTab() {
        return BrowserHelper.getWebDriver().findElement(systemTab);
    }

    private WebElement getComponentsTab() {
        return BrowserHelper.getWebDriver().findElement(componentsTab);
    }

    private WebElement getNewButton() {
        return BrowserHelper.getWebDriver().findElement(newButton);
    }

    // List in Content Tab
    private WebElement getArticleTabList() {
        return BrowserHelper.getWebDriver().findElement(articleTabList);
    }

    private WebElement getCategoriesTabList() {
        return BrowserHelper.getWebDriver().findElement(categoriesTabList);
    }

    private WebElement getFeatureArticlesTabList() {
        return BrowserHelper.getWebDriver().findElement(featuredArticlesTabList);
    }

    private WebElement getFieldsTabList() {
        return BrowserHelper.getWebDriver().findElement(fieldsTabList);
    }

    // List in Component tab
    private WebElement getBannerList() {
        return BrowserHelper.getWebDriver().findElement(bannerList);
    }

    private WebElement getContactsList() {
        return BrowserHelper.getWebDriver().findElement(contactsList);
    }

    private WebElement getListDropDown(String nameText) {
        return BrowserHelper.getWebDriver().findElement(By.xpath(String.format(listDropDown, nameText)));
    }

    private WebElement getItemListDropDown(String itemList) {
        return BrowserHelper.getWebDriver().findElement(By.xpath(String.format(itemListDropDown, itemList)));
    }

    /***
     * Menu tab on web
     */
    public enum MenuTab {
        CONTENT, SYSTEM, COMPONENTS
    }

    /***
     * list in menu tab
     */
    public enum ListInMenuTab {
        ARTICLES, CATEGORIES, FEATURED_ARTICLES, FIELDS, BANNER, CONTACTS
    }

    /***
     * Select Menu Tab
     * @param menuTab
     * @param listInMenuTab
     */
    public void selectMenuTab(MenuTab menuTab, ListInMenuTab listInMenuTab) {
        try {
            switch (menuTab) {
                case CONTENT:
                    getContentTab().click();
                    selectDropDownContentTab(listInMenuTab);
                    break;
                case SYSTEM:
                    getSystemTab().click();

                    break;
                case COMPONENTS:
                    getComponentsTab().click();
                    selectDropDownContactsTab(listInMenuTab);
                    break;
            }
        } catch (NoSuchElementException e) {
            Log.error("Can not find element in List Menu Tab " + e);
        }
    }

    /***
     * Select Dropdown Content Tab
     * @param listInMenuTab
     */
    private void selectDropDownContentTab(ListInMenuTab listInMenuTab) {
        try {
            switch (listInMenuTab) {
                case ARTICLES:
                    getArticleTabList().click();
                    break;
                case CATEGORIES:
                    getCategoriesTabList().click();
                    break;
                case FEATURED_ARTICLES:
                    getFeatureArticlesTabList().click();
                    break;
                case FIELDS:
                    getFieldsTabList().click();
                    break;
            }
        } catch (NoSuchElementException e) {
            Log.error("Can not find element in List Content Tab " + e);
        }
    }

    /***
     * Select Dropdown Contacts Tab
     * @param listInMenuTab
     */
    private void selectDropDownContactsTab(ListInMenuTab listInMenuTab) {
        try {
            switch (listInMenuTab) {
                case BANNER:
                    getBannerList().click();
                    break;
                case CONTACTS:
                    getContactsList().click();
                    break;
            }
        } catch (NoSuchElementException e) {
            Log.error("Can not find element in List Contact Tab " + e);
        }
    }

    /***
     * Get text
     * @param element
     * @return
     */
    public String getText(WebElement element) {
        return element.getText().trim();
    }

    /***
     * Function click New button for create article
     */
    public void clickNewButton() {
        getNewButton().click();
    }

    public void clickCheckInButton(){getCheckInButton().click();}

    public void clickListDropDownAndSelect(String listDropDown,String itemListDropDown) {
        getListDropDown(listDropDown).click();
        getItemListDropDown(itemListDropDown).click();

    }

    public void clickCheckBox(String text){
        getCheckBox(text).click();
    }

    /***
     * get Title web current
     * @return
     */
    public String getTitle() {
        return BrowserHelper.getWebDriver().getTitle();
    }

    /***
     * Function click Trash button
     */
    public void clickTrashButton() {
        getTrashButton().click();
    }

    /***
     * Click Publish button
     */
    public void clickPublishButton() {
        getPublishButton().click();
    }

    /***
     * Function click Save and Close
     */
    public void clickSaveAndCloseButton() {
        getSaveAndCloseButton().click();
    }

    /***
     * Function get text alert message
     * @return
     */
    public String getTextAlertMessage() {
        return getText(getAlertMessage());
    }

    /***
     * Function Click Search Tool Button
     */
    public void clickSearchToolButton() {
        getSearchToolButton().click();
    }

    /***
     * Function click order column
     */
    public void clickOrderColumn() {
        getOrderColumn().click();
    }

    /***
     * Click sort Order and select All
     */
    public void clickSortOrderAll() {
        getSortOrder().click();
        getAllOrder().click();
    }
    public void fillDataSearchInput(String text){
        getSearchInput().sendKeys(text);
    }
    public void clickSearchButton(){
        getSearchButton().click();
    }

}

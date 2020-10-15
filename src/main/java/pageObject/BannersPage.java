package pageObject;

import helper.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BannersPage extends CommonPage {
    private By bannerDetail = By.xpath("//li//a[text()='Banner Details']");
    private By formTitle = By.id("jform_title");
    private By nameForm = By.id("jform_name");
    private String titleTable = "//a[contains(text(),'%s')]";
    private String navBar = "//ul[@id='submenu']//a[text()='%s']";

    private WebElement getTitleTable(String title) {
        return BrowserHelper.getWebDriver().findElement(By.xpath(String.format(titleTable, title)));
    }

    private WebElement getNameForm() {
        return BrowserHelper.getWebDriver().findElement(nameForm);
    }

    private WebElement getFormTitle() {
        return BrowserHelper.getWebDriver().findElement(formTitle);
    }

    private WebElement getBannerDetail() {
        return BrowserHelper.getWebDriver().findElement(bannerDetail);
    }

    private WebElement getNavBar(String navBarText) {
        return BrowserHelper.getWebDriver().findElement(By.xpath(String.format(navBar, navBarText)));
    }

    /***
     * Function click banner Detail
     */
    public void clickBannerDetail() {
        getBannerDetail().click();
    }

    /***
     * Function Fill data for category
     * @param formTitle
     */
    public void fillDataForCategory(String formTitle) {
        getFormTitle().sendKeys(formTitle);
    }


    /***
     * Function click NavBar
     * @param text
     */
    public void clickNavBar(String text) {
        getNavBar(text).click();
    }


    /***
     * Function get attribute Form title
     * @return
     */
    public String getAttributeFormTitle() {
        return getNameForm().getCssValue("color");
    }

    /***\
     *  Function does show title table
     * @param text
     * @return
     */
    public boolean doesShowTitleTable(String text) {
        return getTitleTable(text).isDisplayed();
    }
}

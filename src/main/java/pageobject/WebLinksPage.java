package pageobject;

import helper.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebLinksPage extends CommonPage {
    private By formTitle = By.id("jform_title");
    private By urlName = By.cssSelector("input[name='jform[url]']");
    private String changeStatusOnTable = "//a[contains(text(),'%s')]//..//..//../td//span[@class='icon-publish']";
    private String titleFormWebLink = "//div[@id='j-main-container']//a[contains(text(),'%s')]";

    private WebElement getFormTitle() {
        return BrowserHelper.getWebDriver().findElement(formTitle);
    }

    private WebElement getUrlName() {
        return BrowserHelper.getWebDriver().findElement(urlName);
    }

    private WebElement getChangeStatusOnTable(String text) {
        return BrowserHelper.getWebDriver().findElement(By.xpath(String.format(changeStatusOnTable, text)));
    }

    private WebElement getTitleFormWebLink(String text) {
        return BrowserHelper.getWebDriver().findElement(By.xpath(String.format(titleFormWebLink, text)));
    }

    /***
     * function fill data form web link
     * @param titleName
     * @param urlName
     */
    public void fillDataFormWebLink(String titleName, String urlName) {
        getFormTitle().sendKeys(titleName);
        getUrlName().sendKeys(urlName);
    }

    /***
     * function change status on table
     * @param text
     */
    public void clickChangeStatusOnTable(String text) {
        BrowserHelper.clickByJs(getChangeStatusOnTable(text));
    }

    /***
     * function does show title form web link
     * @param text
     * @return
     */
    public boolean doesShowTitleFormWebLink(String text) {
        return getTitleFormWebLink(text).isDisplayed();
    }
}

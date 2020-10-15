package pageobject;

import helper.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePage extends CommonPage {
    private By formTitle = By.id("jform_title");
    private By articleText = By.id("jform_articletext_ifr");
    private String titleTable = "//td//a[@data-original-title='Edit' and contains(text(),'%s')]";
    private By titleSecond = By.xpath("//input[@id='cb1']//..//../td//a[@data-original-title='Edit']");

    private WebElement getTitleTable(String title) {
        return BrowserHelper.getWebDriver().findElement(By.xpath(String.format(titleTable, title)));
    }

    private WebElement getTitleSecond() {
        return BrowserHelper.getWebDriver().findElement(titleSecond);
    }

    private WebElement getTitleForm() {
        return BrowserHelper.getWebDriver().findElement(formTitle);
    }

    private WebElement getArticleText() {
        return BrowserHelper.getWebDriver().findElement(articleText);
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
     * Function get title table
     * @return
     */
    public Boolean doesShowTitleTableArticle(String text) {
        return getTitleTable(text).isDisplayed();
    }

    /***
     * Function check equal title in table
     * @param textTitle
     * @return
     */
    public boolean compareTitleTable(String textTitle) {
        return !getTitleSecond().getText().equals(textTitle);
    }
}

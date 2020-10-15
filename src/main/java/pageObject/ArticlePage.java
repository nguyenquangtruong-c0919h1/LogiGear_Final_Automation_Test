package pageObject;

import helper.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePage extends CommonPage {
    private By formTitle = By.id("jform_title");
    private By articleText = By.id("jform_articletext_ifr");
    private String titleTable = "//td//a[@data-original-title='Edit' and contains(text(),'%s')]";
//    private String checkboxArticle = "//td//a[@data-original-title='Edit' and contains(text(),'%s')]//..//..//../td/input[@type='checkbox']";
    private WebElement getTotalTitleTable(String text) {
        return BrowserHelper.getWebDriver().findElement(By.xpath(String.format(titleTable,text)));
    }
//    private WebElement getCheckboxArticle(String text) {
//        return BrowserHelper.getWebDriver().findElement(By.xpath(String.format(checkboxArticle, text)));
//    }
    private WebElement getTitleForm() {
        return BrowserHelper.getWebDriver().findElement(formTitle);
    }

    private WebElement getArticleText() {
        return BrowserHelper.getWebDriver().findElement(articleText);
    }

//    public void clickCheckboxArticle(String text) {
//        getCheckboxArticle(text).click();
//    }
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
        return getTotalTitleTable(text).isDisplayed();
    }

    /***
     * Function check equal title in table
     * @param textTitle
     * @return
     */
    public boolean compareTitleTable(String textTitle) {
        return doesShowTitleTableArticle(textTitle);
    }
}

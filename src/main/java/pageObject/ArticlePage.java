package pageObject;

import helper.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePage extends CommonPage {
    private By formTitle = By.id("jform_title");
    private By articleText = By.id("jform_articletext_ifr");
    private By totalTitleTable = By.xpath("//td//a[@data-original-title='Edit']");

    private WebElement getTotalTitleTable() {
        return BrowserHelper.getWebDriver().findElement(totalTitleTable);
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
    public String getTitleTable() {
        return getTotalTitleTable().getText();
    }

    /***
     * Function check equal title in table
     * @param textTitle
     * @return
     */
    public boolean checkEqualTitleTable(String textTitle) {
        return getTitleTable().equals(textTitle);
    }
}

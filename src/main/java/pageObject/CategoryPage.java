package pageObject;

import helper.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CategoryPage extends CommonPage {
    private By formTitle = By.id("jform_title");

    private String titleFormCategory = "//div[@id='j-main-container']//a[contains(text(),'%s')]";

    private WebElement getFormTitle() {
        return BrowserHelper.getWebDriver().findElement(formTitle);
    }

    private WebElement getTitleFormCategory(String text) {
        return BrowserHelper.getWebDriver().findElement(By.xpath(String.format(titleFormCategory, text)));
    }

    /***
     * Function fill data form title
     * @param text
     */
    public void fillDataFormTitle(String text) {
        getFormTitle().sendKeys(text);
    }

    /***
     * Function does show title form category
     * @param text
     * @return
     */
    public boolean doesShowTitleFormCategory(String text) {
        return getTitleFormCategory(text).isDisplayed();
    }
}

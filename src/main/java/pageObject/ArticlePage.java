package pageObject;

import helper.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ArticlePage extends CommonPage {
    private By newButton = By.cssSelector("#toolbar-new>button");
    private By formTitle = By.cssSelector("input#jform_title");
    private By articleText = By.id("jform_articletext_ifr");
    private By saveAndCloseButton = By.cssSelector("#toolbar-save button");
    private By alertMessage = By.cssSelector("div.alert.alert-success>div.alert-message");
    private By titleArticle = By.xpath("//td[@class='has-context']//a");
    private By statusTable = By.xpath("//th[@class='nowrap center']");
    private By articleCheckbox = By.id("cb0");
    private By trashButton = By.id("toolbar-trash");
    private String listDropDown = "//span[text()='%s']";
    private String itemListDropDown = "//li[text()='%s']";

    private WebElement getTitleArticle() {
        return BrowserHelper.getWebDriver().findElement(titleArticle);
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

    public void clickNewButton() {
        getNewButton().click();
    }

    public void clickArticleCheckbox() {
        getArticleCheckbox().click();
    }

    public void clickTrashButton() {
        getTrashButton().click();
    }

    public void clickSaveAndCloseButton() {
        getSaveAndCloseButton().click();
    }

    public void clickListDropDown(String nameText) {
        getListDropDown(nameText).click();
    }

    public void clickItemListDropDown(String itemListDropDown) {
        getItemListDropDown(itemListDropDown).click();
    }

    public void fillDataTitleForm(String text) {
        getTitleForm().sendKeys(text);
    }

    public void fillDataArticleText(String text) {
        getArticleText().sendKeys(text);
    }

    public String getTextAlertMessage() {
        return getText(getAlertMessage());
    }

    public String getTextTitleArticle() {
        return getText(getTitleArticle());
    }
}

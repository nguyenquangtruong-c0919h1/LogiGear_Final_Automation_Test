package pageObject;

import helper.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommonPage {
    private By contentTab = By.xpath("//a[@class='dropdown-toggle' and contains(text(),'Content')]");
    private By systemTab = By.xpath("//a[@class='dropdown-toggle' and contains(text(),'System')]");

    //list element in content tab
    private By articleTabList = By.xpath("//a[@class='dropdown-toggle menu-article' and contains(text(),'Articles')]");
    private By categoriesTabList = By.xpath("//a[@class='dropdown-toggle menu-category' and text()='Categories']");
    private By featuredArticlesTabList = By.xpath("//a[@class='no-dropdown menu-featured' and text()='Featured Articles']");
    private By fieldsTabList = By.xpath("//a[@class='no-dropdown menu-fields' and text()='Fields']");

    //Menu Tab
    private WebElement getContentTab(){
        return BrowserHelper.getWebDriver().findElement(contentTab);
    }
    private WebElement getSystemTab(){
        return BrowserHelper.getWebDriver().findElement(systemTab);
    }
     // List in Content Tab
    private WebElement getArticleTabList(){return BrowserHelper.getWebDriver().findElement(articleTabList);}
    private WebElement getCategoriesTabList(){return BrowserHelper.getWebDriver().findElement(categoriesTabList);}
    private WebElement getFeatureArticlesTabList(){return BrowserHelper.getWebDriver().findElement(featuredArticlesTabList);}
    private WebElement getFieldsTabList(){return BrowserHelper.getWebDriver().findElement(fieldsTabList);}
    public enum MenuTab{
        CONTENT,SYSTEM
    }
    public enum ListInMenuTab{
        ARTICLES, CATEGORIES,FEATURED_ARTICLES,FIELDS
    }
    public void selectMenuTab(MenuTab menuTab,ListInMenuTab listInMenuTab){
        switch (menuTab){
            case CONTENT:
                getContentTab().click();
                selectDropDownContentTab(listInMenuTab);
                break;
            case SYSTEM:
                getSystemTab().click();

                break;
        }
    }

    public void selectDropDownContentTab(ListInMenuTab listInMenuTab){
        switch (listInMenuTab){
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
    }

    public String getText(WebElement element){
        return element.getText().trim();
    }
}

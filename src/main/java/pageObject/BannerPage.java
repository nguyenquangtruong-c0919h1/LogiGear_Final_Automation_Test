package pageObject;

import helper.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BannerPage extends CommonPage {
    private By toolbarHelp = By.id("toolbar-help");
    private String navBar = "//ul[@id='submenu']//a[text()='%s']";
    private By bannerDetail = By.xpath("//li//a[text()='Banner Details']");
    private By nameForm = By.id("jform_name");
    private By nameContact = By.id("jform_contact");
    private By emailForm = By.id("jform_email");
    private By formTitle = By.id("jform_title");

    private WebElement getBannerDetail(){
        return BrowserHelper.getWebDriver().findElement(bannerDetail);
    }
    private WebElement getNameForm() {
        return BrowserHelper.getWebDriver().findElement(nameForm);
    }
    private WebElement getFormTitle() {
        return BrowserHelper.getWebDriver().findElement(formTitle);
    }

    private WebElement getNameContact() {
        return BrowserHelper.getWebDriver().findElement(nameContact);
    }

    private WebElement getEmailForm() {
        return BrowserHelper.getWebDriver().findElement(emailForm);
    }

    private WebElement getToolbarHelp() {
        return BrowserHelper.getWebDriver().findElement(toolbarHelp);
    }

    private WebElement getNavBar(String text) {
        return BrowserHelper.getWebDriver().findElement(By.xpath(String.format(navBar,text)));
    }

    /***
     * Function click banner Detail
     */
    public void clickBannerDetail(){
        getBannerDetail().click();
    }

    /***
     * Function Fill data for category
     * @param formTitle
     */
    public void fillDataForCategory(String formTitle){
        getFormTitle().sendKeys(formTitle);
    }

    /***
     * Function fill data for client Form
     * @param nameForm
     * @param nameContact
     * @param emailForm
     */
    public void fillDataForClientForm(String nameForm, String nameContact, String emailForm) {
        getNameForm().sendKeys(nameForm);
        getNameContact().sendKeys(nameContact);
        getEmailForm().sendKeys(emailForm);
    }

    /***
     * Function click NavBar
     * @param text
     */
    public void clickNavBar(String text) {
        getNavBar(text).click();
    }

    /***
     * Function click ToolBar Help
     */
    public void clickToolbarHelp() {
        getToolbarHelp().click();
    }

    /***
     * Function get attribute Form title
     * @return
     */
     public String getAttributeFormTitle(){
       return getNameForm().getCssValue("color");
     }

}

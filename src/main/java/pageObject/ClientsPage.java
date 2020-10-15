package pageObject;


import helper.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utilities.Log;

public class ClientsPage extends CommonPage {
    private By clientsNavBar = By.xpath("//ul[@id='submenu']//a[text()='Clients']");
    private By emailForm = By.id("jform_email");
    private By nameForm = By.id("jform_name");
    private By nameContact = By.id("jform_contact");
    private String titleFormClient = "//div[@id='j-main-container']//a[contains(text(),'%s')]";
    private String unPublishButton = "//div[@id='j-main-container']//a[contains(text(),'%s')]//..//..//..//span[@class='icon-unpublish']";

    private WebElement getClientsNavBar() {
        return BrowserHelper.getWebDriver().findElement(clientsNavBar);
    }

    private WebElement getNameForm() {
        return BrowserHelper.getWebDriver().findElement(nameForm);
    }

    private WebElement getEmailForm() {
        return BrowserHelper.getWebDriver().findElement(emailForm);
    }

    private WebElement getNameContact() {
        return BrowserHelper.getWebDriver().findElement(nameContact);
    }

    private WebElement getUnPublishButton(String text) {
        return BrowserHelper.getWebDriver().findElement(By.xpath(String.format(unPublishButton, text)));
    }

    private WebElement getTitleFormClient(String text) {
        return BrowserHelper.getWebDriver().findElement(By.xpath(String.format(titleFormClient, text)));
    }

    /***
     * Function click clients Nav Bar
     */
    public void clickClientsNavBar() {
        getClientsNavBar().click();
    }

    /***
     * Function get text title form client
     * @param text
     * @return
     */
    public boolean getTextTitleFormClient(String text) {
        return getTitleFormClient(text).isDisplayed();
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
     * function does unPublish in table
     * @param text
     * @return
     */
    public boolean doesShowUnPublishInTable(String text) {
        try {
            return getUnPublishButton(text).isDisplayed();
        } catch (NoSuchElementException e) {
            Log.error("Failed, Not in mode unPublish");
            return false;
        }
    }
}

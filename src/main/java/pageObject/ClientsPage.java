package pageObject;


import helper.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ClientsPage extends CommonPage {
    private final By clientsNavBar = By.xpath("//ul[@id='submenu']//a[text()='Clients']");
    private final String titleFormClient = "//div[@id='j-main-container']//a[contains(text(),'%s')]";

    private WebElement getClientsNavBar() {
        return BrowserHelper.getWebDriver().findElement(clientsNavBar);
    }

    private WebElement getTitleFormClient(String text) {
        return BrowserHelper.getWebDriver().findElement(By.xpath(String.format(titleFormClient, text)));
    }

    public void clickClientsNavBar() {
        getClientsNavBar().click();
    }
    public boolean getTextTitleFormClient(String text){
        return getTitleFormClient(text).isDisplayed();
    }
}

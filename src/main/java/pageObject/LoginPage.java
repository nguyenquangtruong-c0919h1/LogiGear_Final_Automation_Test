package pageObject;

import helper.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends CommonPage {
    private By userName = By.id("mod-login-username");
    private By password = By.id("mod-login-password");
    private By loginButton = By.xpath("//div[@class='btn-group']/button");

    private WebElement getUserName() {
        return BrowserHelper.getWebDriver().findElement(userName);
    }

    private WebElement getPassword() {
        return BrowserHelper.getWebDriver().findElement(password);
    }

    private WebElement getLoginButton() {
        return BrowserHelper.getWebDriver().findElement(loginButton);
    }

    /***
     * Function fill data in login and Login
     * @param userName
     * @param password
     */
    public void login(String userName, String password) {
        getUserName().sendKeys(userName);
        getPassword().sendKeys(password);
        clickLoginButton();
    }

    /***
     * Function click login
     */
    public void clickLoginButton() {
        getLoginButton().click();
    }
}

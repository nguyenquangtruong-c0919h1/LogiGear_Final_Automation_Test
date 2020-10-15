package helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class BrowserHelper {
    static WebDriver driver;
    public enum TypeWeb {
        CHROME, EDGE, FIREFOX
    }

    /***
     * Function start Browser
     * @param typeWeb
     */
    public static void startBrowser(TypeWeb typeWeb) {
        switch (typeWeb) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        driver.manage().window().maximize();
    }

    /***
     * Navigate To Url
     * @param url
     */
    public static void navigateToUrl(String url) {
        driver.get(url);
    }

    /***
     * get WebDriver
     * @return
     */
    public static WebDriver getWebDriver() {
        return driver;
    }

    /***
     * Close driver
     */
    public static void closeDriver() {
        if (driver != null)
            driver.close();
    }
    /***
     * Get title Browser when having 2 browser
     * @param title
     * @return
     */
    public static boolean isShowTitleHelpBrowser(String title) {
        for (String winHandle : BrowserHelper.getWebDriver().getWindowHandles()) {
            BrowserHelper.getWebDriver().switchTo().window(winHandle);
        }
        return BrowserHelper.getWebDriver().getTitle().equals(title);
    }

    public static void clickByJs(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

}

package helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Constants;

public class BrowserHelper {
    static WebDriver driver;

    public enum SelectBrowser {
        CHROME, EDGE, FIREFOX
    }

    /***
     * Function start Browser
     * @param selectBrowser
     */
    public static void startBrowser(SelectBrowser selectBrowser) {
        switch (selectBrowser) {
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
            driver.quit();
    }

    /***
     * function get driver wait
     * @return
     */
    public static WebDriverWait getDriverWait() {
        return new WebDriverWait(driver, Constants.FIVE_HUNDRED);
    }

    /***
     * Click ByJs
     * @param element
     */
    public static void clickByJs(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    /***
     * Function convert Rgb to hex
     * @param color
     * @return
     */
    public static String convertRgbToHex(String color) {
        return Color.fromString(color).asHex();
    }


}

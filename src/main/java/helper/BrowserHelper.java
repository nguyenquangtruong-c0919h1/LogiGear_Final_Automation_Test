package helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserHelper {
    static WebDriver driver;

    public enum TypeWeb {
        CHROME, EDGE, FIREFOX
    }

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

    public static void navigateToUrl(String url) {
        driver.get(url);
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static void closeWebDriver() {
        if (driver != null)
            driver.quit();
    }
}

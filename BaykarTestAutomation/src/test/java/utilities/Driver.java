package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class Driver {
    private static WebDriver driver;


    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                String browser = ConfigReader.getProperty("browser");
                switch (browser.toLowerCase().trim()) {
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                    case "safari":
                        WebDriverManager.safaridriver().setup();
                        driver = new SafariDriver();
                        break;
                    case "edge":
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                        break;
                    default:
                        WebDriverManager.chromedriver().clearDriverCache().setup();
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--remote-allow-origins=*");
                        driver = new ChromeDriver(options);
                }

                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
            } catch (Exception e) {
                System.out.println("An error occured while starting the driver: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void openURL(String url) {
        driver.get(url);
        //Wait until page is ready
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public static String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public static void navigateBack() {
        driver.navigate().back();
    }

    public static String getPageSource() {
        Helper.waitForPageToLoad(10);
        return driver.getPageSource();
    }

    public static String getPageSource(By by) {
        Helper.waitForElementToLoad(10, by);
        return driver.getPageSource();
    }

    public static WebElement findElement(By xpath) {
        return driver.findElement(xpath);
    }
}
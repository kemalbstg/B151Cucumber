package calisma.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

// POM (PAGE OBJECT MODEL)
// Test senaryolarının daha az kod ile yazılmasına
// ve bakımının daha kolay yapılmasına
// olanak sağlayan bir test yöntemidir.
// testNG ve cucumberda pom kalıbını kullanırız
public class Driver {

    private Driver() {
    }



static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver == null){
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }


            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }

    return driver;

    }
    public static void closeDriver() {
        if (driver != null) {//-->driver'a değer ATANMIŞSA
            driver.close();
            driver = null; //-->driver'1 kapattıktan sonra boşalt
        }
    }
    public static void quitDriver() {
        if (driver != null) {//-->driver'a değer ATANMIŞSA
            driver.quit();
            driver = null; //-->driver'1 kapattıktan sonra boşalt

        }
    }
}
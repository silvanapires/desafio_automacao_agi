package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;


public class DriverFactory {

    public static WebDriver driver;
    public static WebDriverWait wait;

    private static String getProperties() {
        Properties properties = new Properties();
        String value = null;
        try {
            properties.load(new FileInputStream("properties/browser"));
            value = properties.getProperty("browser");
        } catch (IOException e) {
            System.out.println("Não foi possível abrir o arquivo properties " + e.getMessage());
        }
        return value;
    }

    private static WebDriver getDriver(String browser) {
        if (driver == null) {
            if (browser.equals("chrome")) {

                ChromeOptions options = new ChromeOptions();

                if (System.getProperty("os.name").contains("Win")) {
                    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                } else {
                    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                }
                driver = new ChromeDriver(options);

            } else if (browser.equals("firefox")) {

                FirefoxOptions options = new FirefoxOptions();

                if (System.getProperty("os.name").contains("Win")) {
                    System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                } else {
                    System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-v0.29.1-linux64.tar");
                }
                driver = new FirefoxDriver(options);
            }
        }
        assert driver != null;
        driver.manage().window().maximize();
        return driver;
    }

    public static void abrirDriver() {
        driver = null;
        try {
            driver = getDriver(getProperties());
            wait = new WebDriverWait(driver, 25);
        } catch (Exception e) {
            System.out.println("Não foi possível abrir o driver " + e.getMessage());
        }
    }


    public static void fecharDriver() {
        driver.quit();
    }
}

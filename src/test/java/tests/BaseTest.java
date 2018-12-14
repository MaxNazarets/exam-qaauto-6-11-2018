package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.HomePage;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;

    @Parameters("browserName")
    @BeforeMethod
    public void beforeMethod(@Optional("chrome") String browserName) {
        if (browserName.toLowerCase().equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        if (browserName.toLowerCase().equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            try {
                throw new Exception("browserName " + browserName + " is not supported.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.get("https://www.google.com");
        homePage = new HomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

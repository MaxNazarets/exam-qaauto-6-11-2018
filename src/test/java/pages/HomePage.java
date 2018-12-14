package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PageObject class for HomePage.
 */
public class HomePage extends BasePage{

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@name='btnK']")
    private WebElement searchButton;

    /**
     * Constructor of HomePage class.
     * @param driver - WebDriver instance from Test
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to check if page is loaded.
     * @return - true/false
     */
    public boolean isPageLoaded() {
        return driver.getTitle().contains("Google")
                && driver.getCurrentUrl().equals("https://www.google.com/");
    }

    /**
     * Method that fill the searchField and click button 'Search'.
     * @param searchTerm - String value searchTerm.
     * @return new SearchResultsPage object.
     */
    public SearchResultsPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchButton.click();
        return new SearchResultsPage(driver);
    }
}

package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * PageObject class for SearchResultsPage.
 */
public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@id='top_nav']")
    private WebElement searchToolBar;

    @FindBy(xpath = "//div[@class='g']")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//a[@aria-label='Page 2']")
    private WebElement searchPage2;

    /**
     * Constructor of SearchResultsPage class.
     * @param driver - webDriver instance from Test.
     */
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to check if page is loaded.
     * @return true/false
     */
    public boolean isPageLoaded() {
        return searchToolBar.isDisplayed()
                && driver.getTitle().contains("Selenium")
                && driver.getCurrentUrl().contains("https://www.google.com/search");
    }

    /**
     * Method to get SearchResults count of elements.
     * @return count of elements.
     */
    public int getSearchResultsCount() {
        return searchResults.size();
    }

    /**
     * Method to get Array of String searchResultsList and get Text values from each element.
     * @return Array of searchResultsList text.
     */
    public List<String> getSearchResults() {
        List<String> searchResultsList = new ArrayList<String>();
        for (WebElement searchResult : searchResults) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchResult);
            String searchResultText = searchResult.getText();
            searchResultsList.add(searchResultText);
        }
        return searchResultsList;
    }

    /**
     * Method that click on 'Page 2' button
     */
    public void clickSearchPage2() {
        waitUntilElementIsVisible(searchToolBar);
        searchPage2.click();}
}

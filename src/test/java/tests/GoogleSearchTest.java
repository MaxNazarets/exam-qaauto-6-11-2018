package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchResultsPage;

import java.util.List;

public class GoogleSearchTest extends BaseTest {

    /**
     * Precondition
     * - Open Browser
     * - Navigate to google.com
     * <p>
     * Scenario:
     * - Verify Home Page is loaded
     * - Enter "Selenium" into SearchField
     * - Click 'Search' button
     * - Verify SearchResult Page is loaded
     * - Verify resultsList contains 10 items
     * - Verify each item contains searchTerm
     * - Click on "Page 2" button to navigate to second page with searchTerm results
     * - Verify SearchResult Page is loaded
     * - Verify resultsList on page2 contains 10 items
     * - Verify each item contains searchTerm on page2
     * <p>
     * PostCondition:
     * - Close browser
     */
    @Test
    public void basicSearchTest() {

        Assert.assertTrue(homePage.isPageLoaded(), "HomePage is not loaded");

        String searchTerm = "Selenium";
        SearchResultsPage searchResultsPage = homePage.search(searchTerm);

        Assert.assertTrue(searchResultsPage.isPageLoaded(), "SearchResultsPage is not loaded");
        Assert.assertEquals(searchResultsPage.getSearchResultsCount(), 10, "Count of searchResultsList is not equal 10");

        List<String> searchResultsList = searchResultsPage.getSearchResults();

        for (String searchResult : searchResultsList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm " + searchTerm + " not found in:\n" + searchResult);
        }

        searchResultsPage.clickSearchPage2();

        Assert.assertTrue(searchResultsPage.isPageLoaded(), "SearchResultsPage is not loaded");

        Assert.assertEquals(searchResultsPage.getSearchResultsCount(), 10, "Count of searchResultsList is not equal 10");

        searchResultsPage.getSearchResults();

        for (String searchResult : searchResultsList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm " + searchTerm + " not found in:\n" + searchResult);
        }

    }
}
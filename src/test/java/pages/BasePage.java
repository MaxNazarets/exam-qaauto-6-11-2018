package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Main class for all PageObject classes.
 */
public abstract class BasePage {

    protected WebDriver driver;

    /**
     * Method which wait some element on page with hardcoded timeOut
     *
     * @param elementToWaitFor - WebElement which wants to show
     */
    protected void waitUntilElementIsVisible(WebElement elementToWaitFor) {
        waitUntilElementIsVisible(elementToWaitFor, 5);
    }

    /**
     * Method which wait some element on page
     *
     * @param elementToWaitFor - WebElement which wants to show
     * @param timeOutInSeconds - value for wait
     */
    protected void waitUntilElementIsVisible(WebElement elementToWaitFor, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(elementToWaitFor));
    }

    public abstract boolean isPageLoaded();
}

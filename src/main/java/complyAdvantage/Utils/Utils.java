package complyAdvantage.Utils;


import complyAdvantage.Pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils extends BasePage {

    //wait for the element present on the page
    public static void waitForElementPresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //select from the list
    public static void selectFromList(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    //isElementPresent
    public static boolean isElementPresent(WebElement element) {
        return element.isDisplayed();
    }

    //isTextPresent
    public static boolean isTextPresent(WebElement element, String text) {
        return element.getText().contains(text);
    }

}

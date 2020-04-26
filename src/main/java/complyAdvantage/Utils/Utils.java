package complyAdvantage.Utils;


import complyAdvantage.Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils extends BasePage {

    //try to create generic methods, which can be used in page classes
    //try to make the methods static


    //wait for the element present on the page
    public static void waitForElementPresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,30);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //wait for the text present on the page

    //select from list
//    public static void selectFromList(By element, String text) {
//        Select select = new Select(driver.findElement(element));
//        select.selectByVisibleText(text);
//    }
//
    public static void selectFromList(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    //......

    //isElementPresent

    //isTextPresent
}

package complyAdvantage.Pages;

import complyAdvantage.Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    @FindBy(css = "#fullName")
    WebElement nameField;

    @FindBy(css = "#country")
    WebElement countryField;

    @FindBy(css = "[name='yob']")
    WebElement yobField;

    @FindBy(css = "#position")
    WebElement positionField;

    @FindBy(css = "#url")
    WebElement urlField;

    @FindBy(css = "#risk")
    WebElement riskOption;

    @FindBy(css = ".btn.btn-secondary")
    WebElement saveButton;

    @FindBy(css = ".modal-content")
    WebElement modal;

    @FindBy(css = ".modal-body")
    WebElement modalMessage;

    @FindBy(css = ".form-error") //assumption for field set message (Assuming that error message will display on top of the form)
    WebElement fieldSetMessage;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isUserOnHomePage() {
        return driver.findElement(By.cssSelector(".form")).isDisplayed();
    }

    public void enterDetails(String fullname, String country, String yob,String position,String url,String risk_level) {
        nameField.sendKeys(fullname);
        countryField.sendKeys(country);
        yobField.sendKeys(yob);
        positionField.sendKeys(position);
        urlField.sendKeys(url);
        Utils.selectFromList(riskOption,risk_level);
    }

    public void selectSave() {
        saveButton.click();
    }

    public boolean verifyModal() {
        Utils.waitForElementPresent(modal);
        return modal.isDisplayed();
    }

    public boolean verifyMessage(String name) {
        return modalMessage.getText().contains(name);
    }

    public String getFieldSetMessage() {
    return fieldSetMessage.getText();
    }
}

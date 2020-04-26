package complyAdvantage;

import complyAdvantage.Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomePageStepDefs {

    HomePage homePage = new HomePage();

    @Given("^I am on the homepage$")
    public void verifyUserIsOnHomePage() {
        Assert.assertTrue(homePage.isUserOnHomePage());
    }

    @When("^I enter new entity with the data (.+), (.+), (.+), (.+), (.+), (.+)$")
    public void fillTheFrom(String fullname, String country, String yob, String position, String url, String risk_level) {
        homePage.enterDetails(fullname,country,yob,position,url,risk_level);
    }

    @When("^I select save$")
    public void selectSave() {
        homePage.selectSave();
    }

    @Then("^I should see message on pop up with politician name as (.+)$")
    public void verifyMessage(String fullname) {
        Assert.assertTrue(homePage.verifyModal());
        Assert.assertTrue(homePage.verifyMessage(fullname));
    }

    @Then("^I should see validation message as (.+)$")
    public void validationMessage(String message) {
        Assert.assertTrue(homePage.getFieldSetMessage().contains(message));
    }

    @Then("^I should not see the modal$")
    public void verifyModal() {
        Assert.assertFalse(homePage.verifyModal());
    }




}

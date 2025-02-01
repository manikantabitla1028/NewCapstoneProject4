package stepdefinitions;

import hooks.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.PageClass;
import utils.DriverManager;

import java.util.List;


public class StepDefinition {
    WebDriver driver;
    PageClass pageClass;
    public StepDefinition() {
        this.driver = DriverManager.getDriver();
        this.pageClass = new PageClass(driver);

    }

    @Given("I launch the application {string}")
    public void i_launch_the_application(String url) {

        driver.get(url);
    }

    @Then("I verify the title of the page is {string}")
    public void i_verify_the_title_of_the_page_is(String expectedTitle) {
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @When("I click on {string} link")
    public void i_click_on_link(String xpath) {
        switch(xpath) {
            case "A/B Testing":

                pageClass.clickOnABTestingLink();
                break;
            case "Dropdown":

                pageClass.clickOnDropdown();
                break;
            case "Frames":
                pageClass.clickOnFrames();

        }


    }

    @Then("I verify the text on the page is:")
    public void i_verify_the_text_on_the_page_is( DataTable dataTable) {
        String actualText = pageClass.verifyTheText();
        System.out.println("Actual Text on Page: " + actualText);

        if (actualText.equals("A/B Test Control") || actualText.equals("A/B Test Variation 1")) {
            System.out.println("Text matches one of the expected values.");
            Assert.assertTrue(true);  // Pass the test
        } else {
            System.out.println("Unexpected text: " + actualText);
            Assert.fail("Text does not match expected values!");
        }
    }

    @And("I navigate back to the home page")
    public void i_navigate_back_to_the_home_page() {

        driver.navigate().back();
    }


    @And("I select {string} from the dropdown")
    public void i_select_from_the_dropdown(String selectOption) {

        WebElement option = driver.findElement(pageClass.DROPDOWNSELECTION);
        Select select = new Select(option);
        select.selectByVisibleText(selectOption);

    }

    @Then("I verify the dropdown value is selected")
    public void i_verify_the_dropdown_value_is_selected() {
        WebElement option = driver.findElement(PageClass.DROPDOWNSELECTION);
        Select select = new Select(option);
        WebElement selectedOption = select.getFirstSelectedOption();
        Assert.assertEquals(selectedOption.getText(), "Option 1");
    }

    @Then("I verify the following links are present on the Frames page:")
    public void i_verify_the_following_links_are_present_on_the_frames_page(io.cucumber.datatable.DataTable dataTable) {
        for (String linkText : dataTable.asList()) {
            Assert.assertTrue(pageClass.verifyLinks(), linkText);
        }

    }
    @Then("I logout from application")
    public void i_logout_from_application() {
        DriverManager.quitDriver();
    }
}

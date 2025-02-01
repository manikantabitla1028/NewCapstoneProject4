package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
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
    //WebDriver driver = DriverManager.getDriver();

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
                //driver.findElement(By.xpath("//a[contains(text(),'A/B Testing')]")).click();
                pageClass.clickOnABTestingLink();
                break;
            case "Dropdown":
                //driver.findElement(By.xpath("//a[contains(text(), 'Dropdown')]")).click();
                pageClass.clickOnDropdown();
                break;
            case "Frames":
                //driver.findElement(By.xpath("//*[@href='/frames']")).click();
                pageClass.clickOnFrames();

        }


    }

    @Then("I verify the text on the page is:")
    public void i_verify_the_text_on_the_page_is(DataTable dataTable) {
        String actualText = pageClass.verifyTheText();

        // Convert DataTable to List
        List<String> expectedTexts = dataTable.asList();

        // Assert actual text is one of the expected values
        Assert.assertTrue(expectedTexts.contains(actualText),
                "Actual text '" + actualText + "' does not match any expected value!");
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
}

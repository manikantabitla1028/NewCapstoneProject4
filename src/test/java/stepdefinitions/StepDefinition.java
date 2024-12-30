package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.DriverManager;


public class StepDefinition {


    WebDriver driver = DriverManager.getDriver();

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
                driver.findElement(By.xpath("//a[contains(text(),'A/B Testing')]")).click();
                break;
            case "Dropdown":
                driver.findElement(By.xpath("//a[contains(text(), 'Dropdown')]")).click();
                break;
            case "Frames":
                driver.findElement(By.xpath("//*[@href='/frames']")).click();

        }


    }

    @Then("I verify the text on the page is {string}")
    public void i_verify_the_text_on_the_page_is(String expectedText) {
        WebElement textElement = driver.findElement(By.xpath("//h3[contains(text(), 'A/B Test Control')]"));
        Assert.assertTrue(textElement.getText().contains(expectedText));
    }

    @And("I navigate back to the home page")
    public void i_navigate_back_to_the_home_page() {
        driver.navigate().back();
    }


    @And("I select {string} from the dropdown")
    public void i_select_from_the_dropdown(String selectOption) {

        WebElement option = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(option);
        select.selectByVisibleText(selectOption);

    }

    @Then("I verify the dropdown value is selected")
    public void i_verify_the_dropdown_value_is_selected() {
        WebElement option = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(option);
        WebElement selectedOption = select.getFirstSelectedOption();
        Assert.assertEquals(selectedOption.getText(), "Option 1");
    }

    @Then("I verify the following links are present on the Frames page:")
    public void i_verify_the_following_links_are_present_on_the_frames_page(io.cucumber.datatable.DataTable dataTable) {
        for (String linkText : dataTable.asList()) {
            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='example']//li//a")).isDisplayed(), linkText);
        }

    }
}

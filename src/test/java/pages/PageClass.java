package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PageClass {
    public  WebDriver driver;
    public PageClass(WebDriver driver){
        this.driver=driver;
    }

    private final By ABTESTINGLINK = By.xpath("//a[contains(text(),'A/B Testing')]");
    private final By DROPDOWN = By.xpath("//a[contains(text(), 'Dropdown')]");
    private final By FRAMES = By.xpath("//*[@href='/frames']");
    private final By ABTESTCONTROL = By.xpath("//h3");

    public static By DROPDOWNSELECTION = By.xpath("//*[@id='dropdown']");
    private final By LINKTEXT = By.xpath("//div[@class='example']//li//a");




    public void clickOnABTestingLink(){
        driver.findElement(ABTESTINGLINK).click();
    }
    public void clickOnDropdown(){
        driver.findElement(DROPDOWN).click();
    }
    public void clickOnFrames(){
        driver.findElement(FRAMES).click();
    }
    public String verifyTheText(){
        return driver.findElement(ABTESTCONTROL).getText();

    }
    public boolean verifyLinks(){
        return driver.findElement(LINKTEXT).isDisplayed();


    }

}

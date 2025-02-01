package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.security.PublicKey;

public class PageClass {
    public  WebDriver driver;
    public PageClass(WebDriver driver){
        this.driver=driver;
    }

    private  By ABTESTINGLINK = By.xpath("//a[contains(text(),'A/B Testing')]");
    private  By DROPDOWN = By.xpath("//a[contains(text(), 'Dropdown')]");
    private  By FRAMES = By.xpath("//*[@href='/frames']");
    private  By ABTESTCONTROL = By.xpath("//h3[contains(text(), 'A/B Test Control')]");
    private  By ABTESTVARIATION = By.xpath("//h3[contains(text(), 'A/B Test Variation 1')]");

    public static By DROPDOWNSELECTION = By.xpath("//*[@id='dropdown']");
    private  By LINKTEXT = By.xpath("//div[@class='example']//li//a");




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

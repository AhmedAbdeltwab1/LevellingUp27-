package Fluent.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.awt.*;
import java.time.Duration;

public class CheckBoxPage {
    //Webdeiver
    WebDriver driver;
    Wait<WebDriver> wait;
    //Locators
    By checkbox = By.xpath("//form[@id='checkboxes']/input[1]");
    //Constructor
    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NotFoundException.class)
                .ignoring(AssertionError.class)
                .ignoring(ElementNotInteractableException.class);
    }
    public CheckBoxPage navigate(){
        driver.navigate().to("http://the-internet.herokuapp.com/checkboxes");
        return this;
    }
    /**
     * public void clickCheckbox(){
     *         driver.findElement(checkbox).click();
     *
     *     }
     *
     *     public boolean checkboxIsSelected(){
     *        return driver.findElement(checkbox).isSelected();
     *
     *     }
     */
    //Methods
     public CheckBoxPage checkboxStatus(){
         wait.until(d->{
            driver.findElement(checkbox).click();
             Assert.assertTrue(driver.findElement(checkbox).isSelected());
             return true;
         });
         return this;
     }
//    public CheckBoxPage checkboxIsSelected(){
//        driver.findElement(checkbox).isSelected();
//        return this;
//    }
}

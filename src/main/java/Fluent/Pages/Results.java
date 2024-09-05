package Fluent.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.io.NotActiveException;
import java.time.Duration;

public class Results extends Page {
    By anyResultLink;
    By anyResultText;
    //Constructor

    public Results(WebDriver driver) {
        super(driver);
    }

    //Methods

    public void checkResultLink(int index, String expectedLink){
        anyResultLink  = By.xpath("(//article)["+index+"]//h2/a");
        wait.until(d ->{
            String actualLink = driver.findElement(anyResultLink).getAttribute("href");
            Assert.assertEquals(actualLink,expectedLink);
            return true;
        });
        }
    public void checkResultText(int index, String expectedText){
        anyResultText = By.xpath("(//article)["+index+"]//h2");
        wait.until(d->{
            String actualText = driver.findElement(anyResultText).getText();
            Assert.assertEquals(actualText,expectedText);
            return true;
        });
    }
    //(//div[@class="hlcw0c"][1])//h3
    public void checkResultText2(int index, String expectedText){
        anyResultText = By.xpath("(//div[@class=\"hlcw0c\"]["+index+"])//h3");
        wait.until(d->{
            String actualText = driver.findElement(anyResultText).getText();
            Assert.assertEquals(actualText,expectedText);
            return true;
        });
    }
}

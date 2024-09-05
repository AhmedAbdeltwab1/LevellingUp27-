package Fluent.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import javax.xml.transform.Result;

public class Landing extends Page {

    //locators
    By searchField = By.name("q");
    //constructor
    public Landing(WebDriver driver) {
        super(driver);
    }

    //methods
    public Landing navigateToLandingPage(){
        driver.navigate().to("https://duckduckgo.com/");
        return this;
    }
    public Results search(String query){
        driver.findElement(searchField).sendKeys(query, Keys.ENTER);
        return new Results(driver);
    }

}

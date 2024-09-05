package Pom.Pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxPage {
    WebDriver driver;
    By checkbox = By.xpath("//form[@id='checkboxes']/input[1]");
    public CheckBoxPage(WebDriver driver){
        this.driver =driver;
    }
    public void navigateHerokuapp(){
        driver.navigate().to("http://the-internet.herokuapp.com/checkboxes");
    }
    public void clickCheckbox(){
        driver.findElement(checkbox).click();

    }
    public boolean checkboxIsSelected(){
       return driver.findElement(checkbox).isSelected();

    }

}

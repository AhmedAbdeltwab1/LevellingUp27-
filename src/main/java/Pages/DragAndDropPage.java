package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DragAndDropPage {
    WebDriver driver;

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }
    public void navigateToDrageAndDropPage(){
        driver.navigate().to("https://jqueryui.com/resources/demos/droppable/default.html");
    }
    public WebElement draggable(){
        return driver.findElement(By.id("draggable"));
    }
    public WebElement droppable(){
        return driver.findElement(By.id("droppable"));
    }
}

package Pom.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage {
    WebDriver driver;

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }
    WebElement draggableObject = driver.findElement(By.id("draggable"));
    public void navigateToDrageAndDropPage(){
        driver.navigate().to("https://jqueryui.com/resources/demos/droppable/default.html");
    }
    public void dragAndDropPerform(){
        Actions actions = new Actions(driver);

        WebElement droppablePlace = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(draggableObject,droppablePlace).perform();
    }
    public String getDroppablePlaceText(){
        return  driver.findElement(By.id("droppable")).getText();
    }

}

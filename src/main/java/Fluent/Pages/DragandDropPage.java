package Fluent.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DragandDropPage extends Page{

    public DragandDropPage(WebDriver driver) {
        super(driver);
    }
    By dragObject =By.id("draggable");
    By dropPlace = By.id("droppable");

    public DragandDropPage navigate(){
        driver.navigate().to("https://jqueryui.com/resources/demos/droppable/default.html");
        return this;
    }
    public DragandDropPage performDragAndDropObject(){
        wait.until(d->{
            WebElement draggableObject = driver.findElement(dragObject);
            WebElement droppablePlace = driver.findElement(dropPlace);
            actions.dragAndDrop(draggableObject,droppablePlace).perform();
            Assert.assertEquals(droppablePlace.getText(),"Dropped!");
            return true;
        });
        return this;
    }


}

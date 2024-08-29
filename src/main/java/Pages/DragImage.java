package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DragImage {
    WebDriver driver;
    By file = By.name("file");
    By upload = By.id("file-submit");
    public DragImage(WebDriver driver) {
        this.driver = driver;
    }
    public void navigateHerokuappDragImage(){
        driver.navigate().to("http://the-internet.herokuapp.com/upload");
    }
public void uploadTheImage(String absoluteFile){
    driver.findElement(file).sendKeys(absoluteFile);
}

    public WebElement UploadedImage(){
        return driver.findElement(upload);
    }

}

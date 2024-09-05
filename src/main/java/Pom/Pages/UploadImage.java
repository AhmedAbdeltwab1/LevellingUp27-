package Pom.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadImage {
    WebDriver driver;
    By file = By.name("file");
    By upload = By.id("file-submit");
    public UploadImage(WebDriver driver) {
        this.driver = driver;
    }
    public void navigateHerokuappDragImage(){
        driver.navigate().to("http://the-internet.herokuapp.com/upload");
    }
public void uploadTheImage(String absoluteFile){
    driver.findElement(file).sendKeys(absoluteFile);
}

    public void UploadedImage(){
        driver.findElement(upload).click();
    }

}

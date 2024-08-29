package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadedImageChecked {
    WebDriver driver;
    By uploadedFiles = By.id("uploaded-files");
    public UploadedImageChecked(WebDriver driver) {
        this.driver = driver;
    }
    public String UploadedImageGetText(){
        return driver.findElement(uploadedFiles).getText();
    }

}

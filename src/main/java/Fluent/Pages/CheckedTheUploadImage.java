package Fluent.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckedTheUploadImage extends Page {
    public CheckedTheUploadImage(WebDriver driver) {
        super(driver);
    }
    By uploadedFiles = By.id("uploaded-files");
    public void uploadImageStatus(String imageName){
        wait.until(d->{
           String actualImage =  driver.findElement(uploadedFiles).getText();
            Assert.assertEquals(actualImage,imageName);
            return true;
        });
    }

}

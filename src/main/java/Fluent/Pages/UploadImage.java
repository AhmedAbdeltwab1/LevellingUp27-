package Fluent.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class UploadImage extends Page{

    //Locators
    String absoluteFile = "E:\\Learning\\Test Automation\\projects\\IdeaProjects\\LevellingUp27-\\src\\main\\resources\\5.jpg";
    By file = By.name("file");
    By upload = By.id("file-submit");
    //Constructor
    public UploadImage(WebDriver driver) {
        super(driver);
    }
    // Methods
    public UploadImage navigate(){
        driver.navigate().to("http://the-internet.herokuapp.com/upload");
        return this;
    }

    public UploadImage enterThePathOfTheImage(String query){
        wait.until(d->{
            driver.findElement(file).sendKeys(query);
            return true;
        });
        return this;
    }

    public CheckedTheUploadImage uploadTheImage(){
        wait.until(d->{
            driver.findElement(upload).click();
            return true;
        });
        return new CheckedTheUploadImage(driver);
    }



}

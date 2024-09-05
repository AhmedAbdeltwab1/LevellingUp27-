package Fluent.Pages;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFromJsonFile extends Page{
    public ReadFromJsonFile(WebDriver driver) {
        super(driver);
    }
    By textField = By.name("q");
    JsonObject jsonObject;
    private void initiateJsonFile(String filePath) throws IOException {
        String data =new String(Files.readAllBytes(Paths.get(filePath)));
        Gson gson = new Gson();
        jsonObject = gson.fromJson(data, JsonObject.class);
    }
    public ReadFromJsonFile navigate(){
        driver.navigate().to("https://www.google.com/");
        return this;
    }
    public Results search(String filePath) throws IOException {
        initiateJsonFile(filePath);
        String text = jsonObject.get("searchQuery").getAsString();
//        String x = driver.findElement(firstResult).getText();
        wait.until(d->{
            driver.findElement(textField).sendKeys(text+ Keys.ENTER);
//            Assert.assertEquals(x,"WebDriver" );
            return true;
        });
        return new Results(driver);
    }






}

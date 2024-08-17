package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseTests {
    WebDriver driver;
    @BeforeClass
     public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }
    @Test
    public void testGetTitle(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"Google");
        System.out.println("Title is "+title);
    }
    @Test
    public void testIconIsDisplayed(){
        By pageIcon = By.className("lnXdpd");
        Assert.assertTrue(driver.findElement(pageIcon).isDisplayed());
    }
    @AfterClass
    public void quit(){
        driver.quit();
    }
    /*@Test
    public void base(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.quit();
    }*/
}

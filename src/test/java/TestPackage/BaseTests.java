package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.* ;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    WebDriver driver;
    @BeforeClass
     public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }
    @Test(priority = 1)
    public void testGetTitle(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"Google");
        System.out.println("Title is "+title);
    }
    @Test(priority = 2)
    public void testIconIsDisplayed(){
        By pageIcon = By.className("lnXdpd");
        Assert.assertTrue(driver.findElement(pageIcon).isDisplayed());
    }

    /**
     * Open Google Chrome
     * Navigate to [https://www.google.com/ncr]
     * Search for [Selenium WebDriver]
     * Assert that the text of the first result is [Selenium - Web Browser Automation]
     * Close Google Chrome
     * //div[@class="MjjYud"]/div[@class="g Ww4FFb vt6azd tF2Cxc asEBEc"][]
     */
    @Test(priority = 3)
    public void testIVerifyFirstResult(){
        By textField = By.name("q");
        By firstResult = By.xpath("//h3[@class=\"LC20lb MBeuO DKV0Md\"]/span[@dir=\"ltr\"]");
        driver.findElement(textField).sendKeys("Selenium WebDriver"+Keys.ENTER);
        String x = driver.findElement(firstResult).getText();
        System.out.println("Result= " + x);
        Assert.assertEquals(x,"WebDriver" );

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

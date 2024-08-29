package TestPackage.Linear;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test2 {
    WebDriver driver;
    Wait<WebDriver> wait;
    /**
     * #3
     * ________________ Basic ________________
     * Open Mozilla FireFox
     * Navigate to [https://duckduckgo.com/]
     * Search for [Selenium WebDriver]
     * Assert that the link of the first result is [https://www.selenium.dev/documentation/webdriver/]
     * Close Mozilla Firefox
     * #4
     * ________________ Moderate ________________
     * Open Mozilla Firefox
     * Navigate to [https://duckduckgo.com/]
     * Search for [TestNG]
     * Assert that the text of the fourth result is [TestNG Tutorial]
     * Close Mozilla Firefox
     */
    @Test
    public void testFirstResult(){
        By searchField = By.name("q");

        driver.findElement(searchField).sendKeys("Selenium WebDriver",Keys.ENTER);
        wait.until(d-> {
            By firstLink = By.xpath("(//article)[1]//h2/a");
            String actualLink = driver.findElement(firstLink).getAttribute("href");
            Assert.assertEquals(actualLink,"https://www.selenium.dev/documentation/webdriver/");
            return true;
        });
    }
    @Test
    public void testFourthResult(){
        By searchField = By.name("q");
        By fourthLinkText = By.xpath("(//article)[5]//h2");
        driver.findElement(searchField).sendKeys("TestNG",Keys.ENTER);
        wait.until(driver1 -> {
            String text  = driver.findElement(fourthLinkText).getText();
            Assert.assertEquals(text,"TestNG Tutorial - GeeksforGeeks");
            return true;
        });
    }
    @BeforeMethod
    public void setUp(){
        driver = new FirefoxDriver();
        driver.navigate().to("https://duckduckgo.com/");
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1280,720));

        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NotFoundException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(AssertionError.class);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}


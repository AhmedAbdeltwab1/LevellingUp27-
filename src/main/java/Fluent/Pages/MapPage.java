package Fluent.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;

public class MapPage extends Page {
    public MapPage(WebDriver driver) {
        super(driver);
    }

    By Ernst = By.xpath("//table[@id='customers']//tr[td[1]='Ernst Handel']/td[3]");

    public MapPage navigateToMapPage(){

        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
        return this;
    }
    public MapPage countryOfCompanyErnstHandel(){
        wait.until(d->{
            String country = driver.findElement(Ernst).getText();
            Assert.assertEquals(country,"Austria");
            return true;
        });
        return this;
    }


}

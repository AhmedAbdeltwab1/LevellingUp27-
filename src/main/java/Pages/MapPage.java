package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MapPage {
    WebDriver driver;
    By Ernst = By.xpath("//table[@id='customers']//tr[td[1]='Ernst Handel']/td[3]");
    public MapPage(WebDriver driver) {
        this.driver = driver;
    }
    public void navigateToMapPage(){
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
    }
    public String countryOfCompanyErnstHandel(){
        return driver.findElement(Ernst).getText();
    }

}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResult {
    WebDriver driver;
    public SearchResult (WebDriver driver){
        this.driver=driver;
    }
    By firstLink = By.xpath("(//article)[1]//h2/a");
    By fourthLinkText = By.xpath("(//article)[5]//h2");
    public String getLink(){
       String link = driver.findElement(firstLink).getAttribute("href");
       return link;
    }
    public String getText(){
        String text = driver.findElement(fourthLinkText).getText();
        return text;
    }

//    public getText(){
//
//    }




}

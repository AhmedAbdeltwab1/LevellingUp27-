package TestPackage.Modular;

import Fluent.Pages.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class FluentTestCases extends TestCase {

    @Test
    public void checkResltLink(){
        new Landing(driver).navigateToLandingPage()
                .search("Selenium WebDriver")
                .checkResultLink(1,"https://www.selenium.dev/documentation/webdriver/");
    }
    @Test
    public void checkResultText(){
        new Landing(driver).navigateToLandingPage()
                .search("TestNG")
                .checkResultText(4,"TestNG Tutorial");
    }
    @Test
    public void checkCheckBoxIsSelectedRight(){
        new CheckBoxPage(driver)
                .navigate()
                .checkboxStatus();

    }
    @Test
    public void checkCountryName(){
        new MapPage(driver)
                .navigateToMapPage()
                .countryOfCompanyErnstHandel();
    }
    @Test
    public void UploadRequiredImage(){
        String query = "E:\\Learning\\Test Automation\\projects\\IdeaProjects\\LevellingUp27-\\src\\main\\resources\\5.jpg";
        String imageName =  "5.jpg";
        new UploadImage(driver)
                .navigate()
                .enterThePathOfTheImage(query)
                .uploadTheImage()
                .uploadImageStatus(imageName);
    }
    @Test
    public void checkDragAndDrop(){
        new DragandDropPage(driver)
                .navigate()
                .performDragAndDropObject();

    }
    @Test
    public void readDatafromJsonFile() throws IOException {
        String filePath = "E:\\Learning\\Test Automation\\projects\\IdeaProjects\\LevellingUp27-\\src\\test\\resources\\testDataFiles\\JSONFile.json";
        new ReadFromJsonFile(driver)
                .navigate()
                .search(filePath)
                .checkResultText2(1,"WebDriver");

    }

}

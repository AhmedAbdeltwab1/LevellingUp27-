package TestPackage.Linear;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.* ;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseTests {
    WebDriver driver;
    @BeforeClass
     public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }
    //dependancy + before/after Method
    //Never Ever Use Priority
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
        String x = driver.findElement(firstResult).getAttribute("href");
        System.out.println("Result= " + x);
        Assert.assertEquals(x,"WebDriver" );

    }
    /**
     * ●	Open Google Chrome
     * ●	Navigate to [http://the-internet.herokuapp.com/checkboxes]
     * ●	Check Checkbox 1
     * ●	Assert that both Checkboxes are checked
     * ●	Close Google Chrome
     */
    @Test(priority = 4)
    public void testIVerifyCheckbox(){
        driver.navigate().to("http://the-internet.herokuapp.com/checkboxes");
       WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
       checkbox1.click();
       assert checkbox1.isSelected();
    }

    /**
     * ●	Open Google Chrome
     * ●	Navigate to [https://www.w3schools.com/html/html_tables.asp]
     * ●	Assert that the Country for the Company [Ernst Handel] is [Austria]
     * ●	Close Google Chrome
     */
    @Test(priority = 5)
    //take so long time to load the page ?!
    public void testIVerifyTableMapping(){
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
        By Ernst = By.xpath("//table[@id='customers']//tr[td[1]='Ernst Handel']/td[3]");
        String country = driver.findElement(Ernst).getText();
        Assert.assertEquals(country,"Austria");
    }
    /**
     *●	Open Google Chrome
     * ●	Navigate to [http://the-internet.herokuapp.com/upload]
     * ●	Upload a small image file
     * ●	Assert that the file was uploaded successfully
     * ●	Close Google Chrome
     */
    @Test(priority = 6)
    public void testUploadImage(){

        String absoluteFile = "E:\\Learning\\Test Automation\\projects\\IdeaProjects\\LevellingUp27-\\src\\main\\resources\\5.jpg";
        By file = By.name("file");
        By upload = By.id("file-submit");
        By uploadedFiles = By.id("uploaded-files");
        driver.navigate().to("http://the-internet.herokuapp.com/upload");
        driver.findElement(file).sendKeys(absoluteFile);
        WebElement uploadImage = driver.findElement(upload);
        uploadImage.click();
        String checkUploadFile =driver.findElement(uploadedFiles).getText();
        Assert.assertEquals(checkUploadFile,"5.jpg");
    }

    /**
     * ●	Open Google Chrome
     * ●	Navigate to [https://jqueryui.com/resources/demos/droppable/default.html]
     * ●	Drag [Drag me to my target] and drop it on [Drop here]
     * ●	Assert that the text has been changed to [Dropped!]
     * ●	Close Google Chrome
     */
    @Test(priority = 7)
    /*Why does the compiler make Exception when The URL at the bottom?*/
    public void testDragAndDrop(){
        driver.navigate().to("https://jqueryui.com/resources/demos/droppable/default.html");
        WebElement draggableObject = driver.findElement(By.id("draggable"));
        WebElement droppablePlace = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
       // driver.navigate().to("https://jqueryui.com/resources/demos/droppable/default.html");
        actions.dragAndDrop(draggableObject,droppablePlace).perform();
        Assert.assertEquals(droppablePlace.getText(),"Dropped!");
    }

    /**
     * ________________ Task #11 - Difficulty: Advanced ________________
     * ●	Repeat Task #3 but read the text values from an external file (txt, xml, json, or excel)
     * @throws IOException
     */
    @Test(priority =8 )
    public void testIVerifyFirstResultUsingJSONFile() throws IOException {
        driver.get("https://www.google.com/");
        By textField = By.name("q");
        By firstResult = By.xpath("//h3[@class=\"LC20lb MBeuO DKV0Md\"]/span[@dir=\"ltr\"]");
        String filePath = "E:\\Learning\\Test Automation\\projects\\IdeaProjects\\LevellingUp27-\\src\\test\\resources\\testDataFiles\\JSONFile.json";
        String data =new String(Files.readAllBytes(Paths.get(filePath)));
        Gson gson = new Gson();
        // Parse the JSON string into a JsonObject
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        String text = jsonObject.get("searchQuery").getAsString();
        driver.findElement(textField).sendKeys(text+Keys.ENTER);
        String x = driver.findElement(firstResult).getText();
        System.out.println("Result= " + x);
        Assert.assertEquals(x,"WebDriver" );

    }
    @Test(priority =9 )
    public void testIVerifyFirstResultUsingTXTFile() throws IOException {
        driver.get("https://www.google.com/");
        By textField = By.name("q");
        By firstResult = By.xpath("//h3[@class=\"LC20lb MBeuO DKV0Md\"]/span[@dir=\"ltr\"]");
        String filePath = "E:\\Learning\\Test Automation\\projects\\IdeaProjects\\LevellingUp27-\\src\\test\\resources\\testDataFiles\\TestData.txt";
        String data =Files.readString(Paths.get(filePath));
        driver.findElement(textField).sendKeys(data+Keys.ENTER);
        String x = driver.findElement(firstResult).getText();
        System.out.println("Result= " + x);
        Assert.assertEquals(x,"WebDriver" );

    }
    @Test(priority =10)
    public void testIVerifyFirstResultUsingExcelFile() throws IOException {
        driver.get("https://www.google.com/");
        By textField = By.name("q");
        By firstResult = By.xpath("//h3[@class=\"LC20lb MBeuO DKV0Md\"]/span[@dir=\"ltr\"]");
        String filePath = "E:\\Learning\\Test Automation\\projects\\IdeaProjects\\LevellingUp27-\\src\\test\\resources\\testDataFiles\\TestData.txt";
        String data =Files.readString(Paths.get(filePath));
        driver.findElement(textField).sendKeys(data+Keys.ENTER);
        String x = driver.findElement(firstResult).getText();
        System.out.println("Result= " + x);
        Assert.assertEquals(x,"WebDriver" );

    }
    @AfterClass
    public void quit(){
        driver.quit();
    }

}

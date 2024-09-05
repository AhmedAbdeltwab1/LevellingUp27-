package TestPackage.Modular;

import Pom.Pages.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task8Tests {
    WebDriver driver;
    Wait<WebDriver> wait;
    Landing landingPage;
    CheckBoxPage checkBoxPage;
    SearchResult searchResult;
    MapPage mapPage;
    UploadImage uploadImage;
    UploadedImageChecked uploadedImageChecked;
    DragAndDropPage dragAndDropPage;

    /**
     * #3
     * ________________ Basic ________________
     * Open Mozilla FireFox
     * Navigate to [https://duckduckgo.com/]
     * Search for [Selenium WebDriver]
     * Assert that the link of the first result is [https://www.selenium.dev/documentation/webdriver/]
     * Close Mozilla Firefox
     * #4
     */

    @Test
    public void testFirstResult() {
        String testData = "Selenium WebDriver";
        landingPage.search(testData);
        wait.until(d -> {
            String ActualLink = searchResult.getLink();
            Assert.assertEquals(ActualLink, "https://www.selenium.dev/documentation/webdriver/");
            return true;
        });
    }

    /**
     * Open Mozilla Firefox
     * Navigate to [https://duckduckgo.com/]
     * Search for [TestNG]
     * Assert that the text of the fourth result is [TestNG Tutorial]
     * Close Mozilla Firefox
     */
    @Test
    public void testFourthResult() {
        String testData = "TestNG";
        landingPage.search(testData);
        wait.until(driver1 -> {
            String text = searchResult.getText();
            Assert.assertEquals(text, "TestNG Tutorial - GeeksforGeeks");
            return true;
        });
    }

    /**
     * Open Google Chrome
     * Navigate to [http://the-internet.herokuapp.com/checkboxes]
     * Check Checkbox 1
     * Assert that both Checkboxes are checked
     * Close Google Chrome
     */
//    @Test
//    public void testIVerifyCheckbox() {
//        checkBoxPage.navigateHerokuapp();
//        wait.until(driver1 -> {
//            checkBoxPage.Checkbox().click();
//            assert checkBoxPage.Checkbox().isSelected();
//            return true;
//        });
//    }
    @Test
    public void testIVerifyCheckbox() {
        checkBoxPage.navigateHerokuapp();
        wait.until(driver1 -> {
            checkBoxPage.clickCheckbox();
            Assert.assertTrue(checkBoxPage.checkboxIsSelected());
            return true;
        });
    }

    /**
     * ●	Open Google Chrome
     * ●	Navigate to [https://www.w3schools.com/html/html_tables.asp]
     * ●	Assert that the Country for the Company [Ernst Handel] is [Austria]
     * ●	Close Google Chrome
     */
    @Test
    public void testIVerifyTableMapping() {
        mapPage.navigateToMapPage();
        wait.until(d -> {
            String country = mapPage.countryOfCompanyErnstHandel();
            Assert.assertEquals(country, "Austria");
            return true;
        });
    }
    /**
     *●	Open Google Chrome
     * ●	Navigate to [http://the-internet.herokuapp.com/upload]
     * ●	Upload a small image file
     * ●	Assert that the file was uploaded successfully
     * ●	Close Google Chrome
     */
    @Test
    public void testUploadImag() {
        String absoluteFile = "E:\\Learning\\Test Automation\\projects\\IdeaProjects\\LevellingUp27-\\src\\main\\resources\\5.jpg";
        uploadImage.navigateHerokuappDragImage();
        wait.until(d->{
            uploadImage.uploadTheImage(absoluteFile);
            uploadImage.UploadedImage();
            String checkUploadFile = uploadedImageChecked.UploadedImageGetText();
            Assert.assertEquals(checkUploadFile, "5.jpg");
            return true;
        });
    }
    /**
     * ●	Open Google Chrome
     * ●	Navigate to [https://jqueryui.com/resources/demos/droppable/default.html]
     * ●	Drag [Drag me to my target] and drop it on [Drop here]
     * ●	Assert that the text has been changed to [Dropped!]
     * ●	Close Google Chrome
     */
    @Test
    /*Why does the compiler make Exception when The URL at the bottom?*/
    public void testDragAndDrop(){
        dragAndDropPage.navigateToDrageAndDropPage();
        wait.until(d->{
            dragAndDropPage.dragAndDropPerform();
            Assert.assertEquals(dragAndDropPage.getDroppablePlaceText(),"Dropped!");
            return true;
        });

    }

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        landingPage = new Landing(driver);
        searchResult = new SearchResult(driver);
        checkBoxPage = new CheckBoxPage(driver);
        landingPage.navigate();
        mapPage = new MapPage(driver);
        uploadImage = new UploadImage(driver);
        uploadedImageChecked = new UploadedImageChecked(driver);
        dragAndDropPage = new DragAndDropPage(driver);
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1280, 720));

        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NotFoundException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(AssertionError.class);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}




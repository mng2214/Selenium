package JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.sql.rowset.BaseRowSet;
import java.time.Duration;

public class JavascriptMethods {

    //we use javascript methods when selenium methods are not working
    //specifically click , getTitle
    //NOTE: we love using ScrollIntoView method from Javascript in professional environment
    @Test
    public void getTitle() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/");

        System.out.println(driver.getTitle() + " this is regular way to get title");
        //if this is not working  then i need to use JS methods

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = js.executeScript("return document.title").toString();
        System.out.println(title + " this is JS driver method");

    }

    @Test
    public void clickJS() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/radio-button");

        WebElement yesButton = driver.findElement(By.xpath("//input[@id = 'yesRadio']"));
//        yesButton.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", yesButton);

        WebElement message = driver.findElement(By.cssSelector(".mt-3"));
        String actualMessage = BrowserUtils.getText(message);
        String expectedMessage = "You have selected Yes";
        Assert.assertEquals(actualMessage, expectedMessage);

        Thread.sleep(1000);

        WebElement impressiveButton = driver.findElement(By.cssSelector("#impressiveRadio"));
        js.executeScript("arguments[0].click()", impressiveButton);
        Thread.sleep(1000);
        String actualImpressiveMessage = BrowserUtils.getText(message);
        String expectedImpressiveMessage = "You have selected Impressive";
        Assert.assertEquals(actualImpressiveMessage, expectedImpressiveMessage);

    }

    @Test
    public void scrollIntoView() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/");

        WebElement findCourse = driver.findElement(By.xpath("//span[contains(text(),'Find out which course is for you')]//.."));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", findCourse); // ***
        Thread.sleep(500);
        js.executeScript("arguments[0].click()",findCourse); //**
        Thread.sleep(500);
        System.out.println(js.executeScript("return document.title")); //*
    }

    @Test
    public void shortCutsMethods() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/");

        WebElement findCourse = driver.findElement(By.xpath("//span[contains(text(),'Find out which course is for you')]//.."));
        BrowserUtils.scrollWithJS(driver,findCourse);
        Thread.sleep(500);
        BrowserUtils.clickWithJS(driver,findCourse);
        Thread.sleep(500);
        System.out.println(BrowserUtils.getTitleWithJS(driver));






    }

}

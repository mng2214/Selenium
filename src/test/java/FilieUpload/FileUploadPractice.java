package FilieUpload;

import ActionClass.DragAndDrop;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FileUploadPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        Actions actions = new Actions(driver);

        WebElement chooseFileButton = driver.findElement(By.cssSelector("#file-upload"));
        chooseFileButton.sendKeys("C:/Users/mng22/OneDrive/Desktop/B16Mentoring/ASCII.png");
        driver.findElement(By.cssSelector("#file-submit")).click();

        WebElement unloadedFile = driver.findElement(By.cssSelector("#uploaded-files"));
        Assert.assertEquals(BrowserUtils.getText(unloadedFile), "ASCII.png");

//        WebElement box = driver.findElement(By.xpath("//div[@id='drag-drop-upload']"));
//        box.sendKeys("C:/Users/mng22/OneDrive/Desktop/B16Mentoring/ASCII.png");
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/upload/");
        Actions actions = new Actions(driver);

        WebElement chooseFileButton = driver.findElement(By.cssSelector(".upload_txt"));
        chooseFileButton.sendKeys("C:/Users/mng22/OneDrive/Desktop/B16Mentoring/ASCII.png");

        WebElement sentValid = driver.findElement(By.xpath("//b[contains(text(),'Select file to send')]"));
        Assert.assertTrue(BrowserUtils.getText(sentValid).contains("Select file to send"));

        driver.findElement(By.cssSelector("#terms")).click();
        driver.findElement(By.cssSelector("#submitbutton")).click();
        Thread.sleep(500);
        WebElement submitText = driver.findElement(By.xpath("//h3//center"));
        Assert.assertTrue(BrowserUtils.getText(submitText).contains("successfully uploaded"));
        driver.quit();

    }
}

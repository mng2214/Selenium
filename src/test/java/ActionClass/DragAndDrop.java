package ActionClass;

import com.beust.ah.A;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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

public class DragAndDrop {
    @Test
    public void dragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");

        Thread.sleep(1000);

        WebElement cookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookies.click();
        Thread.sleep(1000);

        WebElement orangeBox = driver.findElement(By.xpath("//div[@class = 'test2']"));
        String actualMsg = BrowserUtils.getText(orangeBox);
        String expectedMsg = "... Or here.";
        Assert.assertEquals(actualMsg, expectedMsg);

        Thread.sleep(1000);
        String actualColorOfBox = orangeBox.getCssValue("background-color");
        String expectedColorOfBox = "rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualColorOfBox, expectedColorOfBox);

        WebElement dragger = driver.findElement(By.xpath("//div[@id = 'draggable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragger,orangeBox).perform();
        Thread.sleep(3000);
        orangeBox = driver.findElement(By.xpath("//div[@class = 'test2']"));
        String actualMessageAfterDragAndDrop = BrowserUtils.getText(orangeBox);
        String expectedMessageAfterDragAndDrop = "You did great!";
        Assert.assertEquals(actualMessageAfterDragAndDrop, expectedMessageAfterDragAndDrop);

    }
    @Test
    public void ClickAndHoldRelease () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Thread.sleep(2000);
        WebElement cookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookies.click();
        Thread.sleep(1000);

        WebElement blueBox = driver.findElement(By.xpath("//div[@class = 'test1']"));
        String actualMsg = BrowserUtils.getText(blueBox);
        String expectedMsg = "Drag the small circle here ...";
        Assert.assertEquals(actualMsg, expectedMsg);

        Thread.sleep(1000);
        String actualColorOfBox = blueBox.getCssValue("background-color");
        String expectedColorOfBox = "rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualColorOfBox, expectedColorOfBox);

        WebElement dragger = driver.findElement(By.xpath("//div[@id = 'draggable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(dragger).perform();
        Thread.sleep(1000);
        actions.moveToElement(blueBox).perform();
        Thread.sleep(1000);
        actions.release().perform();
        Thread.sleep(1000);


        blueBox = driver.findElement(By.xpath("//div[@class = 'test1']"));
        String actualMessageAfterDragAndDrop = BrowserUtils.getText(blueBox);
        String expectedMessageAfterDragAndDrop = "You did great!";
        Assert.assertEquals(actualMessageAfterDragAndDrop, expectedMessageAfterDragAndDrop);


    }

}

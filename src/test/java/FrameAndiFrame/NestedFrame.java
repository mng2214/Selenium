package FrameAndiFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class NestedFrame {

    @Test
    public void nestedFramePractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames\n");

        //LEFT

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement LEFT = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        Assert.assertEquals(BrowserUtils.getText(LEFT), "LEFT");
        System.out.println(BrowserUtils.getText(LEFT));

        //MIDDLE

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement MID = driver.findElement(By.xpath("//div[@id='content']"));
        Assert.assertEquals(BrowserUtils.getText(MID), "MIDDLE");
        driver.switchTo().parentFrame();

        //RIGHT

        driver.switchTo().frame("frame-right");
        WebElement RIGHT = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        Assert.assertEquals(BrowserUtils.getText(RIGHT), "RIGHT");

        //BOTTOM

//       driver.switchTo().parentFrame(); // to main frame
//       driver.switchTo().parentFrame(); // to top frame
        driver.switchTo().defaultContent(); // --->> got to main frame right the way!
        driver.switchTo().frame("frame-bottom");
        WebElement BOTTOM = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        Assert.assertEquals(BrowserUtils.getText(BOTTOM), "BOTTOM");

        Thread.sleep(4000);
        driver.quit();
    }
}

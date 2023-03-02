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

public class FramePractice {

    @Test
    public void iframePractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        WebElement title = driver.findElement(By.xpath("//h3"));
        String actual = BrowserUtils.getText(title);
        String expected = "An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actual, expected);

        driver.switchTo().frame("mce_0_ifr");
        Thread.sleep(500);
        WebElement text = driver.findElement(By.cssSelector("#tinymce"));
        text.clear();
        Thread.sleep(500);
        text.sendKeys("i love selenium");

        driver.switchTo().parentFrame();
        Thread.sleep(100);
        WebElement elementLink = driver.findElement(By.xpath("//a[contains(text(),'Elemental Selenium')]"));
        elementLink.click();
        Thread.sleep(500);
        BrowserUtils.switchByTitle(driver,"Elemental Selenium");
        Thread.sleep(500);
        WebElement header = driver.findElement(By.tagName("h1"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "Elemental Selenium";
        Assert.assertEquals(actualHeader,expectedHeader);


    }
}

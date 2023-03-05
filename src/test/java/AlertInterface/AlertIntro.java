package AlertInterface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.swing.plaf.TableHeaderUI;
import java.time.Duration;

public class AlertIntro {

    @Test
    public void AlertIntro() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]")).click(); // new x path
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();
        Thread.sleep(3000);
        WebElement message1 = driver.findElement(By.cssSelector("#result"));
        Assert.assertEquals(BrowserUtils.getText(message1), "You successfully clicked an alert");
        driver.quit();
    }

    @Test
    public void AlertDismiss() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm')]")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Confirm");
        alert.dismiss();
        Thread.sleep(2000);
        WebElement message1 = driver.findElement(By.cssSelector("#result"));
        Assert.assertEquals(BrowserUtils.getText(message1), "You clicked: Cancel");
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void AlertPrompt() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[contains(@onclick,'jsPrompt')]")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("artur");
        alert.accept();
        Thread.sleep(3000);
        WebElement message1 = driver.findElement(By.cssSelector("#result"));
        Assert.assertEquals(BrowserUtils.getText(message1), "You entered: artur");
        Thread.sleep(3000);
        driver.quit();
    }

}

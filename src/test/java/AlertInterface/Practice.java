package AlertInterface;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class Practice {

    @Test
    public void name() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");
        //Box 1
        driver.findElement(By.cssSelector("#alertBox")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(), "I am an alert box!");
        alert.accept();
        Thread.sleep(350);
        WebElement message = driver.findElement(By.cssSelector("#output"));
        Assert.assertEquals(BrowserUtils.getText(message), "You selected alert popup");
        //Box 2
        driver.findElement(By.cssSelector("#confirmBox")).click();
        Assert.assertEquals(alert.getText(),"Press a button!");
        alert.dismiss();
        Thread.sleep(350);
        //Box 3
        driver.findElement(By.cssSelector("#promptBox")).click();
        alert.sendKeys("artur");
        alert.accept();
        Thread.sleep(350);
        Assert.assertEquals(BrowserUtils.getText(message), "You entered text artur in propmt popup");
        driver.quit();

    }


}

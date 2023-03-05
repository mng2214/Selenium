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

import java.time.Duration;

public class HTMLpopUP {
    @Test
    public void htmlPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://sweetalert.js.org/");

        driver.findElement(By.xpath("//button[contains(@onclick,'alert')]")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Oops, something went wrong!");
        alert.accept();
        Thread.sleep(500);

        driver.findElement(By.xpath("//button[contains(@onclick,'swal')]")).click();
        Thread.sleep(2000);
        WebElement textHTML = driver.findElement(By.xpath("//div[@class='swal-modal']"));
        Assert.assertTrue(BrowserUtils.getText(textHTML).contains("Something went wrong!"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[.='OK']")).click();
        driver.quit();



    }
}

package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class OpenChartTestNGPractice {

    @Test
    public void successfulLogin () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.xpath("//input[@id = 'input-username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'input-password']"));
        password.sendKeys("demo");
        WebElement submit = driver.findElement(By.xpath("//button[@type = 'submit']"));
        submit.click();
        Thread.sleep(2000);
        String actual = driver.getTitle();
        String expected = "Dashboard";
        Assert.assertEquals(actual , expected);

        Thread.sleep(10000);
        driver.quit();
    }




}

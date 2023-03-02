package emailSender;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class emailSender {

    @Test
    public void emailer() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.emailondeck.com/");




        driver.findElement(By.xpath("//div[@id='ybarAccountProfile']//a[contains(text(),'Sign in')]")).click();

        driver.findElement(By.cssSelector("#createacc")).click();


        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
        firstName.sendKeys("TONU");

        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
        lastName.sendKeys("Request");

        String emailAddition = "";
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            int userNameRandom = random.nextInt(9);
            emailAddition += userNameRandom;
        }

        String userName = "TONURequest." + emailAddition;

        WebElement emailName = driver.findElement(By.xpath("//input[@name='userId']"));
        emailName.sendKeys(userName);

        String password = "!@2023QWERty";

        WebElement pass = driver.findElement(By.xpath("//input[@id='usernamereg-password']"));
        pass.sendKeys(password);

        WebElement dob = driver.findElement(By.cssSelector("#usernamereg-birthYear"));
        dob.sendKeys("1990");

        driver.findElement(By.cssSelector("#reg-submit-button")).click();
        Thread.sleep(1000);




    }


}

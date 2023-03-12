package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;
import java.time.Duration;
/*
1-Navigate to the website "https://www.facebook.com/"
2-Click Create Account Button
3-Fill all the boxes
4-Choose Custom Gender
5-Choose any pronoun you want from
6-Click Sign up button
7-In general facebook has a protection to automate create account  so once you
click sign up button if there is a message then validate it. If no, just close or quit

   PURPOSE:
       1-This task can come during the interview
       2-How to deal with dynamic elements

 */
public class mentoring2 {

    @Test
     public void creatingFacebookAccount() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.facebook.com/");
        WebElement creatAccButton= driver.findElement(By.xpath("//a[contains(text(), 'Create new account')]"));
        Thread.sleep(2000);
        creatAccButton.click();
        WebElement firstName= driver.findElement(By.xpath("//input[@name = 'firstname']"));
        firstName.sendKeys("artfirst");
        Thread.sleep(1000);
        WebElement lastName= driver.findElement(By.xpath("//input[@name = 'lastname']"));
        lastName.sendKeys("sdsadsadsa");
        Thread.sleep(1000);
        WebElement phoneNumber= driver.findElement(By.xpath("//input[@name = 'reg_email__']"));
        phoneNumber.sendKeys("7735108588");
        Thread.sleep(1000);
        WebElement password = driver.findElement(By.xpath("//input[@data-type= 'password']"));
        password.sendKeys("Pass!1234");
        Thread.sleep(1000);
        WebElement month = driver.findElement(By.xpath("//option[contains(text() , 'Nov')]"));
        month.click();
        Thread.sleep(1000);
        WebElement day = driver.findElement(By.xpath("//option[.='1']"));
        day.click();
        Thread.sleep(1000);
        WebElement year = driver.findElement(By.xpath("//option[.='1993']"));
        year.click();
        Thread.sleep(100);
        WebElement sex = driver.findElement(By.xpath("//label[.= 'Male']"));
        sex.click();
        Thread.sleep(100);
        WebElement submit = driver.findElement(By.xpath("//button[@name = 'websubmit']"));
        submit.click();
        Thread.sleep(3000);
        driver.quit();




    }
}

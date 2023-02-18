package SeleniumIntro.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class testCase4 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Navigate to "https://www.saucedemo.com/"
        driver.navigate().to("https://www.saucedemo.com/");

        //Enter username "standard_user"
        WebElement userName = driver.findElement(By.xpath("//input[@id= 'user-name']"));
        userName.sendKeys("standard_user");
        //Enter password "secret_sauce"
        WebElement password = driver.findElement(By.xpath("//input[@id= 'password']"));
        password.sendKeys("secret_sauce");
        //Click Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id= 'login-button']"));
        loginButton.click();

        String link = driver.getCurrentUrl().trim();
        System.out.println(link.equals("https://www.saucedemo.com/inventory.html")?"PASSED":"FAILED");
        Thread.sleep(10000);
        driver.quit();







    }
}

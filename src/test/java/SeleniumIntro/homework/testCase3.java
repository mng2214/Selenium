package SeleniumIntro.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.TableHeaderUI;
import java.time.Duration;

public class testCase3 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Navigate to "https://www.saucedemo.com/"
        driver.navigate().to("https://www.saucedemo.com/");

        //Enter username "Java"
        WebElement userName = driver.findElement(By.xpath("//input[@id= 'user-name']"));
        userName.sendKeys("Java");
        //Enter password "Selenium"
        WebElement password = driver.findElement(By.xpath("//input[@id= 'password']"));
        password.sendKeys("Selenium");
        //Click Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id= 'login-button']"));
        loginButton.click();

        Thread.sleep(2000);

        WebElement loginError = driver.findElement(By.xpath("//h3[@data-test = 'error']"));
        String ValidationLoginError = loginError.getText().trim();
        System.out.println(ValidationLoginError.equals("Epic sadface: Username and password do not match any user in this service")?"PASSED":"FAILED");

    }
}

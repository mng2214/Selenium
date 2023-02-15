package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorPracticeXpath {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); ///!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

        WebElement firstName = driver.findElement(By.xpath("//input[@id = 'input-firstname']"));
        firstName.sendKeys("test1");
        WebElement lastName = driver.findElement(By.xpath("//input[@id = 'input-lastname']"));
        lastName.sendKeys("test2");
        WebElement email = driver.findElement(By.xpath("//input[@id = 'input-email']"));
        email.sendKeys("testas4esdrjkgrasffd@mail.com");
        WebElement telephone = driver.findElement(By.xpath("//input[@id = 'input-telephone']"));
        telephone.sendKeys("2237737373");
        WebElement agree = driver.findElement(By.xpath("//input[@name = 'agree']"));
        agree.click();
        WebElement password = driver.findElement(By.xpath("//input[@id = 'input-password']"));
        password.sendKeys("Ar2tart123");
        WebElement passwordRepeat = driver.findElement(By.xpath("//input[@id = 'input-confirm']"));
        passwordRepeat.sendKeys("Ar2tart123");
        WebElement submit = driver.findElement(By.xpath("//input[@value = 'Continue']"));
        submit.click();
        Thread.sleep(15000);
        driver.close();
        System.out.println("PASSED");











    }
}

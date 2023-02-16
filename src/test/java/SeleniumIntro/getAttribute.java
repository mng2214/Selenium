package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class getAttribute {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //  1-Navigate to the https://katalon-demo-cura.herokuapp.com/

        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement clickAppoimnet = driver.findElement(By.xpath("//a[@id = 'btn-make-appointment']"));

        // 2-Click Make an Appointment

        clickAppoimnet.click();

        // 3-Login the username and password provided and Login successfully

        WebElement login = driver.findElement(By.xpath("//input[@id = 'txt-username']"));
        String name = login.getAttribute("value");
        Thread.sleep(3000);
        driver.navigate().refresh();
        login.sendKeys(name);



//        WebElement loginClick = driver.findElement(By.xpath("//button[@id = 'btn-login' ]"));
//        loginClick.click();






    }


}

package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementsMethods {

    // C:\Users\mng22\Desktop\Techtorial.html
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
//       driver.navigate().to("file:/C:/Users/mng22/Desktop/Tech.html");  //techtorial1

//        List<WebElement> allBoxes = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
//        for (WebElement box : allBoxes){
//            Thread.sleep(1000);
//            if(box.isDisplayed() && !box.isSelected() && box.isEnabled()){
//                box.click();
//            }
//        }

        driver.navigate().to("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");
        List<WebElement> boxes = driver.findElements(By.xpath("//div[@aria-checked = 'false']"));

        for (WebElement box : boxes) {
            Thread.sleep(500);
            WebElement select = driver.findElement(By.xpath("//div[@aria-checked = 'true']"));
            if(!box.isSelected() && box.isDisplayed() && box.isEnabled()){
                box.click();
            }
        }
        Thread.sleep(5000);
        driver.quit();


    }
}

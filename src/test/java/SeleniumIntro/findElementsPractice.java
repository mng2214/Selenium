package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class findElementsPractice {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://the-internet.herokuapp.com/");

        List<WebElement> links = driver.findElements(By.tagName("li"));
        int count1 = 0;
int count2 = 0;
        for (WebElement link: links){
            System.out.println(link.getText());
            count1++;
        }
        System.out.println(count1);
        System.out.println("====================================");

        for (WebElement link : links){
            if(link.getText().length() >= 12){
                System.out.println( link.getText());
                count2 ++;
            }
        }
        System.out.println(count2);

        ///////////////

        System.out.println("\n\n\n\n\n");
        List<WebElement> linksNEW = driver.findElements(By.tagName("a"));

        for (WebElement link: linksNEW) {
            System.out.println(link.getAttribute("href"));
        }





    }

}

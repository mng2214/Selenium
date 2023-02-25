package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.annotation.concurrent.ThreadSafe;
import java.time.Duration;
import java.util.*;

public class HoverOver {
    @Test
    public void validateNamesFromPicture() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/hovers");


        List<WebElement> names = driver.findElements(By.tagName("h5"));
        List<WebElement> images = driver.findElements(By.xpath("//div[@class = 'figure']//img"));

        List<String> actualNames = new ArrayList<>();
        List<String> expectedNames = Arrays.asList("name: user1", "name: user2", "name: user3");

        Actions actions = new Actions(driver);

        for (int i = 0; i < names.size(); i++) {
            Thread.sleep(2000);
            actions.moveToElement(images.get(i)).perform(); // you are hover over
            actualNames.add(BrowserUtils.getText(names.get(i))); //you are storing inside of a list
        }

        System.out.println(actualNames);
        System.out.println(expectedNames);
        Assert.assertEquals(actualNames, expectedNames);

    }

    @Test
    public void practiceMoveToElement() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/fx/expand");
        Thread.sleep(2000);
        WebElement cookie = driver.findElement(By.xpath("//button[@id = 'onetrust-accept-btn-handler']"));
        cookie.click();
        Thread.sleep(2000);

        Actions actions = new Actions(driver);
        List<WebElement> imagesHoverOver = driver.findElements(By.xpath("//div[@class='product k-listview-item']"));
        List<WebElement> names = driver.findElements(By.xpath("//div[@class='product k-listview-item']//h3"));
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='product k-listview-item']//p"));
        Map<String, String> map = new LinkedHashMap<>();
        Thread.sleep(500);

        for (int i = 0; i < imagesHoverOver.size(); i++) {
            actions.moveToElement(imagesHoverOver.get(i)).perform();
            map.put(BrowserUtils.getText(names.get(i)), BrowserUtils.getText(prices.get(i)));
        }

        Thread.sleep(500);
        System.out.println(map);

        Thread.sleep(5000);
        driver.quit();


    }

}

package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class movingSlider {
    @Test
    public void validateSlider() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider = driver.findElement(By.xpath("//input[@type = 'range']"));
        WebElement range = driver.findElement(By.xpath("//span[@id='range']"));

        while (!BrowserUtils.getText(range).equals("3.5")){
            Thread.sleep(500);
            slider.sendKeys(Keys.ARROW_RIGHT);
        }

        Assert.assertEquals(BrowserUtils.getText(range), "3.5");
    }
}

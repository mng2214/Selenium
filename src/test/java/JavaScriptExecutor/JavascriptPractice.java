package JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.text.BreakIterator;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavascriptPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/");

        Thread.sleep(1000);
        WebElement copyRight = driver.findElement(By.xpath("//div[contains(text(), 'Copyright ©')]"));
        BrowserUtils.scrollWithJS(driver,copyRight);
        Thread.sleep(1000);
        String actualCopyRight = BrowserUtils.getText(copyRight);
        String expectedCopyRight = "Copyright © 2023";
        Assert.assertEquals(actualCopyRight,expectedCopyRight);
        Thread.sleep(1000);


        WebElement apply = driver.findElement(By.xpath("//span[@data-magic = 'button-text']//strong[contains(text(),'APPLY NOW')]"));
        BrowserUtils.scrollWithJS(driver,apply);
        Thread.sleep(500);
        BrowserUtils.clickWithJS(driver,apply);
        Thread.sleep(500);

        List<WebElement> elements = driver.findElements(By.xpath("//h3[@data-element-id = 'heading3Normal']"));
        List <String> expectedElements = Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");


        for (int i = 0  ; i < elements.size();i ++ ){
            Assert.assertEquals(BrowserUtils.getText(elements.get(i)),expectedElements.get(i) );
        }
    }
}

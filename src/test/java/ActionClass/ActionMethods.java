package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionMethods {

    @Test // right click of the mouse
    public void ContextClick() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/");

        WebElement contextMenu = driver.findElement(By.xpath("//a[contains(text(),'Context Menu')]"));
        contextMenu.click();

        WebElement box = driver.findElement(By.cssSelector("#hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();

    }



    @Test
    public void ConextClickPractice (){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement clickArea = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
        Actions actions = new Actions(driver);
        actions.contextClick(clickArea).perform();

    }
//double click
    @Test
    public void doubleClick (){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement area = driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me')]"));
        Actions actions = new Actions(driver);
        actions.doubleClick(area).perform();

    }
}

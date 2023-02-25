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

import javax.sql.rowset.BaseRowSet;
import java.time.Duration;

public class practiceActions {
    @Test
    public void validateMessageAndColor() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");
        Thread.sleep(1500);

        WebElement dragMe = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHere = driver.findElement(By.xpath("//div[@class='simple-drop-container']//div[@id = 'droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMe, dropHere).perform();
        Thread.sleep(1500);


        String actualColor = dropHere.getCssValue("background-color");
        String expectedColor = "rgba(70, 130, 180, 1)";
        Thread.sleep(1500);
        Assert.assertEquals(actualColor, expectedColor);

        String actualMessage = BrowserUtils.getText(dropHere);
        String expectedMessage = "Dropped!";
        Assert.assertEquals(actualMessage, expectedMessage);


    }
}

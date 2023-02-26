package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {
    @Test
    public void switchPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/windows");

        WebElement clickButton = driver.findElement(By.linkText("Click Here"));
        clickButton.click();
        Thread.sleep(1000);

        String pageID = driver.getWindowHandle(); //returns page ID of the class
        System.out.println(pageID); // CDwindow-5DAD30916C3B2A65B17CF279718F3415

        Set<String> allPagesID = driver.getWindowHandles();
        System.out.println(allPagesID); // CDwindow-A957C6EF3FCF41DEF93436431A1E0AC0

        for (String id : allPagesID) {
            if (!id.equals(pageID)) {
                driver.switchTo().window(id);
                break;
            }
        }


        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));


    }

    //HOMEWORK WINDOWS SWITCH

    @Test
    public void windowSwitch() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/");
        Thread.sleep(1000);

        WebElement findCourse = driver.findElement(By.xpath("//span[contains(text(), 'Find out which course is for you')]"));
        BrowserUtils.scrollWithJS(driver, findCourse);
        findCourse.click();
        Thread.sleep(1000);
        String idHome = driver.getWindowHandle();
        Set<String> pageIDs = driver.getWindowHandles();
        System.out.println(pageIDs);



        for (String id : pageIDs) {
            if (!id.equals(idHome)) {
                driver.switchTo().window(id);

                break;
            }
        }
        String expectedTitle = "Courses";
        String actualTitle = driver.getTitle().trim();
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println(expectedTitle);
        System.out.println(actualTitle);

    }
}

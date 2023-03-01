package WindowHandle;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class SwitchMultipleWindows {
    @Test
    public void multipleWindowsPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");

        // BrowserUtils.switchByID(driver);  didnt work

        BrowserUtils.switchByTitle(driver, "Contact us");
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver, "Home");
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver, "Courses");

        //driver.quit();
    }


    @Test
    public void task2() throws InterruptedException {
                /*
1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
2-Click open multiple tabs under Button 4
3-the Basic Control and fill all the blanks
4-Click Register button and validate the message "Registration is Successful"
5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
6- go to the alertsDemo page and click  the "Click Me" button under prompt box
7-quit all the pages.
8-Proud of yourself
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");


        Thread.sleep(2000);


        WebElement button4 = driver.findElement(By.xpath("//button[@id = 'newTabsBtn']"));
        BrowserUtils.scrollWithJS(driver, button4);
        button4.click();
        Thread.sleep(1000);
        BrowserUtils.switchByTitle(driver, "Basic Controls");
        Thread.sleep(1000);

        WebElement firstName = driver.findElement(By.cssSelector("#firstName"));
        firstName.sendKeys("artur");
        Thread.sleep(200);

        WebElement lastName = driver.findElement(By.cssSelector("#lastName"));
        lastName.sendKeys("artur");
        Thread.sleep(200);

        WebElement gender = driver.findElement(By.cssSelector("#malerb"));
        if (!gender.isSelected() && gender.isDisplayed() && gender.isEnabled()) {
            gender.click();
        }
        Thread.sleep(200);
        WebElement english = driver.findElement(By.xpath("//input[@id='englishchbx']"));
        english.click();
        Thread.sleep(200);

        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("artur@gramil.com");
        Thread.sleep(200);

        WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
        pass.sendKeys("artur123");
        Thread.sleep(200);

        WebElement registration = driver.findElement(By.cssSelector("#registerbtn"));
        BrowserUtils.clickWithJS(driver, registration);
        Thread.sleep(1000);

        WebElement validation = driver.findElement(By.xpath("//label[contains(text(),'Registration is Successful')]"));
        String actual = BrowserUtils.getText(validation);
        String expected = "Registration is Successful";
        Assert.assertEquals(actual, expected);
        Thread.sleep(1000);

        BrowserUtils.switchByTitle(driver, "Window Handles Practice");
        Thread.sleep(1000);
        WebElement title = driver.findElement(By.xpath("//h1[contains(text(),'Window Handles Practice')]"));

        String actual2 = BrowserUtils.getText(title);
        String expected2 = "Window Handles Practice";
        Assert.assertEquals(actual2, expected2);

        BrowserUtils.switchByTitle(driver, "AlertsDemo");
        WebElement click = driver.findElement(By.cssSelector("#alertBox"));
        click.click();
        Thread.sleep(1000);
        driver.quit();


    }
}

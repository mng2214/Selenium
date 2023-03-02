package FrameAndiFrame;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.swing.plaf.TableHeaderUI;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FramePRactice2 {
    @Test
    public void practiceFrame() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");

        WebElement pav = driver.findElement(By.xpath("//a[contains(text(),'Pavilion')]"));
        pav.click();
        Thread.sleep(500);

        BrowserUtils.switchByTitle(driver, "Home - qavalidation");
        Thread.sleep(500);

        Actions actions = new Actions(driver);
        WebElement seleniumSelection = driver.findElement(By.xpath("//ul[@id ='primary-menu']//span[.='Selenium']"));
        actions.moveToElement(seleniumSelection).perform();

        Thread.sleep(500);
        WebElement seleniumJava = driver.findElement(By.xpath("//ul[@id ='primary-menu']//span[.='Selenium-Java']"));
        actions.click(seleniumJava).perform();
        Thread.sleep(500);

        List<WebElement> listWebElements = driver.findElements(By.xpath("//ul[@class = 'ht_toc_list']//li"));
        for (WebElement item : listWebElements) {
            System.out.println(BrowserUtils.getText(item));
        }
        System.out.println("\n\n\n-----------------------------");

        Thread.sleep(500);

        //----------------------------------------------------------------
        BrowserUtils.switchByTitle(driver, "iframes");
        Thread.sleep(500);
        WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='Frame1']"));
        driver.switchTo().frame(frame1);

        WebElement category1 = driver.findElement(By.xpath("//a[contains(text(),'Category1')]"));
        category1.click();
        Thread.sleep(500);

        BrowserUtils.switchByTitle(driver,"SeleniumTesting Archives - qavalidation");
        Thread.sleep(500);

        WebElement title = driver.findElement(By.tagName("h1"));
        String actual = BrowserUtils.getText(title);
        String expected = "Category Archives: SeleniumTesting";
        Assert.assertEquals(actual,expected);
        Thread.sleep(500);

        List<WebElement> titles = driver.findElements(By.xpath("//h3//a"));
        for (WebElement title1 : titles) {
            System.out.println(BrowserUtils.getText(title1));
        }
        Thread.sleep(1500);
        //driver.quit();

        BrowserUtils.switchByTitle(driver, "iframes");
        Thread.sleep(500);
        WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='Frame2']"));
        driver.switchTo().frame(frame3);
        Thread.sleep(500);
        WebElement category3 = driver.findElement(By.xpath("//a[contains(text(),'Category3')]"));
        category3.click();
        Thread.sleep(500);

        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives - qavalidation");

        String actualName = driver.getTitle().trim();
        String expectedName = "SoftwareTesting Archives - qavalidation";
        Assert.assertEquals(actualName,expectedName);

    }


}

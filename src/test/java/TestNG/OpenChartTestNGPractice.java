package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class OpenChartTestNGPractice {

    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.xpath("//input[@id = 'input-username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'input-password']"));
        password.sendKeys("demo");
        WebElement submit = driver.findElement(By.xpath("//button[@type = 'submit']"));
        submit.click();
        Thread.sleep(2000);
        String actual = driver.getTitle().trim();
        String expected = "Dashboard";
        Assert.assertEquals(actual, expected);
        driver.quit();


    }

    @Test
    public void negativeLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.xpath("//input[@id = 'input-username']"));
        userName.sendKeys("test");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'input-password']"));
        password.sendKeys("test");
        WebElement submit = driver.findElement(By.xpath("//button[@type = 'submit']"));
        submit.click();
        Thread.sleep(500);

        WebElement errorLogging = driver.findElement(By.xpath("//div[@id = 'alert']"));
        String actual = errorLogging.getText().trim();
        String expected = "No match for Username and/or Password.";

        // Assert.assertFalse(false,expected);
        //OR
        Assert.assertEquals(expected, actual);
        Thread.sleep(3000);
        driver.quit();

    }

    @Test
    public void productsValidation() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.xpath("//input[@id = 'input-username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'input-password']"));
        password.sendKeys("demo");
        WebElement submit = driver.findElement(By.xpath("//button[@type = 'submit']"));
        submit.click();
        Thread.sleep(2000);
        WebElement closeWindow = driver.findElement(By.xpath("//button[@class = 'btn-close']"));
        closeWindow.click();
        Thread.sleep(1000);
        WebElement openCatalog = driver.findElement(By.xpath("//li[@id = 'menu-catalog']"));
        openCatalog.click();
        Thread.sleep(1000);
        WebElement products = driver.findElement(By.xpath("//a[contains(text(), 'Products')]"));
        Assert.assertTrue(products.isDisplayed());
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void ValidateBoxesFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.xpath("//input[@id = 'input-username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'input-password']"));
        password.sendKeys("demo");
        WebElement submit = driver.findElement(By.xpath("//button[@type = 'submit']"));
        submit.click();
        Thread.sleep(1000);
        WebElement closeWindow = driver.findElement(By.xpath("//button[@class = 'btn-close']"));
        closeWindow.click();
        Thread.sleep(500);
        WebElement openCatalog = driver.findElement(By.xpath("//li[@id = 'menu-catalog']"));
        openCatalog.click();
        Thread.sleep(500);
        WebElement productsClick = driver.findElement(By.xpath("//a[contains(text(), 'Products')]"));
        productsClick.click();
        Thread.sleep(500);

        List<WebElement> boxes = driver.findElements(By.xpath("//input[@type = 'checkbox']"));

        for (int i = 1; i < boxes.size(); i++) {
            Assert.assertTrue(boxes.get(i).isDisplayed());
            Assert.assertTrue(boxes.get(i).isEnabled());
            Assert.assertFalse(boxes.get(i).isSelected());
            boxes.get(i).click();
            Assert.assertTrue(boxes.get(i).isSelected());
            boxes.get(i).sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(60);
        }
        Thread.sleep(1000);
        driver.quit();
    }


    @Test
    public void reverseProductNames () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.xpath("//input[@id = 'input-username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'input-password']"));
        password.sendKeys("demo");
        WebElement submit = driver.findElement(By.xpath("//button[@type = 'submit']"));
        submit.click();
        Thread.sleep(1000);
        WebElement closeWindow = driver.findElement(By.xpath("//button[@class = 'btn-close']"));
        closeWindow.click();
        Thread.sleep(500);
        WebElement openCatalog = driver.findElement(By.xpath("//li[@id = 'menu-catalog']"));
        openCatalog.click();
        Thread.sleep(500);
        WebElement productsClick = driver.findElement(By.xpath("//a[contains(text(), 'Products')]"));
        productsClick.click();
        Thread.sleep(500);

        WebElement productNameButton = driver.findElement(By.cssSelector(".asc"));
        productNameButton.click();
        Thread.sleep(1000);

        List <String> actualNames  = new ArrayList<>();
        List <String> expectedNames = new ArrayList<>();

        List <WebElement> productNames = driver.findElements(By.xpath("//td[@class= 'text-start']"));

        for (int i = 1 ; i < productNames.size(); i++){

            actualNames.add(productNames.get(i).getText().toLowerCase().trim());
            expectedNames.add(productNames.get(i).getText().toLowerCase().trim());
        }
        Thread.sleep(1000);
        Collections.sort(expectedNames); // sorting fo asceding
        Collections.reverse(expectedNames); //making garantee
        System.out.println(expectedNames);
        System.out.println(actualNames);



        Assert.assertEquals(actualNames, expectedNames);
        driver.quit();
    }

    @Test
    public void validateProductNameFunc () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.xpath("//input[@id = 'input-username']"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'input-password']"));
        password.sendKeys("demo");
        WebElement submit = driver.findElement(By.xpath("//button[@type = 'submit']"));
        submit.click();
        Thread.sleep(1000);
        WebElement closeWindow = driver.findElement(By.xpath("//button[@class = 'btn-close']"));
        closeWindow.click();
        Thread.sleep(500);
        WebElement openCatalog = driver.findElement(By.xpath("//li[@id = 'menu-catalog']"));
        openCatalog.click();
        Thread.sleep(500);
        WebElement productsClick = driver.findElement(By.xpath("//a[contains(text(), 'Products')]"));
        productsClick.click();
        Thread.sleep(500);

        List <WebElement> productNames = driver.findElements(By.xpath("//td[@class= 'text-start']"));
        List <String> actualNames  = new ArrayList<>();
        List <String> expectedNames = new ArrayList<>();

        for ( int i = 1 ; i < productNames.size(); i ++ ){
            actualNames.add(productNames.get(i).getText().trim().toLowerCase());
            expectedNames.add(productNames.get(i).getText().trim().toLowerCase());
        }

        Collections.sort(expectedNames);
        Assert.assertEquals(expectedNames,actualNames);
        System.out.println(expectedNames);
        System.out.println("\n\n\n");
        System.out.println(actualNames);
        Thread.sleep(3000);
        driver.quit();

    }


}

package homework.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class hm3 {
    @Test(priority = 1)
    public void testcase2and2and3() throws InterruptedException {
        System.out.println("-------------TEST CASE 2.1 --------------");
        //Navigate to the "http://uitestpractice.com/Students/Index"

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://uitestpractice.com/Students/Index");
        Thread.sleep(1000);
        Actions actions = new Actions(driver);


        //Click "Create New" button

        driver.findElement(By.xpath("//a[contains(text(),'Create New')]")).click();
        Thread.sleep(1000);

        //
//        try {
//            driver.switchTo().frame("aswift_2");
//            driver.switchTo().frame("ad_iframe");
//            WebElement close = driver.findElement(By.xpath("//div[@id='dismiss-button']"));
//            close.click();
//            driver.switchTo().parentFrame();
//        } catch (Exception p) {
//            p.getMessage();
//        }

        //

//        driver.switchTo().frame("aswift_2");
//        driver.switchTo().frame("ad_iframe");
//        WebElement close = driver.findElement(By.xpath("//div[@id='dismiss-button']"));
//        close.click();
//        driver.switchTo().parentFrame();

//        Enter any firstname, lastname and enrollment date

        WebElement firstName = driver.findElement(By.cssSelector("#FirstName"));
        firstName.sendKeys("artur");

        WebElement LastName = driver.findElement(By.cssSelector("#LastName"));
        LastName.sendKeys("mng");

        WebElement EnrollmentDate = driver.findElement(By.cssSelector("#EnrollmentDate"));
        EnrollmentDate.sendKeys("3/2/23");

        //Click create button

        driver.findElement(By.xpath("//input[@value='Create']")).click();

        //Search firstname in search bar

        WebElement search = driver.findElement(By.cssSelector("#Search_Data"));
        search.sendKeys("artur");
        driver.findElement(By.xpath("//input[@value='Find']")).click();

        //Validate the new information is created

        WebElement firstNameValidation = driver.findElement(By.xpath("//tr//td[1]"));
        WebElement lastNameValidation = driver.findElement(By.xpath("//tr//td[2]"));
        String expectedFirstName = "artur", expectedLastName = "mng";

        Assert.assertEquals(BrowserUtils.getText(firstNameValidation), expectedFirstName);
        Assert.assertEquals(BrowserUtils.getText(lastNameValidation), expectedLastName);


//----------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("-------------TEST CASE 2.2 --------------");

        //Search your Lastname in search bar

        WebElement searchData = driver.findElement(By.cssSelector("#Search_Data"));
        searchData.clear();
        searchData.sendKeys("mng");
        driver.findElement(By.xpath("//input[@value='Find']")).sendKeys(Keys.ENTER);

        //Click Edit button

        driver.findElement(By.xpath("//tr[2]//button[1]")).click();   //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Is it reliable way to find this element?

        //Change first name

        firstName = driver.findElement(By.cssSelector("#FirstName"));
        firstName.clear();
        firstName.sendKeys("ARTUR222");

        //Click save button

        driver.findElement(By.xpath("//input[@value='Save']")).click();

        //Search with new firstname

        BrowserUtils.switchByTitle(driver, "Testing Controls - UI Automation Demo Site");
        searchData = driver.findElement(By.cssSelector("#Search_Data"));
        searchData.sendKeys("ARTUR222");
        driver.findElement(By.xpath("//input[@value='Find']")).sendKeys(Keys.ENTER);

        //Validate Firstname is changed

        WebElement fistNameValid = driver.findElement(By.xpath("//tr[2]//td[1]"));
        expectedFirstName = "ARTUR222";
        Assert.assertEquals(BrowserUtils.getText(fistNameValid), expectedFirstName);
        Thread.sleep(1500);


        //---------------------------------------------------------------------------------------------------------------------------
        System.out.println("-------------TEST CASE 3 --------------");
        //Search any Lastname in search bar

        search = driver.findElement(By.cssSelector("#Search_Data"));
        search.clear();
        search.sendKeys("mng");
        driver.findElement(By.xpath("//input[@value='Find']")).sendKeys(Keys.ENTER);

        //Click delete button

        driver.findElement(By.xpath("//tr[2]//button[3]")).click();

        //Confirm delete function

        driver.findElement(By.xpath("//input[@value='Delete']")).click();

        //Search with same lastname

        search = driver.findElement(By.cssSelector("#Search_Data"));
        search.sendKeys("mng");
        driver.findElement(By.xpath("//input[@value='Find']")).sendKeys(Keys.ENTER);
        Thread.sleep(500);

        //Validate "There are zero students with this search text Page 0 of 0 after deleting the user

        WebElement validationLastName = driver.findElement(By.xpath("//div[@class='container body-content']"));
        String expected = "There are zero students with this search text Page 0 of 0";
        Assert.assertTrue(BrowserUtils.getText(validationLastName).contains(expected));
        Thread.sleep(1500);
        driver.quit();

    }


    @Test
    public void testcase4() throws InterruptedException {
        System.out.println("-------------TEST CASE 4 --------------");
        //Navigate to the "http://uitestpractice.com/"

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://uitestpractice.com/");
        Actions actions = new Actions(driver);


        //Move small box into the Drop Here box


        WebElement draggable = driver.findElement(By.cssSelector("#draggable"));
        WebElement droppable = driver.findElement(By.cssSelector("#droppable"));
        actions.clickAndHold(draggable).moveToElement(droppable).release().perform();

        //Validate text "Dropped" displayed

        String expectedDropped = "Dropped!";
        Assert.assertEquals(BrowserUtils.getText(droppable), expectedDropped);
        System.out.println(BrowserUtils.getText(droppable));
        Thread.sleep(1500);
        driver.quit();
    }

    @Test
    public void testcase5() throws InterruptedException {
        System.out.println("-------------TEST CASE 5 --------------");

        //Navigate to the "http://uitestpractice.com/"

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://uitestpractice.com/");
        Actions actions = new Actions(driver);

        WebElement dblClick = driver.findElement(By.xpath("//button[@name='dblClick']"));
        actions.doubleClick(dblClick).perform();

        //Validate Alert has "Double Clicked !!" text

        Thread.sleep(2000);
        Assert.assertEquals(driver.switchTo().alert().getText().trim(), "Double Clicked !!");
        Thread.sleep(2000);

        //Click Okay button to close the alert

        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void testcase6() throws InterruptedException {
        System.out.println("-------------TEST CASE 6 --------------");
        //Navigate to the "http://uitestpractice.com/"

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://uitestpractice.com/");
        Actions actions = new Actions(driver);

        //Enter your name inside the iframe

        WebElement iframe1 = driver.findElement(By.xpath("//iframe[@name='iframe_a']"));
        driver.switchTo().frame(iframe1);


        //Enter your name inside the iframe


        WebElement name = driver.findElement(By.cssSelector("#name"));
        name.sendKeys("artur");
        driver.switchTo().parentFrame();

        //Click the link inside the Iframe box

        driver.findElement(By.xpath("//a[@target='iframe_a']")).click();

        //Validate "www.uitestpractice.com refused to connect." is displayed

        Thread.sleep(1000);
        driver.switchTo().frame(iframe1);
        WebElement move = driver.findElement(By.xpath("//div[@id='sub-frame-error']"));
        actions.moveToElement(move).perform();

        WebElement validateLink = driver.findElement(By.xpath("//div[@id = 'sub-frame-error-details']"));
        Assert.assertEquals(BrowserUtils.getText(validateLink), "www.uitestpractice.com refused to connect.");

        Thread.sleep(1500);
        driver.quit();
    }

    @Test
    public void testcase7() throws InterruptedException {
        System.out.println("-------------TEST CASE 7 --------------");
        //Navigate to the "http://uitestpractice.com/"

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://uitestpractice.com/");
        Actions actions = new Actions(driver);

        //Click on the below button to open link in new Window
        driver.findElement(By.xpath("//a[contains(text(),'Click here to watch videos on C#')]")).click();

        //Validate Title contains "C# Beginner to advanced" text

        Thread.sleep(1000);
        BrowserUtils.switchByTitle(driver, "C# Beginner to advanced");
        Assert.assertTrue(driver.getTitle().trim().contains("C# Beginner to advanced"));

        //Validate the link has youtube text in new window

        Assert.assertTrue(driver.getCurrentUrl().contains("youtube"));
        Thread.sleep(1000);
        driver.quit();

    }

}

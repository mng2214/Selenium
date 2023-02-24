package homework.homework2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class homework2 {

    @Test          //Test Case 1   << -------------------
    public void testCase1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Navigate to
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        //Validate the title is equals to "Web Orders Login"
        String actualTitleLoginPage = driver.getTitle().trim();
        String expectedTitleLoginPage = "Web Orders Login";
        Assert.assertEquals(actualTitleLoginPage, expectedTitleLoginPage);
        //Input username "Tester"
        WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");
        //Input password "test"
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        //Click login button
        password.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        //Validate the title is equals to "Web Orders"
        String actualTitleHomePage = driver.getTitle().trim();
        String expectedTitleHomePage = "Web Orders";
        Assert.assertEquals(actualTitleHomePage, expectedTitleHomePage);
        //Validate header is equals to "List of All Orders"
        WebElement header = driver.findElement(By.xpath("//h2"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "List of All Orders";
        Assert.assertEquals(actualHeader, expectedHeader);

        Thread.sleep(2000);
        driver.quit();
    }


    @Test          //Test Case 2   << -------------------
    public void testCase2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Navigate to
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        //Validate the title is equals to "Web Orders Login"
        String actualTitleLoginPage = driver.getTitle().trim();
        String expectedTitleLoginPage = "Web Orders Login";
        Assert.assertEquals(actualTitleLoginPage, expectedTitleLoginPage);
        //Input username "Tester"
        WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");
        //Input password "test"
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        //Click login button
        password.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        //Click "View all products" button
        List<WebElement> boxes = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
        for (WebElement box : boxes) {
            Assert.assertTrue((box.isDisplayed() && box.isDisplayed() && !box.isSelected()));
            box.click();
            Thread.sleep(100);
        }
        //Validate "View all products" is selected
        for (WebElement box : boxes) {
            Assert.assertTrue(box.isSelected());
        }
        //Validate header is equals to "List of Products"
        WebElement header = driver.findElement(By.xpath("//a[.='View all orders']"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "View all orders";
        Assert.assertEquals(actualHeader, expectedHeader);
        //Validate the url has "Products" keyword
        WebElement urlForProducts = driver.findElement(By.xpath("//a[.='View all products']"));
        String urlActual = urlForProducts.getAttribute("href").trim();
        String containsProducts = "Products";
        Assert.assertTrue(urlActual.contains(containsProducts));

        Thread.sleep(2000);
        driver.quit();
    }

    @Test          //Test Case 3  << -------------------
    public void testCase3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Navigate to
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        //Validate the title is equals to "Web Orders Login"
        String actualTitleLoginPage = driver.getTitle().trim();
        String expectedTitleLoginPage = "Web Orders Login";
        Assert.assertEquals(actualTitleLoginPage, expectedTitleLoginPage);
        //Input username "Tester"
        WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");
        //Input password "test"
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        //Click login button
        password.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        WebElement viewAllOrders = driver.findElement(By.xpath("//a[.='View all orders']"));
        String viewAllOrdersStr = viewAllOrders.getAttribute("href").trim();
        String expectedViewOrders = "Default.aspx";
        Assert.assertTrue(viewAllOrdersStr.contains("Default.aspx"), expectedViewOrders);

        WebElement viewAllProducts = driver.findElement(By.xpath("//a[.='View all products']"));
        String viewAllProductsStr = viewAllProducts.getAttribute("href").trim();
        String expectedProducts = "Products.aspx";
        Assert.assertTrue(viewAllProductsStr.contains("Products.aspx"), expectedProducts);

        WebElement order = driver.findElement(By.xpath("//a[.='Order']"));
        String orderStr = order.getAttribute("href").trim();
        String expectedOrders = "Process.aspx";
        Assert.assertTrue(orderStr.contains("Process.aspx"), expectedOrders);

        Thread.sleep(2000);
        driver.quit();
    }


    @Test          //Test Case 4  << -------------------
    public void testCase4() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Navigate to
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        //Validate the title is equals to "Web Orders Login"
        String actualTitleLoginPage = driver.getTitle().trim();
        String expectedTitleLoginPage = "Web Orders Login";
        Assert.assertEquals(actualTitleLoginPage, expectedTitleLoginPage);
        //Input username "Tester"
        WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");
        //Input password "test"
        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        //Click login button
        password.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        //Click "Order" button
        WebElement order = driver.findElement(By.xpath("//a[.='Order']"));
        order.click();
        Thread.sleep(100);
        //Select product "Screen Saver"
        WebElement product = driver.findElement(By.xpath("//option[@value = 'ScreenSaver']"));
        product.click();
        Thread.sleep(100);
        //Input quantity 5
        WebElement quantity = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        Thread.sleep(100);
        quantity.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(100);
        quantity.sendKeys("5");
        Thread.sleep(100);
        //Input Customer name "CodeFish IT School"
        WebElement customerName = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        customerName.sendKeys("CodeFish IT School");
        Thread.sleep(100);
        //Input Street "2200 E devon"
        WebElement street = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys("2200 E devon");
        Thread.sleep(100);
        //Input City "Des Plaines"
        WebElement city = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys("Des Plaines");
        Thread.sleep(100);
        //Input State "Illinois"
        WebElement state = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys("Illinois");
        Thread.sleep(100);
        //Input Zip "60018"
        WebElement zip = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        zip.sendKeys("60018");
        Thread.sleep(100);
        //Select MasterCard
        WebElement mastercard = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_1"));
        mastercard.click();
        Thread.sleep(100);
        //Input card number "444993876233"
        WebElement cardNumber = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumber.sendKeys("444993876233");
        Thread.sleep(100);
        //Input expiration date "03/24"
        WebElement cardExp = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        cardExp.sendKeys("03/24");
        Thread.sleep(100);
        //Click Process button
        WebElement process = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_InsertButton"));
        process.click();
        Thread.sleep(100);
        //Validate text "New order has been successfully added." is displayed below the Process button.
        WebElement confirmation = driver.findElement(By.tagName("strong"));
        String actualConfirmation = confirmation.getText().trim();
        String expectedConfirmation = "New order has been successfully added.";
        Assert.assertEquals(actualConfirmation, expectedConfirmation);
        //Click View all orders button
        WebElement viewAllOrders = driver.findElement(By.xpath("//a[contains(text(), 'View all orders')]"));
        viewAllOrders.click();
        Thread.sleep(100);
        //Validate new order is added and all inputs are matching with new order

        List<WebElement> listCheckOut = driver.findElements(By.xpath("//tr[2]//td"));
        List<String> listCheckOutActual = new ArrayList<>();
        for (int i = 1; i < listCheckOut.size() - 1; i++) {
            listCheckOutActual.add(listCheckOut.get(i).getText().trim());
        }

        List<String> listCheckShopping = Arrays.asList("CodeFish IT School", "ScreenSaver", "5", "02/24/2023", "2200 E devon", "Des Plaines", "Illinois", "60018", "MasterCard", "444993876233", "03/24");
        Collections.sort(listCheckShopping);
        Collections.sort(listCheckOutActual);
//        System.out.println(listCheckShopping);
//        System.out.println(listCheckOutActual);

        Thread.sleep(3000);
        for (int i = 0; i < listCheckShopping.size(); i++) {
            Assert.assertEquals(listCheckOutActual.get(i), listCheckShopping.get(i));
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
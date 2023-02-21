package SeleniumIntro.homework.homework2;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
        String viewAllOrdersStr = viewAllOrders.getAttribute("href").trim().substring(viewAllOrders.getAttribute("href").lastIndexOf("/") + 1);
        String expectedViewOrders = "Default.aspx";
        Assert.assertEquals(expectedViewOrders, viewAllOrdersStr);

        WebElement viewAllProducts = driver.findElement(By.xpath("//a[.='View all products']"));
        String viewAllProductsStr = viewAllProducts.getAttribute("href").trim().substring(viewAllProducts.getAttribute("href").lastIndexOf("/") + 1);
        ;
        String expectedProducts = "Products.aspx";
        Assert.assertEquals(expectedProducts, viewAllProductsStr);

        WebElement order = driver.findElement(By.xpath("//a[.='Order']"));
        String orderStr = order.getAttribute("href").trim().substring(order.getAttribute("href").lastIndexOf("/") + 1);
        ;
        ;
        String expectedOrders = "Process.aspx";
        Assert.assertEquals(expectedOrders, orderStr);

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
        Assert.assertEquals(actualConfirmation,expectedConfirmation);
        //Click View all orders button
        WebElement viewAllOrders = driver.findElement(By.xpath("//a[contains(text(), 'View all orders')]"));
        viewAllOrders.click();
        Thread.sleep(100);
        //Validate new order is added and all inputs are matching with new order
        WebElement nameOrders = driver.findElement(By.xpath("//td[contains(text(), 'CodeFish IT School')]"));
        WebElement productOrders = driver.findElement(By.xpath("//td[contains(text(), 'ScreenSaver')]"));
        WebElement amountOrders = driver.findElement(By.xpath("//td[contains(text(), '5')]"));
        WebElement dateOrders = driver.findElement(By.xpath("//td[contains(text(), '02/21/2023')]"));
        WebElement streetOrders = driver.findElement(By.xpath("//td[contains(text(), '2200 E devon')]"));
        WebElement cityOrders = driver.findElement(By.xpath("//td[contains(text(), 'Des Plaines')]"));
        WebElement stateOrders = driver.findElement(By.xpath("//td[contains(text(), 'Illinois')]"));
        WebElement zipOrders = driver.findElement(By.xpath("//td[contains(text(), '60018')]"));
        WebElement cardTypeOrders = driver.findElement(By.xpath("//td[contains(text(), 'MasterCard')]"));
        WebElement cardNumOrders = driver.findElement(By.xpath("//td[contains(text(), '444993876233')]"));
        WebElement cardExpOrders = driver.findElement(By.xpath("//td[contains(text(), '03/24')]"));

        List <String> listCheckOut = new ArrayList<>();  // list of the items on check view all orders page

        listCheckOut.add(nameOrders.getText());
        listCheckOut.add(productOrders.getText());
        listCheckOut.add(amountOrders.getText());
        listCheckOut.add(dateOrders.getText());
        listCheckOut.add(streetOrders.getText());
        listCheckOut.add(cityOrders.getText());
        listCheckOut.add(stateOrders.getText());
        listCheckOut.add(zipOrders.getText());
        listCheckOut.add(cardTypeOrders.getText());
        listCheckOut.add(cardNumOrders.getText());
        listCheckOut.add(cardExpOrders.getText());

        List <String> listCheckShopping = new ArrayList<>();

        listCheckShopping.add("CodeFish IT School");  // list of the items provided
        listCheckShopping.add("Screen Saver");
        listCheckShopping.add("5");
        listCheckShopping.add("02/21/2023");
        listCheckShopping.add("2200 E devon");
        listCheckShopping.add("Des Plaines");
        listCheckShopping.add("Illinois");
        listCheckShopping.add("60018");
        listCheckShopping.add("MasterCard");
        listCheckShopping.add("444993876233");
        listCheckShopping.add("03/24");

        for (int i = 0; i < listCheckOut.size() ||i < listCheckShopping.size(); i ++){
            Assert.assertEquals(listCheckOut.get(i), listCheckShopping.get(i) );
            System.out.println(true);
        }








        Thread.sleep(2000);
       driver.quit();
    }
}
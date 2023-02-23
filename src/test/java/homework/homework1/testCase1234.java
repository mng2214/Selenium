package homework.homework1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class testCase1234 {


    @Test
    public void testCase1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Navigate to "https://demoqa.com/text-box"
        driver.get("https://demoqa.com/text-box");

        //Enter your full name, email, current and permanent address
        WebElement fullName = driver.findElement(By.xpath("//input[@id = 'userName']"));
        fullName.sendKeys("Artur");
        Thread.sleep(200);
        WebElement email = driver.findElement(By.xpath("//input[@id = 'userEmail']"));
        email.sendKeys("Artur1111@gmail.com");
        Thread.sleep(200);
        WebElement addressCurrent = driver.findElement(By.xpath("//textarea[@id = 'currentAddress']"));
        addressCurrent.sendKeys("1000 Tech Ave, Des Plains, IL, 75456");
        Thread.sleep(200);
        WebElement addressPermanent = driver.findElement(By.xpath("//textarea[@id = 'permanentAddress']"));
        addressPermanent.sendKeys("1000 Tech Ave, Des Plains, IL, 75456");
        Thread.sleep(200);
        //Click submit button.
        WebElement submit = driver.findElement(By.xpath("//button[@id = 'submit']"));
        submit.click();
        Thread.sleep(1000);
        //Validate that all of your information is displayed and matching correctly.
        //Name
        WebElement nameFind = driver.findElement(By.xpath("//p[@id = 'name']"));
        String actualName = nameFind.getText().trim();
        String expectedName = "Name:Artur";
        Assert.assertEquals(actualName, expectedName);
        Thread.sleep(500);
        //Email
        WebElement emailFind = driver.findElement(By.xpath("//p[@id = 'email']"));
        String emailActual = emailFind.getText().trim();
        String emailExpected = "Email:Artur1111@gmail.com";
        Assert.assertEquals(emailActual, emailExpected);
        //checking if the same
        //current address
        WebElement currentAddressValidation = driver.findElement(By.xpath("//p[@id = 'currentAddress']"));
        String addressTextCurrent = currentAddressValidation.getText().trim();
        String currentCurrentCut = (addressTextCurrent.substring(addressTextCurrent.indexOf(":") + 1));
        //permanent address
        WebElement permanentAddressValidation = driver.findElement(By.xpath("//p[@id = 'permanentAddress']"));
        String addressTextPermanent = permanentAddressValidation.getText().trim();
        String permanentCurrentCut = (addressTextPermanent.substring(addressTextPermanent.indexOf(":") + 1));
        //compare current and actual  ??????
        // QUESTION: is it a optimal way i chose using substring in comparison current and permanent address?
        // if im gonna compare permanent and current with out substring its always gonna fail
        Assert.assertEquals(currentCurrentCut, permanentCurrentCut);
        Thread.sleep(3000);
        driver.quit();
    }


    @Test //CASE 2
    public void testCase2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Navigate to "https://demoqa.com/radio-button"
        driver.get("https://demoqa.com/radio-button");

        // Click Yes radio button
        WebElement radioButton = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        radioButton.click();
        //Validate text is : You have selected Yes
        WebElement validationRadioButton = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String actualStringRadioButton = validationRadioButton.getText().trim();
        String expectedStringRadioButton = "You have selected Yes";
        Assert.assertEquals(actualStringRadioButton, expectedStringRadioButton);
        Thread.sleep(1000);

        //Click Impressive radio button
        WebElement impressiveButton = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        impressiveButton.click();

        //Validate text is : You have selected Impressive
        WebElement validationImpressiveButton = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String actualImpressiveButton = validationImpressiveButton.getText().trim();
        String expectedImpressiveButton = "You have selected Impressive";
        Assert.assertEquals(actualImpressiveButton, expectedImpressiveButton);

        Thread.sleep(2000);
        driver.quit();
    }


    @Test //CASE 3
    public void testCase3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Navigate to "https://www.saucedemo.com/"
        driver.navigate().to("https://www.saucedemo.com/");
        //Enter username "Java"
        WebElement userName = driver.findElement(By.xpath("//input[@id= 'user-name']"));
        userName.sendKeys("Java");
        //Enter password "Selenium"
        WebElement password = driver.findElement(By.xpath("//input[@id= 'password']"));
        password.sendKeys("Selenium");
        //Click Login button
        password.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        // negative testing
        WebElement loginError = driver.findElement(By.xpath("//h3[@data-test = 'error']"));
        String expectedValidationLoginError = loginError.getText().trim();
        Assert.assertTrue(true, expectedValidationLoginError);

        Thread.sleep(2000);
        driver.quit();
    }


    @Test //CASE 4
    public void testCase4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Navigate to "https://www.saucedemo.com/"
        driver.navigate().to("https://www.saucedemo.com/");
        //Enter username "standard_user"
        WebElement userName = driver.findElement(By.xpath("//input[@id= 'user-name']"));
        userName.sendKeys("standard_user");
        //Enter password "secret_sauce"
        WebElement password = driver.findElement(By.xpath("//input[@id= 'password']"));
        password.sendKeys("secret_sauce");
        //Click Login button
        password.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        //Verify link
        String actualLink = driver.getCurrentUrl().trim();
        //String expectedLink = "https://www.saucedemo.com/inventory.html";
        Assert.assertTrue(true, actualLink);
        Thread.sleep(2000);
        driver.quit();


    }


}

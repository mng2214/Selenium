package SeleniumLocators;

import io.netty.buffer.ByteBufProcessor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class LocatorsIntro {
    /*
    ID LOCATOR
     */
    /////////

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///C:/Users/mng22/OneDrive/Desktop/Techtorialhtml.html");  //techtorial1
        WebElement header = driver.findElement(By.id("techtorial1"));
        String actualHeader = header.getText().trim(); //Techtorial Academy
        String expectedHeader = "Techtorial Academy";

        System.out.println(actualHeader);
        System.out.println(actualHeader.equals(expectedHeader) ? "PASSED" : "FAILED");

        WebElement paragraph = driver.findElement(By.id("details2"));
        String textPrint = paragraph.getText().trim();
        System.out.println(textPrint);


        // NAME LOCATOR
//hdsgsdgf
        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Artur");


        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Arturovich");
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("7739499898");
        WebElement email = driver.findElement(By.name("userName"));
        email.sendKeys("artur@gmail.com");
        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("6622 W Diversey");
        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Chicago");
        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("IL");
        WebElement postalCode = driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("60707");

//CLASS LOCATOR
        WebElement checkboxesLabel = driver.findElement(By.className("checkboxes"));
        System.out.println(checkboxesLabel.getText());

        WebElement javaBox = driver.findElement(By.id("cond1"));
        if (javaBox.isDisplayed() && !javaBox.isSelected()) {
            javaBox.click();
        }

        WebElement seleniumBox = driver.findElement(By.id("cond2"));
        if (seleniumBox.isDisplayed() && !seleniumBox.isSelected()) {
            seleniumBox.click();
        }

        WebElement testNGBox = driver.findElement(By.id("cond3"));
        if (testNGBox.isDisplayed() && !testNGBox.isSelected()) {
            testNGBox.click();
        }

        WebElement cucumberBox = driver.findElement(By.id("cond4"));
        if (cucumberBox.isDisplayed() && !cucumberBox.isSelected()) {
            cucumberBox.click();
        }

        // TAG NAME LOCATOR  hard to find unique

        WebElement version = driver.findElement(By.tagName("u"));
        String actualVersion = version.getText().trim();
        String exppectedVersion = "Use Java Version";
        if (actualVersion.equals(exppectedVersion)) {
            System.out.println("version test PASSED");
        } else {
            System.out.println("version test FAILED");
        }
    }

}

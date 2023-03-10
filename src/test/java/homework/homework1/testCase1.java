package homework.homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class testCase1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Navigate to "https://demoqa.com/text-box"
        driver.get("https://demoqa.com/text-box");

        //Enter your full name, email, current and permanent address
        WebElement fullName = driver.findElement(By.xpath("//input[@id = 'userName']"));
        fullName.sendKeys("Artur");

        WebElement email = driver.findElement(By.xpath("//input[@id = 'userEmail']"));
        email.sendKeys("Artur1111@gmail.com");

        WebElement addressCurrent = driver.findElement(By.xpath("//textarea[@id = 'currentAddress']"));
        addressCurrent.sendKeys("7200 Devon Ave, Des Plains, IL, 60755");

        WebElement addressPermanent = driver.findElement(By.xpath("//textarea[@id = 'permanentAddress']"));
        addressPermanent.sendKeys("1000 Tech Ave, Des Plains, IL, 75456");

        //Click submit button.

        WebElement submit = driver.findElement(By.xpath("//button[@id = 'submit']"));
        submit.click();
        Thread.sleep(1000);

        //Validate that all of your information is displayed and matching correctly.

        WebElement nameCheck = driver.findElement(By.xpath("//p[@id = 'name']"));
        String nameValidation = nameCheck.getText().trim();
        System.out.println(nameValidation.equals("Name:Artur") ? "NAME PASSED" : "NAME FAILED");

        WebElement emailChecked = driver.findElement(By.xpath("//p[@id = 'email']"));
        String emailValidation = emailChecked.getText().trim();
        System.out.println(emailValidation.equals("Email:Artur1111@gmail.com") ? "EMAIL PASSED" : "EMAIL FAILED");


        //checking if the same

        WebElement currentAddressValidation = driver.findElement(By.xpath("//p[@id = 'currentAddress']"));
        String addressTextCurrent = currentAddressValidation.getText().trim();
        String currentCut = (addressTextCurrent.substring(addressTextCurrent.indexOf(":") + 1));

        WebElement permanentAddressValidation = driver.findElement(By.xpath("//p[@id = 'permanentAddress']"));
        String addressTextPermanent = permanentAddressValidation.getText().trim();
        String permanentCut = (addressTextPermanent.substring(addressTextPermanent.indexOf(":") + 1));

        System.out.println(currentCut.equals(permanentCut) ? "Address if THE SAME :  PASSED" : "Address if THE SAME :FILED");

        // validate address

        System.out.println(currentCut.equals("7200 Devon Ave, Des Plains, IL, 60755") ? "current address PASSED" : "current address FAILED");
        System.out.println(permanentCut.equals("1000 Tech Ave, Des Plains, IL, 75456") ? "Permanent address PASSED" : "Permanent address FAILED");

        Thread.sleep(10000);
        driver.quit();


    }
}

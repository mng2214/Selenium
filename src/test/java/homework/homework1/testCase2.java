package homework.homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class testCase2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
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
        String stringRadioButton = validationRadioButton.getText().trim();
        System.out.println(stringRadioButton.equals("You have selected Yes")?"RadioButton PASSED":"RadioButton FAILED");

        Thread.sleep(2000);
        //Click Impressive radio button
        WebElement impressiveButton = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        impressiveButton.click();

        //Validate text is : You have selected Impressive
        WebElement validationImpressiveButton = driver.findElement(By.xpath("//p[@class='mt-3']"));
        String stringImpressiveButton = validationImpressiveButton.getText().trim();
        System.out.println(stringImpressiveButton.equals("You have selected Impressive")?"ImpressiveButton PASSED":"ImpressiveButton FAILED");












    }

}

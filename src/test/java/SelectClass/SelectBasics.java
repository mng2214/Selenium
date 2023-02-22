package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectBasics {
    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement dropDown = driver.findElement(By.linkText("Dropdown"));
        dropDown.click();
        WebElement optionBox = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select options = new Select(optionBox);

        options.selectByValue("1");
        Thread.sleep(1000);

        options.selectByVisibleText("Option 2");
        Thread.sleep(1000);

        options.selectByIndex(1);
        Thread.sleep(1000);

        System.out.println(options.getFirstSelectedOption().getText().trim());

        Thread.sleep(4000);

        List<WebElement> actualOptions = options.getOptions();
        List <String> expectedOptions = Arrays.asList("Please select an option","Option 1","Option 2");





        for (int i = 0 ; i < actualOptions.size(); i ++){
            Assert.assertEquals(actualOptions.get(i).getText().trim() , expectedOptions.get(i));
        }


    }
}

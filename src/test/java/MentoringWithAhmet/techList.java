package MentoringWithAhmet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class techList {
        /*
    1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox).
7-Select Automation tools you are familiar with (multiple checkboxes).
8-Select Continent(Send Keys).
9-Click on Submit button.
Try your own logic and automate it without any help.
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Artur");

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Test");

        WebElement gender = driver.findElement(By.id("sex-0"));
        gender.click();

        WebElement exp = driver.findElement(By.id("exp-4"));
        exp.click();

        WebElement date = driver.findElement(By.id("datepicker"));
        date.sendKeys("2/14/23");

        WebElement continents = driver.findElement(By.id("continents"));
        continents.sendKeys("North America");








    }
}

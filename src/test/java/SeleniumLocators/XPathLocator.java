package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathLocator {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
//ABSOLUTE XPATH EXAMPLE
        WebElement abTesting = driver.findElement(By.linkText("A/B Testing"));
        abTesting.click();
        WebElement paragraph = driver.findElement(By.xpath("/html/body/div[2]/div/div/p"));
        System.out.println(paragraph.getText().trim());
//RELATIVE X PATH
        WebElement elementSelenium = driver.findElement(By.xpath("//a[contains(text(), 'Selenium')]"));
        System.out.println(elementSelenium.getText().trim());
        Thread.sleep(2000);
        WebElement elementSelenium2 = driver.findElement(By.xpath("//a[.='Elemental Selenium']"));
        System.out.println(elementSelenium2.getText().trim());
        elementSelenium2.click();


    }

}

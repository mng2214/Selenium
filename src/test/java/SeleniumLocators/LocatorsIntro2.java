package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///C:/Users/mng22/OneDrive/Desktop/Techtorialhtml.html");

        // LINKTEXT LOCATOR

        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement header = driver.findElement(By.tagName("h1"));
        System.out.println(header.getText().trim().equals("Java") ? "JAVA LINK PASSED" : "JAVA LINK FAILED");
        //Thread.sleep(2000);
        driver.navigate().back();

        WebElement seleniumLink = driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        WebElement seleniumHeader = driver.findElement(By.tagName("h1"));
        System.out.println(seleniumHeader.getText().trim().equals("Selenium automates browsers. That's it!") ? "PASSED SELENIUM" : "FAILED SELENIUM");
        driver.navigate().back();

        WebElement cucumberLink = driver.findElement(By.linkText("Cucumber"));
        cucumberLink.click();
        WebElement cucumberHeader = driver.findElement(By.tagName("h1"));
        System.out.println(cucumberHeader.getText().trim().equals("Tools & techniques that elevate teams to greatness") ? "PASSED CUCUMBER" : "FAILED CUCUMBER");
        driver.navigate().back();

        WebElement testNG = driver.findElement(By.linkText("TestNG"));
        testNG.click();
        WebElement testNGHeader = driver.findElement(By.tagName("h2"));
        System.out.println(testNGHeader.getText().trim().equals("TestNG") ? "PASSED TESTNG" : "FAILED TESTNG");
        driver.navigate().back();

        String actualURL = driver.getCurrentUrl().trim();
        String expectedURL = "file:///Users/codefish/Downloads/Techtorial.html";
        System.out.println(actualURL.equals(expectedURL) ? "URL PASSED" : "URL FAILED");

// PARTIAL LINK TEXT LOCATOR  must have both tag and text

//        WebElement restApi = driver.findElement(By.partialLinkText("Rest"));
//        restApi.click();
//        String actualUrlRest = driver.getCurrentUrl();
//        String exprectedUrlRest = "";
//        System.out.println(actualUrlRest.equals(exprectedUrlRest)?"REST URL PASSED":"REST URL PASSED");
        driver.close();

    }

}

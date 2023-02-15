package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {


//driver.get()  drier.getTitle



        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver(); //object
        driver.manage().window().maximize(); // maximize screen
        driver.get("https://www.amazon.com/"); //navigate to web
        System.out.println(driver.getTitle()); // get a title
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon.com. Spend less. Smile more.";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("your test is passed");
        } else {
            System.out.println("your test is failed");
        }



        //driver.getCurrentUrl() do not need create another driver



        driver.get("https://www.techtorialacademy.com/");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl ="https://www.techtorialacademy.com/";
        String ActualTitleTechtorial = driver.getTitle();
        String expectedTitleTechtorial = "Home";

        if(actualUrl.equals(expectedUrl)){
            System.out.println("URL is PASSED");
        }else {
            System.out.println("URL is FAILED");
        }

        if(ActualTitleTechtorial.equals(expectedTitleTechtorial)){
            System.out.println("TITLE is PASSED");
        }else {
            System.out.println("TITLE is FAILED");
        }
        driver.close();



    }
}

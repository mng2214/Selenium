package SeleniumIntro.homework.homework1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class titleCheck {
    public static void main(String[] args) {
// test #1 youtube
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");
        System.out.println(driver.getTitle());
        String actualTitle = driver.getTitle();
        String expectedTitle = "YouTube";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("your test is PASSED");
        } else {
            System.out.println("your test is FAILED");
        }
//test #2 // any site gonna work with it
        titleChecker("youtube.com", "YouTube");
// test #3 gitHub
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        driver.manage().window().maximize();
        driver.get("https://www.github.com/");
        System.out.println(driver.getTitle());
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "Let’s build from here · GitHub";
        System.out.println(actualTitle2.equals(expectedTitle2) ? "PASSED IT" : "FAILED IT");
    }

//method for test # 2 // created void method with a String parameters EXP: titleChecker("youtube.com","YouTube");
    public static void titleChecker(String webSite, String expectedTitle) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www." + webSite + "/");
        System.out.println(driver.getTitle());
        String actualTitle = driver.getTitle();
        System.out.println((actualTitle.equals(expectedTitle)) ? "PASSED" : "FAILED");

    }

}






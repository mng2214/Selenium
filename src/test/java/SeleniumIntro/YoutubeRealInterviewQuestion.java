package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class YoutubeRealInterviewQuestion {
    public static void main(String[] args) throws InterruptedException {


        /* 1-Navigate to the website youtube
 2-Search for justin bieber
 3-Find the all song names and store in the list Justin Bieber - Hold On (Live from Paris)
 4-Use for and if conditions to find the song
 5-Click the song
 6-Enjoy your music
 7-Ready to be level 2
 */


        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
//1-Navigate to the website youtube
        driver.navigate().to("https://www.youtube.com/");
// 2-Search for justin bieber
        WebElement searchBar = driver.findElement(By.xpath("//input[@id ='search']"));
        searchBar.sendKeys("justin biber");
       // WebElement clickSearch = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        //clickSearch.click();
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
// 4-Use for and if conditions to find the song
        List<WebElement> songs = driver.findElements(By.xpath("//a[@id='video-title']"));

        for (WebElement song : songs) {
            song.sendKeys(Keys.ARROW_DOWN);

            Thread.sleep(1000);
            if(song.getAttribute("title").trim().equals("Justin Bieber - Ghost")){
                // 5-Click the song
                song.click();
                break;
            }

            // 6-Enjoy your music
        }
    }
}

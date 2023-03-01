package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.text.BreakIterator;
import java.time.Duration;

public class mentoring3 {
    /*
1-Navigate to the website "https://www.thespruceeats.com/"
2-Under Ingredients option --> choose Fish&SeaFood option
3-ScrollDown to the search bar
4-Send the data: "Fish for dinner"
5-On the left side choose 4 star up option
6-From popular: Choose the Editor's choice option
7-Validate the name of product is "6-Ingredient Roasted Salmon Fillets"
8-Quit or close your driver
 */
    @Test
    public void SpruceeInterviewQuestion() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.thespruceeats.com/");

        WebElement ingredients = driver.findElement(By.xpath("//li[@class='global-nav__list-item js-global-nav-item']//span[contains(text(),'Ingredients')]"));
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        action.moveToElement(ingredients).perform();
        Thread.sleep(1000);
        WebElement fishAndSeafood = driver.findElement(By.xpath("//li//a[contains(text(), 'Fish & Seafood')]"));
        action.moveToElement(fishAndSeafood).click(fishAndSeafood).perform();


        WebElement search = driver.findElement(By.xpath("//input[@id='search-form-input']"));
        BrowserUtils.scrollWithJS(driver,search);
        Thread.sleep(1000);
        search.sendKeys("Fish for dinner", Keys.ENTER);
        Thread.sleep(2000);

        WebElement fourStar = driver.findElement(By.xpath("//input[@id='starRating_score_4Star']"));
        action.moveToElement(fourStar).click().perform();
        Thread.sleep(1000);

        WebElement editorChoice = driver.findElement(By.xpath("//input[@id='pop_search_editor']"));
        action.moveToElement(editorChoice).click().perform();
        Thread.sleep(1000);

        WebElement sixElement = driver.findElement(By.xpath("//span[.='6-Ingredient Roasted Salmon Fillets']"));
        String expected = "6-Ingredient Roasted Salmon Fillets";
        String actual = BrowserUtils.getText(sixElement);
        Assert.assertEquals(actual,expected);

        driver.quit();


    }
}

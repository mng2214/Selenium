package mentoring_with_kuba;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambdaTest {
    WebDriver driver;

    @Test
    public void ValidateEmailAndName_TC_01() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to(" https://www.lambdatest.com/selenium-playground/");

        WebElement clickTablePagination = driver.findElement(By.xpath("//a[contains(text(),'Table Pagination')]"));
        clickTablePagination.click();

        Thread.sleep(1000);

        WebElement RowsSelect = driver.findElement(By.xpath("//select[@id ='maxRows']"));
        BrowserUtils.selectBy(RowsSelect, "Show ALL Rows", "text");

        Thread.sleep(1000);

        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> AllEmails = driver.findElements(By.xpath("//tr//td[3]"));
        List<WebElement> allNumbers = driver.findElements(By.xpath("//tr//td[4]"));
        //Map<String,String> map = new HashMap<>();

        for (int i = 0; i < allNames.size(); i++) {
            Map<String,String> map = new HashMap<>();
            map.put(allNames.get(i).getText(), allNames.get(i).getText());
            map.put(AllEmails.get(i).getText(), AllEmails.get(i).getText());
            System.out.println(map);
        }

        for (int i = 0; i < allNames.size(); i++) {
            Map<String,String> map1 = new HashMap<>();
            map1.put(AllEmails.get(i).getText(), allNumbers.get(i).getText().replace("-",""));
            System.out.println(map1);

        }
    }


}

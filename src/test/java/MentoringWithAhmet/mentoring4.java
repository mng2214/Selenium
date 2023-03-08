package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mentoring4 {
    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://petstore.octoperf.com/actions/Catalog.action");

        driver.findElement(By.xpath("//*[@id=\"MainImageContent\"]//area[@alt='Dogs']")).click();

        List<WebElement> IDs = driver.findElements(By.xpath("//tr//a"));
        List<WebElement> names = driver.findElements(By.xpath("//tr/td")); //12 +2
        List<String> namesOnly = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for (int i = 1; i < names.size(); i = i + 2) {
            namesOnly.add(BrowserUtils.getText(names.get(i)));
        }

        for (int i = 0; i < IDs.size(); i++) {
            map.put(BrowserUtils.getText(IDs.get(i)), namesOnly.get(i));
        }
        System.out.println(map);

        driver.findElement(By.xpath("//a[.='K9-BD-01']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='Catalog']/table/tbody/tr[2]/td[5]/a")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[.='K9-RT-02']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='Catalog']/table/tbody/tr[4]/td[5]/a")).click();

        driver.findElement(By.xpath("//img[@name='img_cart']")).click();

        WebElement cartPrice = driver.findElement(By.xpath("//td[@colspan='7']"));
        String cartTotal = BrowserUtils.getText(cartPrice);
        int cartInt = Integer.parseInt(cartTotal.substring(cartTotal.indexOf("$")+1).replace(".","")) ;

        System.out.println(cartInt);
        Thread.sleep(1000);

        WebElement dogPrice1 = driver.findElement(By.xpath("//tr[2]//td[7]"));
        String dog1 = dogPrice1.getText().replace("$", "").replace(".", "");
        int dog1int = Integer.parseInt(dog1);
        System.out.println(dog1);

        WebElement dogPrice2 = driver.findElement(By.xpath("//tr[3]//td[7]"));
        String dog2 = dogPrice2.getText().replace("$", "").replace(".", "");
        int dog2int = Integer.parseInt(dog2);
        System.out.println(dog2);

        Assert.assertEquals(cartInt,dog1int+dog2int);


    }
}

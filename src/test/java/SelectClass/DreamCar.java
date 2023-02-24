package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.crypto.paddings.ZeroBytePadding;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.netty.util.internal.SystemPropertyUtil.contains;

public class DreamCar {
    /*
NOTE: Please use browser utils for the select classes if it is needed.
1-Navigate to the website
2-Choose the "New Cars" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350

     */
     @Test(invocationCount = 10)
    public void validateHeader() throws InterruptedException  {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.cars.com/");

        WebElement newUsedChose = driver.findElement(By.cssSelector("#make-model-search-stocktype"));
        BrowserUtils.selectBy(newUsedChose, "New", "text");
        Thread.sleep(100);

        WebElement make = driver.findElement(By.cssSelector("#makes"));
        BrowserUtils.selectBy(make, "Lexus", "text");
        Thread.sleep(100);


        WebElement model = driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(model, "lexus-rx_350", "value");
        Thread.sleep(100);

        WebElement priceValidation = driver.findElement(By.cssSelector("#make-model-max-price"));
        BrowserUtils.getFirstSelectedOption(priceValidation, "No max price");
//        String expectedPriceValidation = "No max price";
//        Select actualPrice = new Select(priceValidation);
//        Assert.assertEquals(actualPrice.getFirstSelectedOption().getText().trim(), expectedPriceValidation);
        Thread.sleep(2000);


        WebElement distance = driver.findElement(By.cssSelector("#make-model-maximum-distance"));
        BrowserUtils.selectBy(distance, "40", "value");
        Thread.sleep(100);


        WebElement zip = distance.findElement(By.xpath("//input[@id = 'make-model-zip']"));
        zip.clear();
        zip.sendKeys("60056");
        Thread.sleep(100);


        WebElement search = driver.findElement(By.xpath("//button [@data-linkname='search-new-make']"));
        search.click();
        Thread.sleep(3000);


        WebElement lowestPrice = driver.findElement(By.cssSelector("#sort-dropdown"));
        BrowserUtils.selectBy(lowestPrice, "Lowest price", "text");
        Thread.sleep(3000);

//HOME WORK 2/22 FROM AHMET --------------------------------------------------------------------------------------------------------------
        // After i click on *LOWEST PRICE*  need to validate if all cars appears from CHEAPEST TO MORE EXPANSIVE

        List<WebElement> carPrices = driver.findElements(By.xpath("//span[@class ='primary-price']"));
        Thread.sleep(3000);
        List<Integer> StringListActual = new ArrayList<>();
        List<Integer> StringListExpected = new ArrayList<>();

        Thread.sleep(3000);
        for (WebElement carPrice : carPrices) {
            //Thread.sleep(100);
            StringListExpected.add(Integer.parseInt(BrowserUtils.getText(carPrice).replace("$", "").replace(",", "")));
            StringListActual.add(Integer.parseInt(BrowserUtils.getText(carPrice).replace("$", "").replace(",", "")));
        }
        Thread.sleep(3000);
        Collections.sort(StringListExpected);
        System.out.println("----------");
        Thread.sleep(2000);

        for (int i = 0; i < carPrices.size(); i++) {
            Assert.assertEquals(StringListActual.get(i), StringListActual.get(i));
        }
        System.out.println(StringListActual);
        System.out.println(StringListExpected);
        Thread.sleep(2000);

//HOME WORK 2/22 FROM AHMET --------------------------------------------------------------------------------------------------------------

        List<WebElement> cars = driver.findElements(By.xpath("//h2[@class ='title']"));
        for (WebElement car : cars) {
            Assert.assertTrue(BrowserUtils.getText(car).contains("Lexus RX 350"));
        }

        Thread.sleep(3000);
        driver.quit();

    }
}

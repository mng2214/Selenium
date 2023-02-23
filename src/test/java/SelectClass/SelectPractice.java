package SelectClass;

import com.beust.ah.A;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
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
import java.util.Arrays;
import java.util.List;

public class SelectPractice {

    @Test
    public void validateFirstOptionAndAllOptionsPrint() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("file:///C:/Users/mng22/OneDrive/Desktop/Techtorialhtml.html");


        WebElement dropDownCountry = driver.findElement(By.xpath("//select[@name = 'country']"));
        Select options = new Select(dropDownCountry);
        String actualCountry = options.getFirstSelectedOption().getText().trim();
        String expectedCountry = "UNITED STATES";

        Assert.assertEquals(actualCountry, expectedCountry);

        int count = 0;

        List<WebElement> allOptions = options.getOptions();
        for (WebElement option : allOptions) {
            //System.out.println(option.getText().trim());
            count++;
        }
        System.out.println("count is : >> " + count);

        System.out.println("---------------------------------------------------------");

        options.selectByIndex(55);
        Thread.sleep(3000);

        options.selectByVisibleText("ZIMBABWE");
        Thread.sleep(3000);

        options.selectByValue("123");
        Thread.sleep(5000);

        driver.quit();
    }

    @Test
    public void multipleSelect () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("file:///C:/Users/mng22/OneDrive/Desktop/Techtorialhtml.html");

        WebElement countyBox = driver.findElement(By.cssSelector(".select"));
        Select county = new Select(countyBox);
        county.selectByVisibleText("One");
        Thread.sleep(1500);
        county.selectByValue("3");
        Thread.sleep(1500);
        county.selectByIndex(4);
        Thread.sleep(1500);
        county.deselectByVisibleText("One");
        Thread.sleep(1500);
        county.deselectAll();
    }
    /*
1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
"After flight finder - No Seats Avaialble"

NOTE:Your test should fail and say available is not matching with Available.
NOTE2:You can use any select method value,visibleText
*/
    @Test
    public void validateOrderMessage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement flightType = driver.findElement(By.xpath("//input[@value='oneway']"));
        flightType.click();
        Thread.sleep(3000);

        WebElement passengers = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select PassengersOptions = new Select(passengers);
        PassengersOptions.selectByVisibleText("4");
        Thread.sleep(3000);

        WebElement departingFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departingOptions = new Select(departingFrom);
        String selectedExpected = "Acapulco";
        Assert.assertEquals(departingOptions.getFirstSelectedOption().getText(), selectedExpected);

        departingOptions.selectByValue("Paris");

        WebElement on = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select onSelect = new Select(on);
        onSelect.selectByVisibleText("August");
        Thread.sleep(500);


        WebElement onDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select onDaySelect = new Select(onDay);
        onDaySelect.selectByVisibleText("15");
        Thread.sleep(500);


        WebElement arrive = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arriveSelect = new Select(arrive);
        arriveSelect.selectByVisibleText("San Francisco");
        Thread.sleep(500);


        WebElement toDate = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select toDateSelect = new Select(toDate);
        toDateSelect.selectByVisibleText("December");
        Thread.sleep(500);


        WebElement onMonth = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select onMonthSelect = new Select(onMonth);
        onMonthSelect.selectByVisibleText("15");
        Thread.sleep(500);

        WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();
        Thread.sleep(500);

        WebElement airline = driver.findElement(By.xpath("//select [@name='airline']"));
        Select airlineOptions = new Select(airline);
        airlineOptions.selectByVisibleText("Unified Airlines");
        Thread.sleep(500);


        WebElement validation = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airValidation = new Select(validation);

        List<WebElement> actualValidation = airValidation.getOptions();
        List<String> expectedValidation = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        for (int i = 0; i < actualValidation.size(); i++) {
            Assert.assertEquals(actualValidation.get(i).getText(), expectedValidation.get(i));
        }


        WebElement count = driver.findElement(By.xpath("//input[@name='findFlights']"));
        count.click();
        Thread.sleep(500);


        WebElement validation2 = driver.findElement(By.xpath("//font[@size='4']"));
        String actual = validation2.getText().trim();
        String expected = "After flight finder - No Seats Avaialble";
        Assert.assertEquals(actual, expected);

        Thread.sleep(5000);
        driver.quit();

    }






    @Test
    public void shortCutsSelectClass() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement flightType = driver.findElement(By.xpath("//input[@value='oneway']"));
        flightType.click();
        Thread.sleep(3000);


        WebElement passengers = driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(passengers,"4","index");
        Thread.sleep(3000);


        WebElement departingFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departingOptions = new Select(departingFrom);
        String selectedExpected = "Acapulco";
        Assert.assertEquals(departingOptions.getFirstSelectedOption().getText(), selectedExpected);
        departingOptions.selectByValue("Paris");


        WebElement on = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(on,"August","text");
        Thread.sleep(500);


        WebElement onDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Thread.sleep(500);
        BrowserUtils.selectBy(onDay, "15", "text");


        WebElement arrive = driver.findElement(By.xpath("//select[@name='toPort']"));
        BrowserUtils.selectBy(arrive,"San Francisco","text" );
        Thread.sleep(500);


        WebElement toDate = driver.findElement(By.xpath("//select[@name='toMonth']"));
        BrowserUtils.selectBy(toDate,"December", "text");
        Thread.sleep(500);

        WebElement onMonth = driver.findElement(By.xpath("//select[@name='toDay']"));
        BrowserUtils.selectBy(onMonth,"15","text");
        Thread.sleep(500);

        WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();
        Thread.sleep(500);

        WebElement airline = driver.findElement(By.xpath("//select [@name='airline']"));
        BrowserUtils.selectBy(airline,"Unified Airlines","text");
        Thread.sleep(500);

        WebElement validation = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airValidation = new Select(validation);

        List<WebElement> actualValidation = airValidation.getOptions();
        List<String> expectedValidation = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        for (int i = 0; i < actualValidation.size(); i++) {
            Assert.assertEquals(actualValidation.get(i).getText(), expectedValidation.get(i));
        }

        WebElement count = driver.findElement(By.xpath("//input[@name='findFlights']"));
        count.click();
        Thread.sleep(500);

        WebElement validation2 = driver.findElement(By.xpath("//font[@size='4']"));
        String actual = BrowserUtils.getText(validation2);
        String expected = "After flight finder - No Seats Avaialble";
        Assert.assertEquals(actual, expected);

        Thread.sleep(5000);
        driver.quit();
    }
}

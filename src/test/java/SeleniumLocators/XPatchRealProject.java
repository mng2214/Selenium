package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XPatchRealProject {
    /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your command for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.*/

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //  1-Navigate to the https://katalon-demo-cura.herokuapp.com/

        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement clickAppoimnet = driver.findElement(By.xpath("//a[@id = 'btn-make-appointment']"));

        // 2-Click Make an Appointment

        clickAppoimnet.click();

        // 3-Login the username and password provided and Login successfully

        WebElement login = driver.findElement(By.xpath("//input[@id = 'txt-username']"));
        login.sendKeys("John Doe");



        WebElement passWord = driver.findElement(By.xpath("//input[@id = 'txt-password']"));
        passWord.sendKeys("ThisIsNotAPassword");

        WebElement loginClick = driver.findElement(By.xpath("//button[@id = 'btn-login' ]"));
        loginClick.click();

        // 4-Choose the facility either HongKong or Seoul -->send keys

        WebElement facility = driver.findElement(By.xpath("//select[@id = 'combo_facility']"));
        facility.sendKeys("Hongkong CURA Healthcare Center");

        // 5-Click apply for hospital admission box if it is displayed and validate it is selected
        WebElement applyHospital = driver.findElement(By.xpath("//input[@id = 'chk_hospotal_readmission']"));
        if (applyHospital.isSelected() && applyHospital.isDisplayed()) {
            applyHospital.click();
        }


        //6-Healthcare program 'Medicaid'

        WebElement medicare = driver.findElement(By.xpath("//input[@id = 'radio_program_medicare']"));
        medicare.click();
        //7-Visit date should be provided -->send keys

        WebElement date = driver.findElement(By.xpath("//input[@id = 'txt_visit_date']"));
        date.sendKeys("02/15/2023");

        //9-Book your appointment
        WebElement book = driver.findElement(By.xpath("//button[@id = 'btn-book-appointment']"));
        book.click();


        //10-Validate the header is "Appointment confirmation" (if statement)
        WebElement appointmentConfValidation = driver.findElement(By.xpath("//h2[contains(text(),'App')]"));
        String header = appointmentConfValidation.getText().trim();
        System.out.println(header.equals("Appointment Confirmation") ? "header pass" : "header failed");
        System.out.println(header);

        //11-Print out the headers and values(only values) on your console.
        WebElement facilityChosen = driver.findElement(By.xpath("//p[@id = 'facility']"));
        System.out.println(facilityChosen.getText());

        WebElement applyYesNo = driver.findElement(By.xpath("//p[@id = 'hospital_readmission']"));
        System.out.println(applyYesNo.getText());

        WebElement healthCareProgram = driver.findElement(By.xpath("//p[@id = 'program']"));
        System.out.println(healthCareProgram.getText());

        WebElement dateAppointment = driver.findElement(By.xpath("//p[@id = 'visit_date']"));
        dateAppointment.getText();

        WebElement comment = driver.findElement(By.xpath("//p[@id = 'comment']"));
        String commentToString = comment.getText();
        System.out.println(commentToString.length() > 1 ? commentToString : "No Comment");

        //12)Click go to homepage and print out url
        WebElement homePage = driver.findElement(By.xpath("//a[@class='btn btn-default']"));
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        homePage.click();

        Thread.sleep(10000);
        //13)Driver.quit or close.
        driver.quit();
    }

}

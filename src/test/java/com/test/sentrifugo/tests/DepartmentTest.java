package com.test.sentrifugo.tests;

import com.test.sentrifugo.pages.DepartmentPage;
import com.test.sentrifugo.pages.HomePage;
import com.test.sentrifugo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DepartmentTest {
    @Test
    public void validateDepartmentFunctionality (){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://demo.sentrifugo.com/index.php/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("EM01", "sentrifugo");
        HomePage homePage = new HomePage(driver);
        homePage.clickDepartments();
        DepartmentPage departmentPage= new DepartmentPage(driver);
        departmentPage.validateDepartmentFunctionality(driver,"IT","445","Department added successfully.");
        homePage.clickDepartments();
        departmentPage.validateDepartmentFunctionality(driver, "IT", "445", "Department added successfully.");
        departmentPage.listValidation("Information Technology", "IT", "01/05/2001", "Thomas E" , "America/New_York [EDT]" ,"Orange Blossom" );
        driver.quit();
    }


}

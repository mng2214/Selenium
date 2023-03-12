package com.test.bank.tests;

import com.test.bank.pages.BankManagerPage;
import com.test.bank.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ManagerTest {
    WebDriver driver ;

    @BeforeMethod
    public void beforeMethod() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

    }



    @Test
    public void managerFunc() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickBankManagerLogin();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomer(driver, "Artur", "Test", "60707");
        bankManagerPage.openAccount(driver, "Artur Test");
        bankManagerPage.customers("Artur", "Test", "60707");

    }

}

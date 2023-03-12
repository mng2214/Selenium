package com.test.bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class BankManagerPage {

    public BankManagerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    WebElement clickAddCustomer;
    @FindBy(xpath = "//input[@ng-model='fName']")
    WebElement firstName;
    @FindBy(xpath = "//input[@ng-model='lName']")
    WebElement lastName;
    @FindBy(xpath = "//input[@ng-model='postCd']")
    WebElement postalCode;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;
    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openAccountButton;
    @FindBy(css = "#userSelect")
    WebElement userSelect;
    @FindBy(css = "#currency")
    WebElement currency;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButtonNewAccount;

    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    WebElement customersButton;
    @FindBy(xpath = "//input[@ng-model='searchCustomer']")
    WebElement searchCustomerButton;
    @FindBy(xpath = "//button[contains(text(),'Delete')]")
    WebElement deleteButton;

    @FindBy(xpath = "//tbody//tr//td[@class='ng-binding']")
    List<WebElement> allInformation;

    public void addCustomer(WebDriver driver, String first, String last, String zip) {
        clickAddCustomer.click();
        firstName.sendKeys(first);
        lastName.sendKeys(last);
        postalCode.sendKeys(zip);
        submitButton.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Customer added successfully with customer"));
        alert.accept();
        driver.navigate().back();

    }

    public void openAccount(WebDriver driver, String fullName) {
        openAccountButton.click();
        Select selectName = new Select(userSelect);
        selectName.selectByVisibleText(fullName);
        Select selectMoney = new Select(currency);
        selectMoney.selectByValue("Dollar");
        submitButtonNewAccount.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Account created successfully with account Number"));
        alert.accept();
    }

    public void customers(String firstName, String lastName, String postalCode) {
        customersButton.click();
        searchCustomerButton.sendKeys(lastName);
        List<String> exprectedInformation = Arrays.asList(firstName, lastName, postalCode);
        for (int i = 0; i < allInformation.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)), exprectedInformation.get(i));
        }
        deleteButton.click();
    }


}

package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderPage {
    public OrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[@id='name']")
    WebElement cardName;
    @FindBy(xpath = "//input[@id='country']")
    WebElement cardCountry;
    @FindBy(xpath = "//input[@id='city']")
    WebElement cardCity;
    @FindBy(xpath = "//input[@id='card']")
    WebElement cardNumber;
    @FindBy(xpath = "//input[@id='month']")
    WebElement cardMonth;
    @FindBy(xpath = "//input[@id='year']")
    WebElement cardYear;
    @FindBy(xpath = "//button[.='Purchase']")
    WebElement purchase;
    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrderButton;
    @FindBy(xpath = "//h2[contains(text(),'Thank you for your purchase!')]")
    WebElement thankYouMsg;
    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;

    public void placeOrderFunc(WebDriver driver, String nameCard, String countryCard, String cityCard, String numCard, String monthCard, String yearCard) throws InterruptedException {

        cardName.sendKeys(nameCard);cardCountry.sendKeys(countryCard);
        cardCity.sendKeys(cityCard);cardNumber.sendKeys(numCard);
        cardMonth.sendKeys(monthCard);cardYear.sendKeys(yearCard);

        purchase.click();

        Assert.assertTrue(thankYouMsg.getText().contains("Thank you for your purchase!"));
        Thread.sleep(500);
        okButton.click();

        Assert.assertEquals(driver.getTitle(), "STORE");
    }
}

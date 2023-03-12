package com.test.blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class MacBookProPage {

    public MacBookProPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h2")//MacBook Pro
    WebElement nameTitle;
    @FindBy(tagName = "h3") //$1100 *includes tax
    WebElement price;
    @FindBy(xpath = "//div[@id='more-information']")
    WebElement productInfo;
    //Product description
    //Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.

    @FindBy (xpath = "//a[.='Add to cart']")
    WebElement addToCartElement;


    public void textValidation(String headerText, String priceText, String descriptionText ) throws InterruptedException {
        Assert.assertTrue(BrowserUtils.getText(nameTitle).contains(headerText));
        Assert.assertTrue(BrowserUtils.getText(price).contains(priceText));
        Assert.assertTrue(BrowserUtils.getText(productInfo).contains(descriptionText));

    }
    public void addToCartClick (WebDriver driver, String expMsgAlert ) throws InterruptedException {
        addToCartElement.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().equals(expMsgAlert));
        alert.accept();
    }
}

package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//a[.='Laptops']")
    WebElement laptopsButton;

    @FindBy(xpath = "//a[.='Cart']")
    WebElement cartButton;

    public void setLaptopsButtonClick () throws InterruptedException {
        laptopsButton.click();
        Thread.sleep(1000);
    }

    public void cartClick () throws InterruptedException {
        cartButton.click();
        Thread.sleep(500);

    }

}

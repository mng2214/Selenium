package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class LaptopsPage {
    public LaptopsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h4//a")
    List<WebElement> laptopsList;
    @FindBy(xpath = "//a[.='MacBook Pro']")
    WebElement macBookPro;

    public void chooseMacLaptopFromList(String brand) throws InterruptedException {
        for (WebElement laptop : laptopsList) {
            if (BrowserUtils.getText(laptop).equals(brand)) {
                macBookPro.click();
                break;
            }
        }
        Thread.sleep(1500);
    }
}

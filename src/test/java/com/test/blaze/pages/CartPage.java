package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartPage {

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tr//td")
    List<WebElement> cartProdValidation;

    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrderButton;

    public void cartTextValidation(String name, String price) {

        List<String> expectedListNames = Arrays.asList(name,price);
        List<String> actualListNames = new ArrayList<>();


        for (int i = 1; i < cartProdValidation.size() - 1; i++) {
            actualListNames.add(BrowserUtils.getText(cartProdValidation.get(i)));
        }

        for (int i = 0; i < actualListNames.size() ; i++) {
            Assert.assertEquals(actualListNames.get(i), expectedListNames.get(i));

        }
        placeOrderButton.click();
    }




}

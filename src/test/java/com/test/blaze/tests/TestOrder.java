package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.annotations.Test;

public class TestOrder extends TestBaseBlaze{
    @Test
    public void orderFunc() throws InterruptedException {

        MainPage mainPage = new MainPage(driver);
        mainPage.setLaptopsButtonClick();

        LaptopsPage laptopsPage = new LaptopsPage(driver);
        laptopsPage.chooseMacLaptopFromList("MacBook Pro");

        MacBookProPage macBookProPage = new MacBookProPage(driver);
        macBookProPage.addToCartClick(driver, "Product added");

        mainPage.cartClick();

        CartPage cartPage = new CartPage(driver);
        cartPage.cartTextValidation("MacBook Pro", "1100");

        OrderPage orderPage = new OrderPage(driver);
        orderPage.placeOrderFunc(driver, "artur", "usa", "chicago", "1234 1234 1234 1234 1234", "11", "2023");

    }
}

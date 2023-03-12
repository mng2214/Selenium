package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.annotations.Test;

public class TestMacBookPro extends TestBaseBlaze {


    @Test
    public void productFunc() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.setLaptopsButtonClick();

        LaptopsPage laptopsPage = new LaptopsPage(driver);
        laptopsPage.chooseMacLaptopFromList("MacBook Pro");

        MacBookProPage macBookProPage = new MacBookProPage(driver);
        macBookProPage.textValidation("MacBook Pro", "$1100 *includes tax", " MacBook Pro line, including a 13-inch and 15-inch");

        macBookProPage.addToCartClick(driver, "Product added");

    }
}

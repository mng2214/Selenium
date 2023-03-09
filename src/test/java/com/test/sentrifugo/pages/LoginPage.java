package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {
    //i store all my elements and methods inside of a specific pagees

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='loginsubmit']")
    WebElement loginButton;

    @FindBy (xpath = "//div[contains(text (),'incorrect')]")
    WebElement errorMessage;

    public void login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }
    public String validateErrorMessage (){
        return BrowserUtils.getText(errorMessage);
    }

    public String colorOfErrorMessage (){
        return errorMessage.getCssValue("color").trim();  //rgba color
    }

}




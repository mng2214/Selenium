package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class DepartmentPage {

    public DepartmentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@title='Add']")
    WebElement addButton;


    @FindBy(xpath = "//input[@id='deptname']")
    WebElement departmentName;

    @FindBy(css = "#s2id_unitid")
    WebElement businessUnits;

    @FindBy(xpath = "//span[.='Orange Blossom']")
    WebElement businessUnitSelect;

    @FindBy(name = "deptcode")
    WebElement departmentCode;

    @FindBy(css = "#submitbutton")
    WebElement saveButton;

    @FindBy(css = ".ml-alert-1-success")
    WebElement message;


    public void validateDepartmentFunctionality(WebDriver driver, String departmentName, String departmentCode, String expectedMessage) {
        addButton.click();
        this.departmentName.sendKeys(departmentName);
        businessUnits.click();
        businessUnitSelect.click();
        this.departmentCode.sendKeys(departmentCode);
        BrowserUtils.scrollWithJS(driver, saveButton);
        saveButton.click();
        Assert.assertEquals(BrowserUtils.getText(message), expectedMessage);
    }


}
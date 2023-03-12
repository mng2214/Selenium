package com.test.sentrifugo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @FindBy(xpath = "//tr[1]//td//span")
    List<WebElement> elements;


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

    public void listValidation(String name, String code, String started_on, String departmentHead, String timeZone, String businessUnit) {
        List<String> expectedElements = Arrays.asList(name, code, started_on, departmentHead, timeZone, businessUnit);

        for (int i = 0; i < elements.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(elements.get(i)), expectedElements.get(i));

        }
    }


}
package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BrowserUtils {
    //WITH OUT CREATING SELECT ELEMENT FOR EVERY CASE
    public static void selectBy(WebElement location, String value, String methodName) {

        Select select = new Select(location);

        switch (methodName) {
            case "text":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Method name is not available , use Text Value Index");
                break;
        }
    }

    //GET TEXT WITHOUT TRIM
    public static String getText(WebElement element) {
        return element.getText().trim();
    }

    //GET FIST SELECTED OPTION WITH OUT CREATING AN OBJECT
    public static void getFirstSelectedOption(WebElement location, String expectedValue) {
        Select select = new Select(location);
        Assert.assertEquals(select.getFirstSelectedOption().getText().trim(), expectedValue);
    }

}

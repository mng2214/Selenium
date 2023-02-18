package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNGIntro {

  @Test(priority = 2) //test anotation
    public void test1(){
    System.out.println("im test1");
  }

  @Test (priority = 1, invocationCount = 20)
  public void test2(){
    System.out.println("im test2");
  }

  @Test (priority = 3)  //test anotation
  public void test3(){
    System.out.println("im test3");
  }





}

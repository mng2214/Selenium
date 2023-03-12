package TestNG;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAfterMethod {
    @BeforeMethod
    public void beforeMethod (){
        System.out.println("Before Method");
    }

    public void afterMethod(){
        System.out.println("After method");
    }
    @Test
    public void hello1() {
        System.out.println("test1");
    }

    @Test
    public void hello2() {
        System.out.println("test2");
    }

    @Test
    public void hello3() {
        System.out.println("test3");
    }
}

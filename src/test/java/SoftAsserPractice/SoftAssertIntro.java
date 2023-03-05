package SoftAsserPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SoftAssertIntro {

    public int getSun (int num1,int num2){
        return num1 + num2;
    }
    @Test
    public void test (){
        Assert.assertEquals(getSun(1,5),6);
        System.out.println("test1");
        Assert.assertEquals(getSun(3,7),10);
        System.out.println("test2");
        Assert.assertEquals(getSun(5,9), 14);
        System.out.println("test3");

    }
}

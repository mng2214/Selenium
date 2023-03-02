package emailSender;

import java.util.Random;

public class test {
    public static void main(String[] args) {


        String emailAddition = "";
        for (int i = 0; i < 5 ; i++) {
            Random random = new Random();
            int userNameRandom = random.nextInt(9);
            emailAddition += userNameRandom;
            System.out.println(emailAddition);
        }
        System.out.println(emailAddition);
    }
}

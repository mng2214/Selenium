import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        // 1
        int sum1 = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum1 += i;
            }
        }
        //System.out.println(sum);

        // 2

        long sum2 = 0;
        int a = 0, b = 1, c;
        for (int i = 1; i <= 4_000_000; i++) {
            sum2 += a;
            c = a + b;
            a = b;
            b = c;
        }
       // System.out.println(sum2);

       // 3

       //The prime factors of 13195 are 5, 7, 13 and 29.
        // What is the largest prime factor of the number 600851475143 ?

        int number = 23 ;
        List<Integer> nums = new ArrayList<>();
        for(int i = 2 ; i  <= number; i++){
            if( number % i == 0){
                nums.add(i);
            }
        }
        System.out.println(nums);







    }
}

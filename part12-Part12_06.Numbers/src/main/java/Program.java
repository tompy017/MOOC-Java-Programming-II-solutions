
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("How many random numbers should be printed?");
        int repeatTimes = Integer.valueOf(scanner.nextLine());
        
        
        Random r = new Random();
        
        int start = 0;
        
        while (start < repeatTimes) {
            int number = r.nextInt(11);
            System.out.println(number);
            start ++;
        }
        
        
    }

}

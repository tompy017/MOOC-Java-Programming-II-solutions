
import java.util.Scanner;



public class MainProgram {

    public static void main(String[] args) {
        // you can create test code here. Call the methods that you'll implement
        // during the course of this exercise
        
        Checker checker = new Checker();
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
       
        // part 1
        /*
        if (checker.isDayOfWeek(input)) {
            System.out.println("The form is correct.");
        } else {
            System.out.println("The form is incorrect.");
        }
        */
        
        // part 2
        if (checker.allVowels(input)) {
            System.out.println("The form is correct.");
        } else {
            System.out.println("The form is incorrect.");
        }
    }
}

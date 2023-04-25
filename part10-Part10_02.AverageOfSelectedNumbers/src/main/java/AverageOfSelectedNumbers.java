
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne
        
        ArrayList<String> list = new ArrayList<>();
        double average = 0.0;
        
        System.out.println("Input numbers, type \"end\" to stop.");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            
            list.add(input);
        }
        
        System.out.println("Print the average of the negative numbers "
                + "or the positive numbers? (n/p)");
        String input = scanner.nextLine();
        
       
        if (input.equals("n")) {                           // NEGATIVE NUMBERS
            System.out.println("Average of the positive numbers: "
            + list.stream()
            .mapToInt(string -> Integer.valueOf(string))
            .filter(number -> number < 0)
            .average()
            .getAsDouble());
            
            
        } else {                                           // POSITIVE NUMBERS
            System.out.println("Average of the negative numbers: "
            + list.stream()
            .mapToInt(string -> Integer.valueOf(string))
            .filter(number -> number >= 0)
            .average()
            .getAsDouble());

        }
    }
}

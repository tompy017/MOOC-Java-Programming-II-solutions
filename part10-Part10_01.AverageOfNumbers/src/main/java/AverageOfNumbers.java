
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Write your program here
        List<Integer> inputs = new ArrayList<>();
        
        System.out.println("Input numbers, type \"end\" to stop.");
        
        while (true) {
            String input = scanner.nextLine();
            
            if (input.equals("end")) {
                break;
            }
            
            inputs.add(Integer.valueOf(input));
        }
        
        double average = inputs.stream()
                .mapToInt(number -> number)
                .average()
                .getAsDouble();
        
        
        System.out.println("average of numbers: " + average);
    }
}

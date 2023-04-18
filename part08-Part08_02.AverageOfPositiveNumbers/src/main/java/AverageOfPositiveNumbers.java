
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbersList = new ArrayList<>();
        
        while (true) {
            int number = Integer.valueOf(scanner.nextLine());
            if (number == 0) {
                break;
            }
            if (number > 0) {
                numbersList.add(number);
            }
        }
        
        int sum = 0;
        for (int n : numbersList) {
            sum += n;
        }
        
        if (numbersList.isEmpty()) {
            System.out.println("Cannot calculate the average");
        } else {
            double average = 1.0 * sum / numbersList.size();
            System.out.println(average);
        }
    }
}


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here
        ArrayList<Integer> testList = new ArrayList<>();
        
        testList.add(-1);
        testList.add(1);
        testList.add(0);
        testList.add(2);
        testList.add(3);
        
        System.out.println(positive(testList));
        

        
    }

    public static List<Integer> positive(List<Integer> numbers) {
        /*
        ArrayList<Integer> positiveNumbers = numbers.stream()
                .filter(number -> number >= 0)
                .collect(Collectors.toCollection(ArrayList::new));
        return positiveNumbers;
        */
        return numbers.stream().filter(number -> number >= 0).collect(Collectors.toList());
        
    }
}

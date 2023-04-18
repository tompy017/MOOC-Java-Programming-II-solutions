
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        
        int first = 0;
        int second = 0;
        
        Scanner scan = new Scanner(System.in);


        while (true) {
            System.out.println("\nFirst: " + first + "/100");
            System.out.println("Second: " + second + "/100");
            System.out.print("> ");
            
            String input = scan.nextLine();
            
            if (input.equals("quit")) {
                break;
            } 
            
            String[] commands = input.split(" ");
            String action = commands[0];
            int amount = Integer.valueOf(commands[1]);
            if (amount < 0) {
                amount = 0;
            }
            
            if (action.equals("add")) {
                first += amount;
                if (first > 100) {
                    first = 100;
                }
                
            } else if (action.equals("move")) {
                if (amount > first) {
                    amount = first;
                }
                first -= amount;

                second += amount;
                if (second > 100) {
                    second = 100;
                }
                
            } else if (action.equals("remove")) {
                second -= amount;
                if (second < 0) {
                    second = 100;
                }
            }
            
        }
    }
    
}

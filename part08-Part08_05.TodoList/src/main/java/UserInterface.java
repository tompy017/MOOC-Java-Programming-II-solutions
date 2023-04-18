
import java.util.Scanner;


/**
 *
 * @author tom
 */
public class UserInterface {
    
    private TodoList todoList;
    private Scanner scanner;

    public UserInterface(TodoList list, Scanner scanner){
        this.todoList = list;
        this.scanner = scanner;
    }
    
    
    public void start() {
        
        while (true) {
            System.out.print("Command: ");
            String input = this.scanner.nextLine();
            
            if (input.equals("stop")) {
                break;
            }
            
            if (input.equals("add")) {
                System.out.print("To add: ");
                //String newTask = scanner.nextLine();
                this.todoList.add(scanner.nextLine());
            
            } else if (input.equals("list")) {
                this.todoList.print();
            
            } else if (input.equals("remove")) {
                System.out.print("Which one is removed? ");
                int toRemove = Integer.valueOf(this.scanner.nextLine());
                this.todoList.remove(toRemove);
            }
            
        }
    }
}

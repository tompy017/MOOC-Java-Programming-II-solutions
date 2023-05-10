package mooc.logic;

import mooc.ui.UserInterface;

/**
 *
 * @author tom
 */
public class ApplicationLogic {
    private UserInterface ui;
    
    public ApplicationLogic(UserInterface ui) {
        this.ui = ui;
    }
    
    public void execute(int times) {
        int repeat = 1;
        
        while (repeat <= times) {
            System.out.println("Application logic is working");
            ui.update();
            repeat ++;
        }
    }
}

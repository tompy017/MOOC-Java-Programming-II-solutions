
/**
 *
 * @author tom
 */
public class ProductWarehouseWithHistory extends ProductWarehouse {
    
    private ChangeHistory log;
    
    
    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        //Instance of ChangeHistory and adding the initial balance to the log
        this.log = new ChangeHistory();
        this.addToWarehouse(initialBalance);
    }
    
 
    public String history() {
        return log.toString();
    }
    
    
    
    @Override
    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        double newBalance = this.getBalance();
        this.log.add(newBalance);
    }
    
    @Override
    public double takeFromWarehouse(double amount) {
       double take = super.takeFromWarehouse(amount);
       double newBalance = this.getBalance();
       log.add(newBalance);
       return take;
    }
    
    public void printAnalysis() {
        System.out.println("Product: " + this.getName());
        System.out.println("History: " + log);
        System.out.println("Largest amount of product: " + log.maxValue());
        System.out.println("Smallest amount of product: " + log.minValue());
        System.out.println("Average: " + log.average());
    }
}

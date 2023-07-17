package application;


/**
 *
 * @author tom
 */
public class Calculator {
    
    private double savings;
    private double interest;
    
    
    
    public Calculator(double amount, double interest) {
        if (amount < 0) {
            amount = 0;
        } else if (amount > 250) {
            amount = 250;
        }
        if (interest < 0) {
            interest = 0;
        } else if (interest > 10) {
            interest = 10;
        }
        
        this.savings = amount;
        this.interest = interest;
    }
    
    public Calculator() {
        this(0, 0);
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getSavings() {
        return savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }
    
    public double monthlyReturns() {
        double monthlySavings = savings * (interest / 100);
        savings += monthlySavings;//(interest / 100);
        return monthlySavings;//savings *= (interest / 100);//monthlySavings;
        
    }
    
    
    public double yearlyReturns() {
        double yearlySum = 0;
        for (int i = 0; i < 12; i++) {
            yearlySum += monthlyReturns();
        }
        
        return yearlySum;
    }
    
}

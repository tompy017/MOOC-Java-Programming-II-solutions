package application;

import javafx.geometry.Insets;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author tom
 */
public class UserInterface {
    
    private BorderPane layout;
    private Calculator calc;
    private Calculator calcNoInterest;
    private XYChart.Series<Number, Number> dataSeries;
    private XYChart.Series<Number, Number> dataSeriesNoInterest;
    private Slider savingsSlider;
    private Slider interestSlider;
    
    // COnstructors
    public UserInterface() {
        this.layout = new BorderPane();
        this.calc = new Calculator();
        this.calcNoInterest = new Calculator();
    }

    
    //Getter
    public BorderPane getLayout() {
        
        layout.setCenter(createLineChart());
        layout.setTop(createTopPane());
        
        return this.layout;
    }
    
    
    // views
    
    private LineChart<Number, Number> createLineChart() {
        // chart axis
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        yAxis.setTickLabelFormatter(null);
        //line chart
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        
        dataSeries = new XYChart.Series<>();
        dataSeries.setName("Interest");
        dataSeriesNoInterest = new XYChart.Series<>();
        dataSeriesNoInterest.setName("No interest");
        
        
        lineChart.getData().addAll(dataSeries, dataSeriesNoInterest);
        lineChart.setAnimated(false);
        
        return lineChart;
        
    }
    
    
    private VBox createTopPane() {
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));
        
        vbox.getChildren().addAll(savingsPane(), interestPane());
        
        return vbox;
    }
        
    
    private BorderPane savingsPane() {
        savingsSlider = new Slider(25, 250, 5);
        Label savingsLabel = new Label(Double.toString(savingsSlider.getValue()));  //set with initial value of the slider
        
        // slider event handler
        savingsSlider.valueProperty()
            .addListener((change, oldValue, newValue) -> {
                savingsLabel.setText(Double.toString(newValue.doubleValue()));
                
                calc.setSavings(newValue.doubleValue());
                calcNoInterest.setSavings(newValue.doubleValue());
                //update chart
                updateLineChart();
                    
            });
                
        BorderPane upperPane = new BorderPane();
        upperPane.setLeft(new Label("Monthly savings"));
        upperPane.setCenter(savingsSlider);
        upperPane.setRight(savingsLabel);
        
        return upperPane;    
    }
    
    
    private BorderPane interestPane() {
        interestSlider = new Slider(0, 10, 1);
        Label interestLabel = new Label(Double.toString(interestSlider.getValue()));
        
        //slider event handler
        interestSlider.valueProperty()
            .addListener((change, oldValue, newValue) -> {
               interestLabel.setText(Double.toString(newValue.doubleValue()));
               
               calc.setInterest(newValue.doubleValue());
               //update chart
               updateLineChart();
               
            });
        
        BorderPane bottomPane = new BorderPane();
        bottomPane.setLeft(new Label("Yearly interest rate"));
        bottomPane.setCenter(interestSlider);
        bottomPane.setRight(interestLabel);
        
        return bottomPane;
    }
    
    
    private void updateLineChart() {
        dataSeries.getData().clear();
        dataSeriesNoInterest.getData().clear();
        
        calc.setSavings(savingsSlider.getValue());
        calc.setInterest(interestSlider.getValue());
        calcNoInterest.setSavings(savingsSlider.getValue());
        
        double yearlySavings = calc.getSavings();
        double yearlySavingsNoInterest = calcNoInterest.getSavings();
        
        for (int i = 0; i <= 30; i++) {
            yearlySavings += calc.yearlyReturns();
            yearlySavingsNoInterest += calcNoInterest.getSavings();//calc.yearlyReturnsNoInterest();
            dataSeries.getData().add(new XYChart.Data<>(i, yearlySavings));
            dataSeriesNoInterest.getData().add(new XYChart.Data<>(i, yearlySavingsNoInterest));
        }
    }
    
}

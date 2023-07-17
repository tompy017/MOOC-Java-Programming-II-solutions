package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        // create x and y axis that the chart is going to use
        NumberAxis xAxis = new NumberAxis(2006, 2018, 2); //optional lower and upper bound and number of ticks between them 
        NumberAxis yAxis = new NumberAxis(0, 100, 10);
        // title of axis
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");
        
        // create linechart using the axis as numbers
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai ranking");
        
        
        // create dataset
        XYChart.Series helsinki = new XYChart.Series();
        helsinki.setName("University of Helsinki");
        
        // and single points into the data set
        helsinki.getData().add(new XYChart.Data(2007, 73));
        helsinki.getData().add(new XYChart.Data(2008, 68));
        helsinki.getData().add(new XYChart.Data(2009, 72));
        helsinki.getData().add(new XYChart.Data(2010, 72));
        helsinki.getData().add(new XYChart.Data(2011, 74));
        helsinki.getData().add(new XYChart.Data(2012, 73));
        helsinki.getData().add(new XYChart.Data(2013, 76));
        helsinki.getData().add(new XYChart.Data(2014, 73));
        helsinki.getData().add(new XYChart.Data(2015, 67));
        helsinki.getData().add(new XYChart.Data(2016, 56));
        helsinki.getData().add(new XYChart.Data(2017, 56));
        
        
        
        // add dataset to lineChart
        lineChart.getData().add(helsinki);
 
        
        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }

}

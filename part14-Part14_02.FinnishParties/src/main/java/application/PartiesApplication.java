package application;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        Map<String, Map<Integer, Double>> values = new HashMap<>();
        
        try (Scanner file = new Scanner(Paths.get("partiesdata.tsv"))){
            
            //first line title of file
            String[] years = file.nextLine().split("\t");
            
            while (file.hasNextLine()) {
                
                String line = file.nextLine();
                String[] parts = line.split("\t");
                String partyName = parts[0];
                
                Map<Integer, Double> partyData = new HashMap<>();
                //add values to HashMap
                for (int i = 1; i < years.length; i++) {
                    
                    int year = Integer.valueOf(years[i]);
                    
                    if (parts[i].equals("-")) {
                        continue;
                    }
                    
                    double value = Double.valueOf(parts[i]);
                    partyData.put(year, value);
                }
                
                values.put(partyName, partyData);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        //Charts
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);
        
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        
        values.keySet()                      // each KEY (returned as a set)
                .stream()
                .forEach(party -> {
                    XYChart.Series data = new XYChart.Series();
                    data.setName(party);
                    
            values.get(party).entrySet()
                    .stream()
                    .forEach(pair -> {
                        data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
                
                    });
            
            
            lineChart.getData().add(data);        
                    
                    
                });
        
        
        
        Scene scene = new Scene(lineChart, 640, 480);        
        stage.setScene(scene);
        stage.show();
    }
    
    
}

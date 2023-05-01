
//import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;

public class LiteracyComparison {
    
    public static void main(String[] args) {
                
        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(line -> line.split(","))
                    .map(data -> new 
        Literacy(data[3], Integer.valueOf(data[4]), data[2].trim().split(" ")[0], Double.valueOf(data[5])))
                    .sorted()
                    .forEach(result -> System.out.println(result));
        
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}

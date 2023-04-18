
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author tom
 */
public class VehicleRegistry {
    
    private HashMap<LicensePlate, String> registry;

    
    public VehicleRegistry() {
        this.registry = new HashMap<>();
    }
    
    
    public boolean add(LicensePlate licensePlate, String owner) {
        if (registry.containsKey(licensePlate)) {
            return false;  
        }
        
        registry.put(licensePlate, owner);
        
        return true;
    }
    
    
    public String get(LicensePlate licensePlate) {
        return registry.get(licensePlate);
    }
    
    public boolean remove(LicensePlate licensePlate) {
        if (registry.containsKey(licensePlate)) {
            registry.remove(licensePlate);
            
            return true;
        }
        return false;  
    }
    
    /*
    public boolean remove(LicensePlate licensePlate) {
        if (!owners.containsKey(licensePlate)) {
            return false;
        }
        owners.remove(licensePlate);
        return true;
        }
    */
    
    
    public void printLicensePlates() {
        for (LicensePlate license : registry.keySet()) {
            System.out.println(license);
        }
    }
    
    public void printOwners() {
        ArrayList<String> owners = new ArrayList<>();
        
        for (String owner : registry.values()) {
            if (owners.contains(owner)) {
                continue;
            }
            
            System.out.println(owner);
            owners.add(owner);
        }
    }
}

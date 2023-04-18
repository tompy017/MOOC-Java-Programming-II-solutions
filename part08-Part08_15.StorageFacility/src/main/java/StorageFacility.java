
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author tom
 */
public class StorageFacility {
    
    private final HashMap<String, ArrayList> storageFacility;
    
    public StorageFacility() {
        this.storageFacility = new HashMap<>();
    }
    
    public void add(String unit, String item) {
        storageFacility.putIfAbsent(unit, new ArrayList<>());
        storageFacility.get(unit).add(item);
    }
    
    /*
    Returns an array with all the items that it contains. If there are no items
    or if the storage unit doesn't exists, it returns an empty arrayList
    */
    public ArrayList<String> contents(String storageUnit) {
        return storageFacility.getOrDefault(storageUnit, new ArrayList<>());
    }
    
    
    public void remove(String storageUnit, String item) {
        if (this.storageFacility.containsKey(storageUnit)) {
            this.storageFacility.get(storageUnit).remove(item);
        }
        if (this.storageFacility.get(storageUnit).isEmpty()) {
            this.storageFacility.remove(storageUnit);
        }
    }
    
    public ArrayList<String> storageUnits() {
        ArrayList<String> notEmptyUnits = new ArrayList<>();
        
        for (String unit : this.storageFacility.keySet()) {
            if (!this.storageFacility.get(unit).isEmpty()) {
                notEmptyUnits.add(unit);
            }
        }
        return notEmptyUnits;
    }
}

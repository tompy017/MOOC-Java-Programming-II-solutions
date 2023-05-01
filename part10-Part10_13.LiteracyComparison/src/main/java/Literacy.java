
/**
 *
 * @author tom
 */
public class Literacy implements Comparable<Literacy> {
    
    private String country;
    private int yearOfData;
    private String gender;
    private double percent;
    
    
    public Literacy(String name, int year, String gender, double percent) {
        this.country = name;
        this.yearOfData = year;
        this.gender = gender;
        this.percent = percent;
    }

    public String getCountry() {
        return country;
    }

    public int getYearOfData() {
        return yearOfData;
    }

    public String getGender() {
        return gender;
    }

    public double getPercent() {
        return percent;
    }
     
    
    @Override
    public String toString() {
        return this.country + " (" + this.yearOfData + "), " 
                + this.gender + ", " + this.percent;
    }

    @Override
    public int compareTo(Literacy l) {
        if (this.percent == l.getPercent()) {
            return 0;
        } else if (this.percent < l.getPercent()) {
            return -1;
        }
        return 1;
    }
}

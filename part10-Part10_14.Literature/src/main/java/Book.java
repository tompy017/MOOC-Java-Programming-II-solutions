
/**
 *
 * @author tom
 */
public class Book {
    
    private String title;
    private int recommendedAge;
    
    
    public Book(String title, int age) {
        this.title = title;
        this.recommendedAge = age;
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getRecommendedAge() {
        return recommendedAge;
    }
    
    @Override
    public String toString() {
        return this.title + " (recommended for " + this.recommendedAge + " years-old or older)"; 
    }
    
}

package validating;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        
        if (name == null || name.isEmpty() || name.length() > 40 
                || age < 0 || age > 120) {
            throw new IllegalArgumentException("Name can't be empty or over 40 chars.");
        }
        
        
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

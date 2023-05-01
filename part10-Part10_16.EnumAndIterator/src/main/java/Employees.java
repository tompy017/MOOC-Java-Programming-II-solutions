
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author tom
 */
public class Employees {
    
    private List<Person> employees;
    
    
    public Employees() {
        this.employees = new ArrayList<>();
    }
    
    
    public void add(Person personToAdd) {
        this.employees.add(personToAdd);
    }
    
    
    public void add(List<Person> peopleToAdd) {
        peopleToAdd.stream().forEach(person -> this.employees.add(person));       
    }
    
    public void print() {
        Iterator<Person> iterator = this.employees.iterator();
        iterator.forEachRemaining(employee -> System.out.println(employee));
        /*this.employees.stream()
                .forEach(employee -> System.out.println(employee));*/
    }
    
    public void print(Education education) {
        Iterator<Person> iterator = this.employees.iterator();
        
        while (iterator.hasNext()) {
            Person p = iterator.next();
            if (p.getEducation() == education) {
                System.out.println(p);
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> iterator = this.employees.iterator();
        
        while (iterator.hasNext()) {
            if (iterator.next().getEducation() == education) {
                iterator.remove();
            }
        }
    }
    
    
}

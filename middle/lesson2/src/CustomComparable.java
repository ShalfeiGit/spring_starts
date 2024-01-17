import java.util.ArrayList;
import java.util.Collections;

public class CustomComparable {
    public static void main(String[] args) {
        ArrayList<Employee> array = new ArrayList<>();
        array.add(new Employee(5, "»ван", 10000));
        array.add(new Employee(4, "»ль€", 2000));
        array.add(new Employee(3, "яна", 750));
        array.add(new Employee(2, "Zina", 450));
        array.add(new Employee(1, "Valya", 750));
        System.out.println(array);
        Collections.sort(array);
        System.out.println(array);
    }
}

class Employee implements Comparable<Employee> {
    Integer id;
    String name;
    int salary;

    Employee (Integer id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "{" + "id: " + id + ", name: " + name + ", salary: " + salary + "}";
    }

    @Override
    public int compareTo(Employee emp) {
//        return this.salary > emp.salary ? 1 : this.salary < emp.salary ? -1 : 0;
//        return this.id.compareTo(emp.id);
        return this.name.compareTo(emp.name);

    }
}

package CustomLambda;
import java.util.ArrayList;
import java.util.function.*;

public class CustomLambda {
  
}
class Employee {
  String name;
  String department;
  int salary;
  Employee(String name, String department, int salary){
    this.name = name;
    this.department = department;
    this.salary = salary;

  }

}

class TestEmployee{
  static void printEmployee (Employee emp){
    System.out.println("Name: " + emp.name + ", department: " + emp.department + ", salary: " + emp.salary);
  }
  static void filterEmployee (ArrayList <Employee> array, Predicate<Employee> filter ) {
    for(Employee emp:array){
      if(filter.test(emp)){
        printEmployee(emp);
      }
    }
    System.out.println("");
  }
  public static void main(String[] args) {
    ArrayList <Employee> array = new ArrayList<>();
    array.add(new Employee("Ivan", "IT", 100));
    array.add(new Employee("Levan", "Levan", 200));
    array.add(new Employee("Kostya", "C", 300));
    array.add(new Employee("Igor", "IT", 150));
    array.add(new Employee("Evgenii", "B", 500));
    array.add(new Employee("Vova", "IT", 450));

    filterEmployee(array, emp -> emp.department == "IT" && emp.salary > 200);
    filterEmployee(array, emp -> emp.name.startsWith("E") && emp.salary != 450);
    filterEmployee(array, emp -> emp.department == emp.name);
  }
}

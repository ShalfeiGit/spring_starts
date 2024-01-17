package AccessModifiers2;

import AccessModifiers.Employee;

public class B {
  public static void main(String[] args) {
    Employee employee1 = new Employee(500);
    
    employee1.showSalary();
    employee1.showId();
    employee1.showSurname();
  }
}

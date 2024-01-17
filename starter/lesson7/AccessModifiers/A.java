package AccessModifiers;

public class A {
  public static void main(String[] args) {
    Employee employee1 = new Employee(500);
    Employee employee3 = new Employee(500, "Ivanov", 5);

    employee1.showSalary();
    employee1.showId();
    employee1.showSurname();

    employee3.showSalary();
    employee3.showId();
    employee3.showSurname();
  }
}

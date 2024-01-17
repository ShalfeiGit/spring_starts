package AccessModifiers;

public class Employee {
  private int salary;
  public String surname;
  int id;

  public Employee(int salary){
    this(salary, "Ivanov", 5 );
  }

  private Employee(int salary, String surname){
    this(salary, surname, 5);
  }

  Employee(int salary, String surname, int id){
    this.id = id;
    this.salary = salary;
    this.surname = surname;
  }

  public void showSalary(){
    System.out.println(salary);
  }

  public void showId(){
    System.out.println(id);
  }

  public void showSurname(){
    System.out.println(surname);
  }

  public static void main(String[] args) {
    Employee employee1 = new Employee(500);
    Employee employee2 = new Employee(500, "Ivanov");
    Employee employee3 = new Employee(500, "Ivanov", 5);

    employee1.showSalary();
    employee1.showId();
    employee1.showSurname();

    employee2.showSalary();
    employee2.showId();
    employee2.showSurname();

    employee3.showSalary();
    employee3.showId();
    employee3.showSurname();
  }

}

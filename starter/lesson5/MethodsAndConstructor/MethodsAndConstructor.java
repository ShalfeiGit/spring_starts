package MethodsAndConstructor;

public class MethodsAndConstructor {
  public static void main(String[] args) {
    BankAccount bA = new BankAccount(50);
    bA.info();
    bA.replenishmentAccount(5);
    bA.info();
    bA.cashWithdrawal(10);
    bA.info();
  }
}

class BankAccount {
  int account;

  BankAccount(int cash){
    account = cash;
  }

  int replenishmentAccount(int cash){
    return account += cash;
  }
  
  int cashWithdrawal(int cash){
    return account += cash;
  }

  void info(){
    System.out.println(account);
  }
}

class Employee {
  int id;
  String surname;
  int age;
  int salary;
  String department;

  Employee(int id1, String surname1, int age1, int salary1, String department1){
    id = id1;
    surname = surname1;
    age = age1;
    salary = salary1;
    department = department1;
  }

  void replenishmentAccount (){
    salary *=2;
  }

  void info(Employee employee){
    System.out.println("Surname: " + employee.surname + " Account: " + employee.salary);
  }

}

class EmployeeTest {
  public static void main(String[] args) {
    Employee employee1 = new Employee(60, "Zaycev", 20, 500,  "Architectory");
    Employee employee2 = new Employee(60, "Tulev", 25, 600,  "Arts");
    employee1.info(employee1);
    employee2.info(employee2);
    employee1.replenishmentAccount(); 
    employee2.replenishmentAccount();
    employee1.info(employee1);
    employee2.info(employee2);

  }
}
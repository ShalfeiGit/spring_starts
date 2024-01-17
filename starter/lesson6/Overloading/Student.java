package Overloading;

public class Student {
  int id;
  int year;
  String name;  
  String surname;
  String course;

  Student(){
    this(2003, 2, "Ivan", "Zadornov",  "Java");
  }

  Student(int year, int id, String name, String surname, String course){
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.course = course;
    this.year = year;
  }

  Student(int id, String name, String surname, String course){
    this(2004, id, name, surname,  course);
  }
}

class StudentTest {

  public static void main(String[] args) {
    Student student = new Student();
    Student student1 = new Student(2003, 2, "Ivan1", "Zadornov",  "Java");
    Student student2 = new Student( 2, "Ivan2", "Zadornov",  "Java");
    System.out.println(student.name);
    System.out.println(student1.name);
    System.out.println(student2.name);

  }
}

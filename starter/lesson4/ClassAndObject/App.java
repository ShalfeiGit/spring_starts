package ClassAndObject;

public class App {
  
}

class Student {
  int numberStudentTicket;
  String name;
  String surname;
  int yearOfEducation;
  int mathGrade;
  int economyGrade;
  int englishGrade;
}

class StudentTest {
  double showMiddleGrade(Student student) {
    return (student.economyGrade + student.mathGrade + student.englishGrade)/3.0;
  }

  public static void main(String[] args) {
    StudentTest test = new StudentTest();
    Student student1 = new Student();    
    Student student2 = new Student();
    Student student3 = new Student();
    
    student1.numberStudentTicket = 1;
    student1.name = "Ivan";
    student1.surname = "Zaycev";
    student1.yearOfEducation = 2003;
    student1.economyGrade = 4;    
    student1.mathGrade = 3;
    student1.englishGrade = 4;

    student2.numberStudentTicket = 2;
    student2.name = "Petr";
    student2.surname = "Laow";
    student2.yearOfEducation = 2004;
    student2.economyGrade = 2;    
    student2.mathGrade = 1;
    student2.englishGrade = 2;

    student3.numberStudentTicket = 3;
    student3.name = "Stas";
    student3.surname = "Igorev";
    student3.yearOfEducation = 2001;
    student3.economyGrade = 3;    
    student3.mathGrade = 2;
    student3.englishGrade = 3;

    System.out.println("Student: " + student1.name + " " + student1.surname +  ", Grade: " +  test.showMiddleGrade(student1));
    System.out.println("Student: " + student2.name + " " + student2.surname +  ", Grade: " +  test.showMiddleGrade(student2));
    System.out.println("Student: " + student3.name + " " + student3.surname +  ", Grade: " +  test.showMiddleGrade(student3));
  }

   
}
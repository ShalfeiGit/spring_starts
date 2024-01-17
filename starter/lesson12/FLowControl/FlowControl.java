package FLowControl;

public class FlowControl {
  public static void main(String[] args) {
    Student student1 = new Student("Ivanov", 6); 
    Student student2 = new Student("Ivanov", 6);
    

    Student.equalsInstance(student1, student2); 
    Student.deepEqualsInstance(student1, student2);
  }

}

class Student {

  String name;
  int grade;

  Student(String name, int grade){
    this.name = name;
    this.grade = grade;
  }

  static void equalsInstance(Student instance1, Student instance2){
    if(instance1 == instance2){
      System.out.println("Объекты равны");
    } else {
      System.out.println("Объекты не равны");
    }
  }

  static void deepEqualsInstance(Student instance1, Student instance2){
    if(!instance1.name.equals(instance2.name)){
      System.out.println("ОБъекты не равны, имена различаются");
    } else if (!(instance1.grade == instance2.grade)) {
      System.out.println("ОБъекты не равны, оценки различаются");
    } else {
      System.out.println("Объекты равны");
    }

  }

}

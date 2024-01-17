package Encapsulation;

import javax.sound.midi.Soundbank;

public class Encapsulation {
  
}

class Student{
  private StringBuilder name;
  private int course;
  private int grade;

  void setName(StringBuilder n){
    if(n.length() > 3){
      name = n;
    }
  }

  void setCourse(int c){
    if(1 < c && c < 4){
      this.course = c;
    }
  }

  void setGrade(int g){
    if(3 < g && g < 10){
      this.grade = g;
    }
  }

  StringBuilder getName(){
    return new StringBuilder(this.name);
  }

  int getCourse(){
    return course ;
  }

  int getGrade(){
    return grade;
  }

  void showInfo(){
    System.out.println("StudentInfo: " + "name: " + this.name + ", course: " + this.course + ", grade: " + this.grade);
  }
}

class TestStudent {
  public static void main(String[] args) {
    Student student =  new Student();
    student.setName(new StringBuilder("Ivan"));
    student.setCourse(2);
    student.setGrade(6);

    student.showInfo();

  }
}

class Animal{
  Animal(){
    System.out.println("I am animal");
  }
  int eyes;
  void eat(){
    System.out.println("Animal eats");
  }
  void drink(){
    System.out.println("Animal drinks");
  }
}

class Pet extends Animal {
  Pet(){
    super.eyes = 2;
    System.out.println("I am pet");
  }
  String name;
  int tail = 1;
  int paw = 4;
  void run(){
    System.out.println("Pet runs");
  }
  void jump(){
    System.out.println("Pet jumps");
  }
}

class Dog extends Pet {
  Dog(String name){
    super.name = name;
    System.out.println("I am a dog and my name is: " + super.name );
  }
  void plays (){
    System.out.println(" Cat palys");
  }
}

class Cat extends Pet {
  Cat(String name){
    super.name = name;
    System.out.println("I am a cat and my name is: " + super.name );
  }
  void sleep (){
    System.out.println(" Cat sleeps");
  }
}

class Test {
  public static void main(String[] args) {
    Cat cat = new Cat("Tosik");
    cat.sleep();
    Dog dog = new Dog("Toshka");
    System.out.println(dog.paw);
  }
}
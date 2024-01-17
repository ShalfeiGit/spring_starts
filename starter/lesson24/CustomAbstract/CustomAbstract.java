package CustomAbstract;

public class CustomAbstract {
  public static void main(String[] args) {
    Mechenosec mechenosec = new Mechenosec("Pushka");
    System.out.println(mechenosec.name);
    mechenosec.eat();
    mechenosec.sleep();
    mechenosec.swim();
    
    Speakable speakable = new Pingvin("Vush");
    speakable.speak();

    Animal lev1 = new Lev("Carb");
    System.out.println(lev1.name);
    lev1.eat();
    lev1.sleep();

    Mammal lev2 = new Lev("Scrab");
    System.out.println(lev2.name);
    lev2.eat();
    lev2.run();
    lev2.speak();
    lev2.sleep();

    Speakable [] array1 = { speakable, lev2  };
    Animal [] array2 = {mechenosec, lev1, lev2 };

    for(Speakable a: array1){
      if(a instanceof Speakable){
        a.speak();
      }
      if(a instanceof Lev){
        a.speak();
        System.out.println(((Lev)a).name);
        ((Lev)a).run();
        ((Lev)a).sleep();
        ((Lev)a).eat();
      }
    }
    for(Animal a: array2){
      if(a instanceof Animal){
        System.out.println(a.name);
        a.eat();
        a.sleep();
      }
    }

  }
}

abstract class Animal {
  String name;
  Animal(String name){
    this.name = name;
  }
  abstract void eat();
  abstract void sleep();
}

abstract class Fish extends Animal {
  Fish(String name){
    super(name);
  }
  void sleep(){
    System.out.println("Всегда интересно наблюдать, как спят рыбы");
  }
  abstract void swim();
}

abstract class Bird extends Animal implements Speakable {
  String name;
  Bird(String name){
    super(name);
    this.name = name;
  }
  abstract void fly();
  public void speak(){
    System.out.println(name + " говорит");
  }
}

abstract class Mammal extends Animal implements Speakable{
  String name;
  Mammal(String name){
    super(name);
    this.name = name;
  }
  abstract void run();
}

interface Speakable {
  default void speak(){
    System.out.println("Кто-то говорит");
  }
}

class Mechenosec extends Fish {
  String name;
  Mechenosec(String name){
    super(name);
    this.name = name;
  }

  void swim (){
    System.out.println("Меченосец красивая рыба, которая быстро плавает");
  }

  void eat(){
    System.out.println("Меченосец не хищная рыба, и она есть рыбий корм");
  }
}


class Pingvin extends Bird {
  String name;
  Pingvin(String name){
    super(name);
    this.name = name;
  }
  public void speak (){
    System.out.println("Пингвин не умеет петь");
  }

  void eat(){
    System.out.println("Пингвины едят рыбу");
  }

   void sleep(){
    System.out.println("Пингвины спят прижавщись у друг другу");
  }
  
   void fly(){
    System.out.println("Пингвин не умеет летать");
  }
}

class Lev extends Mammal {
  String name;
  Lev(String name){
    super(name);
    this.name = name;
  }
  void eat(){
    System.out.println("Лев, как любой охотник ест мясо");
  }
  void sleep(){
    System.out.println("Большую часть дня лев спит");
  }
  void run (){
    System.out.println("Лев- не самая быстрая кошка");
  }
}

package MethodsParams;

public class Car {
  String color;
  String engine;
  int doors;

  Car(String color, String engine, int doors){
    this.color = color;
    this.engine = engine;
    this.doors = doors;
  }
}

class CarTest{

  void changeDoors (int doors, Car car){
    car.doors = doors; 
  }

   void swapCars (Car car1, Car car2){
    String color;
    color = car1.color;
    car1.color = car2.color;
    car2.color = color;
  }

  public static void main(String[] args) {
    Car car1 = new Car("red", "v6", 4);
    Car car2 = new Car("black", "v8", 2);
    CarTest carTest = new CarTest();

    carTest.changeDoors(10, car1);
    System.out.println(car1.doors);

    carTest.swapCars(car1, car2);
    System.out.println(car1.color);
    System.out.println(car2.color);


  }


}

package Modificators;

public class Modificators2 {
  static final double PI = 3.14;

  double countSquareCircle (int radius) {
    return PI * radius * radius;
  }

  static double countLengthCircle(int radius){
    return 2 * PI * radius;
  }

  void showInfo(int radius){
    System.out.println("Radius: " + radius + " Square: " + countSquareCircle(radius) + " LengthCircle: " + countLengthCircle(radius));
  }
}

class Modificators2Test {
  public static void main(String[] args) {
    Modificators2 modificators2 = new Modificators2();
    modificators2.showInfo(5);
  }
}

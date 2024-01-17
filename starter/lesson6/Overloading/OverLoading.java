package Overloading;

public class OverLoading {
  int summa(){
    System.out.println("Summa: " + 0);
    return 0;
  }
  int summa(int a){
     System.out.println("Summa: " + a);
    return a;
  }
  int summa(int a, int b){
     System.out.println("Summa: " + (a + b));
    return a + b;
  }
  int summa(int a, int b, int c){
     System.out.println("Summa: " + (a + b + c));
    return a + b + c;
  }
  int summa(int a, int b, int c, int d){
    System.out.println("Summa: " + (a + b + c + d));
    return a + b + c + d;
  }

  public static void main(String[] args) {
    OverLoading overLoading = new OverLoading();
    overLoading.summa();
    overLoading.summa(1);
    overLoading.summa(1, 2);
    overLoading.summa(1, 2, 3);
    overLoading.summa(1, 2, 3, 4);
  }
}

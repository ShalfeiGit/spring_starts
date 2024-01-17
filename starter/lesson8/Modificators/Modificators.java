package Modificators;



public class Modificators {
  static int summa(int a, int b, int c){
    return a + b + c;
  }

  static void delenie(int a, int b){
    System.out.println("Resultat delenia: Celoe - " + (a/b) + " Ostatok - " + (a%b));
  }
}

class ModificatorsTest {

  public static void main(String[] args) {
    System.out.println(Modificators.summa(1, 2, 3) );
    Modificators.delenie(9, 2);

    System.out.println(Modificators.summa(3, 4, 5) );
    Modificators.delenie(18, 2);
   
  }
}

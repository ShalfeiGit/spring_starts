package p4;

import p1.A;
import static p1.p2.B.showB1;
import p1.p2.*;
import p1.p2.p3.C;
import p4.p5.E;

public class D {
  int d = 5;
  static int d1 = 4;

  void showD(){
    System.out.println(d);
  }

  static void showD1(){
    System.out.println(d1);
  }

  public static void main(String[] args) {
    A a = new A();
    a.showA();
    A.showA1();
    
    B b = new B();
    b.showB();
    showB1();

    C c = new C();
    c.showC();
    C.showC1();

    E e = new E();
    e.showE();
    E.showE1();
  }
}

package p2;

import p1.*;

public class Y extends X {
  Y(){}
  public void abc() { System.out.println("Y");}
  public void def(){ Y y =  new Y(); y.abc();}
  public void ghi(){ X x =  new Y(); x.abc();}

  public static void main(String[] args) {
    Y y = new Y();
    y.abc();
    y.def();
    y.ghi();

  }
  
}

package p1;

public class X {
  public X(){};
  public X(int i){
    System.out.println("X" + i);
  };
  private boolean lkm(){ return false;}

  public void abc(){
    System.out.println("X");
  }
  public static void main(String[] args) {
    X x = new K(18);
    System.out.println(x.lkm());
  }
}

class K extends X{
  public K(int i){
    System.out.println("K");
  };
  private boolean lkm(){ return true;}
}


class M{}
class N extends M {}
class G {
  public static void abc(M m, N n) {
    System.out.println("Privet");
    
  }
  public static void abc(N n, M m) {
    System.out.println("Poka");
  }
  public static void main(String[] args) {
    N a = new N();
    G.abc(a, a);
  }
}


class L{
  String s1 = "privet";
}
class P extends L{
  boolean bool = false;
}

class TestL {
  public static void main(String[] args) {
    L l = new P();
    System.out.println(l.s1 +" "+l.bool);
  }
}



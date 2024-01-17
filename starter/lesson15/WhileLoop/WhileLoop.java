package WhileLoop;

public class WhileLoop {
  public static void showtime(){
    int i = 0;
    OUTER: while(i<6){
      int j = -1;
      MIDDLER: 
        do{
          int k = 0;
          j++;
          if(i>1 && j%10 == 0){
            break OUTER;
          }
          INNER: 
            while(k<60){
              if(k*i > j){
                continue MIDDLER;
              }
              System.out.println(i+":"+j+":"+k);
              k++;
            }
        
        }while(j<59);
      i++;
    }
  }
  public static void main(String[] args) {
    WhileLoop.showtime();
  }
}

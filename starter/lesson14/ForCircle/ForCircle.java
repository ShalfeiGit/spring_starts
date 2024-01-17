package ForCircle;

public class ForCircle {
  public static void showtime(){
    OUTER: for(int i=0; i<6; i++){
      MIDDLER: for(int j=0; j<60; j++){
        if(i>1 && j%10 == 0){
          break OUTER;
        }
        for(int k=0; k<60; k++){
          if(k*i > j){
            continue MIDDLER;
          }
          System.out.println(i+":"+j+":"+k);
        }
      }
    }
  }
  public static void main(String[] args) {
    ForCircle.showtime();
  }
}

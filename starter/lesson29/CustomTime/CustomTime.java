package CustomTime;

import java.time.format.*;
import java.time.*;

 
public class CustomTime {
  DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy, MMMM-d !! HH:mm "); 
  DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("hh:mm, dd/MMM/yy");
  void smena (LocalDateTime ldt1, LocalDateTime ldt2, Period p){
    LocalDateTime innerLdt1 = ldt1;
    do{
      System.out.print("Работаем с: "+ innerLdt1.format(dateTimeFormatter1) + " ");
      innerLdt1 = innerLdt1.plus(p);
      System.out.print("До: "+ innerLdt1.format(dateTimeFormatter2) + " ");
      System.out.println();
    }while(innerLdt1.isBefore(ldt2));
  }
  public static void main(String[] args) {
    CustomTime customTime = new CustomTime();
    LocalDateTime  ldt1 = LocalDateTime.of(2023, 1, 1, 1, 1, 1);
    LocalDateTime  ldt2 = LocalDateTime.of(2023, 11, 1, 1, 1, 1);
    Period p = Period.ofMonths(1);
    customTime.smena(ldt1, ldt2, p);
  }
}

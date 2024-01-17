package CustomArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;

public class CustomArrayList {
  void deleteReplaceItems(String ... defaultArray){
    
    ArrayList <String> arrayList = new ArrayList<>();
    List <String> defaultList = Arrays.asList(defaultArray);
    Iterator <String> it = defaultList.iterator();
    while(it.hasNext()){
      String item = it.next();
      if(!arrayList.contains(item)){
        arrayList.add(item);
      }
      
    }
    Collections.sort(arrayList);
    for(String item: arrayList){
      System.out.print(item + " ");
    }
  }
  public static void main(String[] args) {
    CustomArrayList customArrayList = new CustomArrayList();
    customArrayList.deleteReplaceItems("privet", "buy", "no", "buy", "no", "one");
  }
}

public class CustomForeach {
  String [][] replacedDuplicatedStringToNull(String [] ... target){
    String [] [] array = new String[target.length][];
      int i = 0;
      for (String[] customStrings : target) {
        array[i] = customStrings;
        i++;
      }
    return array;
  }
  public static void main(String[] args) {
    CustomForeach customForeach = new CustomForeach();
    String[][] target = new String[3][];
    int i = 0;
    for (String[] customStrings : target) {
      target[i] = args;
      i++;
    }

    String[][] items = customForeach.replacedDuplicatedStringToNull(target);
    int j = 0;
    for (String[] customStrings : items) {
      int k = 0;
      for (String strings : customStrings) {
        if(target[j][k].equals(strings)){
          items[j] = null;
        }
        k++;
      }
      j++;
    }

    for (String[] customStrings : items) {
      System.out.println(customStrings);
    }
  }

}

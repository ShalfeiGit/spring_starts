package CustomArrays;

public class CustomArrays {

  void customSort(int ... defaultArray){
    int [] array = defaultArray;
     
    for (int i = 0; i < array.length - 1; i++) {
      for(int j = 0; j < array.length - i - 1; j++) {
        if(array[j + 1] < array[j]) {
            int swap = array[j];
            array[j] = array[j + 1];
            array[j + 1] = swap;
        }
      }
    }
   for(int a: array){
        System.out.print(a + " ");
      }
  }

  void showArray(String [][] array){
    System.out.print("{ ");
    for (int i = 0; i < array.length; i++) {
      System.out.print("{ ");
      for(int j = 0; j < array[i].length; j++) {
       System.out.print(array[i][j] + (j != array[i].length - 1 ? ", " : "" ));
      }
      System.out.print(" }");
    }
     System.out.print(" }");
  }


  public static void main(String[] args) {
    int arr[] = { 64, 34, 25, 90, 12, 22, 11 };
    CustomArrays customArrays = new CustomArrays();
    customArrays.customSort(arr);
    String [][] array = {{"a"},{"b", "c", "d"},{"e", "f"},{"g", "h"}};
    customArrays.showArray(array);
    
  }
}

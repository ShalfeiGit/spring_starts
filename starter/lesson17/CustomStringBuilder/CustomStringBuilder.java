package CustomStringBuilder;

public class CustomStringBuilder {
  boolean customEquals(StringBuilder string1, StringBuilder string2){
    boolean isEquals = true;
    if(string1.length() != string2.length() ){
      return isEquals = false;
    }

    for(int i = 0; i < string1.length(); i++){
      if(string1.charAt(i) != string2.charAt(i)){
        isEquals = false;
      }
    }
    return isEquals;
  }
  public static void main(String[] args) {
    CustomStringBuilder customStringBuilder = new CustomStringBuilder();
    StringBuilder string1 = new StringBuilder("Hello");
    StringBuilder string2 = new StringBuilder("Hello");

    System.out.println(customStringBuilder.customEquals(string1, string2));
  }
}

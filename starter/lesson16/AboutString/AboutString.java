package AboutString;

public class AboutString {
  void getEmail(String emails){
    String currentEmail = "";
    boolean addCharToString = false;
    for(int letter=0; letter < emails.length(); letter++){
      if(emails.charAt(letter) == '@'){
        addCharToString= true;
      } else if(emails.charAt(letter) == '.'){
        System.out.println(currentEmail);
        currentEmail = "";
        addCharToString= false;
      } 
      else if(addCharToString){
        currentEmail = currentEmail.concat(emails.substring(letter, letter+1));
      } 
    }
  }
  public static void main(String[] args) {
    AboutString aboutString = new AboutString();
    aboutString.getEmail("ya@yahoo.com; on@mail.ru; ona@gmail.com;");
  }
}

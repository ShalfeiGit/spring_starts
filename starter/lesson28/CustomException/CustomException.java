package CustomException;

public class CustomException {
  

}

class NeMyasoException extends RuntimeException {
  NeMyasoException(String message){
    super(message);
  }
}

class NeVodaException extends Exception {
  NeVodaException(String message){
    super(message);
  }
}

class Tiger {
  void eat(String food) throws NeMyasoException {
    if(food == "myaso"){
      System.out.println("Tigr est myaso"); 
    } else{
        throw new NeMyasoException("Tigr ne est " + food);
    };

  }
  void drink (String drinks) throws NeVodaException{
    if(drinks == "voda"){
      System.out.println("Tigr pyet vodu");
    } else{
        throw new NeVodaException("Tigr ne pyet " + drinks);
    };
    
  }
}

class Test {
  public static void main(String[] args) {
    Tiger tiger = new Tiger();
    tiger.eat("myaso");
    try{
      tiger.drink("voda");
      try{
        tiger.drink("pivo");
      } catch(NeVodaException e){
        System.out.println(e.getMessage()); 
      } catch(Exception e){
      System.out.println(e.getMessage()); 
    }  
      finally {
          System.out.println("Eto inner finally block"); 
      }
    } catch(RuntimeException e){
      System.out.println(e.getMessage()); 
    } catch(Exception e){
      System.out.println(e.getMessage()); 
    } 

  }
}
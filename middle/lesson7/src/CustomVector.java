import java.util.Stack;
import java.util.Vector;

public class CustomVector {

    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("A");
        vector.add("B");
        vector.add("C");
        vector.add("D");
        for(String v:vector){
            System.out.println(v);
        }

        Stack<String> stack = new Stack<>();
        stack.push("F");
        stack.push("G");
        stack.push("H");
        stack.push("I");
        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}

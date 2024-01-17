import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class CustomScanner {
    public static void main(String[] args) throws IOException {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Vvedite chislo");
        int i = scanner1.nextInt();
        System.out.println("Vvedenoe chislo: " + i);

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Input string s1");
        String s1 = scanner2.nextLine();
        System.out.println("Input string1: " + s1);
        System.out.println("Input string s2");
        String s2 = scanner2.next();
        System.out.println("Input string2: " + s2);

        Scanner scanner3 = new Scanner(new FileReader("test.txt"));
        while (scanner3.hasNext()){
            System.out.println(scanner3.next());
        }

    }
}

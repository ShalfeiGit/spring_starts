import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomRegex {
    public static void main(String[] args) {
        String testString = "This is test line. And this is additional time 6";
        String testString1 = "This is test line. And this is additional time 3124 6 75 84";
        Pattern pattern1 = Pattern.compile("This"); //����� �� ����������
        Pattern pattern2 = Pattern.compile("[lz]"); //����� ���� ����, ���� ������
        Pattern pattern3 = Pattern.compile("[A-Z]"); //����� ���� ������ �� ���������
        Pattern pattern4 = Pattern.compile("[m|y]"); //����� ���� ���� ����, ���� ������
        Pattern pattern5 = Pattern.compile("\\d"); //������������ ����� ����� \\D - �� �����, \\w-���� ����� ��� ����� ��� _
        Pattern pattern6 = Pattern.compile("(\\d\\d)");
        // \\W- �� \\w, \\s- ���������� ������, \\S - �� ������������ ��������,
        // ? - 0 ��� 1 ����������
        // * - 0 ��� �������� ����������� ����������
        // + - 1 ��� �������� ���������� ��������
        // {n} - ����������� ����������� ���������� n
        // {m, n} - ����������� ����������� ���������� �� m �� n
        // {n, } - ����������� n  � �������� ���������� ����������
        // . - ����� ������
        // ^ - ��������� � ������ ������
        // $ - ��������� � ����� ������
        // \A - ������������� ������ ������ ������
        // \Z - ������������� ����� ������ ������
        // \b - ������������ ������� ����� ��� �����
        // \B - ������������� ������� �� ����� � �� �����


        Matcher matcher1 = pattern1.matcher(testString);
        Matcher matcher2 = pattern2.matcher(testString);
        Matcher matcher3 = pattern3.matcher(testString);
        Matcher matcher4 = pattern4.matcher(testString);
        Matcher matcher5 = pattern5.matcher(testString);
        Matcher matcher6 = pattern6.matcher(testString1);

        while(matcher1.find()){
            System.out.println(matcher1.start() + "  " + matcher1.group());
        }

        while(matcher2.find()){
            System.out.println(matcher2.start() + "  " + matcher2.group());
        }

        while(matcher3.find()){
            System.out.println(matcher3.start() + "  " + matcher3.group());
        }

        while(matcher4.find()){
            System.out.println(matcher4.start() + "  " + matcher4.group());
        }

        while(matcher5.find()){
            System.out.println(matcher5.start() + "  " + matcher5.group());
        }

        String testString2 = "3";
        boolean result = testString2.matches("\\d");
        System.out.println(result);

        String [] array = testString1.split(" ");
        for(String s:array){
            System.out.println(s);
        }

        while (matcher6.find()){
            System.out.println(matcher6.group(1));
        }

        String matcherString = matcher6.replaceAll("X");
        System.out.println(matcherString);
        System.out.printf("%15s %n", "random text");
        String s = String.format("a = %s, b = %03d, c = %d", "asdasd", 4, 3);
        System.out.println(s);
    }
}

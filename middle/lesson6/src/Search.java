import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Search {
    public static void main(String[] args) {
        ArrayList<Empoyee1> arrayList1 = new ArrayList<>();
        arrayList1.add(new Empoyee1("Ivan1"));
        arrayList1.add(new Empoyee1("Ivan2"));
        arrayList1.add(new Empoyee1("Ivan6"));
        arrayList1.add(new Empoyee1("Ivan4"));
        arrayList1.add(new Empoyee1("Ivan5"));
        Collections.sort(arrayList1);
        System.out.println(arrayList1);

        int index1 = Collections.binarySearch(arrayList1, new Empoyee1("Ivan4 "));
        System.out.println(index1);

        ArrayList<Empoyee2> arrayList2 = new ArrayList<>();
        arrayList2.add(new Empoyee2(1));
        arrayList2.add(new Empoyee2(42));
        arrayList2.add(new Empoyee2(8));
        arrayList2.add(new Empoyee2(10));
        arrayList2.add(new Empoyee2(6));
        Comparator<Empoyee2> comparator = (o1, o2) -> o1.age.compareTo(o2.age);
        Collections.sort(arrayList2, comparator);
        System.out.println(arrayList2);

        int index2 = Collections.binarySearch(arrayList2, new Empoyee2(10), comparator);
        System.out.println(index2);
    }
}
class Empoyee1 implements Comparable<Empoyee1> {
    String name;

    public Empoyee1(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Empoyee1{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Empoyee1 o) {
        return this.name.compareTo(o.name);
    }
}

class Empoyee2 {
 Integer age;

    @Override
    public String toString() {
        return "Empoyee2{" +
                "age=" + age +
                '}';
    }

    public Empoyee2(int age) {
        this.age = age;
    }
}

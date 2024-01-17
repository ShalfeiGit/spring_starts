import java.util.*;

public class CustomIterator {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("A1");
        arrayList1.add("B1");
        arrayList1.add("C1");
        arrayList1.add("D1");

        //Перебор Iterator
        Iterator<String> iterator = arrayList1.iterator();
        for (Iterator <String> it = iterator; it.hasNext();) {
            System.out.println(it.next());
        }

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("A2");
        arrayList2.add("B2");
        arrayList2.add("C2");
        arrayList2.add("D2");

        //Перебор ArrayList
        for (String s:arrayList2) {
            System.out.println(s);
        }

        LinkedList<String> linkedList3 = new LinkedList<>();
        linkedList3.add("A3");
        linkedList3.add("B3");
        linkedList3.add("C3");
        linkedList3.add("D3");
        //Перебор LinkedList
        for (String s:linkedList3) {
            System.out.println(s);
        }

        //Перебор ListIterator
        ListIterator<String> listIterator =  linkedList3.listIterator(linkedList3.size()); //устанавливаем курсор на конечный индекс
        for (ListIterator <String> it = listIterator; it.hasPrevious();) {
            System.out.println(it.previous());
        }
    }
}

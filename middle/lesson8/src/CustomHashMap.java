import java.util.*;

public class CustomHashMap {
    public static void main(String[] args) {
        // не хранит историю добавлени€ (способ хранени€ таблица по хэшкодам, плюс LinkedList дл€ элементов с одиновыми hashCode)
        Map<Integer, Student> map = new HashMap<>();
        Student st1 = new Student("Ivan");
        Student st2 = new Student("Anton");
        Student st3 = new Student("Jenia");
        Student st4 = new Student("Serega");
        Student st5 = new Student("Olya");
        Student st6 = new Student("Zina");
        map.put(1, st1);
        map.put(2, st2);
        map.put(3, st3);
        map.put(4, st4);
        map.put(5, st5);
        map.put(6, st6);
        System.out.println(map.get(3));
        System.out.println(st1.hashCode() == st6.hashCode());
        for (Map.Entry<Integer, Student> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        Comparator<Student> comparator = (o1, o2) -> o1.name.compareTo(o2.name);

        // сразу сортирует хранит в сбалансированных двочиных деревь€х (красно-черное дерево) используют дл€ поиска диопзонов, сортировка возможна с Compatarator
        TreeMap<Student, Integer> treeMap = new TreeMap<>(comparator);
        treeMap.put(st1, 5);
        treeMap.put(st2, 4);
        treeMap.put(st3, 3 );
        treeMap.put(st4, 7);
        treeMap.put(st5, 8);
        treeMap.put(st6, 9);
        for (Map.Entry<Student, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // хранит историю добавлени€
        LinkedHashMap<Integer, Student> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put(5, st1);
        linkedHashMap.put(4, st2);
        linkedHashMap.put(3, st3);
        linkedHashMap.put(7, st4);
        linkedHashMap.put(8, st5);
        linkedHashMap.put(9, st6);
        for (Map.Entry<Integer, Student> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // хранит по €чейкам без LinkedList - перезаписывает
        Hashtable<Integer, Student> hashTable = new Hashtable<>();
        hashTable.put(10, st1);
        hashTable.put(11, st2);
        hashTable.put(12, st3);
        hashTable.put(10, st1);
        hashTable.put(14, st5);
        hashTable.put(15, st6);
        for (Map.Entry<Integer, Student> entry : hashTable.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

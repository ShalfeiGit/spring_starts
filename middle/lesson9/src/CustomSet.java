import java.util.*;

public class CustomSet {
    public static void main(String[] args) {
        Set<Student> customSet = new HashSet<>();
        Student st1 = new Student("Ivan");
        Student st2 = new Student("Anton");
        Student st3 = new Student("Jenia");
        Student st4 = new Student("Serega");
        Student st5 = new Student("Olya");
        Student st6 = new Student("Zina");
        customSet.add(st1);
        customSet.add(st2);
        customSet.add(st3);
        customSet.add(st4);
        customSet.add(st5);
        customSet.add(st6);
        for(Student set:customSet){
            System.out.println(set);
        }

        // сразу сортирует хранит в сбалансированных двочиных деревьях (красно-черное дерево) используют для поиска диопзонов
        Comparator<Student> comparator = (o1, o2) -> o1.name.compareTo(o2.name);
        TreeSet<Student> treeSet = new TreeSet<>(comparator);
        treeSet.add(st1);
        treeSet.add(st2);
        treeSet.add(st3);
        treeSet.add(st4);
        treeSet.add(st5);
        treeSet.add(st6);
        for(Student set:treeSet){
            System.out.println(set);
        }

        // хранит историю добавления
        LinkedHashSet<Student> linkedHashSet = new LinkedHashSet<>(16, 0.75f);
        linkedHashSet.add(st2);
        linkedHashSet.add(st1);
        linkedHashSet.add(st3);
        linkedHashSet.add(st4);
        linkedHashSet.add(st5);
        linkedHashSet.add(st6);
        for(Student set:linkedHashSet){
            System.out.println(set);
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

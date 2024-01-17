import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CustomLambda {
    public static void main(String[] args) {
        CustomLambda customLambda = new CustomLambda();
        Student st1 = new Student(20, "Ivan");
        Student st2 = new Student(21, "Ivan");
        Student st3 = new Student(22,"Petya");
        Student st4 = new Student(23, "Ivan");
        Student st5 = new Student(24, "Jenya");
        ArrayList<Student> array = new ArrayList<>();
        array.add(st1);
        array.add(st2);
        array.add(st3);
        array.add(st4);
        array.add(st5);

        for(Student st:array){
            if(customLambda.checkAgeStudent(st, s -> s.age > 20)){
                System.out.println(st);
            }
        }
        System.out.println("_______________________________");
        for(Student st:array){
            if(customLambda.checkAgeStudent(st, s -> s.name == "Ivan")){
                System.out.println(st);
            }
        }
        //Supplier  - inner method accept()
        System.out.println("_______________________________");
        Consumer<Student> c = st -> st.age = 20;
        array.forEach(c);

        //Supplier  - inner method get()
        Supplier<Student> s = () -> {
            return new Student(22, "Ilya");
        };

        array.add(customLambda.makeStudent(s));

        //Predicate  - inner method test()
        Predicate<Student> p = st -> st.age < 21;
        array.removeIf(p);

        //Function  - inner method apply()
        Function<Student, Integer> f = st -> st.age;
        for(Student st:array){
            System.out.println(customLambda.getStudentAge(st, f));
        }
        System.out.println("_______________________________");
        for(Student st:array){
            System.out.println(customLambda.checkNameStudent(st, stud -> stud.name));
        }
    }

    boolean checkAgeStudent(Student st, CustomFilter f){
        return f.checkAge(st);
    }

    Student makeStudent(Supplier<Student> s){
        return s.get();
    }

    Integer getStudentAge(Student st, Function<Student, Integer> f){
        return f.apply(st);
    }

    String checkNameStudent(Student st, CustomFilterWithGeneric<Student> f){
        return f.checkName(st);
    }
}

interface CustomFilter {
    boolean checkAge(Student st);
}

interface CustomFilterWithGeneric<T> {
    String checkName(T st);
}

class Student {
    Integer age;
    String name;

    @Override
    public String

    toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }


}
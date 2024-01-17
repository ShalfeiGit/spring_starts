import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomStreams {
    public static void main(String[] args) {

        Student st1 = new Student("Ivan", 22);
        Student st2 = new Student("Bogdan", 20);
        Student st3 = new Student("Olya", 23);
        Student st4 = new Student("Jenya", 24);
        Student st5 = new Student("Kirill", 25);
        Student st6 = new Student("Misha", 27);
        Stream<Student> streamStreamMap = Stream.of(st1, st2, st3, st4, st5, st6);
        Stream<Student> streamStreamFilter = Stream.of(st1, st2, st3, st4, st5, st6);
        Stream<Student> streamStreamForeach = Stream.of(st1, st2, st3, st4, st5, st6);
        Stream<Student> streamStreamReduce = Stream.of(st1, st2, st3, st4, st5, st6);
        Stream<Student> streamStreamSorted = Stream.of(st1, st2, st3, st4, st5, st6);
        Stream<Student> streamStreamPeek = Stream.of(st1, st2, st3, st4, st5, st6);

        //Методы для Stream
        // concat: Stream.concat(streamStreamMap, streamStreamFilter) - объединяем стримы в один
        // distinct (i): streamStreamMap.distinct() - оставляет только уникальные по equals сравнение
        // count (t): streamStreamMap.count() - колличество элементов в стриме
        // collect (t): streamStreamMap.collect(Collectors.groupingBy(el -> el.getName())) - группировка по значению поля
        // collect (t): streamStreamMap.count(Collectors.partitioning(el -> el.getName() === "Ivan")) - группировка по Predicate
        // findFirst (t): streamStreamMap.findFirst().get() - возвращает первый элементв стриме
        // min (t): streamStreamMap.min((o1, o2) -> o1.getAge() - o2.getAge()).get() - возвращает первый элементв стриме
        // max (t): streamStreamMap.max((o1, o2) -> o1.getAge() - o2.getAge()).get() - возвращает первый элементв стриме
        // limit (i): streamStreamMap.limit(2) - отдает поток с лимитированным количеством элементов
        // mapToInt (i): streamStreamMap.mapToInt(el -> el.getAge()).boxed.collect(Collectors.toList()) - отдает List<Integer> - примитивный тип данных также есть matToDouble
        // parallelStream (i): streamOfDouble.parallelStream().reduce(0, (acc, doubleValue) -> acc +=doubleValue) - делить операции на парарллельные потоки
        //  (ВАЖНО понимать, что порядок операций не сохраняется, а определяется Java, поэтому допустим только для операций где порядок выполения не важен)

        ArrayList<Student> streamList = new ArrayList<>();
        streamList.add(st1);
        streamList.add(st2);
        streamList.add(st3);
        streamList.add(st4);
        streamList.add(st5);
        streamList.add(st6);

        HashMap<Integer, Student> streamHashMap = new HashMap<>();
        streamHashMap.put(st1.getAge(), st1);
        streamHashMap.put(st2.getAge(), st2);
        streamHashMap.put(st3.getAge(), st3);
        streamHashMap.put(st4.getAge(), st4);
        streamHashMap.put(st5.getAge(), st5);
        streamHashMap.put(st6.getAge(), st6);

        Student [] array = new Student[] {st1, st2, st3, st4, st5, st6};

        //--------------------------------------------------------------------------------------------------------------

        //  method map for Stream
        System.out.println("method map(i) for Stream: _______________________________________________________________");
        Stream<String> stream1 = streamStreamMap.map(st -> st.name);
        stream1.forEach(System.out::println);
        System.out.println();

        //  method map for List
        System.out.println("method map (i) for List:");
        List<String> stream2 = streamList.stream().map(st -> st.name).collect(Collectors.toList());
        Iterator it1 = stream2.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }
        System.out.println();

        //  method map for Map
        System.out.println("method map(i) for Map:");
        Map<Integer, String> stream3 = streamHashMap.entrySet().stream().map(st -> {
                    st.getValue().name = st.getValue().name.substring(0, 1).toUpperCase() + st.getValue().name.substring(1);
                    return st;
                })
                .collect(Collectors.toMap(st -> st.getKey(), st -> st.getValue().name));
        Iterator it2 = stream3.values().iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }
        System.out.println();

        //  method map for Array
        System.out.println("method map (i) for Array:");
        Object[] stream4 = Arrays.stream(array).map(st -> st.name).toArray();
        for(Object st:stream4){
            System.out.println(st);
        }
        System.out.println();

        //--------------------------------------------------------------------------------------------------------------

        //  method filter for Stream
        System.out.println("method filter(i) for Stream: ____________________________________________________________");
        Stream<Student> stream5 = streamStreamFilter.filter(st -> st.age > 23);
        stream5.forEach(st -> System.out.println(st.getName()));
        System.out.println();

        //  method filter for List
        System.out.println("method filter(i) for List:");
        List<Student> stream6 = streamList.stream().filter(st -> st.age > 23).collect(Collectors.toList());
        Iterator it3 = stream6.iterator();
        while (it3.hasNext()) {
            System.out.println(((Student) it3.next()).getName());
        }
        System.out.println();

        //  method filter for Map
        System.out.println("method filter(i) for Map:");
        Map<Integer, String> stream7 = streamHashMap.entrySet().stream().filter(st -> st.getValue().age > 23)
                .collect(Collectors.toMap(st -> st.getKey(), st -> st.getValue().name));
        Iterator it4 = stream7.values().iterator();
        while (it4.hasNext()) {
            System.out.println(it4.next());
        }
        System.out.println();

        //  method filter for Array
        System.out.println("method filter (i) for Array:");
        Object[] stream8 = Arrays.stream(array).filter(st -> st.age > 23).toArray();
        for(Object st:stream8){
            System.out.println(((Student) st).getName());
        }
        System.out.println();

        //--------------------------------------------------------------------------------------------------------------

        //  method forEach for Stream
        System.out.println("method forEach(t) for Stream: ___________________________________________________________");
        streamStreamForeach.forEach(st -> System.out.println(st.name));
        System.out.println();

        //  method forEach for List
        System.out.println("method forEach(t) for List:");
        streamList.stream().forEach(st -> System.out.println(st.name));
        System.out.println();

        //  method forEach for Map
        System.out.println("method forEach(t) for Map:");
        streamHashMap.entrySet().stream().forEach(st -> System.out.println(st.getValue().name));
        System.out.println();

        //  method filter for Array
        System.out.println("method forEach(t)for Array:");
        Arrays.stream(array).forEach(st -> System.out.println(st.name));
        System.out.println();

        //--------------------------------------------------------------------------------------------------------------

        //  method reduce for Stream
        System.out.println("method reduce(t) for Stream: ____________________________________________________________");
        Student stream9 = streamStreamReduce.reduce(new Student("Vasya", 30), (acc, st) -> st.age < acc.age ? acc : st);
        System.out.println(stream9);
        System.out.println();

        //  method reduce for List
        System.out.println("method reduce(t) for List:");
        Student stream10 = streamList.stream().reduce(new Student("Vasya", 30), (acc, st) -> st.age < acc.age ? acc : st);
        System.out.println(stream10);
        System.out.println();

        //  method reduce for Map
        System.out.println("method reduce(t) for Map:");
        Map.Entry<Integer, Student> stream11 = streamHashMap.entrySet().stream()
                .reduce(Map.entry(30, new Student("Vasya", 30)), (acc, st) -> st.getValue().age > acc.getValue().age ? acc : st);
        System.out.println(stream11);
        System.out.println();

        //  method reduce for Array
        System.out.println("method reduce(t) for Array:");
        Student stream12 = Arrays.stream(array).reduce(new Student("Vasya", 30), (acc, st) -> st.age < acc.age ? acc : st);
        System.out.println(stream12);
        System.out.println();

        //--------------------------------------------------------------------------------------------------------------

        //  method sorted for Stream
        System.out.println("method sorted(i) for Stream: ____________________________________________________________");
        Stream<Student> stream13 = streamStreamSorted.sorted((o1, o2) -> o2.age - o1.age);
        stream13.forEach(System.out::println);
        System.out.println();

        //  method sorted for List
        System.out.println("method sorted(i) for List:");
        List<Student> stream14 = streamList.stream().sorted((o1, o2) -> o2.age - o1.age).collect(Collectors.toList());
        stream14.forEach(System.out::println);
        System.out.println();

        //  method sorted for Map
        System.out.println("method sorted(i) for Map:");
        Map<Integer, Student> stream15 = streamHashMap.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().age - o1.getValue().age)
                .collect(Collectors.toMap(st -> st.getKey(), st -> st.getValue()));
        stream15.entrySet().forEach(st -> System.out.println(st.getValue()));
        System.out.println();

        //  method sorted for Array
        System.out.println("method sorted(i) for Array:");
        Object[] stream16 = Arrays.stream(array).sorted((o1, o2) -> o2.age - o1.age).toArray();
        for(Object st:stream16){
            System.out.println(((Student) st).toString());
        }
        System.out.println();

        //--------------------------------------------------------------------------------------------------------------

        //  method peek for Stream
        System.out.println("method peek(i) for Stream: ___________________________________________________________");
        long stream17 = streamStreamPeek.distinct().peek(st -> System.out.println(st.name)).count();
        System.out.println(stream17);

        //  method forEach for List
        System.out.println("method peek(i) for List:");
        long stream18 = streamList.stream().distinct().peek(st -> System.out.println(st.name)).count();
        System.out.println(stream18);

        //  method forEach for Map
        System.out.println("method peek(i) for Map:");
        long stream19 = streamHashMap.entrySet().stream().distinct().peek(st -> System.out.println(st.getValue().name)).count();
        System.out.println(stream19);

        //  method filter for Array
        System.out.println("method peek(i) for Array:");
        long stream20 = Arrays.stream(array).distinct().peek(st -> System.out.println(st.name)).count();
        System.out.println(stream20);

        //--------------------------------------------------------------------------------------------------------------

        //  method flatMap for Array
        System.out.println("method flatMap(i) for Stream: ___________________________________________________________");
        Stream<Student> streamFlatMap1 = Stream.of(st1, st2, st3, st4, st5, st6);
        Stream<Student> streamFlatMap2 = Stream.of(st1, st2, st3, st4, st5, st6);
        ArrayList<Stream<Student>> streamArrayListForFlat = new ArrayList<>();
        streamArrayListForFlat.add(streamFlatMap1);
        streamArrayListForFlat.add(streamFlatMap2);

        streamArrayListForFlat.stream().flatMap(steam -> steam).forEach(st -> System.out.println(st.name));
    }
}

class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
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
        return Objects.hash(name, age);
    }

}

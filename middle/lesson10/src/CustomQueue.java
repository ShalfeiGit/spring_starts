import java.util.*;

public class CustomQueue {
    public static void main(String[] args) {
        //обычная очередь
        Queue<Student> queue = new LinkedList<>();
        Student st1 = new Student("Ivan");
        Student st2 = new Student("Anton");
        Student st3 = new Student("Jenia");
        Student st4 = new Student("Serega");
        Student st5 = new Student("Olya");
        Student st6 = new Student("Zina");
        queue.offer(st1);
        queue.offer(st2);
        queue.offer(st3);
        queue.offer(st4);
        queue.offer(st5);
        queue.offer(st6);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue);

        //двусторонняя очередь (добавление в конец и начало)
        Deque<Student> deque = new ArrayDeque<>();
        deque.offerFirst(st1);
        deque.offerLast(st2);
        deque.offerLast(st3);
        deque.offerLast(st4);
        deque.offerLast(st5);
        deque.offerFirst(st6);
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println(deque);

        //приоритетная очередь, по компаратору хранит элементы
        Comparator<Student> comparator = (o1, o2) -> o1.name.compareTo(o2.name);
        Queue<Student> priorityQueue = new PriorityQueue<>(comparator);
        priorityQueue.offer(st1);
        priorityQueue.offer(st2);
        priorityQueue.offer(st3);
        priorityQueue.offer(st4);
        priorityQueue.offer(st5);
        priorityQueue.offer(st6);
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue);


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

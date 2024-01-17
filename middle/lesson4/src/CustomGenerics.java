import java.util.ArrayList;

public class CustomGenerics {
    public static void main(String[] args) {
        Student<String, Integer, House> student = new Student <> ("Valentin");
        student.setName("Victor");
        System.out.println(student.getName());
        System.out.println(student.showAge(15));
    }

}

interface IStudentShowAge <T extends Number> {
    public <T> T showAge( T age);
}
interface IStudentShowCar {
    public void showCars(ArrayList<? extends String> cars);
}

interface IBuildings {
    public void build();
    public void destroy();
}
class House implements IBuildings, IHandlersHouse {
    public void build(){
        System.out.println("build");
    };
    public void destroy(){
        System.out.println("destroy");
    };
}
interface IHandlersHouse {
    int year = 100;
}

class Student <A extends String, T extends Number, G extends House&IHandlersHouse&IBuildings > implements IStudentShowCar, IStudentShowAge<T> {
    private A name;
    private G House;
    public Student(A name) {
        this.name = name;
    }

    public A getName() {
        return name;
    }

    public void setName(A name) {
        this.name = name;
    }

    public <T> T showAge( T age){
        return age;
    }

    public void showCars(ArrayList<? extends String> cars){
        for(String car:cars){
            System.out.println(car);
        }
    }
}



import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class CustomReflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class studentClass1 = Class.forName("Student"); // первый способ
        Class studentClass2 = Student.class; // второй способ
        Student student = new Student("Vasya");
        Class studentClass3 = student.getClass(); // третий способ

        Field nameField = studentClass3.getField("name");
        Method showInfoMethod = studentClass1.getMethod("showInfo", int.class);
        System.out.println(nameField.getType());
        System.out.println(showInfoMethod.getReturnType() + " " + showInfoMethod.getName() + " " + Arrays.toString(showInfoMethod.getParameterTypes()));
        Method[] allDeclMethods = studentClass3.getDeclaredMethods();
        for(Method method: allDeclMethods){
            System.out.println(method.getName());
        }
        Constructor studentConstructor = studentClass3.getConstructor(String.class);
        System.out.println(Arrays.toString(studentConstructor.getParameterTypes()) + " " + studentConstructor.getParameterCount());
        Student st1 = (Student) studentConstructor.newInstance("Vasya");
        System.out.println(st1);


        System.out.println(showInfoMethod.invoke(st1, 1));

    }
}

class Student {
    public String name;
    public String showInfo(int a){
        return name;
    }

    private String showInfo(){
        return name;
    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
public class CustomNestedClasses {
    public static void main(String[] args) {
        Car.Engine engine = new Car.Engine(100);
        engine.startEngine();
        Car car = new Car("Nissan");
        car.addWheels();
        car.pressBeep();
        car.turnSide();
    }
}

class Car {
    String name;

    public Car(String name) {
        this.name = name;
    }

    //Nested class
    public static class Engine {
        int power;

        public Engine(int power) {
            this.power = power;
        }

        public void startEngine (){
            System.out.println("Engine started: " + power);
        }
    }

    // inner class
    public class Wheels {
        int count;

        public Wheels(int count) {

            this.count = count;
        }
    }

    public void addWheels (){
        Car car = new Car(name);
        Wheels wheels = car.new Wheels( 4);
        System.out.println("Added " + wheels.count + " wheels");
    }

    public void pressBeep (){
        //local class
        class Beep {
            public void runSignal(){
                System.out.println("Beep signal");
            };
        }
        Beep beep = new Beep();
        beep.runSignal();
    }

    public void turnSide (){
        //Anonymous class
        LightSignal light = new LightSignal(){
            public void runSignal(){
                System.out.println("Turn side");
            };
        };
        light.runSignal();
    }



    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }

}

interface LightSignal {
    public void runSignal();
}
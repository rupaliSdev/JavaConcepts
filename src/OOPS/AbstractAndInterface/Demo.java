package OOPS.AbstractAndInterface;

public class Demo {
    public static void main(String[] args) {

        Car car= new Car("Tesla");
        //interface methods
        car.start();//abstract
        car.show();//default
        Vehicle.clean();//static

        //abstract method
        car.operate();//abstract method
        car.shutdown();//concrete method
        car.greetings(); //default method

        Machine.info();// static method from abstract class
        Car.info();// static method hiding
        System.out.println("Max Speed: " + Vehicle.MAX_SPEED);


    /*    Why is multiple inheritance allowed in interfaces but not in classes?
        Because interfaces do not carry state; only behaviors.
        Classes carry state → creates ambiguity (Diamond Problem).
    */



        Car c = new Car("Tesla");
        Machine m = new Car("Tesla");
        Vehicle v = new Car("Tesla");
   /*     All refer to the same object, but method access is determined by reference type.
          Static methods, constants → accessed based on reference type.
          Overridden methods → resolved at runtime (dynamic dispatch).

          interfaces can extend only interfaces.
          Abstract classes can implement interfaces, but not vice versa.

          Because static belongs to the class, not the instance.
          Abstract classes can contain both static and non-static code like normal classes.
    */



    }
}

//Interface (Java 8+ features)
interface Vehicle{
    int MAX_SPEED= 180;// by default static final

    void start(); //abstarct method

    default void show(){
        System.out.println("Default vehicle show");
    }


    //static method(for utility method and static method without need of all implementing classes to inherit them)
    static void clean(){
        System.out.println("vehicle clean");
    }

//    Default methods → inherited by implementing classes.and instance level
//    Static methods → belong only to the interface; not inherited.
//    Must be called using the interface name.




}

//abstract
abstract class Machine implements Vehicle{
    //instance variable allowed
    String name;

    //constructors allowed
    public Machine(String name) {
        this.name = name;
    }

    abstract void operate();//abstract method

    //default not allowed
//    default void hello(){
//    }

    //concrete method
    void shutdown(){
        System.out.println("shutting down");
    }
    //static method
    static void info(){
        System.out.println("Machine info (static method)");
    }
    //cant be overridden
    final void greetings(){
        System.out.println("hello its machine class");
    }
}
class Car extends Machine implements Vehicle{

   Car(String name) {
        super(name);
    }

    @Override
    void operate() {
        System.out.println("Car is operating on the road");
    }

    @Override
    public void start() {
        System.out.println("Car engine started!");
    }

    @Override
    public void show() {
        super.show();
    }

//    void greetings(){} final methods cant be overridden

    //method hiding //not overriding
    static void info(){
        System.out.println("Car specific info (static method hiding)");
    }
}

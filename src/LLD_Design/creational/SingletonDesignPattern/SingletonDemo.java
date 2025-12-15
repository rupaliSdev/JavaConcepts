package LLD_Design.creational.SingletonDesignPattern;

import java.io.*;
import java.lang.reflect.Constructor;

public class SingletonDemo {

    // 1. Volatile instance for double-checked locking
    private static volatile SingletonDemo instance;

    // 2. Private constructor (prevents new, reflection)
    private SingletonDemo(){

        if(instance!=null){
            throw new RuntimeException("Use getInstance");
        }
    }

    // 4. Prevent Cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    // 3. Lazy + Thread-safe + Double-checked locking
    public static synchronized SingletonDemo getInstance(){

        if(instance==null){
            synchronized (SingletonDemo.class){
                if(instance==null){
                    instance= new SingletonDemo();
                }
            }
        }
        return instance;
    }

    // 5. Prevent new instance during Serialization
    protected Object readResolve() throws ObjectStreamException  {
        return instance;
    }

    // 6. Demo method
    public void showMessage() {
        System.out.println("Singleton instance hashcode: " + this.hashCode());
    }


}
class MainDemo{
    public static void main(String[] args) {
        SingletonDemo obj1 = SingletonDemo.getInstance();
        SingletonDemo obj2 = SingletonDemo.getInstance();

        obj1.showMessage();
        obj2.showMessage();
        System.out.println(obj1 == obj2);  // true


        try {
            SingletonDemo instance1 = SingletonDemo.getInstance();

            Constructor<SingletonDemo> constructor =
                    SingletonDemo.class.getDeclaredConstructor();
            constructor.setAccessible(true);

            // Try to create new instance via reflection
            SingletonDemo instance2 = constructor.newInstance();

            System.out.println(instance1.hashCode());
            System.out.println(instance2.hashCode());

        } catch (Exception e) {
            System.out.println("Reflection attack prevented: " + e.getMessage());
        }

        try {
            SingletonDemo instance1 = SingletonDemo.getInstance();
            SingletonDemo instance2 = (SingletonDemo) instance1.clone();

            System.out.println(instance1.hashCode());
            System.out.println(instance2.hashCode());

        } catch (Exception e) {
            System.out.println("Cloning attack prevented: " + e.getMessage());
        }

        try {
            SingletonDemo instance1 = SingletonDemo.getInstance();

            // Serialize
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.ser"));
            oos.writeObject(instance1);

            // Deserialize
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.ser"));
            SingletonDemo instance2 = (SingletonDemo) ois.readObject();

            System.out.println("Instance1: " + instance1.hashCode());
            System.out.println("Instance2: " + instance2.hashCode());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
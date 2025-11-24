package java8features.defaultMethods;

public interface m2 {

    abstract void playing();

    default void hello(){
        System.out.println("hello");
    }
}

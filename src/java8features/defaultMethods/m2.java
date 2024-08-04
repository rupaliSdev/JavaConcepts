package java8features.defaultMethods;

public interface m2 {

    public abstract void playing();

    default void hello(){
        System.out.println("hello");
    }
}

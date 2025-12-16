package java8features.defaultMethods;

public interface m2 {

    abstract void playing();

    default void hey(){
        System.out.println("hello");
    }
}

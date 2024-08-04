package java8features.defaultMethods;

public interface m1 {

    public abstract void play();

    default void hello(){
        System.out.println("hello");
    }
}

package OOPS.AbstractAndInterface;

public class InterfaceDemo implements Engine {

    @Override
    public void refill() {

    }
}
//All **abstract methods are implicitly public ,Default, static, and private methods must use those keywords explicitly
interface Engine{
   //default method
    default void start(){
        System.out.println("engine started");
    }
    // static method — implicitly final
    static void info() {
        System.out.println("Engine info");
    }
    private void stop(){

    }
    // ❌ Not allowed
    // final default void stop() { } // Compile error

    void refill();

}


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

class A {
    // this is a nested interface
    public interface NestedIF {
        boolean isNotNegative(int x);
    }
}
// B implements the nested interface.
class B implements A.NestedIF {
    public boolean isNotNegative(int x) {
        return x < 0 ? false: true;
    }
}
class NestedIFDemo {
    public static void main(String args[]) {
// use a nested interface reference
        A.NestedIF nif = new B();
        if(nif.isNotNegative(10))
            System.out.println("10 is not negative");
        if(nif.isNotNegative(-12))
            System.out.println("this won't be displayed");
    }
}
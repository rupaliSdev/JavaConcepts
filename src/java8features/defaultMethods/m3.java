package java8features.defaultMethods;

public class m3 implements m1, m2{

    @Override
    public void play() {
        System.out.println("playing");
    }

    @Override
    public void playing() {
    }

    //overriding default method
    public void hello(){
        //interfacename.super.methodname();
        m1.super.hello();

    }
}

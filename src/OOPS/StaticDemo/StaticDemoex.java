package OOPS.StaticDemo;

public class StaticDemoex {

    static int y=5;
    private static final int x;
    static {
        System.out.println("static block" + y);
        x=20;
    }

    public static void main(String[] args) {

        showDemo();
        y=45;
        System.out.println(y);

    }

    private static void showDemo() {
        System.out.println("demo " + x);
    }
}

//As soon as the StaticDemoex class is loaded, all the static statements are run. First, y is set to 5,
//then the static block executes, which prints a message and then initializes x to 20. Then main( ) is called,
//which calls showDemo( ).
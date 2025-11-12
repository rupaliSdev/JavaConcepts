package OOPS.polymorphism.Overriding;

public class App {
    public static void main(String[] args) {
         superClass sc= new subClass(2,4);
         superClass sc1 = null;
         sc1.greet();
        // subClass sc1= new subClass(2,4);
         sc.showData();
         //sc1.showData();
         //sc.hello();
         //sc1.hello();

    }
}

class superClass {
    protected int a;
    private int b;

    static void greet(){
        System.out.println("hello from superclass");
    }
    superClass(int a, int b) {
        System.out.println("hey it's super class");
        this.a = 2 * a;
        this.b = 2 * b;
        System.out.println("variables are " + this.a + " " + this.b);
    }

    public void showData() {
        System.out.println("multiply in superclass");
        System.out.println(this.a * this.b);
    }

    public static void hello() {
        System.out.println("hello its super");
    }
}

class subClass extends superClass {
    private int a;
    private int b;

    static void greet(){
        System.out.println("hello from sub class");
    }
    subClass(int a, int b) {
        super(a, b);
        System.out.println("hey it's subclass");
        this.a = a;
        this.b = b;
        System.out.println("variables are " + a + " " + b);
    }

    public void showData() {
        //super.showData();
        System.out.println(super.a);
        System.out.println("multiply in subclass");
        System.out.println(this.a * this.b);
    }

    public static void hello() {
        System.out.println("hello");
    }
}

package LLD_Design.SOLIDPrniciples.LSP;

public class Demo {


  /*  Liskov Substitution Principle (LSP) is a fundamental principle in object-oriented programming that states
    that  objects  of  a  superclass  should  be  replaceable  with  objects  of  its  subclass  without affecting
    the correctness of the program. In other words, if we have a class A that is a superclass of class B, and
    class B is a subclass of A, then  any  instance  of  class  A should  be  able  to  be  replaced  with  an
    instance  of  class  B without breaking the functionality of the program.*/
    public static void main(String[] args) {
        Rectangle r = new Square();
        r.setWidth(5);
        r.setHeight(10);

        System.out.println(r.area()); // Expected: 50, actual: 100



    }
}

class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int w) { width = w; }
    public void setHeight(int h) { height = h; }

    public int area() { return width * height; }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int w) {
        width = height = w;  // Changes both!
    }

    @Override
    public void setHeight(int h) {
        width = height = h; // Changes both!
    }
}


//correct way

interface Shape {
    int area();
}
class Rectangle1 implements Shape {
    protected int width;
    protected int height;

    public void setWidth(int w) { this.width = w; }
    public void setHeight(int h) { this.height = h; }

    public int area() { return width * height; }
}
class Square1 implements Shape {
    private int side;

    public void setSide(int side) { this.side = side; }

    public int area() { return side * side; }
}

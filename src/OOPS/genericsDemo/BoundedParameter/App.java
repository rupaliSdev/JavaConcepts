package OOPS.genericsDemo.BoundedParameter;



public class App {

    public static void main(String[] args) {

        Data<Integer,App> dt1= new Data<>(20,new App());
        System.out.println(dt1.getKey());
        dt1.display('c',20);
        dt1.display('2',8.0);

        Gen gen=new Gen(10);
        gen.print(gen.data);

    }
}


class Gen<T extends  Number>{
    T data;

    public Gen(T data) {
        this.data = data;
    }
    public void print(T x){
        System.out.println("The value is "+x);
    }
}
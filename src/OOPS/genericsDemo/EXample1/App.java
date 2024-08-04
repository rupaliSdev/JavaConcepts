package OOPS.genericsDemo.EXample1;

import java.util.ArrayList;
import java.util.Iterator;

public class App {

    public static void main(String[] args){


        Data d= new Data("rupali");
        String v= (String)d.getObj();

        GenericClass<String> gdata= new GenericClass<String>("rupali");
        //String v1= (String)gdata.getData();//performance of application go down
        //bcoz of typecasting it will take some time
        System.out.println(gdata.getData());
        ArrayList<GenericClass<Object>> lst = new ArrayList<>();
        lst.add(new GenericClass<>("rupali"));
        lst.add(new GenericClass<>(20));
        Iterator it = lst.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        //raw without any type argument
        GenericClass gn=new GenericClass<>("rupali");



    }
}

class GenericClass<T>{
    private T data;

    public T getData() {
        return data;
    }

    public GenericClass(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GenericClass{" +
                "data=" + data +
                '}';
    }
}

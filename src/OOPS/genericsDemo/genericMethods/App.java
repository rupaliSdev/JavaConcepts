package OOPS.genericsDemo.genericMethods;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Data d = new Data();
        List<Integer> lst = new ArrayList<Integer>();
        lst.add(2);
        lst.add(3);
        lst.add(4);
        d.printElementList(lst);
        System.out.println("***********");
        d.display(lst);
        System.out.println("***********");

        List<String> lst1 = new ArrayList<String>();
        lst1.add("rupali");
        lst1.add("Aanchal");
        lst1.add("Munmmun");
        d.printElementList(lst1);
        System.out.println("***********");
        Integer[] array =new Integer[]{2,3,4,5,6};
        d.printElementArray(array);
        System.out.println("***********");
        String[] str=new String[]{"rupali","sahu"};
        d.printElementArray(str);

    }
}


//camelcase
//class and interface -Calc,Runnable
// variable and method -marks show
//constants- PIE ,BRAND
//showMyMarks()
//Human() constructors
class Data{

    public <E> void printElementList(List<E> lst){

        for(E e:lst){
            System.out.println(e);
        }
    }

    public <E> void printElementArray(E[] arrayData){
        for(E e:arrayData){
            System.out.println(e);
        }
    }

    public <T> void display(List<T> data){
        System.out.println(data);
    }
}
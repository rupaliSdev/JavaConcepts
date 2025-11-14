package javaVersions;

public class Five {
    public static void main(String[] args) {
        //enhanced for loop
        int[] arr = {1,2,3,4,5};
        for(int i:arr){
            System.out.println(i);
        }
        //generics

        Data t1= new Data<String>("hellp");


        //-----enums

        //Provides a type-safe way to define constants.
//        enum Season {
//            WINTER, SPRING, SUMMER, FALL
//        }

        //------autoboxing

        Integer integer = 5;
        int i = integer;

    }


}
class Data<T>{
    T val;
    Data(T t){
        val=t;
    }
}

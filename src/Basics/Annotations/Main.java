package Basics.Annotations;

import java.lang.annotation.*;


public class Main {
    public static void main(String[] args) {


        Mobile mobObj=new Mobile();
        mobObj.dummyMethod();
    }
}


@Repeatable(MyAnnotations.class)
@interface MyAnnotation {
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyAnnotations {
    MyAnnotation[] value();
}
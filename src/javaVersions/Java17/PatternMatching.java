package javaVersions.Java17;

public class PatternMatching {

    public static void main(String[] args) {
       Object obj = new Car("seltos",2025);

        //before
        if(obj instanceof Car){
            Car car= (Car) obj;
            System.out.println(car);
        }

        //after
        if(obj instanceof Car car){
            System.out.println("Model: "+ car.model + " Year: "+ car.year);
        }



       switch( obj ){
           case Car c-> System.out.println(c.model);
           case Integer i -> System.out.println(i);
           case null -> System.out.println("It's null");
           default -> System.out.println("It's something else");
       }


    }


}

class Car{
    String model;
    int year;

    Car(String model, int year){
        this.model = model;
        this.year = year;
    }
}



//Pattern Matching for instanceof in Java 17 enhances the instanceof operator and eliminates the need
// for type casting and checking.
//As you can notice, it makes the code more concise but also enhances readability and reduces the possibility of errors,
//such as incorrect casting.
//limitations :doesn't work for primitive data types even for generic type only works for reference types.


//Pattern Matching for the switch is introduced as a preview feature in Java 17.
// This feature extends the switch expression and switch statement to allow pattern matching in case labels.
// Pattern Matching for switch aims to make code more readable and safe, especially when dealing with type
// testing and casting.
//Please note, the Pattern Matching for switch is still in preview and not yet a finalized.



//Problem with Traditional `switch` (Before Java 17)
//Before Java 17, `switch` only worked with:
//
//Primitive types (`int` , `char` )
//Enums
//        Strings
//It did NOT support objects or type checks.
//        For example, to handle different types of objects, you had to write verbose code
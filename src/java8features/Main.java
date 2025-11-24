package java8features;

import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        //introduces conciseness of the code

    /*    lambda expression
        stream api
        default methods in the interface
        static methods
        functional interface
        Optional
        Method References
        Date API
        Nashorn ,JavaScript Engine*/


 /*       In my recent project, I utilized several Java 8 features to enhance code readability, performance, and maintainability.
 I used Lambda expressions and Stream API for concise and declarative data processing, such as filtering and transforming collections
 without the need for verbose loops. We also adopted Optional to handle null values more safely, reducing the risk of NullPointerExceptions.
 Additionally, default methods in interfaces helped avoid code duplication by providing shared functionality, and method references made
 the code more compact. For date and time handling, I replaced the older Date API with the new java.time package, which offers better immutability
 and timezone support. Finally, we leveraged CompletableFuture for asynchronous processing and Collection API improvements like removeIf to simplify
  collection manipulation. These Java 8 features significantly streamlined our development process and improved the overall quality of the application.

*/
        BiConsumer<Integer,Integer> biConsumer= (a,b)-> System.out.println(a+b);

        biConsumer.accept(10,5);






    }
}

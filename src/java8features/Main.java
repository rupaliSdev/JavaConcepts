package java8features;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

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


        //lambda -> for making code more concise
        Runnable r1= new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };

//        with lambda
        Runnable r2 = (()-> System.out.println("hello"));
        r1.run();r2.run();

       //functionalInterface

        FunctionalInterfaceDemo functionalInterfaceDemo= ()-> System.out.println("Please do something");
        functionalInterfaceDemo.doSomeThings();


        //Streams API

       /* Streams provide a declarative way to process sequences of elements.
        They support functional-style operations such as map, filter, reduce, and
        collect, which can be pipelined to operate on large data sets.
                Streams can be sequential or parallel, leveraging multicore architectures for
        improved performance.
        Introduced in Java 8, streams encourage concise and readable code for data
        manipulation and transformation tasks.*/

        //default and static method

       /* Default methods allow interface creators to add new methods to interfaces
        without breaking existing implementations.
        Static methods in interfaces provide utility methods that can be called
        directly on the interface itself.
        These features were introduced in Java 8 to enhance interface flexibility and
                backward compatibility.
        Default and static methods enable the development of more robust and
        reusable code in Java APIs.*/





    /*    The Optional class in Java is used to represent a value that may or may not
                be present.
        It helps prevent null pointer exceptions by encouraging explicit handling of
        null values.
                Optional provides methods like isPresent(), orElse(), and orElseThrow() to
        safely access and manipulate potentially null values.
                Introduced in Java 8, Optional promotes better coding practices by making
        the presence or absence of values explicit in the code.*/

        Optional<String> string= Optional.of("Hello");
        System.out.println(string.isPresent() +" "+ string.get());
        string=Optional.empty();
        System.out.println(string.orElse("default"));



       /* Java's java.time package introduced in Java 8 provides comprehensive date
        and time handling capabilities.
        It includes classes like LocalDate, LocalTime, LocalDateTime, Instant,
                Duration, and Period for date manipulation and formatting.
        java.time classes are immutable and thread-safe, promoting safer concurrent
        programming practices.
        The API addresses shortcomings of the earlier java.util.Date and
        java.util.Calendar classes, offering clearer and more intuitive date and time
        operations.*/

        LocalDate date=LocalDate.now();
        LocalDateTime dateTime=LocalDateTime.now();

        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println(date);
        System.out.println(dateTimeFormatter.format(dateTime));


        /*Nashorn is a lightweight JavaScript engine introduced in Java 8, enabling
        seamless integration of JavaScript with Java applications.
                It allows scripting capabilities within Java applications, facilitating dynamic
        scripting and extension of Java applications with JavaScript logic.
                Nashorn supports ECMAScript 5.1 specification and provides
        interoperability between Java and JavaScript code.
        The engine can be embedded in Java applications to execute JavaScript code
        dynamically at runtime.*/

    /*    ScriptEngineManager manager = new
                ScriptEngineManager();
        ScriptEngine engine =
                manager.getEngineByName("nashorn");
        try {
            engine.eval("print('Hello from JavaScript')");
        } catch (ScriptException e) {
            System.out.println(e.getMessage());
        }
*/

        /*Method References
        Method references provide a shorthand notation for lambda expressions to
        invoke methods.
        They can refer to static methods, instance methods, constructors, and
        arbitrary object methods using different syntax (::).
        Method references improve code readability by reducing verbosity,
        especially for lambda expressions that simply call existing methods.
                Introduced in Java 8, method references enhance the expressiveness and
        flexibility of functional programming in Java.*/

        System.out.println("hello");

        String[] names = {"John", "Jane", "Jack", "Doe"};
        Arrays.sort(names, String::compareToIgnoreCase);

        System.out.println(Arrays.toString(names)); //


      /*  The Collectors class in Java provides utility methods for transforming
        elements of a stream into various data structures (like lists, sets, and maps) or
        performing aggregations.
        It supports common reduction operations such as grouping, partitioning, and
        joining elements.
        Collectors facilitate efficient and concise data processing with streams by
        encapsulating complex reduction operations.
        This class is essential for stream operations involving grouping,
        summarization, and collecting results into collections or aggregating values.*/

        List<String> namesl = Arrays.asList("John", "Jane",
                "Jack", "Doe");
        List<String> filteredNames = namesl.stream()
                .filter(name -> name.startsWith("J"))
                .collect(Collectors.toList());
        System.out.println(filteredNames);


        CompletableFuture.supplyAsync(()->"Hello")
                .thenApplyAsync(result->result+" World")
                .thenAcceptAsync(result-> System.out.println(result));

    }
}

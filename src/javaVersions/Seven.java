package javaVersions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Seven {
//    public static void main(String[] args) {
////        //Try-With-Resources: Automates resource management in try-catch blocks.
////        try (BufferedReader br =
////                     new BufferedReader(
////                             new FileReader("file.txt"))) {
////
////            String day = "Monday";
////            //Strings in Switch: Allows using String values in switch statements.
////            switch (day) {
////                case "Monday": //Do Something;
////                case "Friday": //Do Something;
////                case "Sunday": //Do Something;
////                default: //Do Something;
////            }
////        } catch (FileNotFoundException e) {
////            throw new RuntimeException(e);
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        }
//
//                System.out.print("1");
//
//                synchronized(args) {
//                    System.out.print("2");
//                    try {
//                        args.wait();
//                    } catch(InterruptedException e) { }
//                    System.out.print("3");
//                }
//            }
//        }
public static void main(String[] args) {
    List<List<String>> names =
            Arrays.asList(
                    Arrays.asList("Sachin", "Tarun"),
                    Arrays.asList( "Jack", "Michael"),
                    Arrays.asList("Sam", "Gopal","Ankit"),
                    Arrays.asList("Anil")
            );

    List<String> result =
            names.stream()
                    .flatMap(p -> p.stream()).filter(s->s.startsWith("A"))
                    .collect(Collectors.toList());

    result.forEach(System.out::print);
}

public void go() {
    Runnable r = new Runnable() {
        public void run() {
            System.out.print("foo");
        }
    };

    Thread t = new Thread(r);
    t.start();
    t.start();
}}

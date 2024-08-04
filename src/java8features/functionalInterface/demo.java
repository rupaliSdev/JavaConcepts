package java8features.functionalInterface;

import java.util.function.Predicate;

public class demo {
    public static void main(String[] args) {

        Predicate<String> predicate=(s -> s.length()>5);
        System.out.println(predicate.test("Hello"));
    }
}

package java8features;

@FunctionalInterface
public interface FunctionalInterfaceDemo {
    void doSomeThings();
}



/*
• Functional interfaces have exactly one abstract method, making them
suitable for use with lambda expressions.
        • They can include default methods, which provide default
implementations that can be overridden by implementing classes.
        • Java 8 introduced static methods in interfaces to provide utility methods
that are tightly related to the interface's purpose.
        • Functional interfaces are foundational to Java's support for functional
programming, enabling the use of lambda expressions and method
references.
• The @FunctionalInterface annotation can be used to mark an interface
as a functional interface.*/

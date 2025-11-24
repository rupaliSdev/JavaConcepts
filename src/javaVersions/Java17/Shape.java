package javaVersions.Java17;

public abstract sealed class Shape permits Rectangle {
    public abstract double area();
}

final class Rectangle extends Shape{

    @Override
    public double area() {
        return 0;
    }
}


//Sealed classes are a new language feature introduced in Java 17 as part of JEP 409.
// They provide a way to restrict the subclasses that can extend a class or implement an interface.
// This feature is useful to create more robust and maintainable code and to define a closed hierarchy of types.
//Sealed Classes allow you to specify a limited set of subclasses that can extend a given class
// or implement an interface.
//This is how we can declare a sealed class in Java:
//The permits clause is used to specify the allowed subclasses for type Shape.
//Since the compiler knows all the possible subtypes of a sealed class,
// it will prevent any other class except Circle, Square or Rectangle from extending the Shape class.



//Sealed classes and final classes serve different purposes in Java, although both are used to restrict inheritance.
//Final Classes in Java cannot be inherited at all. It can be used when a class should never be extended.
//Sealed Classes can be inherited, but only by a predefined set of classes. It is used when you want to allow inheritance,
// but only for specific classes.
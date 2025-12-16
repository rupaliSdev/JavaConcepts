## **Abstarct**
* An abstract class can have both abstract and concrete methods.
* It provides a base structure and enforce certain methods in subclasses
* It can have constructors, and they run when a subclass object is created.
* It can have instance variables, and thus it participates in object creation.
* A class with even one abstract method must be declared abstract and cannot be instantiated.
* It supports single inheritance (a class can extend only one abstract class). 
* Why can’t we create abstract objects? Because abstract classes may contain incomplete (abstract) methods.
*  Can a class be both abstract and final? No. Final means “cannot be extended,” abstract means “must be extended.”

## **Interface**
* An interface contains only abstract methods (until Java 8), but can have default and static methods.
* It cannot have constructors because it has no instance state to initialize.
* All variables in an interface are public, static, and final by default.
* A class can implement multiple interfaces, supporting multiple inheritance.Interfaces specify only what the class is doing(contract), not how it is doing it.
* The problem with MULTIPLE INHERITANCE is that two classes may define different ways of doing the same thing,and the subclass can't choose which one to pick.
* An interface reference can point to any class that implements that interface.When you call a method using the interface reference, Java looks at the actual object (not the reference) and calls the correct overridden implementation.
This enables runtime polymorphism, allowing flexible and extensible code.

Abstract methods should be public in implementing class.
CAUTION: Because dynamic lookup of a method at run time incurs a significant overhead when compared with the normal
method invocation in Java, you should be careful not to use interfaces casually in performance-critical code.





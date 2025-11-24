package javaVersions.Java17;

public class Java17ClassDemo {
    public static void main(String[] args) {

        Animal animal= new Animal("dog","2Legs");
        System.out.println(animal.name() + animal.animalType());

    }
}
//https://www.stacktips.com/articles/java-17-interview-questions-and-answers
//https://medium.com/@sbmaggarwal/java-16-and-17-interview-questions-7a232656db20

/*

Restore Always-Strict Floating-Point Semantics (JEP 306)
🔹 JEP 306 - Restore Always-Strict Floating-Point Semantics
JEP 306 was introduced to make floating-point arithmetic more predictable and consistent across platforms. It aims to restore strict floating-point semantics to avoid platform-specific discrepancies that could occur in earlier Java versions. This is especially important when the same code can give different results depending on the hardware or operating system.

---

The Problem (Before JEP 306)
Floating-point operations in Java were sometimes optimized by the CPU or the JVM for performance.
Some CPUs (e.g., x86) used 80-bit registers (higher precision) in hardware, while others (e.g., ARM) used only 64-bit registers, leading to inconsistent behavior between platforms.
As a result, calculations involving floating-point numbers could yield different results on different hardware, even with the same Java code.*/


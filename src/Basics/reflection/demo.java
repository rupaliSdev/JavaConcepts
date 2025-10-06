package Basics.reflection;

import java.lang.reflect.*;

public class demo {
    public static void main(String[] args) throws Exception {

        Class bird = Class.forName("Basics.reflection.Bird");
        System.out.println(bird.getName());

        Class eagle = Eagle.class;
        System.out.println(eagle.getName());
        System.out.println(Modifier.toString(eagle.getModifiers()));

        Class c1 = bird.getClass();
        System.out.println(c1.getName());

        // ✅ Only public methods
        Method[] methods = eagle.getMethods();
        for (Method method : methods) {
            System.out.println("Method Name: " + method.getName());
            System.out.println("Return Type: " + method.getReturnType());
            System.out.println("Class Name: " + method.getDeclaringClass());
        }

        // ✅ Public + private methods
        Method[] methods1 = eagle.getDeclaredMethods();
        for (Method method : methods1) {
            System.out.println("Declared Method Name: " + method.getName());
        }
/*

        // ✅ Instantiate using private constructor safely
        Class<?> eagleClass = Class.forName("Basics.reflection.Eagle");
        Constructor<?> constructor = eagleClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Object eagleObject = constructor.newInstance();

        // ✅ Invoke public method
        Method flyMethod = eagleClass.getMethod("fly", int.class, boolean.class, String.class);
        flyMethod.invoke(eagleObject, 1, true, "hello");

        // ✅ Access private + public constructors
        Constructor<?>[] eagleConstructorList = eagleClass.getDeclaredConstructors();
        for (Constructor<?> eagleConstructor : eagleConstructorList) {
            System.out.println("Modifier: " + Modifier.toString(eagleConstructor.getModifiers()));
            eagleConstructor.setAccessible(true);
            Eagle eagle1 = (Eagle) eagleConstructor.newInstance();
            eagle1.fly(2, false, "reflection");
        }
*/

        Bird birdObj = new Bird();
        Class birdCl = birdObj.getClass();
        System.out.println(birdCl.getName());

        // ✅ Reflection of fields
        Field[] fields = Eagle.class.getDeclaredFields();
        for (Field field1 : fields) {
            field1.setAccessible(true);
            System.out.println("Field: " + field1.getName());
        }
    }
}

class Bird { }

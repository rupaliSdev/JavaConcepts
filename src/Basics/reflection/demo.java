package Basics.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class demo {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
         Class bird= Class.forName("Basics.reflection.Bird");
         System.out.println(bird.getName());

         Class eagle= Eagle.class;
         System.out.println(eagle.getName());
         System.out.println(Modifier.toString(eagle.getModifiers()));

        Method[] methods=eagle.getMethods();
        for (Method method:methods){
            System.out.println("Method Name :"+ method.getName());
            System.out.println("Return Type :"+ method.getReturnType());
            System.out.println("Class Name :"+ method.getDeclaringClass());
        }

        Method[] methods1=eagle.getDeclaredMethods();
        for (Method method:methods1){
            System.out.println("Method Name :"+ method.getName());
            System.out.println("Return Type :"+ method.getReturnType());
            System.out.println("Class Name :"+ method.getDeclaringClass());
        }

        /*Class eagleClass= Class.forName("Basics.reflection.Eagle");
        Object eagleObject=eagleClass.newInstance();

        Method flyMethod= eagleClass.getMethod("fly", int.class, boolean.class, String.class);
        flyMethod.invoke(eagleObject,1,true,"hello");*/



        Constructor[] eagleConstructorList= eagle.getDeclaredConstructors();
        for (Constructor eagleConstructor:eagleConstructorList){
            System.out.println("Modifier "+ Modifier.toString(eagleConstructor.getModifiers()));
            eagleConstructor.setAccessible(true);
            Eagle eagle1=(Eagle) eagleConstructor.newInstance();
            eagle1.fly(1,true,"hello");
        }



         Bird birdObj = new Bird();
         Class birdCl=birdObj.getClass();
         System.out.println(birdCl.getName());
    }
}
class Bird
{

}

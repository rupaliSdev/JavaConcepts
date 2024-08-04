package OOPS.ClassDemo1;

public class Hello {


    public static void main(String[] args){

        Car car= null;
//                new Car();
//        car.setDoors("closed");
//        car.setDriver("seated");
//        car.setEngine("on");
//        car.setSpeed(20);
        System.out.println(car);
        //car.run();

        Car car1= new Car(20,"closed","seated","on");
        car1.run();
        System.out.println();
    }
}

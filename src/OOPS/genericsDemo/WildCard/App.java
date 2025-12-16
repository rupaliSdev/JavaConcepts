package OOPS.genericsDemo.WildCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Print.Vehicle> lst = new ArrayList<>();
        lst.add(new Print.Vehicle(20));
        lst.add(new Print.Vehicle(30));
        lst.add(new Print.Car(40,"A14"));
        List<Print.Car> carList=new ArrayList<>();

   /*     To protect type safety.
        List<Car> != List<Vehicle>.
       carList=lst; not allowed
        lst=carList*/

        Print p= new Print();
        List<Integer> plst=new ArrayList<Integer>();plst.add(20);plst.add(30);
        List<Double> plst1=new ArrayList<Double>();plst1.add(20.20);
        //p.printAllWild(plst,plst1);

        p.printNormal(Collections.singletonList(20),Collections.singletonList(20.20));
    }

    public static class Print
    {


   /*
        ✔ 2. When to use ? extends?

        When list produces items (read-only).

            ✔ 3. When to use ? super?

        When list consumes items (write-only).

            ✔ 4. Why generic method <T> requires same type?

        Compiler binds T once per method call.*/
        //wild card method
    //upper bound

        public <T extends Vehicle> void printVehicle(List<? extends Vehicle> lst){

//            lst.add(new Vehicle(200)); not possible
        }
    //lower bound(not defined in generic method)
//    List of Vehicle OR any superclass of Vehicle.(write only)
        public void printALlabove(List<? super Vehicle> lst){

            lst.add(new Vehicle(200));
            lst.add(new Car(300,"seltos"));

        }
    //two parameter with some type constraint
        public void printAllWild(List<? super Number> source ,List<? extends Number> destination){

        }

        public <T extends Number> void printNormal(List<T> source ,List<T> destination){

        }

        static class Car extends Vehicle {
            private String carmodel;

            public Car(int vehicleid, String carmodel) {
                super(vehicleid);
                this.carmodel = carmodel;
            }

            public String getCarmodel() {
                return carmodel;
            }

            @Override
            public String toString() {
                return "car{" +
                        "carmodel='" + carmodel + '\'' +
                        '}';
            }
        }

        static class Vehicle{
            private int vehicleid;

            public Vehicle(int vehicleid) {
                this.vehicleid = vehicleid;
            }

            public int getVehicleid() {
                return vehicleid;
            }

            @Override
            public String toString() {
                return "vehicle{" +
                        "vehicleid=" + vehicleid +
                        '}';
            }
        }
    }
}


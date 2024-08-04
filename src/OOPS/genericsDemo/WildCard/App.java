package OOPS.genericsDemo.WildCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Vehicle> lst = new ArrayList<>();
        lst.add(new Vehicle(20));
        lst.add(new Vehicle(30));
        lst.add(new Car(40,"A14"));
        List<Car> carList=new ArrayList<>();
//        carList=lst;
        // lst=carList

        Print p= new Print();
        List<Integer> plst=new ArrayList<Integer>();plst.add(20);plst.add(30);
        List<Double> plst1=new ArrayList<Double>();plst1.add(20.20);
        //p.printAllWild(plst,plst1);

        p.printNormal(Collections.singletonList(20),Collections.singletonList(20.20));
    }

}
class Vehicle{
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

class Car extends Vehicle{
     private String carmodel;
    public Car(int vehicleid,String carmodel) {
        super(vehicleid);
        this.carmodel=carmodel;
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
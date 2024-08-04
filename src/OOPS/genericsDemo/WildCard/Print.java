package OOPS.genericsDemo.WildCard;

import java.util.List;

public class Print
{

    //wild card method
//upper bound
    public <T extends Vehicle> void printVehicle(List<? extends Vehicle> lst){

    }
//lower bound(not defined in generic method)
    public void printALlabove(List<? super Vehicle> lst){

    }
//two parameter with some type constraint
    public void printAllWild(List<? super Number> source ,List<? extends Number> destination){

    }

    public <T extends Number> void printNormal(List<T> source ,List<T> destination){

    }
}

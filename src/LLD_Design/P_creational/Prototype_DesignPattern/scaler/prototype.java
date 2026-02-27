package LLD_Design.P_creational.Prototype_DesignPattern.scaler;

public interface prototype<T> {
//can be used by different classes so used generics
    T clone();

}

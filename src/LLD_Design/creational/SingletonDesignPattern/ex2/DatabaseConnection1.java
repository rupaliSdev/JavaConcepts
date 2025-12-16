package LLD_Design.creational.SingletonDesignPattern.ex2;

public class DatabaseConnection1
{

    public static volatile DatabaseConnection1 instance;
    public static DatabaseConnection1 getInstance(){
        if(instance==null){
            instance=new DatabaseConnection1();
        }
        return instance;//not threadsafe
    }
}

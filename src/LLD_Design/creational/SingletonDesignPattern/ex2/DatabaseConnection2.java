package LLD_Design.creational.SingletonDesignPattern.ex2;

public class DatabaseConnection2
{

    public static volatile DatabaseConnection2 instance =new DatabaseConnection2();
    private DatabaseConnection2(){

    }
    public static DatabaseConnection2 getInstance(){

        return instance;
    }
}

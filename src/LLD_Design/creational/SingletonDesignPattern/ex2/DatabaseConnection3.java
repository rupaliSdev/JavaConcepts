package LLD_Design.creational.SingletonDesignPattern.ex2;

public class DatabaseConnection3
{

    public static volatile DatabaseConnection3 instance ;
    private DatabaseConnection3(){

    }
    public static synchronized DatabaseConnection3 getInstance(){
        if(instance==null){
            instance=new DatabaseConnection3();
        }
        return instance;
    }
}

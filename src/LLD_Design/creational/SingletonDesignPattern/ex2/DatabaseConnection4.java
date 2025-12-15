package LLD_Design.creational.SingletonDesignPattern.ex2;

public class DatabaseConnection4
{

    public static volatile DatabaseConnection4 instance;
    public static DatabaseConnection4 getInstance(){
        if(instance==null){
            synchronized (DatabaseConnection4.class){
                if(instance==null){
                instance=new DatabaseConnection4();
            }
            }
        }

        return instance;
    }
}

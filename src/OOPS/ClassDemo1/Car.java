package OOPS.ClassDemo1;

public class Car {

   // all properties are private so we can't access it outside the class
    private int speed=0;
    private String doors="open";

    private String driver="Not seated";
    private String engine;

    public Car(){
        this.engine="off";
        this.doors="open";
        this.speed=0;
        this.engine="off";
    }

    public Car(int speed, String doors, String driver, String engine) {
        //this is pointing to object address
        this.speed = speed;
        this.doors = doors;
        this.driver = driver;
        this.engine = engine;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getDoors() {
        return doors;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }


     public void run(){
        if(doors.equals("closed") && driver.equals("seated") && engine.equals("on") && speed>0){
            System.out.println("Car is running");
        }
        else{
            System.out.println("car is not running");
        }

     }
}

package LLD_Design.SOLIDPrniciples;



/*Open-Close Principle:
The  open-Closed  Principle  is  a  design  principle  in  object-oriented  programming  that  states  that software  entities  (classes,  modules,  functions,  etc.)
should  be  open  for  extension  but  closed  for modification.  This  means  that  you
should  be  able  to  add  new  functionality  to  a  class  or  module without changing its
existing code.
Implementation Guidelines:
 ● The simplest way to apply OCP is to implement the new functionality on new derived classes
● Allow clients to access the original class with an abstract interface*/
public class OCP {

    public static void main(String[] args) {
        Car car1= new Car(new Engine());
        car1.start();

        Car car2= new Car(new RemoteStarter());
        car2.start();

    }


}

interface Starter{
    void start();
}
class Car{
    Starter starter;

    public Car(Starter starter) {
        this.starter = starter;
    }

    public void start(){
       starter.start();
    }
}
class Engine implements  Starter {
    @Override
    public void start() {

    }
}
//now we are adding new functionality remote starter
class RemoteStarter implements Starter{

    @Override
    public void start() {

    }
}




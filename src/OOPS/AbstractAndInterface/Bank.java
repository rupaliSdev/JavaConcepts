package OOPS.AbstractAndInterface;

//An instance of an abstract class can not be created.
//Constructors are allowed.
//We can have an abstract class without any abstract method.
//Abstract classes can have final methods because when you make a method final you can not override it.
//We are not allowed to create object for any abstract class.
//We can define static methods in an abstract class

abstract class Bank {

    Bank(){
        System.out.println("Welcome to the bank");
    }


    int rates=200;
    abstract void accountCreation();
    abstract void validKYC();
    //cant be overridden
    final void greetings(){
        System.out.println("hey how are you");
    }
}

class Saving extends Bank{

    @Override
    void accountCreation() {
        System.out.println("Congratulations, Your account has been created");
    }

    @Override
    void validKYC() {
        System.out.println("KYC is done");
    }

    public static void main(String[] args) {
        Bank b1= new Saving();
        b1.greetings();
    }
}

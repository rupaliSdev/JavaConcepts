package Basics.reflection;

public class Eagle {

    private Eagle(){

    }
    public String breed;
    private boolean canSwim;

    public void fly(int intParam, boolean boolParam, String strParam){
        System.out.println("fly intParam: "+ intParam +" boolParam: "+ boolParam +" strParam :"+strParam);
    }

    private void eat(){
        System.out.println("eat");
    }
}

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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isCanSwim() {
        return canSwim;
    }

    public void setCanSwim(boolean canSwim) {
        this.canSwim = canSwim;
    }
}

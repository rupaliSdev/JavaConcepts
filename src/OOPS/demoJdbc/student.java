package OOPS.demoJdbc;

public class student {

    @SafeVarargs
    private void studying(int[] ...a){
        Object[] objects=a;
        String[] str=new String[2];
        str[0]="Hello";

        objects[0]=str;

    }
    
}

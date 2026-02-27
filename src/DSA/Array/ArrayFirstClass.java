package DSA.Array;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ArrayFirstClass {
    public static void main(String[] args) {

        //count elements having at least one element greater than itself

        int[] arr=new int[]{3,4,6,4,8,5};
        int max=arr[0];
        int count=0;
        for (int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println(count);
        String inputDate = "04/07/2022";
        String result = "[viewed " + LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")).format(DateTimeFormatter.ofPattern("dd MMMM, yyyy", Locale.ENGLISH)) + "]";
        System.out.println(result);
       int i=4;

        System.out.println(String.format("%06d", 4));
        String c=" Wits University Press";
        String lcString =c.trim() + ", ";
        System.out.println(c);
        System.out.println(lcString);
        LocalDate dt= LocalDate.parse(inputDate,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String date =dt.format(DateTimeFormatter.ofPattern("dd MMMM, yyyy"))+"";


        System.out.println(date);


    }
}

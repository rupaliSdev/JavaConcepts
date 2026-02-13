package FileHandling;

import java.io.File;
import java.util.Scanner;

public class ReadingUsingScanner {
    public static void main(String[] args) {
        //surround with try catch block bcoz of private resources
        Scanner sc1= new Scanner(System.in);
        try{
            Scanner sc = new Scanner(new File("team.txt"));
            String line;
            while (sc.hasNext()){
                line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}

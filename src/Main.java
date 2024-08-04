import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        boolean x = false;
        System.out.println(x);
        String x1=new String("hello\r\nrupalu\r\n");
        x1=replaceKeywords(x1);
        System.out.print(x1);
        System.out.println(x1);
        StringBuilder str=new StringBuilder();
        str.append("rupaliSahu"+"; ");
        String ch="u";
        //str.delete(str.length()-2,str.length());
        str.replace(str.indexOf(ch),str.indexOf("u")+ch.length(),"oo");

        System.out.println("after replacement "+str.indexOf("r"));
        List<String> arr=null;
        System.out.println(arr);
        String s ="\"rupali\" is having bday on '19'";
        List<String> keys= Arrays.asList("\"","'");
        /*for (String key:keys) {

            if (key.equals("\"") || key.equals("'")) {
                System.out.println(key);
                System.out.println(s.lastIndexOf(key));
                System.out.println(s.charAt(s.lastIndexOf(key) - 1));
                if(s.indexOf(key)>0){
                if (Character.isDigit(s.charAt(s.indexOf(key) - 1))) {
                    System.out.println("its integer");
                }}
            }
        }*/

    }

    public static String replaceKeywords(String s){
        s=s.replace("u","oo");
        return s;
    }
}
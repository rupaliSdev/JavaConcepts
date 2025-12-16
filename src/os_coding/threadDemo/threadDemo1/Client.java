package os_coding.threadDemo.threadDemo1;

public class Client {

    public static void main(String[] args){
        System.out.println("hello");
        for(int i=0;i<=100;i++){
            PrintTheNumber ptn = new PrintTheNumber(i);
            Thread t = new Thread(ptn);
            t.start();
        }

    }
}

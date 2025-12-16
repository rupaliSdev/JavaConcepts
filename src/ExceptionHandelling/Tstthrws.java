package ExceptionHandelling;

import java.io.IOException;

public class Tstthrws{
    void m() throws IOException{
        System.out.println("method 3");
        throw new IOException("device error");
    }
    void n() throws IOException{
        System.out.println("method 2");
        m();
    }
    void p(){
        try{
            System.out.println("method 1");
            n();
            
        }
        catch (IOException ie){
            System.out.println(ie.getMessage());
        }
        catch(Exception e){
            System.out.println("Exception Handled "+ e.getMessage());
        }
    }
        public static void main(String[] args){
            Tstthrws t1 = new Tstthrws();
            t1.p();
        }
    }

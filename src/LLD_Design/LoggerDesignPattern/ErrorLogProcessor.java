package LLD_Design.LoggerDesignPattern;

public class ErrorLogProcessor extends LogProcessor
{


    ErrorLogProcessor(LogProcessor next){
        super(next);
    }

    public void log(int level, String message){

        if(level==ERROR){
            System.out.println("[ERROR] "+message);
        }
        else{
        super.log(level, message);}
    }

}

package LLD_Design.LoggerDesignPattern;

public class DebugLogProcessor extends LogProcessor{
    public DebugLogProcessor(LogProcessor next){
        super(next);
    }

    public void log( int logLevel ,String msg){

        if(logLevel == DEBUG){
            System.out.println("[DEBUG] " + msg);
        }
        else{
            //go to next
            super.log(logLevel,msg);
        }

    }
}

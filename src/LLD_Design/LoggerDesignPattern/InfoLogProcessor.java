package LLD_Design.LoggerDesignPattern;

public class InfoLogProcessor extends LogProcessor{

    public InfoLogProcessor(LogProcessor nextloggerProcessor) {
        super(nextloggerProcessor);
    }

    public void log(int loglevel,String message){

        if(loglevel ==INFO){
            System.out.println("[INFO] " + message);
        }
        else{
            super.log(loglevel, message);
        }

    }


}

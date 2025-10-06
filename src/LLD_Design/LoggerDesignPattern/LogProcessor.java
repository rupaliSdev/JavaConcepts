package LLD_Design.LoggerDesignPattern;

public abstract class LogProcessor {

    public static int INFO=1;
    public static int DEBUG=2;
    public static int ERROR=3;

    LogProcessor nextloggerProcessor;

    public LogProcessor(LogProcessor nextloggerProcessor) {
        this.nextloggerProcessor = nextloggerProcessor;
    }
//it will send to next
    public void log(int loglevel,String message){
      if(nextloggerProcessor!=null){
          nextloggerProcessor.log(loglevel,message);
      }
    }
}
